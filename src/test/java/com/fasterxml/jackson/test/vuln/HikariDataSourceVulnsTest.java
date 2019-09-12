package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceVulnsTest extends VulnTestBase
{
    // [dataind#2410]
    public void testHikariConfig() throws Exception
    {
        _testIllegalType(HikariConfig.class,
                Collections.singletonMap("metricRegistry", "rmi//localhost:1999/evil"));
    }

    // [dataind#2449]
    public void testHikariDatasource() throws Exception
    {
        _testIllegalType(HikariDataSource.class,
                Collections.singletonMap("metricRegistry", "rmi//localhost:1999/evil"));
    }
}
