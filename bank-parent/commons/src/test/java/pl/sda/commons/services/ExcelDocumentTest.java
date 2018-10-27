package pl.sda.commons.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.commons.MockData;

import java.util.ArrayList;
import java.util.List;

class ExcelDocumentTest {

    @Test
    void shouldSaveMockDataToXlsFile() {
        //given
        List<String> exampleList = new ArrayList<>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");

        MockData exampleToWrite = new MockData(22, "Hello ", "World!!", exampleList);

        //when
        ExcelDocument document = new ExcelDocument();
        Boolean actualResult = document.saveOneToXLS(exampleToWrite);

        //then
        Assertions.assertTrue(actualResult);
    }

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
        ExcelDocument document = new ExcelDocument();
        Boolean actualResult = document.generateXLS(exampleToWrite);

        //then
        Assertions.assertTrue(actualResult);
    }

    @Test
    void shouldSaveListMockDataToXlsFile() {
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
        ExcelDocument document = new ExcelDocument();
        Boolean actualResult = document.saveListToXLS(exampleListToWrite);

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
        ExcelDocument document = new ExcelDocument();
        Boolean actualResult = document.generateXLS(exampleListToWrite);

        //then
        Assertions.assertTrue(actualResult);
    }

    @Test
    void shouldReturnFalseToNull() {
        //given
        MockData exampleToWrite = null;

        //when
        ExcelDocument document = new ExcelDocument();
        Boolean actualResult = document.generateXLS(exampleToWrite);

        //then

    }

}