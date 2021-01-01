package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class DbcpDriverAdapter_3004_Test
    extends VulnTestBase
{
    // [databind#3004]: first DBCP 1.x/2.x directly

    public void testVuln3004_DBCP1() throws Exception
    {
        _testIllegalType(
                org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS.class,
                Collections.singletonMap("url", "ldap://127.0.0.1:1389/Exploit")
        );
    }

    public void testVuln3004_DBCP2() throws Exception
    {
        _testIllegalType(
                org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS.class,
                Collections.singletonMap("url", "ldap://127.0.0.1:1389/Exploit")
        );
    }
    
    // [databind#3004]: then via various embeddings

    // Apache Drill uber-jar:
    public void testVuln3004DrillAll() throws Exception
    {
        _testIllegalType(
                oadd.org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS.class,
                Collections.singletonMap("url", "ldap://127.0.0.1:1389/Exploit")
        );
    }

    // Tomcat-dbcp(1)
    public void testTomcatDBCP1() throws Exception
    {
        _testIllegalType(
                org.apache.tomcat.dbcp.dbcp.cpdsadapter.DriverAdapterCPDS.class,
                Collections.singletonMap("url", "ldap://127.0.0.1:1389/Exploit")
        );
    }

    // Tomcat-dbcp(2)
    public void testTomcatDBCP2() throws Exception
    {
        _testIllegalType(
                org.apache.tomcat.dbcp.dbcp2.cpdsadapter.DriverAdapterCPDS.class,
                Collections.singletonMap("url", "ldap://127.0.0.1:1389/Exploit")
        );
    }
}
