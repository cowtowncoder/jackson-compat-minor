package com.fasterxml.jackson.test.vuln;

import com.fasterxml.jackson.databind.*;

/**
 * Tests against vulns based on JDK-bundled (for some JDK versions anyway)
 * serialization gadgets
 */
public class JDKBundledVulnTest extends VulnTestBase
{
    static class Bean1599 {
        public int id;
        public Object obj;
    }

    /*
    /**********************************************************************
    /* Test methods
    /**********************************************************************
     */

    // // // Tests for [databind#1599]

    @SuppressWarnings("deprecation")
    public void testXalanTypes1599() throws Exception
    {
        final String clsName = "com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl";
        final String JSON = aposToQuotes(
 "{'id': 124,\n"
+" 'obj':[ '"+clsName+"',\n"
+"  {\n"
+"    'transletBytecodes' : [ 'AAIAZQ==' ],\n"
+"    'transletName' : 'a.b',\n"
+"    'outputProperties' : { }\n"
+"  }\n"
+" ]\n"
+"}"
        );
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try {
            mapper.readValue(JSON, Bean1599.class);
            fail("Should not pass");
        } catch (JsonMappingException e) {
            _verifySecurityException(e, clsName);
        }
    }

    // // // Tests for [databind#1737]

    public void testJDKTypes1737() throws Exception
    {
        _testIllegalType(java.util.logging.FileHandler.class);
        _testIllegalType(java.rmi.server.UnicastRemoteObject.class);
    }

    // // // Tests for [databind#1855]

    // 05-Jan-2020, tatu: Not present after JDK8; could check for different errors
    //    etc, but for now just comment out.
    /*
    public void testJDKTypes1855() throws Exception
    {
        // apparently included by some version(s) JDK?
        _testIllegalType("com.sun.org.apache.bcel.internal.util.ClassLoader");
    }
    */
}
