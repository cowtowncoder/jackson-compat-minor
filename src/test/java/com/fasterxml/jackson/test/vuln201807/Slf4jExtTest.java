package com.fasterxml.jackson.test.vuln201807;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class Slf4jExtTest extends VulnTestBase
{
    // [databind#]
    @SuppressWarnings("deprecation")
    public void testDataSources() throws Exception
    {
        _testIllegalType(org.slf4j.ext.EventData.class);
    }
}
