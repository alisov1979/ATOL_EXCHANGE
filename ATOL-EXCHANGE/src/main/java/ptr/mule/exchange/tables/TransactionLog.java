package ptr.mule.exchange.tables;

import java.util.Arrays;
import java.util.HashMap;

import ptr.mule.exchange.Item;
import ptr.mule.exchange.Map;
import ptr.mule.exchange.Property;
import ptr.mule.exchange.Row;

public class TransactionLog extends ptr.mule.exchange.Object{
	
	
	public TransactionLog(Map map, String messageSender, HashMap<?,?> response)
	{
				
		super.sender 		= "DiState";
		super.type 			= "РегистрСведений.ПТР_ЛогТранзакцийЭДО";
		super.recipients 	= Arrays.asList(messageSender, "УТ_ЮНИОН");
		//заполнение НабораЗаписей
		Row row = new Row();
		//период
		row.addProperty("Дата", "Период", Map.getNow());
		//документ
		row.addProperty(map.getPropertyByName("Документ"));
		//ответственный
		//row.addProperty(map.getPropertyByName("Ответственный"));
		row.addProperty(new Property("Справочник.Пользователи","Ответственный","00000000-0000-0000-0000-000000000000", new Property("Строка","Код","DiState")));
		// состояние		
		//row.addProperty("Перечисление.ПТР_СостоянияДокументаЮЗДО", "СостояниеДокумента",  "Подписан");
		row.addProperty(map.getPropertyByName("СостояниеДокумента"));
		// статус транзакции
		row.addProperty("Перечисление.ПТР_СтатусыТранзакцииЮЗДО", "СтатусТранзакции", 
				(Boolean) response.get("success") ? "В процессе DiState" : "Отклонена" );
		// текстОшибки
		row.addProperty("Строка", "ТекстОшибки", (String) response.get("comment"));
		
		super.item = Arrays.asList(new Item(row, "РегистрСведений.ПТР_ЛогТранзакцийЭДО", Arrays.asList(messageSender, "УТ_ЮНИОН")));//сообщение возвращается отправителю messageSender
				
	}
	
	

}
