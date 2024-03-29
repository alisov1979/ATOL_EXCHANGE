
package ptr.mule.exchange;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for complextype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="complextype">
 *   &lt;complexContent>
 *     &lt;extension base="{http://exchange.mule.ptr/}simpletype">
 *       &lt;sequence>
 *         &lt;element name="recipients" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "complextype", propOrder = {
    "recipients"
})
@XmlSeeAlso({
    Object.class,
    Item.class
})
public class ComplexType
    extends SimpleType implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1270750079344177067L;
	@XmlElement(nillable = true)
    protected List<String> recipients;

    /**
     * Gets the value of the recipients property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recipients property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecipients().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRecipients() {
        if (recipients == null) {
            recipients = new ArrayList<String>();
        }
        return this.recipients;
    }

}
