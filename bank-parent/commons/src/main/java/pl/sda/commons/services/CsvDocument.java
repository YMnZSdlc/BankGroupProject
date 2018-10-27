package pl.sda.commons.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import pl.sda.commons.MockData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class CsvDocument {

    private static final String SAMPLE_CSV_FILE = "./sample.csv";

    public static void main(String[] args) throws IOException {

//        CsvGenerator(prepareObject());
        CsvGenerator(prepareList());
//        CsvGenerator(null);

    }

    private static void CsvGenerator(Object data) throws IOException {
        if (data != null) {
            printToFileFinalMethod(data);
        } else {
            throw new RuntimeException("Null Object");
        }
    }


    private static void printToFileFinalMethod(Object data) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

        String[] headers = chooseWhichTypeOfHeaders(data);
        Collection collectionObjects = fillCollection(data);
        Map mapObject;

        try (CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers))) {
            for (Object object : collectionObjects) {
                List<Object> collect = Arrays.stream(object.getClass().getDeclaredFields())
                        .map(field -> setPermissionToFieldAccess(object, field))
                        .collect(toList());

                printer.printRecord(collect);
            }
        }
    }

    private static Collection fillCollection(Object data) {
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

    private static String[] chooseWhichTypeOfHeaders(Object data){
        if (Collection.class.isAssignableFrom(data.getClass())){
            return extractHeadersFromList(data);
        }else if(Map.class.isAssignableFrom(data.getClass())){
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

    private static String[] extractHeadersFromMapKeys(Object data){
            data = (((Map) data).keySet().stream()).collect(toList());
        return extractHeadersFromList(data);
    }

    private static String[] extractHeadersFromList(Object data){
            data = ((List) data).get(0);
        return extractHeaders(data);
    }

    private static List<MockData> prepareList() {
        List<String> exampleList = new ArrayList<>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");

        List<MockData> mockData = new ArrayList<>();
        mockData.add(new MockData(1, "asfga", "asf", exampleList));
        mockData.add(new MockData(2, "asfga", "asf", exampleList));
        mockData.add(new MockData(3, "asfga", "asf", exampleList));
        mockData.add(new MockData(4, "asfga", "asf", exampleList));

        return mockData;
    }

    private static MockData prepareObject() {
        return new MockData(1, "asfga", "asf", null);
    }
}