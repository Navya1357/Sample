package ExcelOperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\Datafiles\\Student.xlsx");
	XSSFWorkbook book = new XSSFWorkbook(fis);
	XSSFSheet sheet = book.getSheet("Student Data");
	int rows=sheet.getLastRowNum();
	HashMap<String,String> data=new HashMap<String,String>();
	//Reading data from excel to hashmap
	for(int r=0; r<=rows;r++)
	{
		String key = sheet.getRow(r).getCell(0).getStringCellValue();
		String value = sheet.getRow(r).getCell(1).getStringCellValue();
	    data.put(key, value);

	}
	//Read data from HashMap
	
	for(Map.Entry entry:data.entrySet())
	{
		System.out.println(entry.getKey()+"   "+entry.getValue());
		}
	}

}



