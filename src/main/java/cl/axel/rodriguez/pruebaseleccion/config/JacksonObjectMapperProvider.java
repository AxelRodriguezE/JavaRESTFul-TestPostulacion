package cl.axel.rodriguez.pruebaseleccion.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper>{

	@Override
	public ObjectMapper getContext(Class<?> arg0) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}

}
