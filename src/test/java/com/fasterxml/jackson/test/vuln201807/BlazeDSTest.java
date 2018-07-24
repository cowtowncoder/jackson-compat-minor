package com.fasterxml.jackson.test.vuln201807;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class BlazeDSTest extends VulnTestBase
{
    // [databind#]
    public void testDataSources() throws Exception
    {
        _testIllegalType(flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor.class);
    }
}
