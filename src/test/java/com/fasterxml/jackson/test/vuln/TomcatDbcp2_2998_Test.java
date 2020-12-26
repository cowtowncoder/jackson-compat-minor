package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class TomcatDbcp2_2998_Test
    extends VulnTestBase
{
    // [databind#2998] (derivative of [databind#2986])
    public void testVuln2998_PerUserPoolDS() throws Exception
    {
        _testIllegalType(
                org.apache.tomcat.dbcp.dbcp2.datasources.PerUserPoolDataSource.class,
                Collections.singletonMap("dataSourceName", "ldap://127.0.0.1:1389/Exploit")
        );
    }

    // [databind#2998] (derivative of [databind#2986])
    public void testVuln2996_SharedPoolDS() throws Exception
    {
        _testIllegalType(
                org.apache.tomcat.dbcp.dbcp2.datasources.SharedPoolDataSource.class,
                Collections.singletonMap("dataSourceName", "ldap://127.0.0.1:1389/Exploit")
        );
    }
}
