
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
    "email"
})
public class Client {

    @JsonProperty("email")
    private String email = "";   
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

   
    public Client(){}
    
    public Client(ptr.mule.exchange.Map map){
    	this.email = "alisov1979@gmail.com";//map.getString("МейлКонтрагента");
    }  
    
    
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

   
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
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
