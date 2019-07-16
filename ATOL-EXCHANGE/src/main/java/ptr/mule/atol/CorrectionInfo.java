
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
    "base_date",
    "base_number",
    "base_name"
})
public class CorrectionInfo {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    private CorrectionInfoType type;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("base_date")
    private String baseDate;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("base_number")
    private String baseNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("base_name")
    private String baseName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public CorrectionInfoType getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(CorrectionInfoType type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("base_date")
    public String getBaseDate() {
        return baseDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("base_date")
    public void setBaseDate(String baseDate) {
        this.baseDate = baseDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("base_number")
    public String getBaseNumber() {
        return baseNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("base_number")
    public void setBaseNumber(String baseNumber) {
        this.baseNumber = baseNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("base_name")
    public String getBaseName() {
        return baseName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("base_name")
    public void setBaseName(String baseName) {
        this.baseName = baseName;
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
