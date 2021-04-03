package com.course.kafkaproducer.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateJsonSerializer extends StdSerializer<LocalDate>
{
    public CustomLocalDateJsonSerializer()
    {
        this(null);
    }
    protected CustomLocalDateJsonSerializer(Class<LocalDate> t)
    {
        super(t);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        gen.writeString(formatter.format(value));
    }
}
