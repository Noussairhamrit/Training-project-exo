package org.exoplatform.rest;

import io.swagger.jaxrs.PATCH;
import org.exoplatform.dao.ClientDao;
import org.exoplatform.dto.ClientDto;
import org.exoplatform.entity.ClientEntity;
import org.exoplatform.service.ClientService;
import org.exoplatform.service.IclientService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;

import javax.inject.Inject;
import javax.ws.rs.*;

import javax.ws.rs.core.Response;


@Path("/clients")
@Produces("application/json")
public class ClientRest implements ResourceContainer  {
    private static Log log = ExoLogger.getLogger(ClientRest.class);
    private  ClientService clientService;
    @Inject
    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    @GET
    @Path("/all")
    public Response GetAllClients(){
          return  clientService.GetAllClients();
    }
    @GET
    @Path("/{id}")
    public Response getOneClient(@PathParam("id") long id){
        return clientService.getOneClient(id);
    }
    @POST
    @Path("/add")
    public Response AjouterClient(ClientDto client) {
       return clientService.createClient(client);
    }
    @DELETE
    @Path("/delete/{id}")
    public Response deleteClient(@PathParam("id") long id){
       return clientService.deleteClient(id);
    }
    @PATCH
    @Path("/edit/{id}")
    public Response editClient(@PathParam("id") long id, ClientDto editClient ){
        return clientService.editClient(id,editClient);
    }
    @GET
    @Path("/addresse/{addresse}")
    public Response GetAllClients(@PathParam("addresse") String addresse){
        return  clientService.GetClientsByAddresse(addresse);
    }
    @GET
    @Path("/count/{name}")
    public Response numberOfClient(@PathParam("name") String name){
        return clientService.numberOfClients(name);
    }
}

