package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class TomcatDbcp1_2997_Test
    extends VulnTestBase
{
    // [databind#2997] (derivative of [databind#2334])
    public void testVuln2996_JNDI() throws Exception
    {
        _testIllegalType(
                org.apache.tomcat.dbcp.dbcp.datasources.PerUserPoolDataSource.class,
                Collections.singletonMap("dataSourceName", "ldap://127.0.0.1:1389/Exploit")
        );
    }

    // [databind#2997] (derivative of [databind#2389])
    public void testVuln2996_DriverMCS() throws Exception
    {
        _testIllegalType(
                org.apache.tomcat.dbcp.dbcp.datasources.SharedPoolDataSource.class,
                Collections.singletonMap("dataSourceName", "ldap://127.0.0.1:1389/Exploit")
        );
    }
}
