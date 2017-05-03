package com.fasterxml.jackson.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SimpleReadWriteTest extends BaseTest
{
    static class Point {
        public int x;
        int y;

        public void setY(int y0) { y = y0; }
        public int getY() { return y; }
    }

    static class NamedPoint {
        final String name;

        public Point p;
        
        @JsonCreator
        public NamedPoint(@JsonProperty("name") String n) {
            name = n;
            p = new Point();
        }

        public String getName() {
            return name;
        }
    }

    /*
    /**********************************************************
    /* Test methods
    /**********************************************************
     */

    private final ObjectMapper MAPPER = newMapper();

    public void testReadWrite() throws Exception
    {
        NamedPoint np = new NamedPoint("Ziggy");
        np.p.x = 3;
        np.p.setY(72);
        
        String json = MAPPER.writeValueAsString(np);
        byte[] jsonB = MAPPER.writeValueAsBytes(np);

        NamedPoint npStr = MAPPER.readValue(json, NamedPoint.class);
        NamedPoint npB = MAPPER.readValue(jsonB, NamedPoint.class);

        assertEquals(3, npStr.p.x);
        assertEquals(3, npB.p.x);
    }
}
