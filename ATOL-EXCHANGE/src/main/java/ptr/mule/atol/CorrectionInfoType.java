package ptr.mule.atol;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CorrectionInfoType {
	
	  SELF("self"),
      INSTRUCTION("instruction");
      private final String value;
      private final static Map<String, CorrectionInfoType> CONSTANTS = new HashMap<String, CorrectionInfoType>();

      static {
          for (CorrectionInfoType c: values()) {
              CONSTANTS.put(c.value, c);
          }
      }

      private CorrectionInfoType(String value) {
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
      public static CorrectionInfoType fromValue(String value) {
          CorrectionInfoType constant = CONSTANTS.get(value);
          if (constant == null) {
              throw new IllegalArgumentException(value);
          } else {
              return constant;
          }
      }


}
