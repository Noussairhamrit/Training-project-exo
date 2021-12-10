package org.exo.training.listener;

import org.exo.training.service.TextService;
import org.exoplatform.services.listener.Event;
import org.exoplatform.services.listener.Listener;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

public class TextListener extends Listener<TextService, String> {
    private static final Log LOG= ExoLogger.getLogger(TextListener.class);
    @Override
    public void onEvent(Event<TextService,String> event) throws Exception {
        LOG.warn("#########onEvent  *****TextListener  ::" +event.getData() +"::"+event.getEventName()+"::"+event.getSource());
    }
}
