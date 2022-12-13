package ExcelOperation;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	public static void main(String[] args) throws IOException {
		XSSFWorkbook book= new XSSFWorkbook();
		XSSFSheet Sheet = book.createSheet("Sample Sheet");
	
		Object empdata [][]= {
				                {"EMPID", "NAME", "JOB"},
				                {"011", "Abc", "Soft Engineering"},
				                {"022", "Xyz", "Manager"},  
				                {"033", "PQR", "HR"}  
				};
		/*int rows = empdata.length;
		 int cols = empdata[0].length;
		 
		 for(int r=0;r<rows;r++) 
		 {
			 XSSFRow row = Sheet.createRow(r);
			 
			 
			 for(int c=0;c<cols;c++)
			 {
				 
				XSSFCell cell = row.createCell(c);
				Object value = empdata[r][c];
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);*/
		
		//Using For each loop
		int rowcount=0;
		for(Object emp[]:empdata)
		{
			XSSFRow rows = Sheet.createRow(rowcount++);
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
				
				
				String excelfilePath = ".\\DataFiles\\empdata.xlsx";
				// To open the excel file
				FileOutputStream output=new FileOutputStream(excelfilePath);
				book.write(output);
			 
				output.close();
				System.out.println("empdata.xlsx  file written successfully");
				
			
			 
		 }
		
}

}


