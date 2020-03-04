package com.fasterxml.jackson.test.vuln;

import java.util.Collections;

public class Ibatis_Anteros_2634_CVE2020_9548Test
    extends VulnTestBase
{
    public void testVuln2634IBatis() throws Exception
    {
        _testIllegalType(com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig.class,
                Collections.singletonMap("properties",
                        Collections.singletonMap("UserTransaction",
                                "ldap://localhost:43658/Calc")));
    }

    public void testVuln2634Anteros() throws Exception
    {
        _testIllegalType(br.com.anteros.dbcp.AnterosDBCPConfig.class,
                Collections.singletonMap("healthCheckRegistry",
                        "ldap://localhost:43658/Calc"));
    }
}
