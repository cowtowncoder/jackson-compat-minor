package com.fasterxml.jackson.test.vuln26xx;

import java.util.Collections;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

public class OpenJPA_2670_Test
    extends VulnTestBase
{
    // note: overlaps with tests for db#2186
    public void testOpenJpaManagedRuntimes() throws Exception
    {
        // note: may need other properties too for real repro

        // does not appear exploitable:
//        _testIllegalType(org.apache.openjpa.ee.InvocationManagedRuntime.class, ...);

        _testIllegalType(org.apache.openjpa.ee.JNDIManagedRuntime.class, // in #2186 already
                Collections.singletonMap("transactionManagerName", "ldap://localhost:1389/MyCalc"));

        // does not appear exploitable:
//        _testIllegalType(org.apache.openjpa.ee.OSGiManagedRuntime.class, ...);

        _testIllegalType(org.apache.openjpa.ee.RegistryManagedRuntime.class, // in #2186 already
                Collections.singletonMap("registryName", "ldap://localhost:1389/MyCalc"));

        // does not appear exploitable:
//        _testIllegalType(org.apache.openjpa.ee.SunOneManagedRuntime.class, ...);

        // does not appear exploitable:
//        _testIllegalType(org.apache.openjpa.ee.WASManagedRuntime.class, ...);

        /* 28-Mar-2020, tatu: This seems potentially exploitable, but in practice
         *   fails due to classloading, and dependency itself not available via
         *   Maven Central (but from SpringSource, and very few projects seem to
         *   depend on it).
         *   Assuming it still needs blocking but can not adequately verify block.
         */
        // New here, sub-class of `RegistryManagedRuntime`
        // would actually require "registryName", but there's class load problem so
//        _testIllegalTypeWithValue(org.apache.openjpa.ee.WASRegistryManagedRuntime.class.getName(),
//                Collections.singletonMap("registryName", "ldap://localhost:1389/MyCalc"));

        // does not appear exploitable:
//        _testIllegalType(org.apache.openjpa.ee.WLSManagedRuntime.class, ...);

        // does not appear exploitable (not visible, either, but reflection could find)
//        _testIllegalType(org.apache.openjpa.kernel.LocalManagedRuntime.class, ...);
    }
}
