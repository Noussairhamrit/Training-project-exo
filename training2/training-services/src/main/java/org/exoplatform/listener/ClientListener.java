package org.exoplatform.listener;

import org.exoplatform.dto.ClientDto;
import org.exoplatform.service.ClientService;
import org.exoplatform.services.listener.Event;
import org.exoplatform.services.listener.Listener;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

public class ClientListener extends Listener<ClientService, String> {
    private static final Log LOG= ExoLogger.getLogger(ClientListener.class);

    @Override
    public void onEvent(Event<ClientService, String> event) throws Exception {
        LOG.warn("#########onEvent  ClientListener  "+"#data# : "+event.getData()
                                                        +"#event name# : "+event.getEventName()
                                                        +"#source# : "+event.getSource());

    }
}
