package com.fasterxml.jackson.test.vuln201807;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class Slf4jExtTest extends VulnTestBase
{
    // [databind#2097]
    @SuppressWarnings("deprecation")
    public void testSlf4jExt() throws Exception
    {
        _testIllegalType(org.slf4j.ext.EventData.class);
    }
}
