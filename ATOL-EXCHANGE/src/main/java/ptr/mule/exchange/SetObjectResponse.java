
package ptr.mule.exchange;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{product.specification.stdp.ru}listOfProducts1C"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetObjectResponse", propOrder = { "_return" })
@XmlRootElement(name = "SetObjectResponse", namespace = "http://exchange.mule.ptr/")
public class SetObjectResponse implements iExchangable{

	@XmlElement(name = "return", required = true)
	protected Object _return;

	public Object getReturn() {
		return _return;
	}

	@Override
	public String getType() {
		if(this.getReturn() != null){
			return this.getReturn().getType();
		}
		else
			return "";
	}

	@Override
	public Object getObject() {
		return this.getReturn();
	}

	@Override
	public List<String> getRecipients() {
		List<String> result = new ArrayList<>();
		if (this.getReturn() != null) {
			result = this.getReturn().getRecipients();
		}
		return result;
	}

	@Override
	public Boolean canBePassed(String baseName) {
		if (this.getReturn() != null) {
			List<String> recipients = this.getReturn().getRecipients();
			if (recipients == null)
				return false;
			return recipients.contains(baseName);
		} else
			return false;
	}

	@Override
	public String getSender() {
		if (this.getReturn() != null) {
			return this.getReturn().getSender();
		} else
			return "";
	}


}
