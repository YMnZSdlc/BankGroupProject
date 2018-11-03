package pl.sda.commons.services;

import org.apache.commons.csv.CSVPrinter;
import org.apache.log4j.Logger;
import pl.sda.commons.strategy.Convertable;
import pl.sda.commons.tools.PathToFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.nio.file.Files.newBufferedWriter;
import static java.nio.file.Paths.get;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.csv.CSVFormat.DEFAULT;
import static org.apache.log4j.Logger.getLogger;
import static pl.sda.commons.tools.ValidParameters.check;

public class CsvGenerator implements Convertable {
    private static final String PATH = PathToFile.getPath();
    private static Logger LOGGER = getLogger(CsvGenerator.class);

    @Override
    public boolean convert(Object data) {

        String simpleName = data.getClass().getSimpleName();

        check(data, PATH);
        String[] headers = prepareHeaders(data);
        try (BufferedWriter writer = newBufferedWriter(get(PATH + simpleName + ".csv"));
             CSVPrinter printer = new CSVPrinter(writer, DEFAULT.withHeader(headers))) {

            Collection collectionObjects = fillCollection(data);

            for (Object object : collectionObjects) {
                List<Object> collect = stream(object.getClass().getDeclaredFields())
                        .map(field -> setPermissionToFieldAccess(object, field))
                        .collect(toList());

                printer.printRecord(collect);

            }
            return true;
        } catch (IOException e) {
            LOGGER.error(e.toString());
            return false;
        }
    }

    private Collection fillCollection(Object data) {
        Collection collectionObjects;
        if (Collection.class.isAssignableFrom(data.getClass())) {
            return (List<?>) data;
        } else {
            collectionObjects = new ArrayList();
            collectionObjects.add(data);
            return collectionObjects;
        }
    }

    private static Object setPermissionToFieldAccess(Object data, Field field) {
        try {
            field.setAccessible(true);
            return field.get(data);
        } catch (IllegalAccessException e) {
            LOGGER.error(e.toString());
        }
        return null;
    }

    private static String[] prepareHeaders(Object data) {
        if (Collection.class.isAssignableFrom(data.getClass())) {
            return extractHeadersFromList((List) data);
        } else if (Map.class.isAssignableFrom(data.getClass())) {
            return extractHeadersFromMapKeys(data);
        }
        return extractHeaders(data);
    }

    private static String[] extractHeaders(Object data) {
        Field[] fields = data.getClass().getDeclaredFields();
        List<String> fieldNames = stream(fields).map(Field::getName).collect(toList());
        String[] headers = new String[fieldNames.size()];
        headers = fieldNames.toArray(headers);
        return headers;
    }

    private static String[] extractHeadersFromMapKeys(Object data) {
        data = (((Map) data).keySet().stream()).collect(toList());
        return extractHeadersFromList((List) data);
    }

    private static String[] extractHeadersFromList(List data) {
        return extractHeaders(data.get(0));
    }
}