
package ptr.mule.atol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "company",
    "correction_info",
    "payments",
    "vats"
})
public class Correction {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("company")
    private Company company;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("correction_info")
    private CorrectionInfo correctionInfo;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("payments")
    private List<Payment> payments = null;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vats")
    private List<Vat> vats = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("correction_info")
    public CorrectionInfo getCorrectionInfo() {
        return correctionInfo;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("correction_info")
    public void setCorrectionInfo(CorrectionInfo correctionInfo) {
        this.correctionInfo = correctionInfo;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("payments")
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("payments")
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vats")
    public List<Vat> getVats() {
        return vats;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vats")
    public void setVats(List<Vat> vats) {
        this.vats = vats;
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
