
package ptr.mule.atol;

import java.math.BigDecimal;
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
public class Vat {

    @JsonProperty("type")
    private VatType type;
    @JsonProperty("sum")
    private BigDecimal sum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Vat(){};
  
    public Vat(ptr.mule.exchange.Map map){
    		
    	this.type = VatType.fromValue(map.getString("СтавкаНДС"));
    	this.sum  = map.getDecimal("СуммаНДС");
	
    }
    
 
    public Vat(VatType type, BigDecimal sum) {
		super();
		this.type = type;
		this.sum = sum;
	}

	public VatType getType() {
        return type;
    }

   
    public void setType(VatType type) {
        this.type = type;
    }

    @JsonProperty("sum")
    public BigDecimal getSum() {
        return sum;
    }

    @JsonProperty("sum")
    public void setSum(BigDecimal sum) {
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
