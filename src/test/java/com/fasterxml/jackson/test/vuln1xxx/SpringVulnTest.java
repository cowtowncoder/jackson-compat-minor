package com.fasterxml.jackson.test.vuln1xxx;

import java.util.*;

import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.beans.factory.config.PropertyPathFactoryBean;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fasterxml.jackson.test.vuln.VulnTestBase;

/**
 * Tests for Spring framework types.
 */
public class SpringVulnTest extends VulnTestBase
{
    // // Tests related to issues:
    // //
    // // [databind#1737]: 

    // [databind#1737]
    public void testPropertyPathFactoryBean() throws Exception
    {
        _testIllegalType(PropertyPathFactoryBean.class);
    }
    
    // [databind#1737] / [databind#1855]
    public void testAdvisors() throws Exception
    {
        _testIllegalType(DefaultBeanFactoryPointcutAdvisor.class);
    }

    // [databind#1855]
    public void testApplicationContext() throws Exception
    {
        _testIllegalType(FileSystemXmlApplicationContext.class);
    }

    // [databind#2680]
    public void testMethodLocationFactoryBean() throws Exception
    {
        Map<String, Object> args = new LinkedHashMap<>();
        args.put("targetBeanName", "ldap://localhost:1389/RCE");
        args.put("methodName", "Foobar");
        _testIllegalType(org.springframework.aop.config.MethodLocatingFactoryBean.class, args);
    }

    // [databind#2680]
    // 06-Apr-2020, tatu: This class not available in Spring 4.3, was in 4.0 and earlier
    /*
    public void testBeanRefFactoryBean() throws Exception
    {
        Map<String, Object> args = new LinkedHashMap<>();
        args.put("targetBeanName", "ldap://localhost:1389/RCE");
        args.put("methodName", "Foobar");
        _testIllegalType(org.springframework.beans.factory.config.BeanReferenceFactoryBean.class, args);
    }
    */
}
