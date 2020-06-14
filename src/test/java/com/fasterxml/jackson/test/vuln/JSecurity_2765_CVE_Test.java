package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class JSecurity_2765_CVE_Test extends VulnTestBase
{
    public void testOrgJSecurity() throws Exception
    {
        _testIllegalType(org.jsecurity.realm.jndi.JndiRealmFactory.class,
                Collections.singletonMap("jndiNames", "ldap://127.0.0.1:1389/Exploit"));
    }
}
