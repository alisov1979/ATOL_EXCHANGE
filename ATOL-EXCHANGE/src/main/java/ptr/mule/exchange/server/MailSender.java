package ptr.mule.exchange.server;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class MailSender {
	
	 private String to;         // sender email 
     private String from;        // receiver email 
     private String host; 
     private Properties properties;
     private Log logger = LogFactory.getLog(getClass());
     
     public void init(){
    	 
    	 this.properties = System.getProperties(); 
    	 
         properties.setProperty("mail.smtp.host", this.host); 	   	 
     }
     
     public void send(String text){
    	 
    	 Session session = Session.getDefaultInstance(properties); // default session 
         
		try {
			MimeMessage message = new MimeMessage(session); // email message
			message.setFrom(new InternetAddress(from)); // setting header fields
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Ошибка при отправке чека в АТОЛ."); // subject line
			message.setText(text);
			Transport.send(message);
		} catch (MessagingException mex) {
			logger.error(mex.getMessage());
		}

     }

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
     
     

}
