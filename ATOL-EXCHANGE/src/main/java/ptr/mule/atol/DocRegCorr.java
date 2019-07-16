
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
    "timestamp",
    "external_id",
    "service",
    "correction"
})
public class DocRegCorr {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    private String timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("service")
    private Service service;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("correction")
    private Correction correction;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("external_id")
    public String getExternalId() {
        return externalId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("external_id")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("service")
    public Service getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(Service service) {
        this.service = service;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("correction")
    public Correction getCorrection() {
        return correction;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("correction")
    public void setCorrection(Correction correction) {
        this.correction = correction;
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
