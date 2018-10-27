package pl.sda.commons.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import pl.sda.commons.ConvertToFile;
import pl.sda.commons.DocumentType;
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

public class CsvDocument implements ConvertToFile {

    private static final String SAMPLE_CSV_FILE = "./sample.csv";


    private static void CsvGenerator(Object data) throws IOException {
        assert data != null : "Null Object";
        convert(data);
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

    private static String[] extractHeaders(Object data) {

        Field[] fields = data.getClass().getDeclaredFields();
        List<String> fieldNames = Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
        String[] headers = new String[fieldNames.size()];
        headers = fieldNames.toArray(headers);
        return headers;
    }


    @Override
    public void convert(Object data) {

        String[] headers = extractHeaders(data);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
             CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers))) {

            List<Object> collect = Arrays.stream(data.getClass().getDeclaredFields())
                    .map(field -> setPermissionToFieldAccess(data, field))
                    .collect(Collectors.toList());
            printer.printRecord(collect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}