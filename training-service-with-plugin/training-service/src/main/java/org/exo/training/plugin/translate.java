package org.exo.training.plugin;

public class translate extends TextServicePlugin {
    @Override
    public String transformText(String text) {
        return null;
    }

    @Override
    public String translate(String text) {
        return "translating " + text;
    }

    @Override
    public String ponctuation(String text) {
        return null;
    }
}
