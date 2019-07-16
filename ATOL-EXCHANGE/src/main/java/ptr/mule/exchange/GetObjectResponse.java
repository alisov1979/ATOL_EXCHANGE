
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
@XmlType(name = "GetObjectResponse", propOrder = { "_return" })
@XmlRootElement(name = "GetObjectResponse", namespace = "http://exchange.mule.ptr/")
public class GetObjectResponse implements iExchangable {

	@XmlElement(name = "return", required = true)
	protected Object _return;

	public Object getReturn() {
		return _return;
	}

	public Object get_return() {
		return _return;
	}

	public void set_return(Object _return) {
		this._return = _return;
	}

	public Boolean isVailid(String recipient) {
		if (this.getReturn() != null) {
			List<String> recipients = this.getReturn().getRecipients();
			if (recipients.contains(recipient)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getType() {
		if (this.get_return() != null) {
			return this.getReturn().getType();
		} else {
			return "";
		}
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
		if (this.getReturn() == null) {
			return false;
		} else {
			List<String> recipients = this.getReturn().getRecipients();
			if (recipients == null) {
				return false;
			} else
				return recipients.contains(baseName);
		}
	}

	public GetObjectResponse() {
	};

	public GetObjectResponse(Object object) {
		this._return = object;
	}

	@Override
	public String getSender() {
		if (this.getReturn() != null) {
			return this.getReturn().getSender();
		}
		else
			return "";
	}

}
