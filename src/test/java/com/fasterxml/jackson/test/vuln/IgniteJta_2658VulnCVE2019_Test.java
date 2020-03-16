package com.fasterxml.jackson.test.vuln;

import java.util.Arrays;
import java.util.Collections;

public class IgniteJta_2658VulnCVE2019_Test
    extends VulnTestBase
{
    // This one has confirmed reproduction (although example below is missing
    // one specific ingredient to actually make it work)
    public void testJNDILookup() throws Exception
    {
        _testIllegalType(org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup.class,
                Collections.singletonMap("jndiNames",
                        Arrays.asList("ldap://localhost:43658/Calc"))
                );
    }

    // This is speculative case: seems like it would NOT allow immediate exploitation,
    // but included as safety measure in case valid attack could be found
    public void testJNDIFactory() throws Exception
    {
        _testIllegalType(org.apache.ignite.cache.jta.jndi.CacheJndiTmFactory.class,
                Collections.singletonMap("jndiNames",
                        Arrays.asList("ldap://localhost:43658/Calc"))
                );
    }

    // Another speculative case: seems like it would NOT allow immediate exploitation,
    // but included as safety measure in case valid attack could be found
    public void testQuartzCore() throws Exception
    {
        _testIllegalType(org.quartz.utils.JNDIConnectionProvider.class,
                Collections.singletonMap("jndiUrl", "ldap://localhost:43658/Calc")
        );
    }
}
