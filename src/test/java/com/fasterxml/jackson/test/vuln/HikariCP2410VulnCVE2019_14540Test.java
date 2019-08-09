package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

import com.zaxxer.hikari.HikariConfig;

public class HikariCP2410VulnCVE2019_14540Test extends VulnTestBase
{
    // [dataind#2410]
    public void testCXFXsltProvider() throws Exception
    {
        _testIllegalType(HikariConfig.class,
                Collections.singletonMap("metricRegistry", "rmi//localhost:1999/evil"));
    }
}
