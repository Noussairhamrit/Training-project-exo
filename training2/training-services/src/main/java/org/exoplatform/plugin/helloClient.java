package org.exoplatform.plugin;

import org.exoplatform.dto.ClientDto;
import org.exoplatform.entity.ClientEntity;

public class helloClient extends ClientServicePlugin{
    @Override
    public String helloClient(ClientDto client) {
        return "hello :"+client.getName();
    }
}
