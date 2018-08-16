package com.fasterxml.jackson.test.vuln201807;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class BlazeDSTest extends VulnTestBase
{
    // [databind#2097]
    public void testBlazeExecutor() throws Exception
    {
        _testIllegalType(flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor.class);
    }
}
