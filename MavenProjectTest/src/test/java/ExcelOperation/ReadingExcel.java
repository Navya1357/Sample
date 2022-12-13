package ExcelOperation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {
public static void main(String[] args) throws IOException {
	String excelfilePath = ".\\DataFiles\\TD.1.xlsx";          
	// To open the excel file
	FileInputStream input=new FileInputStream(excelfilePath);
	XSSFWorkbook wb= new XSSFWorkbook(input);
	XSSFSheet Sheet = wb.getSheetAt(0);
	int row = Sheet.getLastRowNum();
	int  col = Sheet.getRow(1).getLastCellNum();
	for(int r=0;r<=row;r++) 
	{
		XSSFRow rows = Sheet.getRow(r);
		
		for(int c=0;c<col;c++) 
		{
			XSSFCell cell = rows.getCell(c);
			
			switch(cell.getCellType())
			{
			case STRING : System.out.println(cell.getStringCellValue()); break;
			case NUMERIC : System.out.println(cell.getNumericCellValue()); break;
			case BOOLEAN : System.out.println(cell.getBooleanCellValue()); break;
				
			}
		}
		System.out.println();
		
	}
	}

	
	
}

