package com.fasterxml.jackson.test.vuln;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0VulnCVE2018_7489Test extends VulnTestBase
{
    // [databind#1931]
    public void testDataSources() throws Exception
    {
        _testIllegalType(ComboPooledDataSource.class);
    }
}
