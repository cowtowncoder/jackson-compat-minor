package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

// [databind#2704] with xalan2 via jaxp-ri
public class Xalan_2704_CVE_Test extends VulnTestBase
{
    public void testXalan2Vuln() throws Exception
    {
        _testIllegalType(com.sun.org.apache.xalan.internal.lib.sql.JNDIConnectionPool.class,
                Collections.singletonMap("jndiPath", "ldap://127.0.0.1:1389/Exploit"));
    }
}
