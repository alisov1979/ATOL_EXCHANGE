
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
    "uuid",
    "timestamp",
    "group_code",
    "daemon_code",
    "device_code",
    "external_id",
    "callback_url",
    "status",
    "error",
    "payload"
})
public class DocRegResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uuid")
    private String uuid;
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
    @JsonProperty("group_code")
    private String groupCode;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("daemon_code")
    private String daemonCode;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("device_code")
    private String deviceCode;
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("callback_url")
    private String callbackUrl;
    @JsonProperty("status")
    private DocRegResponse.Status status;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("error")
    private Error error;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("payload")
    private Payload payload;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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
    @JsonProperty("group_code")
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("group_code")
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("daemon_code")
    public String getDaemonCode() {
        return daemonCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("daemon_code")
    public void setDaemonCode(String daemonCode) {
        this.daemonCode = daemonCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("device_code")
    public String getDeviceCode() {
        return deviceCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("device_code")
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    @JsonProperty("external_id")
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty("external_id")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("callback_url")
    public String getCallbackUrl() {
        return callbackUrl;
    }

    @JsonProperty("callback_url")
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @JsonProperty("status")
    public DocRegResponse.Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(DocRegResponse.Status status) {
        this.status = status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("error")
    public Error getError() {
        return error;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("error")
    public void setError(Error error) {
        this.error = error;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("payload")
    public Payload getPayload() {
        return payload;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("payload")
    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum Status {

        WAIT("wait"),
        DONE("done"),
        FAIL("fail");
        private final String value;
        private final static Map<String, DocRegResponse.Status> CONSTANTS = new HashMap<String, DocRegResponse.Status>();

        static {
            for (DocRegResponse.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Status(String value) {
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
        public static DocRegResponse.Status fromValue(String value) {
            DocRegResponse.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
