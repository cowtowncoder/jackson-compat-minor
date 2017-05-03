package com.fasterxml.jackson.test.df;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.test.BaseTest;

public class XMLTest extends BaseTest
{
    public void testSimple() throws Exception
    {
        // NOTE: with XML not possible to use generic mapper so:
        ObjectMapper mapper = new XmlMapper();
        byte[] data = mapper.writeValueAsBytes(new FiveMinuteUser());

        FiveMinuteUser output = mapper.readValue(data, FiveMinuteUser.class);
        assertNotNull(output);
    }
}
