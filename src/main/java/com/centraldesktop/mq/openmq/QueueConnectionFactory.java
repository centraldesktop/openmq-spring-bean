/*
 * Copyright CentraldDesktop.com 2010
 * Licensed to all under the Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
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
        serviceUrl = url;
        qcf.setProperty(ConnectionConfiguration.imqAddressList,
                url);
    }

    @Override
    public QueueConnection createQueueConnection() throws JMSException {
        return qcf.createQueueConnection();
    }

    @Override
    public QueueConnection createQueueConnection(String username, String password) throws JMSException {
        return qcf.createQueueConnection(username, password);
    }

    @Override
    public Connection createConnection() throws JMSException {
        return qcf.createConnection();
    }

    @Override
    public Connection createConnection(String username, String password) throws JMSException {
        return qcf.createConnection(username, password);
    }
}
