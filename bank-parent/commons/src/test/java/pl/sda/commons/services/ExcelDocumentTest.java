package pl.sda.commons.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.commons.strategy.ConvertObjectToFile;
import pl.sda.commons.MockData;

import java.util.ArrayList;
import java.util.List;

import static pl.sda.commons.strategy.DocumentType.EXCEL;

class ExcelDocumentTest {

    @Test
    void shouldGenerateMockDataToXlsFile() {
        //given
        List<String> exampleList = new ArrayList<>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");

        MockData exampleToWrite = new MockData(22, "Hello ", "World!!", exampleList);

        //when
        ConvertObjectToFile convertObjectToFile = new ConvertObjectToFile(EXCEL);
        Boolean actualResult = convertObjectToFile.convert(exampleToWrite);

        //then
        Assertions.assertTrue(actualResult);
    }


    @Test
    void shouldGenerateListMockDataToXlsFile() {
        //given
        List<String> exampleList = new ArrayList<>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");

        List<MockData> exampleListToWrite = new ArrayList<>();
        exampleListToWrite.add(new MockData(1, "AAA", "aaa", exampleList));
        exampleListToWrite.add(new MockData(2, "BBB", "bbb", exampleList));
        exampleListToWrite.add(new MockData(3, "CCC", "ccc", exampleList));
        exampleListToWrite.add(new MockData(4, "DDD", "ddd", exampleList));


        //when

        ConvertObjectToFile convertObjectToFile = new ConvertObjectToFile(EXCEL);
        Boolean actualResult = convertObjectToFile.convert(exampleListToWrite);

        //then
        Assertions.assertTrue(actualResult);
    }

    @Test
    void shouldReturnFalseToNull() {
        //given
        MockData exampleToWrite = null;

        //when
        ConvertObjectToFile convertObjectToFile = new ConvertObjectToFile(EXCEL);
        Boolean actualResult = convertObjectToFile.convert(exampleToWrite);

    }

}