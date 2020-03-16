package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

import ch.qos.logback.core.db.JNDIConnectionSource;

public class Logback_2389_VulnTest extends VulnTestBase
{
    // [databind#2389]
    public void testJNDIConnectionSource() throws Exception
    {
        _testIllegalType(JNDIConnectionSource.class,
                Collections.singletonMap("jndiLocation", "address"));
    }
}
