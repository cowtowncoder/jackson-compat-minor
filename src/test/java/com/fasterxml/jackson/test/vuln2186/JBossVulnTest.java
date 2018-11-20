package com.fasterxml.jackson.test.vuln2186;

import java.util.Collections;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class JBossVulnTest extends VulnTestBase
{
    // [databind#2186]
    public void testDocumentEditor() throws Exception
    {
        // not real payload that'd be needed; we only verify that attempt at instantiating
        // Gadget class is blocked
        _testIllegalType(org.jboss.util.propertyeditor.DocumentEditor.class,
                Collections.singletonMap("asText", "<root></root>"));
    }
}
