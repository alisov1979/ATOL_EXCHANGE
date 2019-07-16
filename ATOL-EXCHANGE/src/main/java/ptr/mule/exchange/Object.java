package ptr.mule.exchange;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for object complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="object">
 *   &lt;complexContent>
 *     &lt;extension base="{http://exchange.mule.ptr/}complextype">
 *       &lt;sequence>
 *         &lt;element name="item" type="{http://exchange.mule.ptr/}item" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sender" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Object", propOrder = {"item", "sender", "reply", "time", "hashKey"})
@XmlRootElement(name = "Object", namespace = "http://exchange.mule.ptr/")
public class Object extends ComplexType implements iExchangable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8245867685825397848L;

	@XmlElement(name = "item", nillable = true)
	protected List<Item> item;

	@XmlAttribute(name = "sender", required = true)
	protected String sender = "";
	
	@XmlAttribute(name = "reply", required = true)
	protected String reply = "";
	
	@XmlAttribute(name = "time")
	protected String time = "";
	
	@XmlElement(name = "hashKey")
	protected String hashKey = "";

	/**
	 * Gets the value of the item property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the item property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getItem().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Item }
	 * 
	 * 
	 */
	public List<Item> getItem() {
		if (item == null) {
			item = new ArrayList<Item>();
		}
		return this.item;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	/**
	 * Gets the value of the sender property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Sets the value of the sender property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSender(String value) {
		this.sender = value;
	}

	public List<String> getRecipients() {
		
		if(this.recipients == null){
			this.recipients = new ArrayList<>();
		}
		
		return recipients;
	}
	
	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	public void setRecipients(List<String> recipients){
		
		super.recipients = recipients;
		
	}

	public String getRecipient() {

		String recipient = "";

		if (this.recipients != null && this.recipients.size() != 0) {

			recipient = this.recipients.get(0);

		}

		return recipient;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public Object(Item item, String sender, String type, String recipient) {
		super();
		this.item = new ArrayList<>();
		this.item.add(item);
		this.sender = sender;
		super.type = type;
		super.recipients = new ArrayList<>();
		super.recipients.add(recipient);
	}

	public Object(Item item, String sender, String type, List<String> recipient) {
		super();
		this.item = new ArrayList<>();
		this.item.add(item);
		this.sender = sender;
		super.type = type;
		super.recipients = recipient;
	}

	public Object() {
	};
	
	public Object(List<Item> items, String type, String recipient, String sender){
		
		super.recipients = new ArrayList<>();
		super.recipients.add(recipient);
		super.type = type;
		this.sender = sender;
		this.item = items;
	}
	
	public Object(List<Item> items, String type, String recipient, String sender, String reply){
		
		super.recipients = new ArrayList<>();
		super.recipients.add(recipient);
		super.type = type;
		this.sender = sender;
		this.item = items;
		this.reply = reply;
	}

	public void addItems(List<Item> items) {

		if (this.item == null) {
			this.item = new ArrayList<>();
		}

		for (Item i : items) {
			String t = i.getType();
			if (t.contains("request") == false
					&& t.contains("��������") == false)
				this.item.add(i);
		}
	}

	public void addRows(String itemType, Row row) {

		if (this.item == null) {
			this.item = new ArrayList<>();
		}

		Item i = this.getItemByName(itemType);

		if (i == null) {
			this.item.add(new Item(itemType, row));
		} else {
			i.addRows(row);
		}

	}

	public Item getItemByName(String name) {

		for (Item i : this.item) {
			if (i.getType().equals(name)) {
				return i;
			}
		}

		return null;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void addItem(Item item){
		
		if(this.item == null){
			this.item = new ArrayList<>();
		}
		 
		this.item.add(item);
		
		
	}

	@Override
	public Object getObject() {
		return this;
	}

	@Override
	public Boolean canBePassed(String baseName) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
