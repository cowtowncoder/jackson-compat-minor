package com.fasterxml.jackson.test.vuln26xx;

import java.util.Collections;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class HikariConfigShaded_2631_CVE2020_9546Test
    extends VulnTestBase
{
    public void testVuln2631() throws Exception
    {
        _testIllegalType(org.apache.hadoop.shaded.com.zaxxer.hikari.HikariConfig.class,
                Collections.singletonMap("metricRegistry", "ldap://127.0.0.1:43658/Exploit"));
    }
}
