
package ptr.mule.atol;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "sum"
})
public class Payment {

	@JsonProperty("type")
    private PaymentType type;
    @JsonProperty("sum")
    private Double sum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Payment(){}
    
    public Payment(ptr.mule.exchange.Map map){
    	
    	this.type = PaymentType._1;
    	this.sum = map.getDouble("СуммаДокумента");
    	
    }
    
    public PaymentType getType() {
        return this.type;
    }
  
    public void setType(PaymentType type) {
        this.type = type;
    }

    @JsonProperty("sum")
    public Double getSum() {
        return sum;
    }

    @JsonProperty("sum")
    public void setSum(Double sum) {
        this.sum = sum;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
