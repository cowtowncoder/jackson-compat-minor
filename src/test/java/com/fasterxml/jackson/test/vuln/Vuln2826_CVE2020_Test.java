package com.fasterxml.jackson.test.vuln;

import java.util.*;

// for "com.nqadmin.rowset:jdbcrowsetimpl:1.0.1" (db#2826)
public class Vuln2826_CVE2020_Test
    extends VulnTestBase
{
    public void testVuln2826() throws Exception
    {
        Map<String, Object> args = new HashMap<>();
        args.put("dataSourceName", "ldap://127.0.0.1:1389/Exploit");
        args.put("autoCommit", true);
        _testIllegalType(com.nqadmin.rowset.JdbcRowSetImpl.class, args);
    }
}
