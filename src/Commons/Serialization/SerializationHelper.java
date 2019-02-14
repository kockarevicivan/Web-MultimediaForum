package Commons.Serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationHelper<T extends Serializable> {

	public String serialize(T obj) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
