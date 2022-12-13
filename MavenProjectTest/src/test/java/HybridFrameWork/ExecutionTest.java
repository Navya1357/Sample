package HybridFrameWork;

	import java.io.IOException; 
	import java.lang.reflect.InvocationTargetException;

import FrameWork.Action_Keyword; 
	

	 

	public class ExecutionTest 
	{ 
	public static void main(String[] args) throws IOException, Exception, IllegalArgumentException, InvocationTargetException 
	{ 
	ReadExcelSheet rs = new ReadExcelSheet(); 
	rs.DemoFile(4); 
	Action_Keyword k = new Action_Keyword();

	 

	k.enterEmail(); 
	k.enterPassword(); 
	k.clickSignIn(); 
	k.logout(); 
	k.closeBrowser();
	System.out.println("Test executed successfully"); 
	}
	}
	
