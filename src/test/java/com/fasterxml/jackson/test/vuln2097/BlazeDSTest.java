package com.fasterxml.jackson.test.vuln2097;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class BlazeDSTest extends VulnTestBase
{
    // [databind#2097]
    public void testBlazeExecutor() throws Exception
    {
        // 19-Nov-2018, tatu: I can't seem to get dependencies included, so need to
        //   leave this out, unfortunately.
        
//        _testIllegalType(flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor.class);
    }
}
