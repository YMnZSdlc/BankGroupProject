package pl.sda.commons.tools;

import pl.sda.commons.exceptions.ObjectToSaveInvalid;
import pl.sda.commons.exceptions.PathNotFoundException;

public class ValidParameters {

    public static void check(Object data, String path) {

        if (data == null) {

            throw new ObjectToSaveInvalid("Null object");
        }
        if (path == null) {
            throw new PathNotFoundException("Path not found");
        }
    }
}
