package pl.sda.commons.tools;

import java.util.Properties;

public class PathToFile {

    public static String setPath() {
        Properties properties = System.getProperties();
        String osName = (String) properties.get("os.name");
        if (osName.equals("Mac OS X")) {
            return properties.get("user.home") + "/desktop/Pdf";
        } else if (osName.equals("Windows")) {
            return properties.get("user.home") + "/Pdf";
        }
        return null;
    }
}
