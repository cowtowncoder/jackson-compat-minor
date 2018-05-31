package com.fasterxml.jackson.test.vuln;

import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.beans.factory.config.PropertyPathFactoryBean;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
}
