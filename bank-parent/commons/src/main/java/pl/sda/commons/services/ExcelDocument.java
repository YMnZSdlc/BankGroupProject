package pl.sda.commons.services;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.*;

import org.apache.log4j.Logger;

import pl.sda.commons.strategy.Converatble;
import pl.sda.commons.tools.PathToFile;
import pl.sda.commons.tools.ValidParameters;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;

public class ExcelDocument implements Converatble {

    private static Logger LOGGER = Logger.getLogger(ExcelDocument.class);
    private static final String PATH = PathToFile.setPath();

    @Override
    public boolean convert(Object data) {
        ValidParameters.check(data, PATH);

        if (Collection.class.isAssignableFrom(data.getClass())) {
            return saveListToXLS((Collection) data);
        } else {
            return saveOneToXLS(data);
        }
    }

    private boolean saveListToXLS(Collection<?> data) {
        WritableWorkbook exampleXls = null;
        String nameForFileAndSheet = data.getClass().getSimpleName();

        try {
            exampleXls = Workbook.createWorkbook(new File(PATH + nameForFileAndSheet + ".xls"));

            // create Excel sheet name from class name
            WritableSheet excelSheet = exampleXls.createSheet(nameForFileAndSheet, 0);

            // read fields name from class
            Class<?> aClass = data.iterator().next().getClass();
            Field[] fields = aClass.getDeclaredFields();

            // create Excel label name from fields name

            saveLabelLoop(excelSheet, fields);

            // create Excel content from Class content
            int row = 1;
            for (Object sData : data) {
                aClass = sData.getClass();
                Field[] fieldsInside = aClass.getDeclaredFields();
                saveContentLoop(excelSheet, row, sData, fieldsInside);
                row++;
            }

            exampleXls.write();
            return true;

        } catch (IOException | WriteException | IllegalAccessException e) {
            LOGGER.error("Błąd dostępu do pliku", e);
        } finally {
            if (exampleXls != null) {
                try {
                    exampleXls.close();
                } catch (IOException | WriteException e) {
                    LOGGER.error("Błąd zapisu do pliku", e);
                }
            }
        }
        return false;
    }


    private boolean saveOneToXLS(Object data) {
        WritableWorkbook exampleXls = null;
        String nameForFileAndSheet = data.getClass().getSimpleName();

        try {
            exampleXls = Workbook.createWorkbook(new File(PATH + nameForFileAndSheet + ".xls"));

            // create Excel sheet name from class name
            WritableSheet excelSheet = exampleXls.createSheet(nameForFileAndSheet, 0);

            // read fields name from class
            Class<?> aClass = data.getClass();
            Field[] fields = aClass.getDeclaredFields();

            // create Excel label name from fields name

            saveLabelLoop(excelSheet, fields);

            // create Excel content from Class content
            int row = 1;
            saveContentLoop(excelSheet, row, data, fields);

            exampleXls.write();
            return true;

        } catch (IOException | WriteException | IllegalAccessException e) {
            LOGGER.error("Błąd dostępu do pliku", e);
        } finally {
            if (exampleXls != null) {
                try {
                    exampleXls.close();
                } catch (IOException | WriteException e) {
                    LOGGER.error("Błąd zapisu do pliku", e);
                }
            }
        }
        return false;
    }

    private void saveLabelLoop(WritableSheet excelSheet, Field[] fields) throws WriteException {
        // create Excel format for label
        WritableCellFormat labelFormat = getLabelFormat();
        Label label;
        int col = 0;
        for (Field field : fields) {
            label = new Label(col, 0, field.getName(), labelFormat);
            excelSheet.addCell(label);
            col++;
        }
    }

    private void saveContentLoop(WritableSheet excelSheet, int row, Object sData, Field[] fields1) throws IllegalAccessException, WriteException {
        // create Excel format for content
        WritableCellFormat contentFormat = getContentFormat();
        Label label;
        int col = 0;
        for (Field field : fields1) {
            field.setAccessible(true);
            label = new Label(col, row, "" + field.get(sData), contentFormat);
            excelSheet.addCell(label);
            col++;
        }
    }

    private WritableCellFormat getLabelFormat() throws WriteException {
        // create Excel format for label
        WritableCellFormat labelFormat = new WritableCellFormat();
        WritableFont labelFont = new WritableFont(WritableFont.TAHOMA, 10, WritableFont.BOLD);
        labelFont.setColour(Colour.BLUE);
        labelFormat.setFont(labelFont);
        return labelFormat;
    }

    private WritableCellFormat getContentFormat() throws WriteException {
        // create Excel format for content
        WritableCellFormat contentFormat = new WritableCellFormat();
        WritableFont contentFont = new WritableFont(WritableFont.TAHOMA, 10);
        contentFont.setColour(Colour.BLACK);
        contentFormat.setFont(contentFont);
        return contentFormat;
    }
}
