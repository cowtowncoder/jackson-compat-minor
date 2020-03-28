package com.fasterxml.jackson.test.vuln;

import java.util.*;

public class AriesTxJms_2659_CVE2020_10672Test
    extends VulnTestBase
{
    public void testXaPooledConnectionFactory() throws Exception
    {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("tmJndiName", "ldap://localhost:43658/Calc");
        params.put("tmFromJndi", Boolean.TRUE);
        _testIllegalType(org.apache.aries.transaction.jms.internal.XaPooledConnectionFactory.class,
                params
        );
    }

    public void testRecoverablePooledConnectionFactory() throws Exception
    {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("tmJndiName", "ldap://localhost:43658/Calc");
        params.put("tmFromJndi", Boolean.TRUE);
        _testIllegalType(org.apache.aries.transaction.jms.RecoverablePooledConnectionFactory.class,
                params
        );
    }
}
