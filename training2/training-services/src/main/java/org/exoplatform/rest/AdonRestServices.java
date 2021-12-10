package org.exoplatform.rest;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.json.JSONArray;
import org.json.JSONObject;


import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/testapi")
@Produces("application/json")


public class AdonRestServices implements  ResourceContainer{

    private static Log log = ExoLogger.getLogger(AdonRestServices.class);

    @GET
    @Path("/list")
    @RolesAllowed("users")
    public Response getClient(){
        JSONArray jsonArray =new JSONArray();
        try {
            for (int i=1; i<=10; i++)
            {
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("id", i);
                jsonObject.put("name", "item-"+i);
                jsonArray.put(jsonObject);
            }

            return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();

        }
        catch (Exception e) {
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred when trying to get the client list").build();
        }
    }

}