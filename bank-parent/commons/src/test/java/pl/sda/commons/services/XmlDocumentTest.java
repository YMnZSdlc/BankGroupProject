package pl.sda.commons.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.commons.services.mockClass.MockData;
import pl.sda.commons.strategy.ConvertObjectToFile;
import pl.sda.commons.strategy.DocumentType;

import java.util.ArrayList;
import java.util.List;

public class XmlDocumentTest {

    @Test
    public void shouldSaveMockDataToXmlFile() {

        //given
        List<String> exampleList = new ArrayList<>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");
        MockData mockData = new MockData(22, "Hello ", "World!!", exampleList);
        //when
        ConvertObjectToFile convertObjectToFile = new ConvertObjectToFile(DocumentType.XML);
        boolean result = convertObjectToFile.convert(mockData);
        //then
        Assertions.assertTrue(result);

    }


    @Test
    public void shouldSaveListMOckDataToXmlFile() {

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
        ConvertObjectToFile convertObjectToFile = new ConvertObjectToFile(DocumentType.XML);
        boolean result = convertObjectToFile.convert(list);
        //then
        Assertions.assertTrue(result);
    }

}
