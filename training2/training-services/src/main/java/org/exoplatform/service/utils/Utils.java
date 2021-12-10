package org.exoplatform.service.utils;

import org.exoplatform.dto.ClientDto;
import org.exoplatform.entity.ClientEntity;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static ClientEntity toEntity(ClientDto client){
        ClientEntity clientEntity=new ClientEntity();
        clientEntity.setId(client.getId());
        clientEntity.setName(client.getName());
        clientEntity.setPrenom(client.getPrenom());
        clientEntity.setAddresse(client.getAddresse());
        clientEntity.setEmail(client.getEmail());
        return clientEntity;
    }
    public static ClientDto toDto(ClientEntity client){
        ClientDto clientDto=new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setPrenom(client.getPrenom());
        clientDto.setEmail(client.getEmail());
        clientDto.setAddresse(client.getAddresse());
        return clientDto;

    }
    public static List<ClientDto> toDtoList(List<ClientEntity> list ){
        List<ClientDto> clientDtosList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            ClientEntity cc = list.get(i);
            ClientDto c=toDto(cc);
            clientDtosList.add(c);
        }
        return clientDtosList;
    }
}
