package pl.sda.commons.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.DocumentType;
import pl.sda.commons.MockData;

import java.util.ArrayList;
import java.util.List;

class ExcelDocumentTest {

    @Test
    void shouldSaveMockDataToXlsFile() throws IllegalAccessException {
        //given
        List<String> exampleList = new ArrayList<String>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");

        MockData exampleToWtite = new MockData(22,"Hello ","World!!",exampleList);
        ExcelDocument document = new ExcelDocument("xls", DocumentType.EXCEL);

        //when
        Boolean actualResult = document.saveToXLS(exampleToWtite);

        //then
        Assertions.assertTrue(actualResult);
    }





}