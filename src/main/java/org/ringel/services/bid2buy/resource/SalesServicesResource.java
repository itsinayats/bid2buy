package org.ringel.services.bid2buy.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.ringel.services.bid2buy.model.ItemModel;
import org.ringel.services.bid2buy.service.SalesAndServicesService;
import org.ringel.services.bid2buy.serviceImpl.SalesAndServicesServiceImpl;

@Path("/sales")
@Produces(MediaType.APPLICATION_JSON)
public class SalesServicesResource {
	@POST
	@Path("/saveorupdateItem")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Signup(ItemModel item) {
		 SalesAndServicesService service=	new SalesAndServicesServiceImpl();
		 item= service.SaveOrUpdateItem(item);
		return Response.status(Status.CREATED).entity(item).build();

}
	
	
	@GET
	@Path("/getItemByCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getItemByCategory(@QueryParam("category")String category) {
		 SalesAndServicesService service=new SalesAndServicesServiceImpl();
		 ArrayList<ItemModel> list=new ArrayList<>();
		 list= service.getItemsByCategory(category);
		return Response.status(Status.CREATED).entity(list).build();
	

}
}
