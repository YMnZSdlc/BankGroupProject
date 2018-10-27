package pl.sda.commons.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.commons.ConvertObjectToFile;
import pl.sda.commons.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pl.sda.commons.DocumentType.CSV;

class CsvDocumentTest {

    @Test
    void shouldSaveMockDataToCsvFile() throws IOException {
        //given
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

        CsvDocument document = new CsvDocument();

        //when
        ConvertObjectToFile convertObjectToFile = new ConvertObjectToFile(CSV);

        Boolean actualResult = convertObjectToFile.convert(mockData);

        //then
        Assertions.assertTrue(actualResult);
    }

}