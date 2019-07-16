package ptr.mule.exchange;

import java.util.Arrays;

public class PrintedBills extends Object{

	private static final long serialVersionUID = 2774096662131930268L;

	public PrintedBills(Map map, String base){
			
		super.type = "";
		super.recipients = Arrays.asList(base);
		super.sender  = base;
		super.time = String.valueOf(System.currentTimeMillis());
		
		Property Документ = map.getPropertyByName("Документ");
		Property ПризнакРасчета = map.getPropertyByName("ПризнакРасчетаЧека");
		Property ПризнакСпособаРасчетаЧека = map.getPropertyByName("ПризнакСпособаРасчетаЧека");
				
		Row row = new Row().add(ПризнакРасчета.getType(), "ПризнакРасчетаЧека", ПризнакРасчета.getValue())
				.add(ПризнакСпособаРасчетаЧека.getType(), "ПризнакСпособаРасчетаЧека", ПризнакСпособаРасчетаЧека.getValue())
				.add(Документ.getType(), "Документ", Документ.getValue());
		
		super.item = Arrays.asList(new Item("request", row));
		
	}
	
	public PrintedBills(Property Документ,Property ПризнакРасчета, Property ПризнакСпособаРасчетаЧека , String base){
		
		super.type = "РегистрСведений.РаспечатанныеЧеки.ДобавитьЗаписьНаРегистр";
		super.recipients = Arrays.asList(base);
		super.sender  = base;
		super.time = String.valueOf(System.currentTimeMillis());
						
		Row row = new Row().add(ПризнакРасчета.getType(), "ПризнакРасчетаЧека", ПризнакРасчета.getValue())
				.add(ПризнакСпособаРасчетаЧека.getType(), "ПризнакСпособаРасчетаЧека", ПризнакСпособаРасчетаЧека.getValue())
				.add(Документ.getType(), "Документ", Документ.getValue());
		
		super.item = Arrays.asList(new Item("request", row));
		
	}

}
