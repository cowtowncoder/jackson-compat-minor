package com.fasterxml.jackson.test.misc;

import java.util.Collections;

import com.fasterxml.jackson.jr.ob.JSON;

import com.fasterxml.jackson.test.BaseTest;

public class JacksonJrTest extends BaseTest
{
    public void testSimpleRead() throws Exception
    {
        Object ob = JSON.std.anyFrom("[1, true, { \"msg\": \"hello!\"}]");
        assertNotNull(ob);
    }

    public void testSimpleWrite() throws Exception
    {
        byte[] json = JSON.std.asBytes(Collections.singletonMap("msg", "Hello!"));
        assertNotNull(json);
    }
}
