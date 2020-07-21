package com.fasterxml.jackson.test.vuln;

public class ComPastdev_2798_CVE2020_Test extends VulnTestBase
{
    public void testJndiConfiguration() throws Exception
    {
        _testIllegalType(com.pastdev.httpcomponents.configuration.JndiConfiguration.class,
                "ldap://127.0.0.1:1389/Exploit");
    }
}
