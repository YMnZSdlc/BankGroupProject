package pl.sda.commons.tools;

import pl.sda.commons.exceptions.OsNotFound;

import java.util.Properties;

public class PathToFile {

    public static String getPath() {

        Properties properties = System.getProperties();
        String userHome = (String) properties.get("user.home");
        String osName = (String) properties.get("os.name");
        if (osName.equals("Mac OS X")) {
            return userHome + "/desktop/Pdf";
        } else if (osName.equals("Windows 10")) {
            return userHome;
        } else {
            throw new OsNotFound("Os Not Found");
        }
    }
}
