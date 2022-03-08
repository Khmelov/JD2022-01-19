package by.it.kharevich.calculator.resources;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    final String RESOURCES_LANGUAGE = "by.it.kharevich.calculator.resources.languagecalc";

    private ResourceBundle resourceBundle;

    ResourceManager() {
        Locale.setDefault(Locale.ENGLISH);
        set(Locale.ENGLISH);
    }

    public void set(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(RESOURCES_LANGUAGE, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
