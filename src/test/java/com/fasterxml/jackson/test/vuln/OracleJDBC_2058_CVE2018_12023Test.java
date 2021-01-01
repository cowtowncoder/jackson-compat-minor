package com.fasterxml.jackson.test.vuln;

// For [databind#2058]
//
// 22-Aug-2020, tatu: Would require use of Oracle Maven repo; leave out,
//   but do not delete code yet (in case it's desired)
public class OracleJDBC_2058_CVE2018_12023Test
    extends VulnTestBase
{
    // Dependency to add in pom.xml:
    /*
<!--
    <dependency>
      <groupId>oracle</groupId>
      <artifactId>ojdbc6</artifactId>
      <version>11.2.0.3</version>
    </dependency>
    <dependency>
      <groupId>javax</groupId>
      <artifactId>javaee-api</artifactId>
      <version>7.0</version>
    </dependency>
-->
     */
    
    
    /*
    public void testConnectionFactory() throws Exception
    {
        _testIllegalType(oracle.jdbc.connector.OracleManagedConnectionFactory.class,
                "{'xadataSourceName':'ldap://127.0.0.1:1389/Test1', 'logWriter':null}");
    }

    public void testRowSet() throws Exception
    {
        // 31-May-2018, tatu: Not sure if "command" property has effect since it should not
        //   get executed without call to `execute()` method?
        _testIllegalType(oracle.jdbc.rowset.OracleJDBCRowSet.class,
                "{'dataSourceName':'ldap://127.0.0.1:1389/Test1', 'command':'SELECT * FROM ACCOUNTS'}");
    }
    */

    public void testBogus() {
        // just so junit won't complain
    }
}
