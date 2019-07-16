package ptr.mule.atol;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum VatType {
	
	   NONE("none"),
       VAT_0("vat0"),
       VAT_10("vat10"),
       VAT_18("vat18"),
       VAT_110("vat110"),
       VAT_118("vat118");
       private final String value;
       private final static Map<String, VatType> CONSTANTS = new HashMap<String, VatType>();
       private final static java.util.Map<String, String> str =  new HashMap<String, String>();
       static {
           for (VatType c: values()) {
               CONSTANTS.put(c.value, c);
           }
                     
        	str.put("Без НДС", "none");
        	str.put("0%", "vat0");
        	str.put("18% / 118%", "vat118");
        	str.put("18%", "vat18");
        	str.put("10% / 110%", "vat110");
        	str.put("10%", "vat10");
        	str.put("20% / 120%", "vat120");
        	str.put("20%", "vat20");
           
       }

       private VatType(String value) {
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
       public static VatType fromValue(String value) {
           VatType constant = CONSTANTS.get(str.get(value));
           if (constant == null) {
               throw new IllegalArgumentException(value);
           } else {
               return constant;
           }
       }

}
