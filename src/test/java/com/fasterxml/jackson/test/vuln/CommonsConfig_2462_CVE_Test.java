package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class CommonsConfig_2462_CVE_Test extends VulnTestBase
{
    // [databind#2462] / CVE-2019-?????
    public void testCommonsConfig1() throws Exception
    {
        _testIllegalType(org.apache.commons.configuration.JNDIConfiguration.class,
                Collections.singletonMap("prefix", "ldap://127.0.0.1:1389/Exploit"));
    }

    // Same but with commons-configuration2
    public void testCommonsConfig2() throws Exception
    {
        _testIllegalType(org.apache.commons.configuration2.JNDIConfiguration.class,
                Collections.singletonMap("prefix", "ldap://127.0.0.1:1389/Exploit"));
    }
}
