package com.fasterxml.jackson.test.dt;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.test.BaseTest;

public class JsonOrgTest extends BaseTest
{
    final ObjectMapper MAPPER = newMapper();

    public void testReadObject() throws Exception
    {
        JSONObject ob = MAPPER.readValue("{\"a\":{\"b\":3}, \"c\":[9, -4], \"d\":null, \"e\":true}",
                JSONObject.class);
        assertEquals(4, ob.length());
        JSONObject ob2 = ob.getJSONObject("a");
        assertEquals(1, ob2.length());
        assertEquals(3, ob2.getInt("b"));
        JSONArray array = ob.getJSONArray("c");
        assertEquals(2, array.length());
        assertEquals(9, array.getInt(0));
        assertEquals(-4, array.getInt(1));
        assertTrue(ob.isNull("d"));
        assertTrue(ob.getBoolean("e"));
    }

    public void testWriteObject() throws Exception
    {
        final ObjectMapper mapper = newMapper();

        // Ok: let's create JSONObject from JSON text
        String JSON = "{\"a\":{\"b\":3}}";
        JSONTokener tok = new JSONTokener(JSON);
        JSONObject ob = (JSONObject) tok.nextValue();
        assertEquals(JSON, mapper.writeValueAsString(ob));

        // And for [Issue#2], with null(s):
        JSON = "{\"a\":null}";
        tok = new JSONTokener(JSON);
        ob = (JSONObject) tok.nextValue();
        assertEquals(JSON, mapper.writeValueAsString(ob));
    }
}
