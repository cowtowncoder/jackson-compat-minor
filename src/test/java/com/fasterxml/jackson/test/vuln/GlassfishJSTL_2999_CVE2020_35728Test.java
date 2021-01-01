package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

// [databind#2999] / CVE-2020-35728
public class GlassfishJSTL_2999_CVE2020_35728Test
    extends VulnTestBase
{
    // [databind#2999] (derivative of [databind#2469])
    public void testVuln2999_JNDI_ConnectionPool() throws Exception
    {
        _testIllegalType(
                com.oracle.wls.shaded.org.apache.xalan.lib.sql.JNDIConnectionPool.class,
                Collections.singletonMap("jndiPath", "ldap://127.0.0.1:1389/Exploit")
        );
    }
}
