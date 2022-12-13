package ExcelOperation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook ();
		XSSFSheet sheet = book.createSheet("Student Data");
		Map<String,String> data = new HashMap<String,String>();
		data.put("111", "ABC");
		data.put("112", "xyz");
		data.put("113", "pqr");
		data.put("114", "klm");
		 
		int rowno=0;
		for(Map.Entry entry:data.entrySet())
		{
		XSSFRow row=sheet.createRow(rowno++);
			row.createCell(0).setCellValue((String)entry.getKey());
			row.createCell(1).setCellValue((String)entry.getValue());  

		}
		FileOutputStream fos = new FileOutputStream(".\\Datafiles\\Student.xlsx");
		book.write(fos);
		fos.close();
		System.out.println("Excel written successfully");
		}
}
