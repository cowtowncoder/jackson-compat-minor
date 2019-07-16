package com.fasterxml.jackson.test.vuln;

public class Jdom2_2341_CVE2019_12814Test extends VulnTestBase
{
    public void testJDOM2() throws Exception
    {
        _testIllegalType(org.jdom2.transform.XSLTransformer.class,
                "http://so.malic.ious/funky.xml");
    }

    public void testJDOM1() throws Exception
    {
        _testIllegalType(org.jdom.transform.XSLTransformer.class,
                "http://so.malic.ious/funky.xml");
    }
}
