package com.fasterxml.jackson.test.dt;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.test.BaseTest;

/**
 * Simple tests to see that Joda module works too.
 */
public class JodaTest extends BaseTest
{
    static class TimeWrapper {
        public DateTime time;
    }
    
    final ObjectMapper MAPPER = newMapper();

    public void testSimpleJoda() throws Exception
    {
        TimeWrapper input = new TimeWrapper();
        input.time = DateTime.now();
        String json = MAPPER.writeValueAsString(input);
        TimeWrapper out = MAPPER.readValue(json, TimeWrapper.class);
        // no guarantee timezone remains the same, but underlying timestamp should so:
        assertEquals(input.time.getMillis(), out.time.getMillis());
    }
}
