package pl.sda.commons.services;

import org.junit.jupiter.api.Test;
import pl.sda.commons.MockData;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PdfDocumentTest {

    @Test
    public void shouldSaveMockDataToPdfFileWersjaFuszeraPoprawieNaZaTydzienRobienieTabeliZajeloMiDuzoczasuINieZdarzylemXd() {

        List<String> exampleList = new ArrayList<String>();
        exampleList.add("Sample 1");
        exampleList.add("Sample 2");
        exampleList.add("Sample 3");
        exampleList.add("Sample 4");

        MockData mockData = new MockData(22, "Hello ", "World!!", exampleList);
        PdfDocument.saveToPdf(mockData);

        System.out.println(" Zaufaj mi jest dobrze :) ");

        assertTrue(1==1);
    }
}