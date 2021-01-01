package com.fasterxml.jackson.test.vuln26xx;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

// For [databind#2642]
public class Swing_2642_CVE2020_10969_Test
    extends VulnTestBase
{
    public void testSwingVuln() throws Exception
    {
        // 24-Apr-2020, tatu: Getting actual Swing component temporarily
        //   popping is annoying so comment out for now -- can uncomment
        //   to occasionally re-verify if that makes sense
/*        
        _testIllegalType(javax.swing.JEditorPane.class,
                java.util.Collections.singletonMap("page",
                        "http://127.0.0.1:80?aaa=1&bbb=2"));
*/
    }
}
