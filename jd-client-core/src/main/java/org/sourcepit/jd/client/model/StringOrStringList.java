package org.sourcepit.jd.client.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import lombok.Data;

// Cmd:
// description: "Command to run specified as a string or an array of strings."
// type:
// - "array"
// - "string"
// items:
// type: "string"
@Data
public class StringOrStringList
{

	private List<String> values;

	private String value;

	public static class Deserializer extends JsonDeserializer<StringOrStringList>
	{

		@Override
		public StringOrStringList deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException, JsonProcessingException
		{
			String value = null;
			List<String> values = null;
			switch (p.getCurrentTokenId())
			{
				case JsonTokenId.ID_STRING:
					value = p.getValueAsString();
					break;
				case JsonTokenId.ID_START_ARRAY:
					values = new ArrayList<>();
					p.nextToken();
					while (p.getCurrentTokenId() == JsonTokenId.ID_STRING)
					{
						values.add(p.getValueAsString());
						p.nextToken();
					}

					if (p.getCurrentTokenId() != JsonTokenId.ID_END_ARRAY)
					{
						throw new JsonParseException(p, "Expected end of array");
					}
					break;
				default:
					throw new JsonParseException(p, "Expected string or start of array");
			}

			final StringOrStringList result = new StringOrStringList();
			result.setValue(value);
			result.setValues(values);
			return result;
		}

	}

	public static class Serializer extends JsonSerializer<StringOrStringList>
	{
		@Override
		public void serialize(StringOrStringList union, JsonGenerator gen, SerializerProvider serializers)
				throws IOException, JsonProcessingException
		{
			final String value = union.getValue();
			final List<String> values = union.getValues();

			if (value == null && values == null)
			{
				throw new JsonGenerationException("One of value or values must be set", null, gen);
			}

			if (value != null && values != null)
			{
				throw new JsonGenerationException("Only one of value or values must be set", null, gen);
			}

			if (value != null)
			{
				gen.writeString(value);
			}

			if (values != null)
			{
				gen.writeStartArray();
				for (String string : values)
				{
					gen.writeString(string);
				}
				gen.writeEndArray();
			}
		}
	}

}