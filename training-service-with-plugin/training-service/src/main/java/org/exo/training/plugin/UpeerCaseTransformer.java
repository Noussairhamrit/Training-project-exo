package org.exo.training.plugin;

public class UpeerCaseTransformer extends TextServicePlugin{
  @Override
   public String transformText(String text) {
    return text.toUpperCase();
  }

  @Override
  public String translate(String text) {
    return null;
  }

    @Override
    public String ponctuation(String text) {
        return null;
    }
}
