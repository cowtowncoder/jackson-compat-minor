package com.fasterxml.jackson.test.vuln23xx;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class Mysql_2326_CVE2019_12086Test extends VulnTestBase
{
    // [databind#2326]
    public void testConnectionFactory() throws Exception
    {
        _testIllegalType(com.mysql.cj.jdbc.admin.MiniAdmin.class,
                "'jdbc:mysql://localhost:3307/test'");
    }
}
