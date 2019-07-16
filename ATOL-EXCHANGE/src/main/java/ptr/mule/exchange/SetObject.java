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
 * Java class for GetProduct complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="GetProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listOfArticules" type="{product.specification.stdp.ru}listOfArticules"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetObject", propOrder = { "object" })
@XmlRootElement(name = "SetObject", namespace = "http://exchange.mule.ptr/")
public class SetObject implements iExchangable {

	@XmlElement(name = "object", required = true)
	protected Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public SetObject() {
	};

	public SetObject(Object object) {

		this.object = object;

	};

	public Boolean isVailid(String recipient) {
		if (this.object != null) {
			List<String> recipients = this.object.getRecipients();
			if (recipients.contains(recipient)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getType() {
		if (this.object != null) {
			return this.object.getType();
		} else
			return "";
	}

	@Override
	public List<String> getRecipients() {
		List<String> result = new ArrayList<>();
		if (this.object != null) {
			result = this.object.getRecipients();
		}
		return result;
	}

	@Override
	public Boolean canBePassed(String baseName) {
		List<String> recipients = this.getRecipients();
		if (recipients == null)
			return false;
		return recipients.contains(baseName);
	}

	@Override
	public String getSender() {
		if (this.object != null) {
			return this.object.getSender();
		} else
			return "";
	}

}
