
package ptr.mule.atol;

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
    "email",
    "sno",
    "inn",
    "payment_address"
})
public class Company {

    @JsonProperty("email")
    private String email;
    @JsonProperty("sno")
    private Company.Sno sno;
    @JsonProperty("inn")
    private String inn;
    @JsonProperty("payment_address")
    private String paymentAddress;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public Company(){}
    
    public Company(ptr.mule.exchange.Map map){
    	
    	this.email = "test@petrovich.ru";
    	this.sno = Company.Sno.OSN;
    	this.inn = "5544332219";
    	this.paymentAddress = "https://v4.online.atol.ru";
    	
    }

 
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }


    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("sno")
    public Company.Sno getSno() {
        return sno;
    }

    @JsonProperty("sno")
    public void setSno(Company.Sno sno) {
        this.sno = sno;
    }

    @JsonProperty("inn")
    public String getInn() {
        return inn;
    }

    @JsonProperty("inn")
    public void setInn(String inn) {
        this.inn = inn;
    }

    @JsonProperty("payment_address")
    public String getPaymentAddress() {
        return paymentAddress;
    }


    @JsonProperty("payment_address")
    public void setPaymentAddress(String paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum Sno {

        OSN("osn"),
        USN_INCOME("usn_income"),
        USN_INCOME_OUTCOME("usn_income_outcome"),
        ENVD("envd"),
        ESN("esn"),
        PATENT("patent");
        private final String value;
        private final static Map<String, Company.Sno> CONSTANTS = new HashMap<String, Company.Sno>();

        static {
            for (Company.Sno c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Sno(String value) {
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
        public static Company.Sno fromValue(String value) {
            Company.Sno constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
