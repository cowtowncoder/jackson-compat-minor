package com.fasterxml.jackson.test.vuln1xxx;

import org.apache.ibatis.parsing.XPathParser;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class IBatis_1931_CVE2018_11307Test extends VulnTestBase
{
    // [databind#1931]
    public void testXPathParser() throws Exception
    {
        // 30-May-2018, tatu: NOTE! Not actual vulnerability code (requires more elaborate
        //    XML with DTD and parsed external entities), just verifies that handling blocked
        _testIllegalType(XPathParser.class, "'<root>value</root>'");
    }
}
