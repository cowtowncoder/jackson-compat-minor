package com.fasterxml.jackson.test.vuln;

import java.util.HashMap;
import java.util.Map;

public class Vuln2827_CVE2020_Test
    extends VulnTestBase
{
    public void testVuln2827Original() throws Exception
    {
        Map<String, Object> args = new HashMap<>();
        args.put("dataSourceName", "ldap://127.0.0.1:1389/Exploit");
        args.put("autoCommit", true);
        _testIllegalType(org.arrah.framework.rdbms.UpdatableJdbcRowsetImpl.class, args);
    }
}
