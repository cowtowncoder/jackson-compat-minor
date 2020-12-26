package com.fasterxml.jackson.test.vuln24xx;

import java.util.Collections;

import org.apache.cxf.jaxrs.provider.XSLTJaxbProvider;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class CXFJaxRsVuln_2420Test extends VulnTestBase
{
    // [dataind#2420]
    public void testCXFXsltProvider() throws Exception
    {
        _testIllegalType(XSLTJaxbProvider.class,
                Collections.singletonMap("inTemplate", "nasty xslt"));
    }
}
