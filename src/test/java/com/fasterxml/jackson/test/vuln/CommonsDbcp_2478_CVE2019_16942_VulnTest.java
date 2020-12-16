package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

import org.apache.commons.dbcp.datasources.PerUserPoolDataSource;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;
import com.p6spy.engine.spy.P6DataSource;

// CVE-2019-16942
public class CommonsDbcp_2478_CVE2019_16942_VulnTest extends VulnTestBase
{
    public void testDBCPDataSource1() throws Exception
    {
        _testIllegalType(PerUserPoolDataSource.class,
                Collections.singletonMap("dataSourceName",
                        "rmi://127.0.0.1:1389/Exploit"
                )
        );
    }

    public void testDBCPDataSource2() throws Exception
    {
        _testIllegalType(SharedPoolDataSource.class,
                Collections.singletonMap("dataSourceName",
                        "rmi://127.0.0.1:1389/Exploit"
                )
        );
    }

    public void testP6Spy() throws Exception
    {
        _testIllegalType(P6DataSource.class,
                Collections.singletonMap("realDataSource",
                        "rmi://127.0.0.1:1389/Exploit"
                )
        );
    }
}
