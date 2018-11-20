package com.fasterxml.jackson.test.vuln;

public class Axis2Transport2186VulnTest extends VulnTestBase
{
    // [databind#2186]
    public void testRegistryManagedRuntime() throws Exception
    {
        _testIllegalType(org.apache.axis2.transport.jms.JMSOutTransportInfo.class,
                "jms:/ldap://localhost:31337/UnpleasantSurprise");
    }
}
