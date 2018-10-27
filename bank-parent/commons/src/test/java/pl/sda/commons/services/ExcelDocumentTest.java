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
        List<String> exampleList = new ArrayList<String>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");

        MockData exampleToWtite = new MockData(22, "Hello ", "World!!", exampleList);

        //when
        ExcelDocument document = new ExcelDocument();
        Boolean actualResult = document.saveOneToXLS(exampleToWtite);

        //then
        Assertions.assertTrue(actualResult);
    }

    @Test
    void shouldSaveMockDataListToXlsFile() {
        //given
        List<String> exampleList = new ArrayList<String>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");

        List<MockData> exampleListToWtite = new ArrayList<>();
        exampleListToWtite.add(new MockData(1, "AAA", "aaa", exampleList));
        exampleListToWtite.add(new MockData(2, "BBB", "bbb", exampleList));
        exampleListToWtite.add(new MockData(3, "CCC", "ccc", exampleList));
        exampleListToWtite.add(new MockData(4, "DDD", "ddd", exampleList));


        //when
        ExcelDocument document = new ExcelDocument();
        Boolean actualResult = document.saveListToXLS(exampleListToWtite);

        //then
        Assertions.assertTrue(actualResult);

    }

}