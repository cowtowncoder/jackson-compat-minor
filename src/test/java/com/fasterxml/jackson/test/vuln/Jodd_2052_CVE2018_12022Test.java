package com.fasterxml.jackson.test.vuln;

import jodd.db.connection.DataSourceConnectionProvider;

// [databind#2052]
public class Jodd_2052_CVE2018_12022Test extends VulnTestBase
{
    public void testConnectionFactory() throws Exception
    {
        _testIllegalType(DataSourceConnectionProvider.class,
                "'ldap://127.0.0.1:1389/Test1'");
    }
}
