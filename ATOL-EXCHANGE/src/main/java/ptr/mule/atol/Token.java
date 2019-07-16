package ptr.mule.atol;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jnr.ffi.annotations.Synchronized;
import ptr.mule.exchange.server.HttpRequest;

public class Token {
	
	private Map<String, DateTimeValue> tokenCache = new HashMap<>();
	private Long livetime;
	private String URL = "https://online.atol.ru/possystem/v4/";
	private Map<String,String> groupCode;
	@Inject
	ObjectMapper jsonMapper;
	@Inject
	HttpRequest httpRequest;
	private Map<String,Auth> auth;
	
	public void init()
	{
		groupCode 					   = new HashMap<String, String>();
		groupCode.put("УТ_СПБ", 		"petrovich-ru_10642");
		groupCode.put("УТ_СЗФО", 		"petrovich-ru_10642");
		groupCode.put("УТ_МСК", 		"petrovich-ru_10642");
		groupCode.put("УТ_ПЕТРОЦЕНТР",  "petrocenter-ru_11485");
		groupCode.put("УТ_СИЛТА", 		"silta-ru_11272");
		////////////////////////////////////////////////////////
		auth 						  = new HashMap<String, Auth>();
		auth.put("УТ_СПБ", 				new Auth("petrovich-ru-1","GQHK0BHkg"));
		auth.put("УТ_СЗФО", 			new Auth("petrovich-ru-1","GQHK0BHkg"));
		auth.put("УТ_МСК", 				new Auth("petrovich-ru-1","GQHK0BHkg"));		
		auth.put("УТ_СИЛТА", 			new Auth("silta-ru","WDcsc2wiK"));
		auth.put("УТ_ПЕТРОЦЕНТР", 		new Auth("petrocenter-ru","KW9MW2afB"));
	}
	
	
	public void getNewToken(String sender) {

		if (isValid(sender) == false)// если токен просрочен, то запрашиваем
										// новый
		{
			String authRequest;
			
			Auth authValue = auth.get(sender);
			
			if(authValue == null)
				throw new RuntimeException("Не найдены параметры авторизации для базы - " + sender);

			try {
				authRequest = jsonMapper.writeValueAsString(authValue);
			} catch (JsonProcessingException e1) {
				throw new RuntimeException(e1);
			}

			HttpRequest.Response response = null;

			try 
			{
				response = httpRequest.execute(URL + "/getToken", "POST", authRequest);

				HashMap<?, ?> mapResponse = jsonMapper.readValue(response.getResponse(), HashMap.class);

				String strToken = (String) mapResponse.get("token");

				setValue(sender, strToken);

			} catch (URISyntaxException | IOException e) 
			{
				throw new RuntimeException(e);
			}

		}

	}	

	public String getValue(String sender) {
		
		if(tokenCache.get(sender) != null)
			return tokenCache.get(sender).getValue();
		
		return null;
	}
	
	public boolean isValid(String sender) {

		Long currentTime = System.currentTimeMillis();
				
		DateTimeValue dateTimeValue = tokenCache.get(sender);
		
		if(dateTimeValue != null)
		{
			Long time = dateTimeValue.getTime();
			
			if ((currentTime - time >= livetime * 60 * 60 * 1000)) 
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		
		return false;
	}

	@Synchronized
	public void setValue(String sender, String value) {
		
		Long currentTime = System.currentTimeMillis();
		Long lastTime 	 = null;
		
		if(tokenCache.get(sender) != null)
			lastTime    = tokenCache.get(sender).getTime();
		
		if (lastTime == null || currentTime - lastTime >= livetime * 60 * 60 * 1000)
		{
			tokenCache.put(sender, new DateTimeValue(value, System.currentTimeMillis()));
		}
		
	}

	public Long getLivetime() {
		return livetime;
	}

	public void setLivetime(Long livetime) {
		this.livetime = livetime;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getGroupCode(String sender) {
		
		if(groupCode.get(sender) == null)
			throw new RuntimeException("Не указан GroupCode для базы - " + sender);
		
		return groupCode.get(sender);
	}
	
	private class DateTimeValue{
		
		protected String value;
		protected Long time;
		
		public DateTimeValue(String value, Long time) {
			super();
			this.value = value;
			this.time = time;
		}

		public String getValue() {
			return value;
		}

		public Long getTime() {
			return time;
		}				
		
	}

	
}
