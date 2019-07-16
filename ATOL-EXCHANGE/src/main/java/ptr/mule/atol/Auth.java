
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
    "login",
    "pass"
})
public class Auth {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("login")
    private String login;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pass")
    private String pass;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pass")
    public String getPass() {
        return pass;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pass")
    public void setPass(String pass) {
        this.pass = pass;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public Auth(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}
    
	public Auth() {

	}
    

}
