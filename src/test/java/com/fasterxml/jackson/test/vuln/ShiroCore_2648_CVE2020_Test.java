package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class ShiroCore_2648_CVE2020_Test
    extends VulnTestBase
{
    public void testVuln2648() throws Exception
    {
        _testIllegalType(org.apache.shiro.realm.jndi.JndiRealmFactory.class,
                Collections.singletonMap("jndiNames", "ldap://127.0.0.1:43658/Exploit"));
    }
}
