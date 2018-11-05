import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/initiation")
public class ShippingInitiation {
	@GET
	@javax.ws.rs.Produces(MediaType.TEXT_PLAIN)
	public Response ping() {
		return Response.ok("Hello, UPS is up and running to serve you ...").build();
	}

}
