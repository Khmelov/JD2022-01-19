package by.it.chaikova.jd02_05.resources;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    final String  baseName = "by.it.chaikova.jd02_05.resources.language";
    private ResourceBundle resourceBundle;

    ResourceManager() {
        Locale.setDefault(Locale.ENGLISH);
        set(Locale.ENGLISH);
    }

    public void set(Locale locale){
        resourceBundle=ResourceBundle.getBundle(baseName,locale);
    }
    public String get(String key){
        return resourceBundle.getString(key);
    }
}

