package org.exoplatform.plugin;

import org.exoplatform.container.component.BaseComponentPlugin;
import org.exoplatform.dto.ClientDto;
import org.exoplatform.entity.ClientEntity;

public abstract class ClientServicePlugin extends BaseComponentPlugin {
    public abstract String helloClient(ClientDto client);

}
