package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

import net.sf.ehcache.transaction.manager.DefaultTransactionManagerLookup;

public class EHCache_1931_CVE2018_7489Test extends VulnTestBase
{
    // [databind#1931] / CVE-2018-7489
    public void testTransactionMgrLookup() throws Exception
    {
        _testIllegalType(DefaultTransactionManagerLookup.class,
                Collections.singletonMap("properties",
                        Collections.singletonMap("jndi", "address")));
    }
}
