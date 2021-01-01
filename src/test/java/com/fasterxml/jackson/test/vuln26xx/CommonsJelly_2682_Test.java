package com.fasterxml.jackson.test.vuln26xx;

import java.util.Collections;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

// [databind#2682], SSRF with commons-jelly
public class CommonsJelly_2682_Test
    extends VulnTestBase
{
    public void testImplEmbeddedSSRF() throws Exception
    {
        _testIllegalType(org.apache.commons.jelly.impl.Embedded.class,
                Collections.singletonMap("script", "http://127.0.0.1:2020/evil2.xml")
        );
    }
}
