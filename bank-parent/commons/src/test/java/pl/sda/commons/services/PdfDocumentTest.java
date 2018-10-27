package pl.sda.commons.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.commons.MockData;
import pl.sda.commons.MockDataTwo;

import java.util.ArrayList;
import java.util.List;

class PdfDocumentTest {

    @Test
    public void shouldSaveMockDataToPdfFile() {

        //given
        List<String> exampleList = new ArrayList<>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");
        MockData mockData = new MockData(22, "Hello ", "World!!", exampleList);
        //when
        boolean result = PdfDocument.saveToPdf(mockData);
        //then
        Assertions.assertTrue(result);

    }

    @Test
    public void shouldSaveListMOckDataToPdfFile() {

        //given
        List<String> exampleList = new ArrayList<>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");
        MockData mockData = new MockData(22, "Hello ", "World!!", exampleList);

        MockData mockData1 = new MockData(12, "Sth", "Do", exampleList);

        ArrayList<MockData> list = new ArrayList<>();
        list.add(mockData);
        list.add(mockData1);

        //when
        boolean result = PdfDocument.saveToPdf(list);
        //then
        Assertions.assertTrue(result);

    }

    @Test
    public void shouldSaveObjectWithListMockDataToPdfFile() {

        //given
        List<String> exampleList = new ArrayList<>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");
        MockData mockData = new MockData(22, "Hello ", "World!!", exampleList);

        MockData mockData1 = new MockData(12, "Sth", "Do", exampleList);


        List<MockData> list = new ArrayList<>();
        list.add(mockData);
        list.add(mockData1);

        MockDataTwo mockDataTwo = new MockDataTwo("JAAAAAZDA", list);

        //when
        boolean result = PdfDocument.saveToPdf(mockDataTwo);
        //then
        Assertions.assertTrue(result);

    }
}