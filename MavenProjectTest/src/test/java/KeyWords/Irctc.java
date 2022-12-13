package KeyWords;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import KeyWords.Keyword1;
import KeyWords.Keywords;

public class Irctc {
	WebDriver driver;
	String path = System.getProperty("user.dir");

	Keywords keyword = new Keywords();
	Keyword1 Keyword1 = new Keyword1();

	@Test
	public void readExcelandexecute() throws IOException, InterruptedException{


		String excelFilePath = path+"C:\\Users\\Dell\\OneDrive - Abylle Solutions Pvt Ltd\\Desktop\\Test Cases.xlsx";
		FileInputStream fileInputStream = new FileInputStream(excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

		int testcasescount = workbook.getNumberOfSheets()-1;

		System.out.println("Total no of test cases :"+testcasescount);

		for (int testcase=0;testcase<testcasescount;testcase++){
			System.setProperty("webdriver.chrome.driver","C:\\Navya\\Selenium\\Drivers\\chromedriver.exe");  
			driver = new ChromeDriver();

			XSSFSheet worksheet = workbook.getSheetAt(testcase);

			System.out.println("worksheet Number "+testcase+":"+worksheet.getSheetName());

			int row = worksheet.getLastRowNum();
			int column = worksheet.getRow(1).getLastCellNum();

			for(int i=1;i<=row;i++){

				LinkedList<String> Testexecution = new LinkedList<>();

				System.out.println("Row value :"+i+"First cell value as : "+worksheet.getRow(i).getCell(0));

				for(int j=0;j<column-1;j++){
					System.out.println("Column index :"+j);
					Cell Criteria = worksheet.getRow(i).getCell(j);

					String CriteriaText;
					if(Criteria==null){
						CriteriaText = null;
					}else{
						CriteriaText = Criteria.getStringCellValue();
					}
					Testexecution.add(CriteriaText);
				}
				System.out.println("List :"+Testexecution);

				String TestStep = Testexecution.get(0);
				String ObjectName = Testexecution.get(1);
				String TypeLocator = Testexecution.get(2);
				String Testdata = Testexecution.get(3);
				String AssertionType = Testexecution.get(4);
				String ExpectedValue = Testexecution.get(5);
				String ActualValue = Testexecution.get(6);

				perform(TestStep,ObjectName,TypeLocator,Testdata,AssertionType,ExpectedValue,ActualValue);

				System.out.println("Row"+i+" is read and action performed");
			}

			driver.close();
			System.out.println("****TEST CASE "+worksheet.getSheetName()+" is executed*****");
		}
	}

	public void perform(String operation, String objectName, String typeLocator, String testdata,
			String assertionType, String expectedValue, String actualValue) throws IOException, InterruptedException {

		switch (operation) {
		case "enter_URL":

			//Perform click action
			keywords.enter_URL(driver,testdata);
			break;

		case "get_currentURL":

			Keywords.get_currentURL(driver);
			break;

		case "type":
			keywords.type(driver, objectName, typeLocator, testdata);

		case "click":
			keywords.click(driver, objectName, typeLocator);


		case "implicitWait":
			Thread.sleep(8000);

		default:
			break;
		}

		if(operation.contains("AssertURL")){

			switch(assertionType){

			case "contains":Keyword1.AssertURLContains(driver, Keyword1.get_currentURL(driver), expectedValue);
			case "equals":Keyword1.AssertURLEquals(driver, Keyword1.get_currentURL(driver), expectedValue);

			}

		}

		if(operation.contains("AssertElement")
				{Keyword1.AssertElement(driver, assertionType, objectName, typeLocator);

		}
	}
}
