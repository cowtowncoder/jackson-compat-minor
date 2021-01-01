package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class Docx4jXalan_3003_Test
    extends VulnTestBase
{
    // [databind#3003] (derivative of [databind#2469])
    public void testVuln3003_JNDI_ConnectionPool() throws Exception
    {
        _testIllegalType(
                org.docx4j.org.apache.xalan.lib.sql.JNDIConnectionPool.class,
                Collections.singletonMap("jndiPath", "ldap://127.0.0.1:1389/Exploit")
        );
    }
}
