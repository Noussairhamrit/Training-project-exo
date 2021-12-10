package org.exoplatform.rest;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.json.JSONArray;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/test")
@Produces("application/json")
public class testRestSercice implements ResourceContainer {
    private static Log log = ExoLogger.getLogger(testRestSercice.class);


    @GET
    @Path("/noussair/{id}")

    public Response test(@PathParam("id") int id) {
        JSONArray jsonArray = new JSONArray();
//        String userbyid;
        try {
            for (int i = 1; i <= 10; i++) {
//                Client myuser=new Client();
//                        myuser.id=i;
//                        myuser.name="noussair----"+i;
//
//                jsonArray.put(myuser);

            }
//            userbyid=jsonArray.getString(id);
//           //return  userbyid.toString();
//           return Response.ok(userbyid.toString(), MediaType.APPLICATION_JSON).build();
            return null;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity("An internal error has occurred when trying to get the client list").build();
        }
    }
}