package ExcelOperation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class XLUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook book;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	XLUtility(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
	fi= new FileInputStream(path);
	book=new XSSFWorkbook(fi);
	sheet=book.getSheet("TestData");
	int rowcount=sheet.getLastRowNum();
	book.close();
	fi.close();
	return rowcount;
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException
	{
		fi= new FileInputStream(path);
		book=new XSSFWorkbook(fi);
		sheet=book.getSheet("TestData");
		row=sheet.getRow(1);
		int cellcount=row.getLastCellNum();
		book.close();
		fi.close();
		return cellcount;
	}
	public String getCellData(String sheetName, int rownum,int column) throws IOException
	{
		fi= new FileInputStream(path);
		book=new XSSFWorkbook(fi);
		sheet=book.getSheet("TestData");
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
		data=formatter.formatCellValue(cell);
		}
		catch (Exception e)
		{
		  data="";
		}
		book.close();
		fi.close();
		return data;		
			
	}
	 public void setCellData(String sheetName, int rownum,int column,String data) throws IOException
	 {
		   fi= new FileInputStream(path);
			book=new XSSFWorkbook(fi);
			sheet=book.getSheet(sheetName);
			
			row=sheet.getRow(rownum);
			cell=row.getCell(column);
			cell.setCellValue(data);
			
			fo=new FileOutputStream(path);
			book.write(fo);
			book.close();
			fi.close();
			fo.close();  
	 }
	 public void fillGreenColour(String sheetName,int rownum,int column) throws IOException
	 {
		 fi= new FileInputStream(path);
			book=new XSSFWorkbook(fi);
			sheet=book.createSheet(sheetName);
			
			row=sheet.getRow(rownum);
			cell=row.getCell(column);
			
			style=book.createCellStyle();
			
			style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			book.write(fo);
			book.close();
			fi.close();
			fo.close();
		 
		 
		
	 }
	 public void fillRedColour(String sheetName,int rownum,int column) throws IOException
	 {
		 fi= new FileInputStream(path);
			book=new XSSFWorkbook(fi);
			sheet=book.getSheet(sheetName);
			
			row=sheet.getRow(rownum);
			cell=row.getCell(column);
			
			style=book.createCellStyle();
			
			style.setFillBackgroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			book.write(fo);
			book.close();
			fi.close();
			fo.close();
		 
		 
		
		
	 }
}

