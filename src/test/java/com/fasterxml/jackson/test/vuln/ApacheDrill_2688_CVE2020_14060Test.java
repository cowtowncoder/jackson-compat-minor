package com.fasterxml.jackson.test.vuln;

import java.util.Collections;
import java.util.Map;

// [CVE-2020-14060]
public class ApacheDrill_2688_CVE2020_14060Test
    extends VulnTestBase
{
    public void testApacheDrill() throws Exception
    {
        final Map<String, String> ARGS = Collections.singletonMap(
                "jndiPath", "rmi://127.0.0.1:1099/calc");

        _testIllegalType(oadd.org.apache.xalan.lib.sql.JNDIConnectionPool.class, ARGS);
    }
}
