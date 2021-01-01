package com.fasterxml.jackson.test.vuln26xx;

import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class ActiveMQ_JMS_2664_Test
    extends VulnTestBase
{
    public void testRmiProvidersActiveMqCore() throws Exception
    {
        // note: may need other properties too for real repro
        final Map<String, String> ARGS = Collections.singletonMap(
                "brokerURL", "ldap://localhost:1389/MyCalc");

        // from activemq-core
        _testIllegalType(org.apache.activemq.ActiveMQConnectionFactory.class, ARGS);
        _testIllegalType(org.apache.activemq.ActiveMQXAConnectionFactory.class, ARGS);

        _testIllegalType(org.apache.activemq.spring.ActiveMQConnectionFactory.class, ARGS);
        _testIllegalType(org.apache.activemq.spring.ActiveMQXAConnectionFactory.class, ARGS);
    }

    public void testRmiProvidersActiveMqPool() throws Exception
    {
        // note: may need other properties too (tmFromJndi) for real repro
        final Map<String, String> ARGS = Collections.singletonMap(
                "tmJndiName", "ldap://localhost:1389/MyCalc");

        // from activemq-pool
        _testIllegalType(org.apache.activemq.pool.JcaPooledConnectionFactory.class, ARGS);
        _testIllegalType(org.apache.activemq.pool.PooledConnectionFactory.class, ARGS);
        _testIllegalType(org.apache.activemq.pool.XaPooledConnectionFactory.class, ARGS);
    }

    public void testRmiProvidersActiveMqJmsPool() throws Exception
    {
        // note: may need other properties too (tmFromJndi) for real repro
        final Map<String, String> ARGS = Collections.singletonMap(
                "tmJndiName", "ldap://localhost:1389/MyCalc");

        // from activemq-jms-pool
        _testIllegalType(org.apache.activemq.jms.pool.XaPooledConnectionFactory.class, ARGS);
        _testIllegalType(org.apache.activemq.jms.pool.JcaPooledConnectionFactory.class, ARGS);
    }
}
