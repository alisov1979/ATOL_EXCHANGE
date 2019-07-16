
package ptr.mule.atol;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    "client",
    "company",
    "items",
    "payments",
    "vats",
    "total",
    "additional_check_props"
})
public class Receipt {

    @JsonProperty("client")
    private Client client;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<>();
    @JsonProperty("payments")
    private List<Payment> payments = new ArrayList<>();
    @JsonProperty("vats")
    private List<Vat> vats = new ArrayList<>();
    @JsonProperty("total")
    private BigDecimal total;
    @JsonProperty("additional_check_props")
    private String additionalCheckProps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public Receipt(){};
    
    public Receipt(ptr.mule.exchange.Map map){
    	
    	this.client 	= new Client(map);
    	this.company  	= new Company(map);
    	this.total 		= map.getDecimal("СуммаДокумента");
    	
    	this.total.setScale(2, BigDecimal.ROUND_HALF_UP);
    	
    	this.payments.add(new Payment(map));
    	
    	if(map.NextItem("Документ.РеализацияТоваровУслуг.Товары")){
    		int i = 0;
    		while (map.NextRow(i)){
    			items.add(new Item(map));
    			i ++;
    		}
    	}
    	
    	if(map.NextItem("Документ.РеализацияТоваровУслуг.Услуги")){
    		int i = 0;
    		while (map.NextRow(i)){
    			items.add(new Item(map));
    			i ++;
    		}
    	}
    	
    	 Map<VatType, BigDecimal> vats =  calculateTotalVat();
    	 
    	 vats.entrySet().forEach(entry -> this.vats.add(new Vat(entry.getKey(), entry.getValue())));
    	
    }


    @JsonProperty("client")
    public Client getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(Client client) {
        this.client = client;
    }

    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonProperty("payments")
    public List<Payment> getPayments() {
        return payments;
    }

    @JsonProperty("payments")
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @JsonProperty("vats")
    public List<Vat> getVats() {
        return vats;
    }

    @JsonProperty("vats")
    public void setVats(List<Vat> vats) {
        this.vats = vats;
    }

    @JsonProperty("total")
    public BigDecimal getTotal() {
        return total;
    }


    @JsonProperty("total")
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @JsonProperty("additional_check_props")
    public String getAdditionalCheckProps() {
        return additionalCheckProps;
    }

    @JsonProperty("additional_check_props")
    public void setAdditionalCheckProps(String additionalCheckProps) {
        this.additionalCheckProps = additionalCheckProps;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    public Map<VatType, BigDecimal> calculateTotalVat(){
    	
    	Map<VatType, BigDecimal> result = new HashMap<VatType, BigDecimal>();
    	
    	VatType[] vatTypes = VatType.values();
    	
    	for (int i = 0; i < vatTypes.length; i++) {
			VatType vatType = vatTypes[i];
			BigDecimal total = new BigDecimal(0);
			total.setScale(2, BigDecimal.ROUND_HALF_UP);
			for(Item it : this.items){				
				if(it.getVat().getType().value().equals(vatType.value()))
					total = total.add(it.getVat().getSum());				
			}
			if (! total.equals(new BigDecimal(0)))
				result.put(vatType, total);
			
		}
    	
    	return result;
    }

}
