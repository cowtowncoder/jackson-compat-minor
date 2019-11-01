package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

import net.sf.ehcache.transaction.manager.DefaultTransactionManagerLookup;

public class EHCache2Vuln_2387Test extends VulnTestBase
{
    // [databind#2387]
    public void testTransactionMgrLookup() throws Exception
    {
        _testIllegalType(DefaultTransactionManagerLookup.class,
                Collections.singletonMap("properties",
                        Collections.singletonMap("jndi", "address")));
    }
}
