package com.fasterxml.jackson.test.vuln2186;

import java.util.*;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class OpenJPAVulnTest extends VulnTestBase
{
    // [databind#2186]
    public void testRegistryManagedRuntime() throws Exception
    {
        Map<String, Object> args = new LinkedHashMap<>();
        args.put("registryName", "localhost:8080");
        args.put("rollbackOnly", null);
        _testIllegalType(org.apache.openjpa.ee.RegistryManagedRuntime.class, args);
    }

    // [databind#2186]
    public void testJNDIManagedRuntime() throws Exception
    {
        Map<String, Object> args = new LinkedHashMap<>();
        args.put("transactionManagerName", "ldap://localhost:8080/nasty");
        args.put("rollbackOnly", null);
        _testIllegalType(org.apache.openjpa.ee.JNDIManagedRuntime.class, args);
    }
}
