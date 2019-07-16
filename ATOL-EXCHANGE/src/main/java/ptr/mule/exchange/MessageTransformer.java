package ptr.mule.exchange;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.fasterxml.jackson.databind.ObjectMapper;

import ptr.mule.atol.Auth;
import ptr.mule.atol.DocRegResponse;
import ptr.mule.atol.Token;
import ptr.mule.exchange.server.HttpRequest;
import ptr.mule.exchange.server.MuleService;
import ptr.mule.exchange.server.QueueMessageSender;

public class MessageTransformer extends AbstractMessageTransformer {
	
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

			
	@Override
	public java.lang.Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		
		iExchangable payload 	= (iExchangable) message.getPayload();
		Object req 				= payload.getObject();
		String sender			= req.getSender();				
		String URL 		 		= token.getURL();
		String groupCode 		= token.getGroupCode(sender);
		Object object 			= wsPort.getObject(sender, req);				
		String reciver  		= "ATOL";
		
		object.getItem().removeIf(item -> ! item.getRecipients().contains(reciver) && !"request".equals(item.getType()));	
					
		token.getNewToken(sender);
		
		Map map = new Map(object);
		
		if(map != null && map.NextItem("РегистрСведений.ЧекиКОтправкеВСервисАТОЛ") && map.NextRow(0))
		{
			Property Документ 					= map.getPropertyByName("Документ");
			Property ПризнакРасчетаЧека 		= map.getPropertyByName("ПризнакРасчетаЧека");
			Property ПризнакСпособаРасчетаЧека 	= map.getPropertyByName("ПризнакСпособаРасчетаЧека");
			
			////установка даты обработки
			Property date 	= map.getPropertyByName("ДатаОбработки");
			date.setValue(Map.getNow());
			/////////////////////////////
			//DocReg docReg = new DocReg(map);			
			HttpRequest.Response response 	= null;
			String request 					= map.getString("ДанныеЧека");			
			LogToBase logToBase 			= null;			
			DocRegResponse docRegResponse 	= null;
			try 
			{				
				response =  httpRequest.execute(URL + groupCode + "/sell?token=" +  token.getValue(sender), "POST", request);				
				docRegResponse = jsonMapper.readValue(response.getResponse(), DocRegResponse.class);				
				logToBase = new LogToBase(sender)
						.add(Документ.getType(), "Документ", Документ.getValue())
						.add("Строка", "Запрос", request)
						.add("Строка", "Чек",  request)
						.add("Строка", "Ответ", jsonMapper.writeValueAsString(docRegResponse))
						.add("Строка", "ОписаниеОшибки", docRegResponse.getError() == null ? "" : jsonMapper.writeValueAsString(docRegResponse.getError()))
						.add("Булево","Успех", "Да")
						.add("Число","Порядок", "1");				
				msgSender.sendObject(logToBase, "atol.log");
				
				//if(docRegResponse.getError() == null || docRegResponse.getError().getType() == ErrorType.SYSTEM)
				//	wsPort.setObject(sender, object);	
				
			} 
			catch (Exception e) 
			{
				
				logger.error("Request: " + (URL + groupCode + "/sell?token=" +  token.getValue(sender))+" Body: " + request + " Error: " + e.getMessage());
				
				try 
				{
					logToBase = new LogToBase(sender)
							.add(Документ.getType(), "Документ", Документ.getValue())
							.add("Строка", "Запрос", request)
							.add("Строка", "ОписаниеОшибки", e.getMessage())
							.add("Булево","Успех", "Нет")
							.add("Число","Порядок", "1");	
					
					msgSender.sendObject(logToBase, "atol.log");
				} 
				catch (Exception e1) 
				{
					throw new RuntimeException(e1);
				}				
			
				return true; //окончание выполнения
			}
			////////////////////////////////////////////////////////////						
			String uuid = docRegResponse.getUuid();
			
			if(uuid != null && ! "".equals(uuid))
			{
				String getRequest = URL + groupCode + "/report/" + uuid + "?token=" +  token.getValue(sender);				
				try 
				{					
					response = httpRequest.execute(getRequest, "GET", null);					
					docRegResponse = jsonMapper.readValue(response.getResponse(), DocRegResponse.class);	
					
					if(docRegResponse.getStatus() == DocRegResponse.Status.DONE){									
						msgSender.sendObject(new PrintedBills(Документ,ПризнакРасчетаЧека, ПризнакСпособаРасчетаЧека, sender), "atol.log");																	
					}
					else
					//if (docRegResponse.getError() != null && docRegResponse.getError().getCode().equals(34))
					{
						msgSender.sendObject(new AtolRequest(sender, uuid, Документ, ПризнакРасчетаЧека, ПризнакСпособаРасчетаЧека), "atol.get");
					}										
					logToBase = new LogToBase(sender)
							.add(Документ.getType(), "Документ", Документ.getValue())
							.add("Строка", "Запрос", jsonMapper.writeValueAsString(getRequest))
							.add("Строка", "Чек",  "")
							.add("Строка", "Ответ", jsonMapper.writeValueAsString(docRegResponse))
							.add("Строка", "ОписаниеОшибки",docRegResponse.getError() == null ? "" : jsonMapper.writeValueAsString(docRegResponse.getError()))
							.add("Булево","Успех", "Да")
							.add("Число","Порядок", "2");	
					
					msgSender.sendObject(logToBase, "atol.log");				
				} 
				catch (Exception  e) 
				{					
					try 
					{						
						logToBase = new LogToBase(sender)
								.add(Документ.getType(), "Документ", Документ.getValue())
								.add("Строка", "Запрос", jsonMapper.writeValueAsString(getRequest))
								.add("Строка", "Чек",  "")
								.add("Строка", "Ответ", "")
								.add("Строка", "ОписаниеОшибки", e.getMessage())
								.add("Булево","Успех", "Нет")
								.add("Число","Порядок", "2");	
						msgSender.sendObject(logToBase, "atol.log");
					} 
					catch (Exception e1) 
					{						
						throw new RuntimeException(e1);
					}					
										
				}				
			}
							
		}	
		
		//установка даты в 1С - последнее действие
		wsPort.setObject(sender, object);	
		
		if(! sender.equals("УТ_СИЛТА") && ! sender.equals("УТ_ПЕТРОЦЕНТР"))
			wsPort.setObject("УТ_ЮНИОН", object);
		
		return true;	
	}
	
}
