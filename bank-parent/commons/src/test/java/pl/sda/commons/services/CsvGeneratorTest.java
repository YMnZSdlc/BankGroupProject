package pl.sda.commons.services;

import org.junit.jupiter.api.Test;
import pl.sda.commons.MockData;
import pl.sda.commons.strategy.ConvertObjectToFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.sda.commons.strategy.DocumentType.CSV;

class CsvGeneratorTest {

    @Test
    void shouldSaveMockDataToCsvFile() {
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

        //when
        ConvertObjectToFile convertObjectToFile = new ConvertObjectToFile(CSV);
        boolean actualResult = convertObjectToFile.convert(mockData);

        //then
        assertTrue(actualResult);
    }

    @Test
    void isFileExist() {
        File file = new File("C:\\Users\\mateu\\IdeaProjects\\sda_ldz_9\\sample.csv");
        assertTrue(file.exists());
    }

    @Test
    void sizeShouldBeGreaterThan0() {
        File file = new File("C:\\Users\\mateu\\IdeaProjects\\sda_ldz_9\\sample.csv");
        long size = file.length();
        assertTrue(size > 0);
    }
}