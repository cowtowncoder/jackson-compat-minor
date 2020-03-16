package com.fasterxml.jackson.test.vuln;

import org.apache.ibatis.parsing.XPathParser;

public class IBatis_CVE2018_11307_VulnTest extends VulnTestBase
{
    // [databind#1931]
    public void testXPathParser() throws Exception
    {
        // 30-May-2018, tatu: NOTE! Not actual vulnerability code (requires more elaborate
        //    XML with DTD and parsed external entities), just verifies that handling blocked
        _testIllegalType(XPathParser.class, "'<root>value</root>'");
    }
}
