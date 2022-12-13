package HybridFrameWork;


import java.lang.reflect.Method;

import org.openqa.selenium.interactions.Actions;
public class DriverScript{
public static Actions actionKeywords;
public static String sActions;
//This is reflection class object and declared as 'public static' and it can //be used outside the main[] method
public static Method method[];
public static void main(String[] args) throws Exception {
//Declaring the path of the Excel file with the name of the Excel file
String sPath = "Path to the exceldata.xlsx";
ReadExcelData.setExcelFile(sPath, "Sheet1");
for (int iRow=1;iRow<=9;iRow++)
{ sActions = ReadExcelData.getCellData(iRow, 1);
execute_Actions(); 

}
}
private static void execute_Actions() throws Exception {
actionKeywords = new Actions();
//It will load all the methods of the class 'Actions' in it. 
method = actionKeywords.getClass().getMethods();
//It will run for the number of actions in the Action Keyword class 
for(int i = 0;i<method.length;i++) {
if(method[i].getName().equals(sActions))
{
method[i].invoke(actionKeywords);
break;
}
}
}
}