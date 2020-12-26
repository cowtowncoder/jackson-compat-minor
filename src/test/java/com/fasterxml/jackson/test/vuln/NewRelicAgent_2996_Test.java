package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class NewRelicAgent_2996_Test
    extends VulnTestBase
{
    // [databind#2996] (derivative of [databind#2334])
    public void testVuln2996_JNDI() throws Exception
    {
        _testIllegalType(
                com.newrelic.agent.deps.ch.qos.logback.core.db.JNDIConnectionSource.class,
                Collections.singletonMap("jndiLocation", "ldap://127.0.0.1:1389/Exploit")
        );
    }

    // [databind#2996] (derivative of [databind#2389])
    public void testVuln2996_DriverMCS() throws Exception
    {
        _testIllegalType(
                com.newrelic.agent.deps.ch.qos.logback.core.db.DriverManagerConnectionSource.class,
                Collections.singletonMap("url", "ldap://127.0.0.1:1389/Exploit")
        );
    }
}
