package com.fasterxml.jackson.test.vuln;

import java.util.*;

public class AriesTransactionJms_2659_VulnTest
    extends VulnTestBase
{
    public void testJNDILookup() throws Exception
    {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("tmJndiName", "ldap://localhost:43658/Calc");
        params.put("tmFromJndi", Boolean.TRUE);
        _testIllegalType(org.apache.aries.transaction.jms.internal.XaPooledConnectionFactory.class,
                params
        );
    }
}
