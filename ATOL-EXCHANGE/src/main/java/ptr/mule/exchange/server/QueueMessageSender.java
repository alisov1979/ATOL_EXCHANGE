package ptr.mule.exchange.server;


import java.util.UUID;
import javax.inject.Inject;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.logging.LogFactory;
import org.mule.transport.jms.activemq.ActiveMQJmsConnector;

import ptr.mule.exchange.AtolRequest;
import ptr.mule.exchange.Object;

public class QueueMessageSender { 

	@Inject
	private ActiveMQJmsConnector mqGet;

	private org.apache.commons.logging.Log logger = LogFactory.getLog(this.getClass());

	private Session session;

	public void destroy() throws JMSException {
		if (this.session != null)
			this.session.close();
	}


	public void sendObject(AtolRequest message, String queueName) throws JMSException, RuntimeException {

		sendToQueue(message, queueName);
	}

	public void sendObject(String message, String queueName) throws JMSException, RuntimeException {

		sendToQueue(message, queueName);

	}
	
	public void sendObject(Object message, String queueName) throws JMSException, RuntimeException {

		sendToQueue(message, queueName);

	}


	private void sendToQueue(AtolRequest message, String queueName) throws JMSException, RuntimeException {

		if (this.session == null)
			this.session = mqGet.getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);

		MessageProducer producer = null;

		try {
			producer = session.createProducer(new ActiveMQQueue(queueName));
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			ObjectMessage msg = session.createObjectMessage(message);
			msg.setJMSType("OBJECT");
			msg.setJMSCorrelationID(UUID.randomUUID().toString());
			producer.send(msg);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		} finally {
			if (producer != null)
				producer.close();
			else {
				this.session.close();
				this.session = null;
			}

		}
	}
	
	private void sendToQueue(Object message, String queueName) throws JMSException, RuntimeException {

		if (this.session == null)
			this.session = mqGet.getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);

		MessageProducer producer = null;

		try {
			producer = session.createProducer(new ActiveMQQueue(queueName));
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			ObjectMessage msg = session.createObjectMessage(message);
			msg.setJMSType("OBJECT");
			msg.setJMSCorrelationID(UUID.randomUUID().toString());
			producer.send(msg);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		} finally {
			if (producer != null)
				producer.close();
			else {
				this.session.close();
				this.session = null;
			}

		}
	}


	private void sendToQueue(String object, String queueName) throws JMSException, RuntimeException {

		if (this.session == null)
			this.session = mqGet.getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);

		MessageProducer producer = null;

		try {
			producer = session.createProducer(new ActiveMQQueue(queueName));
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			TextMessage msg = session.createTextMessage(object);
			msg.setJMSType("OBJECT");
			msg.setJMSCorrelationID(UUID.randomUUID().toString());
			producer.send(msg);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		} finally {
			if (producer != null)
				producer.close();
			else {
				this.session.close();
				this.session = null;
			}

		}

	}

}
