package by.it.skorobogatyi.jd02_05.calc.resources;

import java.util.Locale;
import java.util.ResourceBundle;

public enum LocalisationManager {

    INSTANCE;

    public static final String BASE_NAME = "by.it.skorobogatyi.jd02_05.calc.resources.language";
    private ResourceBundle resourceBundle;

    LocalisationManager(){
        Locale.setDefault(Locale.getDefault());
        set(Locale.ENGLISH);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

    public void set(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }
}
