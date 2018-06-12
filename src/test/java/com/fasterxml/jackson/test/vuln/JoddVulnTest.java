package com.fasterxml.jackson.test.vuln;

import jodd.db.connection.DataSourceConnectionProvider;

public class JoddVulnTest extends VulnTestBase
{
    public void testConnectionFactory() throws Exception
    {
        _testIllegalType(DataSourceConnectionProvider.class,
                "'ldap://127.0.0.1:1389/Test1'");
    }
}
