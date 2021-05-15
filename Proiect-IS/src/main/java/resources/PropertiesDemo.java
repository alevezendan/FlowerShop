package resources;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesDemo {

    public void prop(){
        Locale[] supportedLocales = {
                Locale.FRENCH,
                Locale.GERMAN,
                Locale.ENGLISH
        };

        //for(Locale currentLocale:supportedLocales){
        Locale currentLocale=supportedLocales[0];
            ResourceBundle labels = ResourceBundle.getBundle("MyBundle", currentLocale);
            Enumeration bundleKeys = labels.getKeys();

            while (bundleKeys.hasMoreElements()) {
                String key = (String)bundleKeys.nextElement();
                String value = labels.getString(key);
                System.out.println("key = " + key + ", " + "value = " + value);
            }
        //}
    }
}
