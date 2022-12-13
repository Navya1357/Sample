package ExcelOperation;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteFormulaData1 {
public static void main(String[] args) throws IOException {
	XSSFWorkbook book = new XSSFWorkbook();
	XSSFSheet sheet = book.createSheet("Numbers");
	XSSFRow row = sheet.createRow(0);
	  row.createCell(0).setCellValue(10);
	  row.createCell(1).setCellValue(20);
	  row.createCell(2).setCellValue(30);
	  
	  row.createCell(3).setCellFormula("A1*B1*C1");
	  FileOutputStream outputfile = new FileOutputStream(".\\DataFiles\\WriteFormulasData.xlsx");  
     book.write(outputfile);
     outputfile.close();
     
     System.out.println("Calc.xlsx created with formula cell....");
     
}
}

