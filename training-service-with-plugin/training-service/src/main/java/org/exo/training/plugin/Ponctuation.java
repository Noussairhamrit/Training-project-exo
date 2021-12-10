package org.exo.training.plugin;

public class Ponctuation extends TextServicePlugin{
  @Override
  public String transformText(String text) {
    return null;
  }

    @Override
    public String translate(String text) {
        return null;
    }

    @Override
    public String ponctuation(String text) {
        return text + "!!!!!!!";
    }
}
