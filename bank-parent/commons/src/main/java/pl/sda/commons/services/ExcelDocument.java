package pl.sda.commons.services;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import pl.sda.Document;
import pl.sda.DocumentType;
import pl.sda.commons.MockData;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

//EXCEL -> *.xls
public class ExcelDocument extends Document {

    public static final String EXCEL_FILE_LOCATION = "ExampleExcel.xls";

    public ExcelDocument(String text, DocumentType docType) {
        super(text, docType);
    }


//    MockData mockData = new MockData(22, "Hello ", "World !!!");

    public boolean saveToXLS(MockData data) {
        WritableWorkbook exampleXls = null;

        try {
            exampleXls = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

            // create Excel sheet name from class name
            WritableSheet excelSheet = exampleXls.createSheet(data.getClass().getSimpleName(), 0);

            // create Excel format for label
            WritableCellFormat labelFormat = new WritableCellFormat();
            WritableFont labelFont = new WritableFont(WritableFont.TAHOMA, 16, WritableFont.BOLD);
            labelFont.setColour(Colour.BLUE);
            labelFormat.setFont(labelFont);

            // create Excel format for content
            WritableCellFormat contentFormat = new WritableCellFormat();
            WritableFont contentFont = new WritableFont(WritableFont.TAHOMA, 12);
            contentFont.setColour(Colour.BLACK);
            contentFormat.setFont(contentFont);


            // read fields name from class
            Label label = null;
            Class<?> aClass = data.getClass();
            Field[] fields = aClass.getDeclaredFields();



            // create Excel label name from fields name
            int col = 0;
            int row = 0;
            for (Field field : fields) {
                label = new Label(col, row, field.getName(),labelFormat);
                excelSheet.addCell(label);
                col ++;
            }

            // create Excel content from Class content
            col = 0;
            row = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                label = new Label(col,row,  ""+field.get(data), contentFormat);
                excelSheet.addCell(label);
                col ++;
            }

            exampleXls.write();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (exampleXls != null) {
                try {
                    exampleXls.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }


}