package ptr.mule.exchange;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import ptr.mule.exchange.server.MuleService;

public class SendLogTransformer extends AbstractMessageTransformer {
	
	@Inject
	MuleService wsPort;

	@Override
	public java.lang.Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {

		Object payload = (Object) message.getPayload();
		
		if(message.getPayload() instanceof PrintedBills)
		{
			wsPort.execute(payload.getSender(), payload);
		}
		else
		{
			payload.getRecipients().forEach(recipient -> wsPort.setObject(recipient, payload));
		}
		
		return true;
	}

}
