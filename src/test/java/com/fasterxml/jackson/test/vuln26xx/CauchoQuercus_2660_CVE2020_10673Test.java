package com.fasterxml.jackson.test.vuln26xx;

import java.util.Collections;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class CauchoQuercus_2660_CVE2020_10673Test
    extends VulnTestBase
{
    public void testResourceRef() throws Exception
    {
        _testIllegalType(com.caucho.config.types.ResourceRef.class,
                Collections.singletonMap("lookupName", "ldap://localhost:43658/Calc")
        );
    }
}
