package com.fasterxml.jackson.test.vuln2186;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class Axis2TransportVulnTest extends VulnTestBase
{
    // [databind#2186]
    public void testRegistryManagedRuntime() throws Exception
    {
        _testIllegalType(org.apache.axis2.transport.jms.JMSOutTransportInfo.class,
                "jms:/ldap://localhost:31337/UnpleasantSurprise");
    }
}
