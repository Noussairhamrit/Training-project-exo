package org.exo.training.plugin;

import org.exoplatform.container.component.BaseComponentPlugin;

public abstract class TextServicePlugin extends BaseComponentPlugin {
  public abstract String transformText(String text);
  public abstract String translate(String text);
  public abstract String ponctuation(String text);
}
