package com.fasterxml.jackson.test.vuln26xx;

import java.util.Collections;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class CommonsProxy_2666_Test
    extends VulnTestBase
{
    public void testRmiProvider() throws Exception
    {
        _testIllegalType(org.apache.commons.proxy.provider.remoting.RmiProvider.class,
                Collections.singletonMap("host", "127.0.0.1")
                // note: may need other properties too (port, name) for real repro
        );
    }
}
