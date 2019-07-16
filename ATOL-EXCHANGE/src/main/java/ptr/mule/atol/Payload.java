
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
    "fiscal_receipt_number",
    "shift_number",
    "receipt_datetime",
    "total",
    "fn_number",
    "ecr_registration_number",
    "fiscal_document_number",
    "fiscal_document_attribute",
    "fns_site"
})
public class Payload {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fiscal_receipt_number")
    private Long fiscalReceiptNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shift_number")
    private Long shiftNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("receipt_datetime")
    private String receiptDatetime;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("total")
    private Double total;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fn_number")
    private String fnNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ecr_registration_number")
    private String ecrRegistrationNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fiscal_document_number")
    private Long fiscalDocumentNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fiscal_document_attribute")
    private Long fiscalDocumentAttribute;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fns_site")
    private String fnsSite;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fiscal_receipt_number")
    public Long getFiscalReceiptNumber() {
        return fiscalReceiptNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fiscal_receipt_number")
    public void setFiscalReceiptNumber(Long fiscalReceiptNumber) {
        this.fiscalReceiptNumber = fiscalReceiptNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shift_number")
    public Long getShiftNumber() {
        return shiftNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shift_number")
    public void setShiftNumber(Long shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("receipt_datetime")
    public String getReceiptDatetime() {
        return receiptDatetime;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("receipt_datetime")
    public void setReceiptDatetime(String receiptDatetime) {
        this.receiptDatetime = receiptDatetime;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("total")
    public Double getTotal() {
        return total;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("total")
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fn_number")
    public String getFnNumber() {
        return fnNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fn_number")
    public void setFnNumber(String fnNumber) {
        this.fnNumber = fnNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ecr_registration_number")
    public String getEcrRegistrationNumber() {
        return ecrRegistrationNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ecr_registration_number")
    public void setEcrRegistrationNumber(String ecrRegistrationNumber) {
        this.ecrRegistrationNumber = ecrRegistrationNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fiscal_document_number")
    public Long getFiscalDocumentNumber() {
        return fiscalDocumentNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fiscal_document_number")
    public void setFiscalDocumentNumber(Long fiscalDocumentNumber) {
        this.fiscalDocumentNumber = fiscalDocumentNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fiscal_document_attribute")
    public Long getFiscalDocumentAttribute() {
        return fiscalDocumentAttribute;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fiscal_document_attribute")
    public void setFiscalDocumentAttribute(Long fiscalDocumentAttribute) {
        this.fiscalDocumentAttribute = fiscalDocumentAttribute;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fns_site")
    public String getFnsSite() {
        return fnsSite;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fns_site")
    public void setFnsSite(String fnsSite) {
        this.fnsSite = fnsSite;
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
