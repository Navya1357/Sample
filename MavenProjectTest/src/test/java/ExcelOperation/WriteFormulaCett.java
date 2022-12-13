package ExcelOperation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteFormulaCett {

	public static void main(String[] args) throws IOException {
		String path = ".\\DataFiles\\ApplyFormulaAndCalc.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(0);
		
		sheet.getRow(7).getCell(2).setCellFormula("SUM(C2:C6)");
		fis.close();
		FileOutputStream fos=new FileOutputStream(path);
		book.write(fos);
		book.close();
		fos.close();
	System.out.println("Done!!!");
		
}      

}


