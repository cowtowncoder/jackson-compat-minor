package com.fasterxml.jackson.test.vuln26xx;

import java.util.Collections;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class BusProxy_2662_CVE_2020_10968Test
    extends VulnTestBase
{
    public void testRmiProvider() throws Exception
    {
        // 5.6.9 has this class
        _testIllegalType(org.aoju.bus.proxy.provider.RmiProvider.class,
        // earlier possible different package:
//        _testIllegalType(org.aoju.bus.proxy.provider.remoting.RmiProvider.class,
                Collections.singletonMap("host", "127.0.0.1")
                // note: may need other properties too (port, name) for real repro
        );
    }
}
