package com.fasterxml.jackson.test.df;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;

import com.fasterxml.jackson.test.BaseTest;

public class CSVTest extends BaseTest
{
    public void testSimple() throws Exception
    {
        ObjectMapper mapper = newMapper(new CsvFactory());

        // !!! 23-Feb-2016, tatu: Trivial to avoid using any Schema
        assertNotNull(mapper);
    }
}
