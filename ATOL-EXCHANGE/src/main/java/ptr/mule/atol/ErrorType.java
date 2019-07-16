package ptr.mule.atol;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {
	
    NONE("none"),
    UNKNOWN("unknown"),
    SYSTEM("system"),
    DRIVER("driver"),
    TIMEOUT("timeout"),
	AGENT("agent");
    private final String value;
    private final static Map<String, ErrorType> CONSTANTS = new HashMap<String, ErrorType>();

    static {
        for (ErrorType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }
    
    private ErrorType(String value) {
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
    public static ErrorType fromValue(String value) {
        ErrorType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

	public String getValue() {
		return value;
	}
    
    

}
