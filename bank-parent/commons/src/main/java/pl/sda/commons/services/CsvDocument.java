package pl.sda.commons.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import pl.sda.commons.MockData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CsvDocument {

    private static final String SAMPLE_CSV_FILE = "./sample.csv";

    public static void main(String[] args) throws IOException {
        printToFile(mockDataList());
    }

    private static boolean printToFile(List<MockData> mockDataList) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
        MockData mockData = mockDataList.get(0);
        Field[] fields = mockData.getClass().getDeclaredFields();
        List<String> fieldNames = Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());

        String[] headers = new String[fieldNames.size()];
        headers = fieldNames.toArray(headers);


        try (CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers))) {
            for (MockData data : mockDataList) {
                List<Object> collect = Arrays.stream(data.getClass().getDeclaredFields()).map(field -> {
                    try {
                        field.setAccessible(true);
                        return field.get(data);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.toList());
                printer.printRecord(collect);
            }
        }
        return true;
    }

    static boolean saveToCSV(List<MockData> mockData) throws IOException {
        if (!mockData.getClass().isAssignableFrom(Collection.class)) {
            return printToFile(mockData);
        }
        return false;
    }

    private static List<MockData> mockDataList() {
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
        mockData.add(new MockData(5, "asfga", "asf", exampleList));
        return mockData;
    }

}