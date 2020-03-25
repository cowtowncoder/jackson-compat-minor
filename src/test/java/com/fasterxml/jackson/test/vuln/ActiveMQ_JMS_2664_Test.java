package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class ActiveMQ_JMS_2664_Test
    extends VulnTestBase
{
    public void testRmiProvider() throws Exception
    {
        _testIllegalType(org.apache.activemq.jms.pool.XaPooledConnectionFactory.class,
        // earlier possible different package:
    //    _testIllegalType(org.aoju.bus.proxy.provider.remoting.RmiProvider.class,
                Collections.singletonMap("tmJndiName", "ldap://localhost:1389/MyCalc")
                // note: may need other properties too (tmFromJndi) for real repro
                );
    }
}
