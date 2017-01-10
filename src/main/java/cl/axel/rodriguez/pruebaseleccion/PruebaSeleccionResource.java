package cl.axel.rodriguez.pruebaseleccion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cl.axel.rodriguez.pruebaseleccion.domain.FirstRequest;
import cl.axel.rodriguez.pruebaseleccion.domain.FirstResponse;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class PruebaSeleccionResource {
	
	private static final String IN_FORMAT_DATE = "HH:mm";
	private static final String OUT_FORMAT_DATE = "yyyy-MM-dd'T'HH:mm:ss.sZ";
	private static final String PATTERN_WORD_VALIDATE = "[a-zA-Z]+";

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    @Path("/word")
    @Consumes(MediaType.APPLICATION_JSON)
    public FirstResponse getIt(FirstRequest request) {
    	if(Pattern.matches(PATTERN_WORD_VALIDATE, request.getData()) 
    			&& request.getData().length() == 4)
    		return generateResponse("00", request.getData().toUpperCase(), "OK");
    	else 
    		return generateResponse("400", request.getData().toUpperCase(), "ERROR");
    }
    
    @GET
    @Path("/time")
    public FirstResponse time(@QueryParam("value") String value) throws ParseException {
    	SimpleDateFormat hourFormat = new SimpleDateFormat(IN_FORMAT_DATE);
    	Date date = hourFormat.parse(value);
    	String formatted = new SimpleDateFormat(OUT_FORMAT_DATE)
                .format(date);
    	return generateResponse("00", formatted, "OK");
    }
    
    private FirstResponse generateResponse(String code, String data, String description) {
    	FirstResponse response = new FirstResponse();
    	response.setCode(code);
    	response.setData(data);
    	response.setDescription(description);
    	return response;
    }
}
