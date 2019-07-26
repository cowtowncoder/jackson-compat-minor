package com.fasterxml.jackson.test.vuln;

import oracle.jdbc.connector.OracleManagedConnectionFactory;
import oracle.jdbc.rowset.OracleJDBCRowSet;

public class OracleJDBCVulnCVE2018_12023Test extends VulnTestBase
{
    public void testConnectionFactory() throws Exception
    {
        _testIllegalType(OracleManagedConnectionFactory.class,
                "{'xadataSourceName':'ldap://127.0.0.1:1389/Test1', 'logWriter':null}");
    }

    public void testRowSet() throws Exception
    {
        // 31-May-2018, tatu: Not sure if "command" property has effect since it should not
        //   get executed without call to `execute()` method?
        _testIllegalType(OracleJDBCRowSet.class,
                "{'dataSourceName':'ldap://127.0.0.1:1389/Test1', 'command':'SELECT * FROM ACCOUNTS'}");
    }
}
