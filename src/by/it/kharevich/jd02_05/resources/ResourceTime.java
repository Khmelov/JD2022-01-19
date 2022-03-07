package by.it.kharevich.jd02_05.resources;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceTime {
    TIME;

    final String RESOURCES_TIME = "by.it.kharevich.jd02_05.resources.commands";

    private ResourceBundle resourceBundleTime;

    ResourceTime() {
        Locale.setDefault(Locale.ENGLISH);
        set(Locale.ENGLISH);
    }

    public void set(Locale locale) {
        resourceBundleTime = ResourceBundle.getBundle(RESOURCES_TIME, locale);
    }

    public String get(String key) {
        return resourceBundleTime.getString(key);
    }
}
