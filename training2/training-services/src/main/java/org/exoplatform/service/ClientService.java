package org.exoplatform.service;


import org.apache.regexp.RE;
import org.exo.training.plugin.UpeerCaseTransformer;
import org.exoplatform.dao.ClientDao;
import org.exoplatform.dto.ClientDto;
import org.exoplatform.entity.ClientEntity;
import org.exoplatform.plugin.ClientServicePlugin;
import org.exoplatform.services.listener.ListenerService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.exoplatform.service.utils.Utils.*;
public class ClientService implements IclientService  {

    private static final Log log = ExoLogger.getLogger(ClientService.class);
    ///////////////////////plugins////////////////////////////////
    List<ClientServicePlugin>plugins=new ArrayList<>();
    @Override
    public void addPlugin(ClientServicePlugin clientServicePlugin) {
        this.plugins.add(clientServicePlugin);
    }


    ////////////////////////////////////////////////////////////////////////
//    private List<TextServicePlugin> pluginList = new ArrayList<>();
//
//
//    public void addTextTransformer(TextServicePlugin textServicePlugin) {
//        this.pluginList.add(textServicePlugin);
//    }
    private UpeerCaseTransformer upeerCaseTransformer;
    /////////////////////////listener//////////////////////////////
    private static final String LISTENER_NAME="add-client-listener";
    private ListenerService listenerService;
    ///////////////////////////injection/////////////////////////////

    private ClientDao clientDao;


    public ClientService(ClientDao clientDao , ListenerService listenerService) {
        this.clientDao = clientDao;
        this.listenerService=listenerService;
    }
    ///////////////////////////////////////////////



    @Override
    public Response GetAllClients() {

        List<ClientEntity> clients=clientDao.findAll();
        List<ClientDto> dtolist = toDtoList(clients);
        JSONArray jsonArray =new JSONArray();
        try {
            for(ClientDto client : dtolist){
                JSONObject jsonObject = new JSONObject();

                    jsonObject.put("id", client.getId());
                    jsonObject.put("prenom", client.getPrenom());
                    jsonObject.put("name", client.getName());
                    jsonObject.put("email", client.getEmail());
                    jsonObject.put("addresse", client.getAddresse());
//                    jsonObject.put("upeer",upeerCaseTransformer.transformText("restrest"));
                    jsonArray.add(jsonObject);


            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred When trying to import client list")
                    .build();
        }
        return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();
    }



    public Response createClient (ClientDto client){
        String hi="";
        try {
        ClientEntity clientEntity=toEntity(client);
        clientEntity.setId(null);
            clientEntity=clientDao.create(clientEntity);
            hi = hello(client);
            System.out.println("hello "+clientEntity);
          listenerService.broadcast(LISTENER_NAME,this,client);

    }catch (Exception e){
        log.error(e.getMessage(),e);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("failed to add : " + client)
                .build();
    }
        return Response.ok(hi, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response getOneClient(long id) {

        ClientEntity clientById;
        ClientDto clientDto;
        try {
            clientById=clientDao.find(id);
             clientDto = toDto(clientById);

    }catch (Exception e){
        log.error(e.getMessage(),e);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("failed to get client with id :"+id)
                .build();
    }
        return Response.ok(clientDto.toString(), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteClient(long id) {
        try {
            clientDao.delete(clientDao.find(id));
        }
         catch (Exception e){
                log.error(e.getMessage(),e);
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity("failed to delete client with id :"+id)
                        .build();
            }
            return Response.ok(MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response editClient(long id, ClientDto editClient) {
        try {
            ClientEntity c = clientDao.find(id);
            c.setAddresse(editClient.addresse);
            c.setEmail(editClient.email);
            c.setPrenom(editClient.prenom);
            c.setName(editClient.name);
            clientDao.update(c);
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("failed to edit client with id :"+id)
                    .build();
        }
        return Response.ok(MediaType.APPLICATION_JSON).build();

    }
        public String hello(ClientDto clientDto){
            String msg = "";

            for (ClientServicePlugin plugin:this.plugins){
                   msg= plugin.helloClient(clientDto);

                }
                return msg;
        }
    @Override
    public Response GetClientsByAddresse(String addresse) {
        List<ClientEntity> clients=clientDao.getClientByAddresse(addresse);
        List<ClientDto> dtolist = toDtoList(clients);
        JSONArray jsonArray =new JSONArray();
        try {
            for(ClientDto client : dtolist){
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("id", client.getId());
                jsonObject.put("prenom", client.getPrenom());
                jsonObject.put("name", client.getName());
                jsonObject.put("email", client.getEmail());
                jsonObject.put("addresse", client.getAddresse());
                jsonArray.add(jsonObject);
            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred When trying to import client list by Addresse")
                    .build();
        }
        return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response numberOfClients(String name) {
        long num = clientDao.numberOfClient(name);
        JSONArray jsonArray =new JSONArray();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("num", num);
            jsonArray.add(jsonObject);
            }
        catch (Exception e){
            log.error(e.getMessage(),e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred When trying to import client list by Addresse")
                    .build();
        }
        return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();
    }

}
