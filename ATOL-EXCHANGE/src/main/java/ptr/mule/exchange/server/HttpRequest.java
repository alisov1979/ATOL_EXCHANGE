package ptr.mule.exchange.server;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.commons.lang.StringEscapeUtils;

public class HttpRequest {

	protected CloseableHttpClient httpClient;
	
	public void init()
	{			
		this.httpClient 		= HttpClients.createDefault();
	}
	
	public void destroy()
	{
		//попытка закрыть соединение, выполняется 3 раза
		for (int i = 0; i < 3; i ++ )
		{
			try 
			{
				this.httpClient.close();
				break;
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
				
	}
	
	public Response execute(String url, String type, String payload) throws ClientProtocolException, URISyntaxException, IOException
	{
		switch (type) {
		case "GET":
			return httpGet(url);		
		case "POST":
			return httpPost(url, payload);	
		default:
			return null;
		}		
	}

	public Response httpPost(String url, String payload) throws URISyntaxException, ClientProtocolException, IOException{
					
		HttpPost httpPost =  new HttpPost();		
		httpPost.addHeader("content-type", "application/json");
		httpPost.addHeader("Accept-Encoding", "utf-8");
		httpPost.addHeader("Content-Encoding", "utf-8");		
		httpPost.setEntity(new StringEntity(payload, ContentType.create("application/json", "UTF-8")));
		httpPost.setURI(new URI(url));
		
		int CONNECTION_TIMEOUT_MS = 10 * 1000; // Timeout in millis.
		RequestConfig requestConfig = RequestConfig.custom()
		    .setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS)
		    .setConnectTimeout(CONNECTION_TIMEOUT_MS)
		    .setSocketTimeout(CONNECTION_TIMEOUT_MS)
		    .build();
		httpPost.setConfig(requestConfig);
		
		HttpResponse httpResponse = this.httpClient.execute(httpPost);//, this.localContext);		
		HttpEntity httpEntity  = httpResponse.getEntity();
		
		Response response = new Response();
		int code = httpResponse.getStatusLine().getStatusCode();
		String desc = EntityUtils.toString(httpEntity, "UTF-8");
		
		response.setCode(code);
		response.setResponse(desc);
		
		return 	response;
	}
	
	public Response httpGet(String url) throws URISyntaxException, ClientProtocolException, IOException{

		HttpGet httpGet = new HttpGet();
		
		httpGet.setURI(new URI(url));
		
		int CONNECTION_TIMEOUT_MS = 10 * 1000; // Timeout in millis.
		RequestConfig requestConfig = RequestConfig.custom()
		    .setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS)
		    .setConnectTimeout(CONNECTION_TIMEOUT_MS)
		    .setSocketTimeout(CONNECTION_TIMEOUT_MS)
		    .build();
		httpGet.setConfig(requestConfig);
		
		httpGet.addHeader("content-type", "application/json");
		httpGet.addHeader("Accept-Encoding", "utf-8");
		httpGet.addHeader("Content-Encoding", "utf-8");		
		
		HttpResponse httpResponse = this.httpClient.execute(httpGet);
		HttpEntity httpEntity = httpResponse.getEntity();
		String reply = null;
		
		if (httpEntity != null)
			reply = IOUtils.toString(httpEntity.getContent(), "utf-8"); 
		
		return new Response(httpResponse.getStatusLine().getStatusCode(), 
				httpEntity != null ? reply : null);
	}
	
	public class Response
	{
		private Integer code;
		private String response;
		
		public Response(){};
		
		public Response(Integer code, String response) {
			super();
			this.code = code;
			this.response = response;
		}

		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}
		
		
	}
	

	

	

}
