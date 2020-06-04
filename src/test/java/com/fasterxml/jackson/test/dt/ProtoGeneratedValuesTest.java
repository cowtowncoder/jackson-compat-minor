package com.fasterxml.jackson.test.dt;

import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.test.BaseTest;
import com.hubspot.jackson.datatype.protobuf.ProtobufModule;

public class ProtoGeneratedValuesTest extends BaseTest
{
    private final ObjectMapper MAPPER = JsonMapper.builder()
            .addModule(new ProtobufModule())
            .build();

    public void testProtoGeneradWriteRead() throws Exception
    {
        // TODO: use actual proto values; this is just placeholder
        final String json = MAPPER.writeValueAsString(Arrays.asList("abc", "def"));
        assertEquals("[\"abc\",\"def\"]", json);
    }
}
