package com.fasterxml.jackson.test.vuln2097;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class Axis2SSRFVulnTest extends VulnTestBase
{
    // [databind#2097]
    public void testAxis2HandlerResolver() throws Exception
    {
        _testIllegalType(org.apache.axis2.jaxws.spi.handler.HandlerResolverImpl.class);
    }
}
