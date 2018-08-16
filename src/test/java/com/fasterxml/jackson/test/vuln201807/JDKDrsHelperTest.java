package com.fasterxml.jackson.test.vuln201807;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class JDKDrsHelperTest extends VulnTestBase
{
    // [databind#2097]
    public void testJDKDRSHelper() throws Exception
    {
        // 24-Jul-2018, tatu: This class is included in "deploy.jar" of JRE 1.8
        //   at least. But, alas, can't seem to make it visible through Maven, so
        //   can not really test properly.
//        _testIllegalType(com.sun.deploy.security.ruleset.DRSHelper.class);
    }
}
