package com.fasterxml.jackson.test.vuln;

import org.apache.log4j.receivers.db.DriverManagerConnectionSource;
import org.apache.log4j.receivers.db.JNDIConnectionSource;

import com.google.common.collect.ImmutableMap;

public class Log4jExtras_2498_CVE2019_17531Test extends VulnTestBase
{
    public void testManagedConnectionSource() throws Exception
    {
        _testIllegalType(DriverManagerConnectionSource.class,
                ImmutableMap.of("url",
                        "jdbc:h2:tcp://127.0.0.1:1389/~/test"
                )
        );
    }

    public void testJNDIConnectionSource() throws Exception
    {
        _testIllegalType(JNDIConnectionSource.class,
                ImmutableMap.of("jndiLocation",
                        "ldap://localhost:1389/Exploit"
                )
        );
    }
}
