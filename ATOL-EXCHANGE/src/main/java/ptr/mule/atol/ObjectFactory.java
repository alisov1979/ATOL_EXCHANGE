
package ptr.mule.atol;

import javax.xml.bind.annotation.XmlRegistry;



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

	 

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: product.specification.stdp.ru
     * 
     */
    public ObjectFactory() {
    }

   public AgentInfo createAgentInfo(){
	   return new AgentInfo();
   }
   
   public Auth createAuth(){
	   return new Auth();
   }
   
   public AuthResponse createAuthResponse(){
	   return new AuthResponse();
   }
   
   public Company createCompany(){
	   return new Company();
   }
    
   public Correction createCorrection(){
	   return new Correction();
   }
   
   public CorrectionInfo createCorrectionInfo(){
	   return new CorrectionInfo();
   }
   
   public DocReg createDocReg(){
	   return new DocReg();
   }
   
   public DocRegCorr createDocRegCorr(){
	   return new DocRegCorr();
   }
   
   public DocRegResponse createDocRegResponse(){
	   return new DocRegResponse();
   }
   
   public Error createError(){
	   return new Error();
   }

   public Item createItem(){
	   return new Item();
   }

   public MoneyTransferOperator createMoneyTransferOperator(){
	   return new MoneyTransferOperator();
   }
   
   public PayingAgent createPayingAgent(){
	   return new PayingAgent();
   }
   
   public Payload createPayload(){
	   return new Payload();
   }

   public Payment createPayment(){
	   return new Payment();
   }

   public Receipt createReceipt(){
	   return new Receipt();
   }
   
   public ReceivePaymentsOperator createReceivePaymentsOperator(){
	   return new ReceivePaymentsOperator();
   }
   
   public Service createService(){
	   return new Service();
   }

   public SupplierInfo createSupplierInfo(){
	   return new SupplierInfo();
   }
   
   public Vat createVat(){
	   return new Vat();
   }
   
   public Client createClient(){
	   return new Client();
   }


}


