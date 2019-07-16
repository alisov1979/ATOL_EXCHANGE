package ptr.mule.atol;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentType {
	
    _0(0),
    _1(1),
    _2(2),
    _3(3),
    _4(4),
    _5(5),
    _6(6),
    _7(7),
    _8(8),
    _9(9);
    private final Integer value;
    private final static Map<Integer, PaymentType> CONSTANTS = new HashMap<Integer, PaymentType>();

    static {
        for (PaymentType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private PaymentType(Integer value) {
        this.value = value;
    }

    @JsonValue
    public Integer value() {
        return this.value;
    }

    @JsonCreator
    public static PaymentType fromValue(Double value) {
        PaymentType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
