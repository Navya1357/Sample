package ExcelOperation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatabaseToExcel {

	public static void main(String[] args) throws SQLException, IOException {
		//CONNECT TO THE DATABASE
		Connection Con = DriverManager.getConnection("jdbc:mysql://DESKTOP-3M30ENU\\SQLEXPRESS/SampleData");
		//Statement /query
		Statement stmt = Con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Employees");

		//Excel file
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Employees Data");

		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("Name");
		row.createCell(1).setCellValue("EmpId");
		row.createCell(2).setCellValue("Position");
		row.createCell(3).setCellValue("Salary");

		int r=1;
		while(rs.next())
		{
			String Name = rs.getString("Name");
			int EmpId = rs.getInt("EmpId");
			String Position = rs.getString("Position");
			double Salary = rs.getDouble("Salary");

			row=sheet.createRow(r++);
			row.createCell(0).setCellValue(Name);
			row.createCell(1).setCellValue(EmpId);
			row.createCell(2).setCellValue(Position);
			row.createCell(3).setCellValue(Salary);
		}
		FileOutputStream fos=new FileOutputStream(".\\Datafiles\\Employees.xlsx");
		book.write(fos);
         book.close();
         fos.close();
         Con.close();
         System.out.println("Done");
	}
	
}



