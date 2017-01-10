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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cl.axel.rodriguez.pruebaseleccion.domain.FirstRequest;
import cl.axel.rodriguez.pruebaseleccion.domain.FirstResponse;

/**
 * @author Axel
 *
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class PruebaSeleccionResource {
	
	private static final String IN_FORMAT_HOUR = "HH:mm:ss";
	private static final String OUT_FORMAT_DATE = "yyyy-MM-dd'T'HH:mm:ss.sZ";
	private static final String PATTERN_WORD_VALIDATE = "[a-zA-Z]+";
	private static final String ERROR_400 = "Error 400 -bad request";

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    @Path("/word")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getIt(FirstRequest request) {
    	if(Pattern.matches(PATTERN_WORD_VALIDATE, request.getData()) 
    			&& request.getData().length() == 4)
       		return Response.ok(generateResponse("200", request.getData().toUpperCase(), "OK"), 
       				MediaType.APPLICATION_JSON).build();
    	else
            return Response.status(Status.BAD_REQUEST).entity(ERROR_400).build();  
    }
    
    @GET
    @Path("/time")
    @Produces("application/json")
    public Response time(@QueryParam("value") String value) {
    	SimpleDateFormat hourFormat = new SimpleDateFormat(IN_FORMAT_HOUR);
    	Date date;
		try {
			date = hourFormat.parse(value);
			String formatted = new SimpleDateFormat(OUT_FORMAT_DATE)
	                .format(date);
	    	return Response.ok(generateResponse("200", formatted, "OK"), 
       				MediaType.APPLICATION_JSON).build();
		} catch (ParseException e) {
			return Response.status(Status.BAD_REQUEST).entity(ERROR_400).build();
		}
    	
    }
    
    private FirstResponse generateResponse(String code, String data, String description) {
    	FirstResponse response = new FirstResponse();
    	response.setCode(code);
    	response.setData(data);
    	response.setDescription(description);
    	return response;
    }
}
