package org.ringel.services.bid2buy.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.ringel.services.bid2buy.model.CategoriesModel;
import org.ringel.services.bid2buy.model.UserModel;
import org.ringel.services.bid2buy.service.UtilityService;
import org.ringel.services.bid2buy.serviceImpl.UtilityServiceImpl;

@Path("/utilities")
@Produces(MediaType.APPLICATION_JSON)
public class UtilityResource {
	
	@GET
	@Path("/categories")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Signup(UserModel user) {
		UtilityService service=new UtilityServiceImpl();
	ArrayList<CategoriesModel> list=	service.getCategories();
	return Response.status(Status.CREATED).entity(list).build();
		
	}
}
	
