package ptr.mule.exchange;

import java.io.Serializable;

public class AtolRequest implements Serializable{

	
	private static final long serialVersionUID = 577535944484933155L;
	protected String sender;
	protected String Request;
	protected Property docId;
	protected Property ПризнакРасчетаЧека;
	protected Property ПризнакСпособаРасчетаЧека;
		
	public AtolRequest(String sender, String request, Property docId,Property ПризнакРасчетаЧека, Property ПризнакСпособаРасчетаЧека) {
		super();
		this.sender = sender;
		Request = request;
		this.docId = docId;
		this.ПризнакРасчетаЧека = ПризнакРасчетаЧека;
		this.ПризнакСпособаРасчетаЧека = ПризнакСпособаРасчетаЧека;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRequest() {
		return Request;
	}
	public void setRequest(String request) {
		Request = request;
	}
	public Property getDocId() {
		return docId;
	}
	public void setDocId(Property docId) {
		this.docId = docId;
	}
	@Override
	public String toString() {
		return "AtolRequest [sender=" + sender + ", Request=" + Request + ", docId=" + "{type = " + docId.getType() +", value = " 
					+ docId.getValue() + "}]";
	}
	public Property getПризнакРасчетаЧека() {
		return ПризнакРасчетаЧека;
	}

	public Property getПризнакСпособаРасчетаЧека() {
		return ПризнакСпособаРасчетаЧека;
	}

	

}
