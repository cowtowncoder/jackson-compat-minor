package com.fasterxml.jackson.test.vuln26xx;

import java.util.Collections;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

// Initially for [databind#2634] but later also for
// [databind#2814]
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

    // 17-Sep-2020, tatu: Some dependency missing or wrong version, we get
    //  gnarly stack trace (but no failure)... so leave out for now.
    //  Can be spot-checked if absolutely necessary
/*    
    public void testVuln2634Anteros() throws Exception
    {
        _testIllegalType(br.com.anteros.dbcp.AnterosDBCPConfig.class,
                Collections.singletonMap("healthCheckRegistry",
                        "ldap://localhost:43658/Calc"));
    }

    public void testVuln2814Anteros() throws Exception
    {
        _testIllegalType(br.com.anteros.dbcp.AnterosDBCPDataSource.class,
                Collections.singletonMap("healthCheckRegistry",
                        "ldap://127.0.0.1:1389/Exploit"));
    }
    */
}
