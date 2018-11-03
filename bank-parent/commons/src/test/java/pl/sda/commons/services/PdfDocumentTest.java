package pl.sda.commons.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.commons.strategy.ConvertObjectToFile;
import pl.sda.commons.services.mockClass.MockData;

import java.util.ArrayList;
import java.util.List;

import static pl.sda.commons.strategy.DocumentType.PDF;

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
        ConvertObjectToFile convertObjectToFile = new ConvertObjectToFile(PDF);
        boolean result = convertObjectToFile.convert(mockData);
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
        ConvertObjectToFile convertObjectToFile = new ConvertObjectToFile(PDF);
        boolean result = convertObjectToFile.convert(list);
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

        MockData mockDataTwo = new MockData(33, "DJAn", "askd#$", exampleList);
        mockDataTwo.setMockDataList(list);

        //when
        ConvertObjectToFile convertObjectToFile = new ConvertObjectToFile(PDF);
        boolean result = convertObjectToFile.convert(mockDataTwo);
        //then
        Assertions.assertTrue(result);

    }
}