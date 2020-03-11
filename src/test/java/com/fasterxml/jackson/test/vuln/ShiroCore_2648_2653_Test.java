package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class ShiroCore_2648_2653_Test
    extends VulnTestBase
{
    public void testVuln2648() throws Exception
    {
        _testIllegalType(org.apache.shiro.realm.jndi.JndiRealmFactory.class,
                Collections.singletonMap("jndiNames", "ldap://127.0.0.1:43658/Exploit"));
    }

    public void testVuln2653() throws Exception
    {
        _testIllegalType(org.apache.shiro.jndi.JndiObjectFactory.class,
                Collections.singletonMap("resourceName", "ldap://127.0.0.1:43658/Exploit"));
    }
}
