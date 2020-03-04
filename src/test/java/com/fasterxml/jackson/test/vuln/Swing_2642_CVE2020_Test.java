package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

// For [databind#2642]
public class Swing_2642_CVE2020_Test
    extends VulnTestBase
{
    public void testSwingVuln() throws Exception
    {
        _testIllegalType(javax.swing.JEditorPane.class,
                Collections.singletonMap("page",
                        "http://127.0.0.1:80?aaa=1&bbb=2"));
    }
}
