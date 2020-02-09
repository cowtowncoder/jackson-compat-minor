package com.fasterxml.jackson.test.vuln;

import java.util.Collections;


public class XBean_2620_CVE2020_xxxxxTest // [databind#2620] with Xbean-reflect
    extends VulnTestBase
{
    public void testXBeanVuln() throws Exception
    {
        _testIllegalType(org.apache.xbean.propertyeditor.JndiConverter.class,
                Collections.singletonMap("asText", "ldap://127.0.0.1:1389/Exploit"));
    }
}
