package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

import ch.qos.logback.core.db.JNDIConnectionSource;

public class LogbackVuln_2389Test extends VulnTestBase
{
    // [databind#2389]
    public void testJNDIConnectionSource() throws Exception
    {
        _testIllegalType(JNDIConnectionSource.class,
                Collections.singletonMap("jndiLocation", "address"));
    }
}
