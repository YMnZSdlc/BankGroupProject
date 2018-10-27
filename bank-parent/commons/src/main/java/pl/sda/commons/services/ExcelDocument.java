package pl.sda.commons.services;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.*;
import pl.sda.commons.MockData;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

//EXCEL -> *.xls
public class ExcelDocument {

    public static final String EXCEL_FILE_LOCATION = "Example.xls";


//    MockData mockData = new MockData(22, "Hello ", "World !!!");


        public boolean saveToExcel (Object data){

            //            worker.getClass().isAssignableFrom(Collections.class);
            //            worker.getClass().cast()
            if (data.getClass().isAssignableFrom(Collection.class)) {


            } else {
                return saveOneToXLS(data);
            }

            return false;
        }


        public boolean saveListToXLS(List<MockData> data) {

            if (data.isEmpty()) {
                // TODO: 20.10.2018
            }

            WritableWorkbook exampleXls = null;
            String prefix = data.getClass().getSimpleName();

            try {
                exampleXls = Workbook.createWorkbook(new File(prefix + EXCEL_FILE_LOCATION));

                // create Excel sheet name from class name
                WritableSheet excelSheet = exampleXls.createSheet(prefix, 0);

                // create Excel format for label
                WritableCellFormat labelFormat = new WritableCellFormat();
                WritableFont labelFont = new WritableFont(WritableFont.TAHOMA, 10, WritableFont.BOLD);
                labelFont.setColour(Colour.BLUE);
                labelFormat.setFont(labelFont);

                // create Excel format for content
                WritableCellFormat contentFormat = new WritableCellFormat();
                WritableFont contentFont = new WritableFont(WritableFont.TAHOMA, 10);
                contentFont.setColour(Colour.BLACK);
                contentFormat.setFont(contentFont);

                // read fields name from class
                Label label = null;
                Class<?> aClass = data.get(0).getClass();
                Field[] fields = aClass.getDeclaredFields();

                // create Excel label name from fields name
                int col = 0;
                int row = 0;
                for (Field field : fields) {
                    label = new Label(col, row, field.getName(), labelFormat);
                    excelSheet.addCell(label);
                    col++;
                }

                // create Excel content from Class content
                col = 0;
                row = 1;
                for (Object sData : data) {
                    aClass = sData.getClass();
                    Field[] fields1 = aClass.getDeclaredFields();
                    for (Field field : fields1) {
                        field.setAccessible(true);
                        label = new Label(col, row, "" + field.get(sData), contentFormat);
                        excelSheet.addCell(label);
                        col++;
                    }
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


        public boolean saveOneToXLS(Object data){
            WritableWorkbook exampleXls = null;
            String prefix = data.getClass().getSimpleName();

            try {

                exampleXls = Workbook.createWorkbook(new File(prefix + EXCEL_FILE_LOCATION));

                // create Excel sheet name from class name
                WritableSheet excelSheet = exampleXls.createSheet(prefix, 0);

                // create Excel format for label
                WritableCellFormat labelFormat = new WritableCellFormat();
                WritableFont labelFont = new WritableFont(WritableFont.TAHOMA, 10, WritableFont.BOLD);
                labelFont.setColour(Colour.BLUE);
                labelFormat.setFont(labelFont);

                // create Excel format for content
                WritableCellFormat contentFormat = new WritableCellFormat();
                WritableFont contentFont = new WritableFont(WritableFont.TAHOMA, 10);
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
                    label = new Label(col, row, field.getName(), labelFormat);
                    excelSheet.addCell(label);
                    col++;
                }

                // create Excel content from Class content
                col = 0;
                row = 1;
                for (Field field : fields) {
                    field.setAccessible(true);
                    label = new Label(col, row, "" + field.get(data), contentFormat);
                    excelSheet.addCell(label);
                    col++;
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


    }
