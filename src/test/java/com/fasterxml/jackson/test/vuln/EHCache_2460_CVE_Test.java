package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

import net.sf.ehcache.hibernate.EhcacheJtaTransactionManagerLookup;

public class EHCache_2460_CVE_Test extends VulnTestBase
{
    // [databind#2460] / CVE-2019-?????
    public void testTransactionMgrLookup() throws Exception
    {
        _testIllegalType(EhcacheJtaTransactionManagerLookup.class,
                Collections.singletonMap("properties",
                        Collections.singletonMap("jndi", "ldap://127.0.0.1:1389/Exploit")));
    }
}
