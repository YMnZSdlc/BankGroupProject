package pl.sda.commons.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.commons.MockData;

import java.util.ArrayList;
import java.util.List;

class ExcelDocumentTest {

    @Test
    void shouldSaveOneObjectToXlsFile() throws IllegalAccessException {
        //given
        List<String> sampleList1 = new ArrayList<String>();
        sampleList1.add("Sample 1");
        sampleList1.add("Sample 2");
        sampleList1.add("Sample 3");
        sampleList1.add("Sample 4");

        MockData exampleToWtite = new MockData(22,"Hello ","World!!",sampleList1);
        ExcelDocument exampleDocument1 = new ExcelDocument();

        //when
        Boolean actualResult = exampleDocument1.saveOneToXLS(exampleToWtite);

        //then
        Assertions.assertTrue(actualResult);
    }

    @Test
    void shouldSaveListObjectToXlsFile() throws IllegalAccessException {
        //given
        List<String> sampleList2 = new ArrayList<String>();
        sampleList2.add("Sample 1");
        sampleList2.add("Sample 2");
        sampleList2.add("Sample 3");
        sampleList2.add("Sample 4");
        List<MockData> exampleListToWrite = new ArrayList<>();
        MockData sample1 = new MockData(21,"Hello ","World!!",sampleList2);
        MockData sample2 = new MockData(22,"AAA","aaa",sampleList2);
        MockData sample3 = new MockData(23,"BBB","bbb",sampleList2);
        MockData sample4 = new MockData(24,"CCC","ccc",sampleList2);
        MockData sample5 = new MockData(25,"DDD","ddd",sampleList2);
        exampleListToWrite.add(sample1);
        exampleListToWrite.add(sample2);
        exampleListToWrite.add(sample3);
        exampleListToWrite.add(sample4);
        exampleListToWrite.add(sample5);
        ExcelDocument exampleDocument2 = new ExcelDocument();

        //when
        Boolean actualResult = exampleDocument2.saveListToXLS(exampleListToWrite);

        //then
        Assertions.assertTrue(actualResult);
    }








}