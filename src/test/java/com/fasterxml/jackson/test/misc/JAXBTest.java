package com.fasterxml.jackson.test.misc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.fasterxml.jackson.test.BaseTest;

public class JAXBTest extends BaseTest
{
    public void testBasic() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JaxbAnnotationModule());

        // TODO: actual active testing that uses JAXB annotations...
        FiveMinuteUser input = new FiveMinuteUser();
        String json = mapper.writeValueAsString(input);
        FiveMinuteUser out = mapper.readValue(json, FiveMinuteUser.class);
        assertNotNull(out);
    }
}
