package by.it.tarend.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    INSTANCE;
    final String baseName = "by.it.tarend.jd02_05.resourses.language";
    private ResourceBundle resourceBundle;

    ResourceManager() {
        Locale.setDefault(Locale.ENGLISH);
        set(Locale.ENGLISH);
    }

    public void set(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(baseName, locale);

    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
