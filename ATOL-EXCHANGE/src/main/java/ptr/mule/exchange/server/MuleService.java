package ptr.mule.exchange.server;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.ws.BindingProvider;

import ptr.mule.exchange.Item;
import ptr.mule.exchange.Object;
import ptr.mule.exchange.Row;
import ptr.mule.exchange.services.MuleExchangePortType;

public class MuleService extends ptr.mule.exchange.services.MuleService{
			
	public Object getObject(String base, Object object) {

		MuleExchangePortType wsPort = getWsPort(base);

		((BindingProvider) wsPort).getRequestContext().put("javax.xml.ws.client.connectionTimeout", 10 * 1000);
		((BindingProvider) wsPort).getRequestContext().put("javax.xml.ws.client.receiveTimeout", 	10 * 1000);
		
		return wsPort.getObject(object);
	}
	
	public Object execute(String base, Object object) {
		

		MuleExchangePortType wsPort = getWsPort(base);

		((BindingProvider) wsPort).getRequestContext().put("javax.xml.ws.client.connectionTimeout", 10 * 1000);
		((BindingProvider) wsPort).getRequestContext().put("javax.xml.ws.client.receiveTimeout", 	10 * 1000);
		
		return wsPort.execute(object);
	}

	public Object setObject(String base, Object object) {	

		MuleExchangePortType wsPort = getWsPort(base);

		((BindingProvider) wsPort).getRequestContext().put("javax.xml.ws.client.connectionTimeout", 10 * 1000);
		((BindingProvider) wsPort).getRequestContext().put("javax.xml.ws.client.receiveTimeout", 	10 * 1000);
		
		return wsPort.setObject(object);
	}

	@Override
	public Object calculatePrices(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Row closeOrder(String arg0, Row arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object compareItems(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createPaymentDocument(String arg0, Item arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createPaymentDocumentFullSum(String arg0, Item arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getData(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrintForms(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object prepareOrderProductTable(String arg0, Item arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrintForm(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getMetadata(String base, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getBaseStructure(String base) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
