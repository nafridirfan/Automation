package logincases;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcel {

    public String readExcel(){

        String credentials = "";
        try{
            FileInputStream excelFile = new FileInputStream(new File("poi_test.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet dataypesheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = dataypesheet.iterator();

            while(iterator.hasNext()){
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()){
                    Cell currentCell = cellIterator.next();
                    if(currentCell.getCellTypeEnum() == CellType.STRING){
                        credentials = currentCell.getStringCellValue();
                    } else if(currentCell.getCellTypeEnum() == CellType.NUMERIC){
                        System.out.print(currentCell.getNumericCellValue() + "---");
                    }
                }
                System.out.println();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return credentials;
    }
}
