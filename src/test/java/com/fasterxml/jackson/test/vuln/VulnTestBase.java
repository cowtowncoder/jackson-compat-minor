package com.fasterxml.jackson.test.vuln;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.test.BaseTest;

abstract class VulnTestBase extends BaseTest
{
    static class PolyWrapper {
        @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
                include = JsonTypeInfo.As.WRAPPER_ARRAY)
        public Object v;
    }

    protected final ObjectMapper MAPPER = newObjectMapper();

    protected void _testIllegalType(String nastyClassName) throws Exception {
        _testIllegalType(nastyClassName, "'/tmp/foobar.txt'");
    }

    protected void _testIllegalType(Class<?> nasty) throws Exception {
        _testIllegalType(nasty.getName(), "'/tmp/foobar.txt'");
    }

    protected void _testIllegalType(Class<?> nasty, String value) throws Exception {
        _testIllegalType(nasty.getName(), value);
    }

    private void _testIllegalType(String clsName, String value) throws Exception
    {
        // While usually exploited via default typing let's not require
        // it here; mechanism still the same
        String json = aposToQuotes("{'v':['"+clsName+"',"+value+"]}");
        try {
            MAPPER.readValue(json, PolyWrapper.class);
            fail("Should not pass");
        } catch (JsonMappingException e) {
            _verifySecurityException(e, clsName);
        }
    }

    protected void _verifySecurityException(Throwable t, String clsName) throws Exception
    {
        _verifyException(t, InvalidDefinitionException.class,
                "Illegal type",
                "to deserialize",
                "prevented for security reasons");
        verifyException(t, clsName);
    }

    protected void _verifyException(Throwable t, Class<?> expExcType,
            String... patterns) throws Exception
    {
        Class<?> actExc = t.getClass();
        if (!expExcType.isAssignableFrom(actExc)) {
            fail("Expected Exception of type '"+expExcType.getName()+"', got '"
                    +actExc.getName()+"', message: "+t.getMessage());
        }
        for (String pattern : patterns) {
            verifyException(t, pattern);
        }
    }
}
