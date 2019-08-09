package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

import org.apache.cxf.jaxrs.provider.XSLTJaxbProvider;

public class CXFJaxRsVuln_2420Test extends VulnTestBase
{
    // [dataind#2420]
    public void testCXFXsltProvider() throws Exception
    {
        _testIllegalType(XSLTJaxbProvider.class,
                Collections.singletonMap("inTemplate", "nasty xslt"));
    }
}
