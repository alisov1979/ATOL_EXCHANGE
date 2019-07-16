package ptr.mule.exchange;

import java.util.Arrays;

public class LogToBase extends Object{
	
	
	public LogToBase(String sender){
		
		Row row  = new Row().add("Дата", "Период", Map.getNow());
						
		this.item = Arrays.asList(new Item(row,"РегистрСведений.ПТР_ОбменДаннымиПоПечатиЧеков", Arrays.asList(sender, "УТ_ЮНИОН")));
		
		this.recipients = Arrays.asList(sender, "УТ_ЮНИОН");
		this.type = "РегистрСведений.ПТР_ОбменДаннымиПоПечатиЧеков";
		this.sender = sender;
				
	}
	
		
	public LogToBase add(String type, String name, String value){
		
		Row row = this.item.get(0).getRow().get(0);
		
		row.add(type, name, value);
				
		return this;
		
	}
	
	
	

	
	
}
