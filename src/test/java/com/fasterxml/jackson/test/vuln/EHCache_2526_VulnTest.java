package com.fasterxml.jackson.test.vuln;

import net.sf.ehcache.transaction.manager.selector.GenericJndiSelector;
import net.sf.ehcache.transaction.manager.selector.GlassfishSelector;

import com.google.common.collect.ImmutableMap;

public class EHCache_2526_VulnTest extends VulnTestBase
{
    public void testGenericJNDISelector() throws Exception
    {
        _testIllegalType(GenericJndiSelector.class,
                ImmutableMap.of("jndiName",
                        "ldap://127.0.0.1:2333/refObj"
                )
        );
    }

    public void testGlassfishSelector() throws Exception
    {
        _testIllegalType(GlassfishSelector.class,
                ImmutableMap.of("jndiName",
                        "ldap://127.0.0.1:2333/refObj"
                )
        );
    }
}
