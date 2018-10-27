package pl.sda.commons.services;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.*;
import pl.sda.commons.strategy.ConvertToFile;
import pl.sda.commons.tools.PathToFile;
import pl.sda.commons.exceptions.ObjectToSaveInvalid;
import pl.sda.commons.exceptions.PathNotFoundException;
import pl.sda.commons.tools.ValidParameters;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;

public class ExcelDocument implements ConvertToFile {

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
        String prefix = data.getClass().getSimpleName();

        try {
            exampleXls = Workbook.createWorkbook(new File(prefix + PATH));

            // create Excel sheet name from class name
            WritableSheet excelSheet = exampleXls.createSheet(prefix, 0);

            // read fields name from class
            Label label = null;
            Class<?> aClass = data.iterator().next().getClass();
            Field[] fields = aClass.getDeclaredFields();

            // create Excel label name from fields name

            saveLabelLoop(excelSheet, fields);

            // create Excel content from Class content
            int col = 0;
            int row = 1;
            for (Object sData : data) {
                aClass = sData.getClass();
                Field[] fieldsInside = aClass.getDeclaredFields();
                saveContentLoop(excelSheet, col, row, sData, fieldsInside);
                row++;
                col = 0;
            }

            exampleXls.write();
            return true;

        } catch (IOException | WriteException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (exampleXls != null) {
                try {
                    exampleXls.close();
                } catch (IOException | WriteException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }


    private boolean saveOneToXLS(Object data) {
        WritableWorkbook exampleXls = null;
        String prefix = data.getClass().getSimpleName();

        try {
            exampleXls = Workbook.createWorkbook(new File(prefix + PATH));

            // create Excel sheet name from class name
            WritableSheet excelSheet = exampleXls.createSheet(prefix, 0);

            // read fields name from class
            Label label = null;
            Class<?> aClass = data.getClass();
            Field[] fields = aClass.getDeclaredFields();

            // create Excel label name from fields name

            saveLabelLoop(excelSheet, fields);

            // create Excel content from Class content
            int col = 0;
            int row = 1;
            saveContentLoop(excelSheet, col, row, data, fields);

            exampleXls.write();
            return true;

        } catch (IOException | WriteException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (exampleXls != null) {
                try {
                    exampleXls.close();
                } catch (IOException | WriteException e) {
                    e.printStackTrace();
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
        int row = 0;
        for (Field field : fields) {
            label = new Label(col, row, field.getName(), labelFormat);
            excelSheet.addCell(label);
            col++;
        }
    }

    private void saveContentLoop(WritableSheet excelSheet, int col, int row, Object sData, Field[] fields1) throws IllegalAccessException, WriteException {
        // create Excel format for content
        WritableCellFormat contentFormat = getContentFormat();
        Label label;
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
