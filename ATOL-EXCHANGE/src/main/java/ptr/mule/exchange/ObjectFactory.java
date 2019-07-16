
package ptr.mule.exchange;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;



/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the product.specification.stdp.ru package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	  private final static QName _PropertyFile_QNAME = new QName("http://exchange.mule.ptr/", "file");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: product.specification.stdp.ru
     * 
     */
    public ObjectFactory() {
    }

    public GetObjectResponse createGetObjectResponse() {
        return new GetObjectResponse();
    }

 
    public Property createProperty() {
        return new Property();
    }
   

     public GetObject createGetObject(){
    	return new GetObject();
    }
    
    public SetObject createSetObject(){
    	return new SetObject();
    }
    
   
    public Row createRow(){
    	return new Row();
    }
    
    public Item createItem(){
    	return new Item();
    }
    
    
    public Object createObject(){
    	return new Object();
    }
     
    public ArrayOfObjects createArrayOfObjects(){
    	return new ArrayOfObjects();
    }
    
    
    public SimpleType createSimpleType(){
    	return new SimpleType();
    }
    
    public ComplexType createComplesType(){
    	return new ComplexType();
    }

    
   
    
    public SetObjectResponse createSetObjectResponse(){
    	return new SetObjectResponse();
    }
    

    
  
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://exchange.mule.ptr/", name = "file", scope = Property.class)
    public JAXBElement<byte[]> createPropertyFile(byte[] value) {
        return new JAXBElement<byte[]>(_PropertyFile_QNAME, byte[].class, Property.class, ((byte[]) value));
    }

    

}
