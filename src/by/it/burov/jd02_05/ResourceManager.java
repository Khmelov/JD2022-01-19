package by.it.burov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    public static final String RESOURCES_PATH = "by.it.burov.jd02_05.resources.language";
    private ResourceBundle resourceBundle;

    ResourceManager() {
        Locale.setDefault(Locale.ENGLISH);
        set(Locale.ENGLISH);
    }

    public void set(Locale locale){
        resourceBundle=ResourceBundle.getBundle(RESOURCES_PATH,locale);
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }
}
