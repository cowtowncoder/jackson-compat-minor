package com.fasterxml.jackson.test.vuln;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.test.BaseTest;

public abstract class VulnTestBase extends BaseTest
{
    static class PolyWrapper {
        @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
                include = JsonTypeInfo.As.WRAPPER_ARRAY)
        public Object v;
    }

    protected final ObjectMapper MAPPER = newObjectMapper();

    protected void _testIllegalType(String nastyClassName) throws Exception {
        _testIllegalTypeWithValue(nastyClassName, "/tmp/foobar.txt");
    }

    protected void _testIllegalType(Class<?> nasty) throws Exception {
        _testIllegalTypeWithValue(nasty.getName(), "/tmp/foobar.txt");
    }

    protected void _testIllegalType(Class<?> nasty, String value) throws Exception {
        _testIllegalTypeWithValue(nasty.getName(), aposToQuotes(value));
    }

    protected void _testIllegalType(Class<?> nasty, List<Object> value) throws Exception {
        _testIllegalTypeWithValue(nasty.getName(), value);
    }

    protected void _testIllegalType(Class<?> nasty, Map<?,?> value) throws Exception {
        _testIllegalTypeWithValue(nasty.getName(), value);
    }
    
    protected void _testIllegalTypeWithValue(String clsName, Object payload) throws Exception {
        // While usually exploited via default typing let's not require
        // it here; mechanism still the same
        String json = "{\"v\":[\""+clsName+"\","+MAPPER.writeValueAsString(payload)+"]}";
        try {
            PolyWrapper w = MAPPER.readValue(json, PolyWrapper.class);
            String desc = (w.v == null) ? "NULL" : w.v.getClass().getName();
            fail("Should not pass: got instance of type "+desc);
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
