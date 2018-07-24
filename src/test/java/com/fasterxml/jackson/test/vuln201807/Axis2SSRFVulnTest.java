package com.fasterxml.jackson.test.vuln201807;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class Axis2SSRFVulnTest extends VulnTestBase
{
    // [databind#]
    public void testDataSources() throws Exception
    {
        _testIllegalType(org.apache.axis2.jaxws.spi.handler.HandlerResolverImpl.class);
    }
}
