package org.exoplatform.service;

import org.exoplatform.dto.ClientDto;
import org.exoplatform.entity.ClientEntity;
import org.exoplatform.plugin.ClientServicePlugin;

import javax.ws.rs.core.Response;
import java.util.List;

public interface IclientService {
    public Response GetAllClients();
    public Response createClient (ClientDto client);
    public Response getOneClient(long id);
    public Response deleteClient(long id);
    public Response editClient(long id, ClientDto editClient);
    public void addPlugin(ClientServicePlugin clientServicePlugin);
    public Response GetClientsByAddresse(String adresse);
    public Response numberOfClients(String name);

}
