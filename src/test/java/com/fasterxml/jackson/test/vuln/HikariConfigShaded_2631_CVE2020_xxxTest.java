package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class HikariConfigShaded_2631_CVE2020_xxxTest
    extends VulnTestBase
{
    public void testVuln2631() throws Exception
    {
        _testIllegalType(org.apache.hadoop.shaded.com.zaxxer.hikari.HikariConfig.class,
                Collections.singletonMap("metricRegistry", "ldap://127.0.0.1:43658/Exploit"));
    }
}
