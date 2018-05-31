package com.fasterxml.jackson.test.vuln;

import oracle.jdbc.connector.OracleManagedConnectionFactory;

public class OracleJDBCVulnTest extends VulnTestBase
{
    public void testConnectionFactory() throws Exception
    {
        _testIllegalType(OracleManagedConnectionFactory.class,
                "{'xadataSourceName':'ldap://127.0.0.1:1389/Test1', 'logWriter':null}");
    }
}
