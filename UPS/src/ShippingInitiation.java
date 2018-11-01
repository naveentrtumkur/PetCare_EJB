import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/initiation")
public class ShippingInitiation {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response ping() {
		return Response.ok("Hello, UPS is up and running to serve you ...").build();
	}

}
