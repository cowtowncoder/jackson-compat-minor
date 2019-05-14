package com.fasterxml.jackson.test.vuln;

public class MysqlCVE2019_12086Test extends VulnTestBase
{
    public void testConnectionFactory() throws Exception
    {
        _testIllegalType(com.mysql.cj.jdbc.admin.MiniAdmin.class,
                "'jdbc:mysql://localhost:3307/test'");
    }
}
