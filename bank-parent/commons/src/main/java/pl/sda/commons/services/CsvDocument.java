package pl.sda.commons.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import pl.sda.commons.strategy.ConvertToFile;
import pl.sda.commons.tools.PathToFile;
import pl.sda.commons.tools.ValidParameters;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class CsvDocument implements ConvertToFile {

    private static final String PATH = PathToFile.setPath();

    @Override
    public boolean convert(Object data) {

        ValidParameters.check(data, PATH);
        String[] headers = chooseWhichTypeOfHeaders(data);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(PATH));
             CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers))) {

            Collection collectionObjects = fillCollection(data);

            for (Object object : collectionObjects) {
                List<Object> collect = Arrays.stream(object.getClass().getDeclaredFields())
                        .map(field -> setPermissionToFieldAccess(object, field))
                        .collect(toList());

                printer.printRecord(collect);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private Collection fillCollection(Object data) {
        Collection collectionObjects;
        if (!Collection.class.isAssignableFrom(data.getClass())) {
            collectionObjects = new ArrayList();
            collectionObjects.add(data);
        } else {
            collectionObjects = (List<?>) data;
        }
        return collectionObjects;
    }

    private static Object setPermissionToFieldAccess(Object data, Field field) {
        try {
            field.setAccessible(true);
            return field.get(data);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String[] chooseWhichTypeOfHeaders(Object data) {
        if (Collection.class.isAssignableFrom(data.getClass())) {
            return extractHeadersFromList(data);
        } else if (Map.class.isAssignableFrom(data.getClass())) {
            return extractHeadersFromMapKeys(data);
        }
        return extractHeaders(data);
    }

    private static String[] extractHeaders(Object data) {
        Field[] fields = data.getClass().getDeclaredFields();
        List<String> fieldNames = Arrays.stream(fields).map(Field::getName).collect(toList());
        String[] headers = new String[fieldNames.size()];
        headers = fieldNames.toArray(headers);
        return headers;
    }

    private static String[] extractHeadersFromMapKeys(Object data) {
        data = (((Map) data).keySet().stream()).collect(toList());
        return extractHeadersFromList(data);
    }

    private static String[] extractHeadersFromList(Object data) {
        data = ((List) data).get(0);
        return extractHeaders(data);
    }

}