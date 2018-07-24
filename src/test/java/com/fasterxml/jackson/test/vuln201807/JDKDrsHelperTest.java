package com.fasterxml.jackson.test.vuln201807;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class JDKDrsHelperTest extends VulnTestBase
{
    // [databind#]
    public void testDataSources() throws Exception
    {
        _testIllegalType("com.sun.deploy.security.ruleset.DRSHelper");
    }
}
