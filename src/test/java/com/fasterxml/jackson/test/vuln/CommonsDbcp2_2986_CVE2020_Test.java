package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

import org.apache.commons.dbcp2.datasources.PerUserPoolDataSource;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;

// [databind#2986], CVE-2020-???
public class CommonsDbcp2_2986_CVE2020_Test extends VulnTestBase
{
    public void testDBCP2PerUserPoolDS() throws Exception
    {
        _testIllegalType(PerUserPoolDataSource.class,
                Collections.singletonMap("dataSourceName",
                        "rmi://127.0.0.1:1389/Exploit"
                )
        );
    }

    public void testDBCP2SharedPoolDS() throws Exception
    {
        _testIllegalType(SharedPoolDataSource.class,
                Collections.singletonMap("dataSourceName",
                        "rmi://127.0.0.1:1389/Exploit"
                )
        );
    }
}
