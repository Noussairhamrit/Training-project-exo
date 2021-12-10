package org.exo.training.service;

import org.exo.training.plugin.TextServicePlugin;
import org.exoplatform.services.listener.ListenerService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.picocontainer.Startable;

import java.beans.BeanProperty;
import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;

public class TextService implements ITextService, Startable {
  private static final Log  LOG= ExoLogger.getLogger(TextService.class);

  private List<TextServicePlugin> pluginList = new ArrayList<>();


  /////inject ListenerService
    private ListenerService listenerService;
    //// name of listener le meme nom dans configuration.xml
    private static final String TEXT_CHANGED = "text-changed";
    private static final String TRANSLATE = "text-TRANSLATE";

  public TextService(ListenerService listenerService) {
      this.listenerService=listenerService;
    LOG.warn("Text Service created !");
  }

    @Override
    public void addTextTransformer(TextServicePlugin textServicePlugin) {
        this.pluginList.add(textServicePlugin);
    }

  @Override
  public void start() {
    LOG.warn("Text Service started !");
     this.changeText("changeText Training eXo Container");
     this.translateText("traslate exo text");
  }

  @Override
  public void stop() {
    LOG.warn("Text Service stopped !");

  }

  public void changeText(String text) {
     text = "changeText Training eXo Container";

    for (TextServicePlugin plugin : this.pluginList) {
      LOG.warn("Plugin {} returned {}", plugin.getName(), plugin.transformText(text));
    }
    ///// this====est reference pour marquer le source de broadcast de listener qui est TextService
      try {
          listenerService.broadcast(TEXT_CHANGED,this,text+"  #listener# ");
      } catch (Exception e) {
          LOG.error("problem broadcasting event {}", TEXT_CHANGED, e);
      }
  }

  public void translateText(String text) {
      text = " translateText Training eXo Container";
    for (TextServicePlugin plugin : this.pluginList) {
      LOG.warn("Plugin {} returned {}", plugin.getName(), plugin.translate(text));
    }
      try {
          listenerService.broadcast(TRANSLATE,this,text+"  #listener//TRANSLATE# ");
      } catch (Exception e) {
          LOG.error("problem broadcasting event {}", TEXT_CHANGED, e);
      }
  }

    public void ponctuationText(String text) {
        text = "ponctuationText Training eXo Container";
        for (TextServicePlugin plugin : this.pluginList) {
            LOG.warn("Plugin {} returned {}", plugin.getName(), plugin.ponctuation(text));
        }
    }

}
