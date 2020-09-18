package com.fasterxml.jackson.test.vuln;

// For [databind#2642]
public class Swing_2854_CVE2020_Test
    extends VulnTestBase
{
    public void testSwingVuln() throws Exception
    {
        // 17-Sep-2020, tatu: Getting actual Swing component temporarily
        //   popping is annoying so comment out for now -- can uncomment
        //   to occasionally re-verify if that makes sense
/* */
        _testIllegalType(javax.swing.JTextPane.class,
                java.util.Collections.singletonMap("page",
                        "http://127.0.0.1:80?aaa=1&bbb=2"));
    }
}
