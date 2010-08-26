/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centraldesktop.mq.openmq;

import com.sun.messaging.ConnectionConfiguration;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.QueueConnection;

/**
 *
 * @author trey
 */
public class QueueConnectionFactory implements javax.jms.QueueConnectionFactory {

    public String serviceUrl = "localhost:7076";
    private com.sun.messaging.QueueConnectionFactory qcf = null;

    public QueueConnectionFactory() throws JMSException {
        qcf = new com.sun.messaging.QueueConnectionFactory();

        qcf.setProperty(ConnectionConfiguration.imqReconnectEnabled, "true");
    }

    public void setServiceUrl(String url) throws JMSException {
        qcf.setProperty(ConnectionConfiguration.imqAddressList,
                url);
    }

    public QueueConnection createQueueConnection() throws JMSException {
        return qcf.createQueueConnection();
    }

    public QueueConnection createQueueConnection(String username, String password) throws JMSException {
        return qcf.createQueueConnection(username, password);
    }

    public Connection createConnection() throws JMSException {
        return qcf.createConnection();
    }

    public Connection createConnection(String username, String password) throws JMSException {
        return qcf.createConnection(username, password);
    }
}
