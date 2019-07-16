
package ptr.mule.atol;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "price",
    "quantity",
    "sum",
    "measurement_unit",
    "payment_method",
    "payment_object",
    "vat",
    "agent_info",
    "supplier_info",
    "user_data"
})
public class Item {
 
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("quantity")
    private BigDecimal quantity;
    @JsonProperty("sum")
    private BigDecimal sum;
    @JsonProperty("measurement_unit")
    private String measurementUnit;
    @JsonProperty("payment_method")
    private Item.PaymentMethod paymentMethod;
    @JsonProperty("payment_object")
    private Item.PaymentObject paymentObject;
    @JsonProperty("vat")
    private Vat vat;
    @JsonProperty("agent_info")
    private AgentInfo agentInfo;
    @JsonProperty("supplier_info")
    private SupplierInfo supplierInfo;
    @JsonProperty("user_data")
    private String userData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    
    public Item(){};
    
    public Item(ptr.mule.exchange.Map map){
    	
    	this.name 				= map.getString("НоменклатураНаименование");
    	this.price 				= map.getDecimal("Цена");   	
    	this.quantity 			= map.getDecimal("Количество");
    	this.sum 				= map.getDecimal("Сумма");
    	this.measurementUnit 	= map.getString("ЕдиницаИзмеренияНаименование");
    	this.paymentMethod 		= Item.PaymentMethod.FULL_PAYMENT;
    	this.paymentObject 		= Item.PaymentObject.COMMODITY;
    	this.vat 				= new Vat(map);
    	
    	this.price.setScale(2, BigDecimal.ROUND_HALF_UP);
    	this.sum.setScale(2, BigDecimal.ROUND_HALF_UP);
    	
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
    public BigDecimal getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @JsonProperty("quantity")
    public BigDecimal getQuantity() {
        return quantity;
    }


    @JsonProperty("quantity")
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("sum")
    public BigDecimal getSum() {
        return sum;
    }

    @JsonProperty("sum")
    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @JsonProperty("measurement_unit")
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    @JsonProperty("measurement_unit")
    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    @JsonProperty("payment_method")
    public Item.PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("payment_method")
    public void setPaymentMethod(Item.PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @JsonProperty("payment_object")
    public Item.PaymentObject getPaymentObject() {
        return paymentObject;
    }

    @JsonProperty("payment_object")
    public void setPaymentObject(Item.PaymentObject paymentObject) {
        this.paymentObject = paymentObject;
    }

    @JsonProperty("vat")
    public Vat getVat() {
        return vat;
    }

    @JsonProperty("vat")
    public void setVat(Vat vat) {
        this.vat = vat;
    }

    @JsonProperty("agent_info")
    public AgentInfo getAgentInfo() {
        return agentInfo;
    }

    @JsonProperty("agent_info")
    public void setAgentInfo(AgentInfo agentInfo) {
        this.agentInfo = agentInfo;
    }

    @JsonProperty("supplier_info")
    public SupplierInfo getSupplierInfo() {
        return supplierInfo;
    }

    @JsonProperty("supplier_info")
    public void setSupplierInfo(SupplierInfo supplierInfo) {
        this.supplierInfo = supplierInfo;
    }

    @JsonProperty("user_data")
    public String getUserData() {
        return userData;
    }

    @JsonProperty("user_data")
    public void setUserData(String userData) {
        this.userData = userData;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum PaymentMethod {

        FULL_PREPAYMENT("full_prepayment"),
        PREPAYMENT("prepayment"),
        ADVANCE("advance"),
        FULL_PAYMENT("full_payment"),
        PARTIAL_PAYMENT("partial_payment"),
        CREDIT("credit"),
        CREDIT_PAYMENT("credit_payment");
        private final String value;
        private final static Map<String, Item.PaymentMethod> CONSTANTS = new HashMap<String, Item.PaymentMethod>();

        static {
            for (Item.PaymentMethod c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private PaymentMethod(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Item.PaymentMethod fromValue(String value) {
            Item.PaymentMethod constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }
    

    public enum PaymentObject {

        COMMODITY("commodity"),
        EXCISE("excise"),
        JOB("job"),
        SERVICE("service"),
        GAMBLING_BET("gambling_bet"),
        GAMBLING_PRIZE("gambling_prize"),
        LOTTERY("lottery"),
        LOTTERY_PRIZE("lottery_prize"),
        INTELLECTUAL_ACTIVITY("intellectual_activity"),
        PAYMENT("payment"),
        AGENT_COMMISSION("agent_commission"),
        COMPOSITE("composite"),
        ANOTHER("another");
        private final String value;
        private final static Map<String, Item.PaymentObject> CONSTANTS = new HashMap<String, Item.PaymentObject>();

        static {
            for (Item.PaymentObject c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private PaymentObject(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Item.PaymentObject fromValue(String value) {
            Item.PaymentObject constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }
        
    }

}
