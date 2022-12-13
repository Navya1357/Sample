package ExcelOperation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteWithArayList {
	public static void main(String[] args) throws IOException {
		XSSFWorkbook book= new XSSFWorkbook();
		XSSFSheet Sheet = book.createSheet("Sample Sheet");
		ArrayList<Object[]> empdata= new ArrayList<Object[]>();
		empdata.add(new Object[] {"EMPID","NAME","DESIGNATION"});
		empdata.add(new Object[] {"011", "Abc", "Soft Engineering"});
		empdata.add(new Object[]  {"022", "Xyz", "Manager"});
		empdata.add(new Object[] {"033", "PQR", "HR"});
		
		
		//Using For each loop
		int rownum=0;
		for(Object[] emp:empdata)
		{
			XSSFRow rows = Sheet.createRow(rownum++);
			int columncount=0;
			for(Object value:emp)
			{
				XSSFCell cell = rows.createCell(columncount++);
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
				
	
			}   
				
				
				String excelfilePath = ".\\DataFiles\\EmpdataArraylist.xlsx";
				// To open the excel file
				FileOutputStream output=new FileOutputStream(excelfilePath);
				book.write(output);
			 
				output.close();
				System.out.println("empdata.xlsx  file written successfully");
				
				
			 
		 }
		
}
 
}



