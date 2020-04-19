package com.fasterxml.jackson.test.misc;

import java.util.Arrays;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.avro.AvroMapper;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

import com.fasterxml.jackson.test.BaseTest;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GuavaWithAvroTest extends BaseTest
{
    static class MultimapHolder {
        public Multimap<String, String> map = ArrayListMultimap.create();
    }

    public void testGenerateAvroForMultimap() throws Exception
    {
        final AvroMapper avroMapper = AvroMapper.builder()
                .addModule(new GuavaModule())
                .build();
        final AvroSchema schema = avroMapper.schemaFor(MultimapHolder.class);
        
        ObjectWriter avroWriter = avroMapper.writer(schema);
        MultimapHolder input = new MultimapHolder();
        input.map.put("a", "b");
        input.map.put("a", "x");
        input.map.put("b", "y");
        final byte[] avro = avroWriter.writeValueAsBytes(input);        

        MultimapHolder output = avroMapper.readerFor(MultimapHolder.class)
                .with(schema)
                .readValue(avro);
        assertEquals(3, output.map.size());
        assertEquals(Arrays.asList("b", "x"), output.map.get("a"));
        assertEquals(Arrays.asList("y"), output.map.get("b"));
    }
}
