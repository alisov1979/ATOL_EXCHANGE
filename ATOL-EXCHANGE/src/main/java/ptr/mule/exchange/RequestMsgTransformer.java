package ptr.mule.exchange;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;

import org.apache.activemq.command.ActiveMQQueue;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.fasterxml.jackson.databind.ObjectMapper;

import ptr.mule.atol.Auth;
import ptr.mule.atol.DocRegResponse;
import ptr.mule.atol.Token;
import ptr.mule.exchange.server.HttpRequest;
import ptr.mule.exchange.server.MailSender;
import ptr.mule.exchange.server.MuleService;
import ptr.mule.exchange.server.QueueMessageSender;

public class RequestMsgTransformer extends AbstractMessageTransformer {
	
	@Inject
	MuleService wsPort;
	@Inject
	HttpRequest httpRequest;
	@Inject
	ObjectMapper jsonMapper;	
	@Inject
	Token token;
	@Inject
	JAXBContext context;
	@Inject
	QueueMessageSender msgSender;
	@Inject
	MailSender mailSender;
	

	@Override
	public java.lang.Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		
		AtolRequest payload = (AtolRequest) message.getPayload();
		
		String sender = payload.getSender();
		String uuid = payload.getRequest();
		Property docId = payload.getDocId();
		String currQueue 	 = ((ActiveMQQueue) message.getInboundProperty("JMSDestination")).getPhysicalName();
		
		token.getNewToken(sender);
		
		String getRequest = token.getURL() + token.getGroupCode(sender) + "/report/" + uuid + "?token=" +  token.getValue(sender);
		HttpRequest.Response response = null;
		DocRegResponse docRegResponse = null;
		LogToBase logToBase = null;
		try 
		{					
			response = httpRequest.execute(getRequest, "GET", null);
			
			docRegResponse = jsonMapper.readValue(response.getResponse(), DocRegResponse.class);
			
			if (docRegResponse.getError() != null && docRegResponse.getError().getCode().equals(34)){
				throw new RuntimeException(docRegResponse.getError().getText());
			}
			
			if (docRegResponse.getError() != null && docRegResponse.getError().getCode() == 1) {
				logToBase = new LogToBase(sender)
						.add(docId.getType(), "Документ", docId.getValue())
						.add("Строка", "Запрос", jsonMapper.writeValueAsString(getRequest))
						.add("Строка", "Чек",  "")
						.add("Строка", "Ответ", jsonMapper.writeValueAsString(docRegResponse))
						.add("Строка", "ОписаниеОшибки","Ошибка 1: " + docRegResponse.getError() == null ? "" : jsonMapper.writeValueAsString(docRegResponse.getError()))
						.add("Булево","Успех", "Да")
						.add("Число","Порядок", "2");
				msgSender.sendObject(logToBase, "atol.log");
				msgSender.sendObject(payload, "atol.get.DLQ");
				
				if(currQueue.equals("atol.get")){					
					String msgText = "Ошибка при отправке чека в АТОЛ. Запрос: " + jsonMapper.writeValueAsString(getRequest) + 
							". Ответ: " + (docRegResponse.getError() == null ? "" : jsonMapper.writeValueAsString(docRegResponse.getError()));
					mailSender.send(msgText);
				}
				
				
				return true;
			}
			
			if(docRegResponse.getStatus() == DocRegResponse.Status.DONE){											
				msgSender.sendObject(new PrintedBills(payload.getDocId(), payload.getПризнакРасчетаЧека(), payload.getПризнакСпособаРасчетаЧека(), sender), "atol.log");																				
			}
			else
			{								
				//if(sender.equals("УТ_ПЕТРОЦЕНТР"))
				//	return true;
				
				msgSender.sendObject(payload, "atol.get");
			}
			
			logToBase = new LogToBase(sender)
					.add(docId.getType(), "Документ", docId.getValue())
					.add("Строка", "Запрос", jsonMapper.writeValueAsString(getRequest))
					.add("Строка", "Чек",  "")
					.add("Строка", "Ответ", jsonMapper.writeValueAsString(docRegResponse))
					.add("Строка", "ОписаниеОшибки", docRegResponse.getError() == null ? "" : jsonMapper.writeValueAsString(docRegResponse.getError()))
					.add("Булево","Успех", "Да")
					.add("Число","Порядок", "2");
			
			msgSender.sendObject(logToBase, "atol.log");
			
		} 
		catch (Exception  e) 
		{			
			logger.error("Request: " + getRequest + "Error: " + e.getMessage());
			
			try 
			{				
				logToBase = new LogToBase(sender)
						.add(docId.getType(), "Документ", docId.getValue())
						.add("Строка", "Запрос", jsonMapper.writeValueAsString(getRequest))
						.add("Строка", "Чек",  "")
						.add("Строка", "Ответ", "")
						.add("Строка", "ОписаниеОшибки", "Ошибка 2: " + e.getMessage())
						.add("Булево","Успех", "Нет")
						.add("Число","Порядок", "2");
				
				msgSender.sendObject(logToBase, "atol.log");
				msgSender.sendObject(payload, "atol.get.DLQ");
				
			} 
			catch (Exception e1) 
			{						
				throw new RuntimeException(e1);
			}
						
			
		}						
		return true;
	}

}
