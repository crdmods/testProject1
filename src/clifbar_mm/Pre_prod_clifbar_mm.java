package clifbar_mm;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Pre_prod_clifbar_mm {

	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "E:\\myse\\drivers\\chromedriver.exe");
		ChromeDriver rahul= new ChromeDriver();
		
ExtentReports er=new ExtentReports("E:\\myse\\Workspace_eclipse\\clifbar_mm\\ClifbarResults.html",true);
ExtentTest et=er.startTest("Clifbar Pre-Prod Validation");		
	rahul.manage().deleteAllCookies();
	rahul.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	rahul.get("http://cb-mm-qa.info-rhythm.com/home");	
	rahul.manage().window().maximize();
	System.out.println("Website loaded successfully");	
et.log(LogStatus.PASS, "Website loaded successfully");

try
{
	rahul.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("clifbar");
	rahul.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Info@123");
	rahul.findElement(By.xpath("//a[@id='loginButton']")).click();
	////////
	WebDriverWait w1=new WebDriverWait(rahul,50);
	w1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='rpt-thumbnails lg-tile' and @tile-id='6']")));
	//Thread.sleep(25000);
	////////
File src1=rahul.getScreenshotAs(OutputType.FILE);
File dst1=new File("D:\\SE_Screenshots\\1_LoginSuccesful.png");
FileUtils.copyFile(src1,dst1);
	System.out.println("Login Successful");
et.log(LogStatus.PASS, "Login Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\1_LoginSuccesful.png"));

//Thread.sleep(9000);

//Creating a New Report 
	rahul.findElement(By.xpath("//div[@class='rpt-thumbnails lg-tile' and @tile-id='6']")).click();//opening User Access Tile
	Thread.sleep(5000);	
	rahul.findElement(By.xpath("//div[@id='NewReportlist']")).click(); // clicking on New Report Button
	rahul.findElement(By.xpath("//li[@id='result-view_ChangeReport']")).click(); //Clicking on Change report menu
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_changeUser'][1]")).click(); //Clicking on User Dimension
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//span[@class='ui-btn-inner ui-selected-attrib']")).click(); //De-selecting All Users attribute
	rahul.findElement(By.xpath("//span[@name='USER_NAME']")).click(); //Selecting USERNAME Attribute
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Done'])[18]")).click();// clicking on done button
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_ChangeReport']")).click();//Clicking on Change report menu
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[text()='Metrics'])[1]")).click();//Clicking on Metrics
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//td[@id='btnRowDelete']")).click(); 	//Deleting the existing metric
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//span[text()='Add']")).click();  // Adding the New Metric
	rahul.findElement(By.xpath("//span[text()='None']")).click(); // Attempt to select Metric
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//a[text()='Report Access Count']")).click(); //Selected a Metric
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//input[@name='measureDescription']")).clear();
	rahul.findElement(By.xpath("//input[@name='measureDescription']")).sendKeys("Report Access Count TEST-AUT");
	
/////////////	
	
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Done'])[21]")).click(); // clicking on done button
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Done'])[20]")).click(); // clicking on done button
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("//li[@data-menuname='generate']")).click(); // Clicking on generate button
	Thread.sleep(10000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text'])[25]")).click(); //Rotate 1
	Thread.sleep(5000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text'])[25]")).click(); //Rotate 2
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("(//span[text()='Save'])[1]")).click();			//Clicking on Save button
	rahul.findElement(By.xpath("(//input[@name='name' and @id='rptName'])[2]")).sendKeys("Test Save Report AUT_UA");	
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Done'])[7]")).click();	
	Thread.sleep(5000);
	//Thread.sleep(10000);
	rahul.findElement(By.xpath("(//span[text()='Save As'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//input[@name='name' and @id='rptName'])[2]")).sendKeys("_Save As");
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Done'])[7]")).click();	
	//Thread.sleep(10000);
	rahul.findElement(By.xpath("//li[@data-menuname='backButton']")).click();
	
	//WebDriverWait w4=new WebDriverWait(rahul,50);
	//w4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='NewReportlist']")));

	Thread.sleep(15000); 	//This need to be given to let page to load properly

File src2=rahul.getScreenshotAs(OutputType.FILE);
File dst2=new File("D:\\SE_Screenshots\\2_New Report Creation is Successful.png");
FileUtils.copyFile(src2,dst2);
	System.out.println("New Report Creation Process is Successful");
et.log(LogStatus.PASS, "New Report Creation Process is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\2_New Report Creation is Successful.png"));

	//Deleting Report
	///////
	rahul.findElement(By.xpath("//span[text()='Test Save Report AUT_UA']/ancestor::li/descendant::span[@class='checkstyle']")).click();
	///////
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@data-menuname='reportAction']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Yes'])[1]")).click();

	//Thread.sleep(4000); 
	//findElement is not working in this scenerio so used WebDriverWait
WebDriverWait w5=new WebDriverWait(rahul,50);
w5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Report(s) deleted successfully.']")));
	
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='OK'])[2]")).click();
	//Thread.sleep(5000);
	//////
	rahul.findElement(By.xpath("//span[text()='Test Save Report AUT_UA_Save As']/ancestor::li/descendant::span[@class='checkstyle']")).click();
	//////
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@data-menuname='reportAction']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Yes'])[1]")).click();
	et.log(LogStatus.PASS, "Report succesfully delated");
	
	//Thread.sleep(4000);
	//findElement is not working in this scenerio so used WebDriverWait
WebDriverWait w6=new WebDriverWait(rahul,50);
w6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Report(s) deleted successfully.']")));

	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='OK'])[2]")).click();
	//Thread.sleep(4000);
	rahul.findElement(By.xpath("//li[@data-menuname='Home']")).click();
	Thread.sleep(15000);
	

// Opening a existing report
	///////
	rahul.findElement(By.xpath("//div[@class='rpt-thumbnails lg-tile' and @tile-id='6']")).click();//opening User Access Tile
	//////
	//Thread.sleep(5000);	
	
WebDriverWait w20=new WebDriverWait(rahul,50);
w20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='NewReportlist']")));
	
	rahul.findElement(By.xpath("//a[contains(@data-bind,'root.getFolderDetails')]")).click();
	///////
	Thread.sleep(5000);	
	rahul.findElement(By.xpath("//li[@id='112']")).click();
	///////
	Thread.sleep(15000);

File src3=rahul.getScreenshotAs(OutputType.FILE);
File dst3=new File("D:\\SE_Screenshots\\3_Opening Existing Report is Successful.png");
FileUtils.copyFile(src3,dst3);
	System.out.println("Opening Existing Report is Successful");
et.log(LogStatus.PASS, "Opening Existing Report is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\3_Opening Existing Report is Successful.png"));

//Exporting the report

	rahul.findElement(By.xpath("// li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	File src4=rahul.getScreenshotAs(OutputType.FILE);
	File dst4=new File("D:\\SE_Screenshots\\4_Exporting Report is Successful.png");
	FileUtils.copyFile(src4,dst4);
	System.out.println("Exporting Report is Successful");
	rahul.findElement(By.xpath("//li[@id='result-view_export' and @class='report-Action']")).click();
	et.log(LogStatus.PASS, "Exporting Report is Successful");
	et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\4_Exporting Report is Successful.png"));
			
Thread.sleep(12000);

	//unable to insert conditional wait since there is no element to find
	//WebDriverWait w21=new WebDriverWait(rahul,50);
	//w21.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Rotate']")));
	

//Applying Top Criteria

	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click();
	
	Thread.sleep(6000);	
	rahul.findElement(By.xpath("//li[@id='result-view_topcriteria' and @class='report-Action']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//input[@id='topValue']")).clear();
	rahul.findElement(By.xpath("//input[@id='topValue']")).sendKeys("9");
	Thread.sleep(2000);	
	rahul.findElement(By.xpath("((//div[@class='ui-grid-a ui-align-cstmbtn'])[3]/descendant::*)[13]")).click();	
	//rahul.findElement(By.xpath("((//div[@class='ui-grid-a ui-align-cstmbtn'])[3]/descendant::*)[13]")).click();
	//Thread.sleep(5000);	
WebDriverWait w21=new WebDriverWait(rahul,50);
w21.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//span[text()='Apply Top/Bottom'])[1]")));

//Generate button
	Thread.sleep(6000);	
	rahul.findElement(By.xpath("(//*[text()='Generate'][@data-bind='text: $data.text']) [last()-1]")).click();

	File src5=rahul.getScreenshotAs(OutputType.FILE);
	File dst5=new File("D:\\SE_Screenshots\\5_Applying Top Criteria is Successful.png");
	FileUtils.copyFile(src5,dst5);
	System.out.println("Applying Top Criteria is Successful");
	
	//unable to use WebDriverWait due to improper xpath
	//WebDriverWait w22=new WebDriverWait(rahul,50);
	//w22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Rotate']")));

File src6=rahul.getScreenshotAs(OutputType.FILE);
File dst6=new File("D:\\SE_Screenshots\\6_Report Generation is Successful.png");
FileUtils.copyFile(src6,dst6);
	System.out.println("Report Generation is Successful");
et.log(LogStatus.PASS, "Report Generation is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\6_Report Generation is Successful.png"));
		
// Creating new custom metric
	Thread.sleep(6000);		
	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_addCustomColumn'] [@class='report-Action']")).click();
	//Thread.sleep(5000);	
	rahul.findElement(By.xpath("//input[@class='customexp-popup-input02 customexp-popup-input03 txtcustomExpColumnName ui-input-text ui-body-e ui-corner-all ui-shadow-inset']")).sendKeys("Test_CustMet_Aut");
//////	
Select drp_ChooseMetric =new Select(rahul.findElement(By.xpath("(//select[@class='customexp-popup-select customMetricOption']) [last()-2]")));
drp_ChooseMetric.selectByVisibleText("Report Access Count-1D-CY");
//////	
Select drp_ChooseDataType =new Select(rahul.findElement(By.xpath("(//*[@class='customexp-popup-select customMetricDataType'])[last()-2]")));
drp_ChooseDataType.selectByVisibleText("Numeric");
	
Select drp_Choose_Precesion =new Select(rahul.findElement(By.xpath("(//*[@class='customexp-popup-select customMetricPrecision'])[last()-2]")));
drp_Choose_Precesion.selectByVisibleText("2 Decimal");
	
	rahul.findElement(By.xpath("//*[@class='custom-functions ui-link'][contains(text(),'Sum')]")).click();
	rahul.findElement(By.xpath("(//a[text()='+'][@class='ui-link'])[last()-1]")).click();
	rahul.findElement(By.xpath("(//a[text()='1'][@class='ui-link'])[last()-1]")).click();
	//Thread.sleep(2000);	
	rahul.findElement(By.xpath("(//*[@class='customexp-popup-buttons']/descendant::span[@class='ui-btn-inner']/child::*)[2]")).click();
///////
WebDriverWait w23=new WebDriverWait(rahul,50);
w23.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Report Access Count-1D-CY']")));
///////

File src7=rahul.getScreenshotAs(OutputType.FILE);
File dst7=new File("D:\\SE_Screenshots\\7_New Custom Metric Creation is Successful.png");
FileUtils.copyFile(src7,dst7);
	System.out.println("New Custom Metric Creation is Successful");
et.log(LogStatus.PASS, "New Custom Metric Creation is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\7_New Custom Metric Creation is Successful.png"));
		
	
 // Linking a Report	
	
	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click(); 
	Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[contains(text(),'Link Reports')])[1]")).click();
	Thread.sleep(5000);
	rahul.findElement(By.xpath("(//a[@class='report-link ui-link'])[1]")).click();
	Thread.sleep(7000); //This need to be maintained since there is a minute page loading going on
	rahul.findElement(By.xpath("//span[@class='ui-btn-text' and contains(text(),'Reports')]//parent::span[@class='ui-btn-text']")).click();
	//Thread.sleep(3000);

	rahul.findElement(By.xpath("//input[@id='linkReport-search']")).sendKeys("Test_Report Access Count_crd");  //Text Search
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("//span[@class='ui-btn-text' and contains(text(),'Explore UserAccess')]")).click(); 
	rahul.findElement(By.xpath("//span[@class='ui-btn-text' and contains(text(),'Standard Report_CRD')]")).click();
	rahul.findElement(By.xpath("//a[contains(text(),'Test_Report Access Count_crd')]")).click();
	rahul.findElement(By.xpath("((//div[@class='ui-grid-c btnBarHeight'])[18]//descendant::*)[10]")).click();
	Thread.sleep(3000);  //Need to wait till the page is loaded
	rahul.findElement(By.xpath("//a[@data-role='none' and contains(text(),'42')]")).click();
	//Thread.sleep(8000);
	// To handle xpath after good number of trails
	//	int ok_size=driver.findElements(By.xpath("//button[text()='OK']")).size();
	//driver.findElements(By.xpath("//button[text()='OK']")).get(ok_size-1).click();
	
WebDriverWait w24=new WebDriverWait(rahul,50);
w24.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Do you want to save changes you made to Report ?']")));
				
	rahul.findElement(By.xpath("(//span[@class='ui-btn-inner ui-btn-corner-all']/child::span[@class='ui-btn-text' and text()='No'])[8]")).click(); //earlier index was 8 but now changed to 7
	
	Thread.sleep(15000); // Need to wait till the page is loaded..
	//WebDriverWait w25=new WebDriverWait(rahul,50);
	//w25.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Rotate']")));

File src8=rahul.getScreenshotAs(OutputType.FILE);
File dst8=new File("D:\\SE_Screenshots\\8_Linking Report is Successful.png");
FileUtils.copyFile(src8,dst8);
	System.out.println("Linking Report is Successful");
et.log(LogStatus.PASS, "Linking Report is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\8_Linking Report is Successful.png"));
		
	rahul.findElement(By.xpath("//li[@data-menuname='backButton']")).click();
	//Thread.sleep(9000);

WebDriverWait w25=new WebDriverWait(rahul,50);
w25.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Explore UserAccess'])[2]")));
	Thread.sleep(3000);
		
// CREATING NEW CUSTOM VALUE

	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_addCustomValue']/child::span[contains(text(),'New Custom Value')]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//input[@class='customexp-popup-input02 customexp-popup-input03 customValueName ui-input-text ui-body-e ui-corner-all ui-shadow-inset']")).sendKeys("Test_CustomValue_Aut");
	Select drp_newCustomValue =new Select(rahul.findElement(By.xpath("(//select[@class='customexp-popup-select customDimensionOption'])[1]")));
	drp_newCustomValue.selectByValue("REPORTS");	
	Select drp_newCustomValue_ChooseAttributes =new Select(rahul.findElement(By.xpath("(//select[@class='customexp-popup-select customAttrOption'])[1]")));
	drp_newCustomValue_ChooseAttributes.selectByValue("functionaltest");
	rahul.findElement(By.xpath("(//a[@class='ui-link'] [@href='#']/child::span[contains(text(),'*')])[2]")).click();
	rahul.findElement(By.xpath("(//a[@class='ui-link' and contains(text(),'1')])[2]")).click();
	rahul.findElement(By.xpath("(//a[@class='ui-link' and contains(text(),'0')])[2]")).click();
	rahul.findElement(By.xpath("(//a[@class='ui-link' and contains(text(),'0')])[2]")).click();
	
	File src9=rahul.getScreenshotAs(OutputType.FILE);
	File dst9=new File("D:\\SE_Screenshots\\9_New Custom Value Creation is Successful.png");
	FileUtils.copyFile(src9,dst9);
	System.out.println("New Custom Value Creation is Successful");	
	et.log(LogStatus.PASS, "New Custom Value Creation is Successful");
	et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\9_New Custom Value Creation is Successful.png"));
			
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-inner']/child::span[@class='ui-btn-text' and text()='Done'])[9]")).click();
	//Thread.sleep(6000);


	
// ADDING FOOT NOTE
	
	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_addFootNote']/child::span[contains(text(),'Add Foot Note')]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//input[@name='footNoteText'])[1]")).sendKeys("Test_FootNote_AUT'");
	rahul.findElement(By.xpath("(//span[@class='ui-btn-inner']/child::span[@class='ui-btn-text'])[33]")).click();
	Thread.sleep(3000);	
File src10=rahul.getScreenshotAs(OutputType.FILE);
File dst10=new File("D:\\SE_Screenshots\\10_Adding Foot Note is Successful.png");
FileUtils.copyFile(src10,dst10);
	System.out.println("Adding Foot Note is Successful");
et.log(LogStatus.PASS, "Adding Foot Note is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\10_Adding Foot Note is Successful.png"));
		
	
//	Checking the Tabular View 

	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_tabularView']/span [contains(text(),'Tabular View')]")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[contains(text(),'Report')])[28]")).click();  //earlier text was Report Dimension, may be changed due to build fix
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-inner ui-btn-corner-all']/child::span[@class='ui-btn-text' and text()='Done'])[7]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//li[@id='result-view_generate']")).click();

	Thread.sleep(8000); // //Need to wait till the page is loaded for report generation
File src11=rahul.getScreenshotAs(OutputType.FILE);
File dst11=new File("D:\\SE_Screenshots\\11_Applying Tablular View is Successful.png");
FileUtils.copyFile(src11,dst11);
	System.out.println("Applying Tabular View is Successful");
et.log(LogStatus.PASS, "Applying Tabular View is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\11_Applying Tabular View is Successful.png"));
			
// ROW COLUMN FUNCTIONS

	//Thread.sleep(10000);
	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[contains(text(),'Row/Column Functions')])[1]")).click();
	//Thread.sleep(8000); 
	rahul.findElement(By.xpath("(//span[@id='customFunctionName' and contains(text(),'Sum')]/following::span[@class='checkstyle'])[2]")).click();
	//Thread.sleep(10000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-inner ui-btn-corner-all']/child::span[@class='ui-btn-text' and text()='Done'])[8]")).click();
	
	Thread.sleep(5000);	
File src12=rahul.getScreenshotAs(OutputType.FILE);
File dst12=new File("D:\\SE_Screenshots\\12_Implementing Row_Column Function is Successful.png");
FileUtils.copyFile(src12,dst12);
	System.out.println("Implementing Row/Column Function is Successful");
et.log(LogStatus.PASS, "Implementing Row/Column Function is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\12_Implementing Row_Column Function is Successful.png"));
				
//Charts validation

	System.out.println("Charts Applied:-");
	
//Horizontal Bar Chart
	
	//Thread.sleep(10000);
	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//div[@class='ui-btn-inner ui-li']/descendant::div[@class='ui-btn-text']/a[text()='Report'])[2]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Choose Attributes']/following::span[@class='ui-btn-text'and text()='Done'])[1]")).click();
	Thread.sleep(3000);
File src13=rahul.getScreenshotAs(OutputType.FILE);
File dst13=new File("D:\\SE_Screenshots\\13_Horizontal Bar chart.png");
FileUtils.copyFile(src13,dst13);
	System.out.println("Horizontal Bar Chart");
et.log(LogStatus.PASS, "Horizontal Bar Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\13_Horizontal Bar chart.png"));
				
//Vertical Bar Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Vertical Bar Chart']")).click();
	Thread.sleep(3000);
File src14=rahul.getScreenshotAs(OutputType.FILE);
File dst14=new File("D:\\SE_Screenshots\\14_Vertical Bar chart.png");
FileUtils.copyFile(src14,dst14);
	System.out.println("Vertical Bar Chart");
et.log(LogStatus.PASS, "Vertical Bar Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\14_Vertical Bar chart.png"));
				
//Pie Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Pie Chart']")).click();
	Thread.sleep(3000);
File src15=rahul.getScreenshotAs(OutputType.FILE);
File dst15=new File("D:\\SE_Screenshots\\15_Pie Chart.png");
FileUtils.copyFile(src15,dst15);	
	System.out.println("Pie Chart");
et.log(LogStatus.PASS, "Pie Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\15_Pie Chart.png"));
					
//Tree Map Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='TreeMap Chart']")).click();
	Thread.sleep(3000);
File src16=rahul.getScreenshotAs(OutputType.FILE);
File dst16=new File("D:\\SE_Screenshots\\16_Tree Map Chart.png");
FileUtils.copyFile(src16,dst16);	
	System.out.println("Tree Map Chart");
et.log(LogStatus.PASS, "Tree Map Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\16_Tree Map Chart.png"));
					
		
//Stacked Area Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Stacked Area Chart']")).click();
	Thread.sleep(3000);
File src17=rahul.getScreenshotAs(OutputType.FILE);
File dst17=new File("D:\\SE_Screenshots\\17_Stacked Area Chart.png");
FileUtils.copyFile(src17,dst17);		
	System.out.println("Stacked Area Chart");
et.log(LogStatus.PASS, "Stacked Area Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\17_Stacked Area Chart.png"));
					
//Funnel Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Funnel Chart']")).click();
	Thread.sleep(3000);
File src18=rahul.getScreenshotAs(OutputType.FILE);
File dst18=new File("D:\\SE_Screenshots\\18_Funnel chart.png");
FileUtils.copyFile(src18,dst18);	
	System.out.println("Funnel Chart");
et.log(LogStatus.PASS, "Funnel Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\18_Funnel chart.png"));
						
		
//Horizontal Target Bar Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Horizontal Target Bar Chart']")).click();
	//Thread.sleep(3000);
///////		
Select drp_SourceItem_TargetChartProp= new Select(rahul.findElement(By.xpath("//select[@id='currentMetric']")));
drp_SourceItem_TargetChartProp.selectByVisibleText("Report Access Count-1D-CY");
///////		
Select drp_TargetItem_TargetChartProp= new Select(rahul.findElement(By.xpath("//select[@id='targetMetric']")));
drp_TargetItem_TargetChartProp.selectByVisibleText("Sum");
		
	rahul.findElement(By.xpath("(//span[text()=' Target Bar Chart Properties']/following::div[@data-role='fieldcontain']/descendant::span[text()='Done'])[1]")).click();
	Thread.sleep(3000);
File src19=rahul.getScreenshotAs(OutputType.FILE);
File dst19=new File("D:\\SE_Screenshots\\19_Horizontal Target Bar Chart.png");
FileUtils.copyFile(src19,dst19);	
	Thread.sleep(5000);
	System.out.println("Horizontal Target Bar Chart");
et.log(LogStatus.PASS, "Horizontal Target Bar Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\19_Horizontal Target Bar Chart.png"));
					
		
//Vertical Target Bar Chart
		
	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Vertical Target Bar Chart']")).click();
	Thread.sleep(3000);
File src20=rahul.getScreenshotAs(OutputType.FILE);
File dst20=new File("D:\\SE_Screenshots\\20_Vertical Target Bar Chart.png");
FileUtils.copyFile(src20,dst20);	
	//Thread.sleep(5000);
	System.out.println("Vertical Target Bar Chart");	
et.log(LogStatus.PASS, "Vertical Target Bar Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\20_Vertical Target Bar Chart.png"));
					

//Mixed Line Chart	
	
	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Mixed Line-Bar Chart']")).click();
	//Thread.sleep(3000);
///////		
Select drp_LineScale=new Select(rahul.findElement(By.xpath("//select[@id='line-scale']")));
drp_LineScale.selectByVisibleText("Report Access Count-1D-CY");
///////
	//Thread.sleep(2000);
		
Select drp_BarScale=new Select(rahul.findElement(By.xpath("//select[@id='bar-scale']")));
drp_BarScale.selectByVisibleText("Sum");
	//Thread.sleep(2000);
		
	//rahul.findElement(By.xpath("(//input[@name='checkbox-useSameScale'])[2]/preceding::span[@class='ui-icon ui-icon-shadow ui-icon-checkbox-off']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[text()=' Mixed Line-Bar Chart Properties']/following::span[text()='Done'])[1]")).click(); //Earlier its index was 1 but now changed to 8//Now again need to reset it to 1
	Thread.sleep(3000);
File src21=rahul.getScreenshotAs(OutputType.FILE);
File dst21=new File("D:\\SE_Screenshots\\21_Mixed Line Chart.png");
FileUtils.copyFile(src21,dst21);	
	System.out.println("Mixed Line Chart");			
et.log(LogStatus.PASS, "Mixed Line Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\21_Mixed Line Chart.png"));
		
//Tile Chart	

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Tile Chart']")).click();
	//Thread.sleep(3000);	
////////		
Select drp_tileCurrentMetric=new Select(rahul.findElement(By.xpath("//select[@id='tileCurrentMetric']")));
drp_tileCurrentMetric.selectByVisibleText("Report Access Count-1D-CY");
////////
	//Thread.sleep(2000);
		
Select drp_tileTargetMetric =new Select(rahul.findElement(By.xpath("//select[@id='tileTargetMetric']")));
drp_tileTargetMetric.selectByVisibleText("Sum");
	//Thread.sleep(2000);
		
	rahul.findElement(By.xpath("(//span[text()=' Tile Chart Properties']/following::span[text()='Done'])[1]")).click();
	Thread.sleep(3000);
File src22=rahul.getScreenshotAs(OutputType.FILE);
File dst22=new File("D:\\SE_Screenshots\\22_Tile Chart.png");
FileUtils.copyFile(src22,dst22);	
	System.out.println("Tile Chart");
et.log(LogStatus.PASS, "Tile Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\22_Tile Chart.png"));
	
	System.out.println("All Charts are completed");
	System.out.println("Rahul Congrats!!! Automation Process Phase-I is Successfully completed");
et.log(LogStatus.PASS, "Automation Process Phase-I is Successfully completed");
	System.out.println("");		


//Phase-II Automation of Explore Cube...

	rahul.findElement(By.xpath("(//span[text()='Home'])[1]")).click();
	Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='No'])[16]")).click();
	Thread.sleep(5000);

//Creating a New Report 
	////////
	rahul.findElement(By.xpath("//div[@class='rpt-thumbnails lg-tile' and @tile-id='1']")).click();//opening User Access Tile
	////////
	Thread.sleep(5000);	
	rahul.findElement(By.xpath("//div[@id='NewReportlist']")).click(); // clicking on New Report Button
	rahul.findElement(By.xpath("//li[@id='result-view_ChangeReport']")).click(); //Clicking on Change report menu
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_changeProduct'][1]")).click(); //Clicking on Report Dimension
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//span[@class='ui-btn-inner ui-selected-attrib']")).click(); 	//De-selecting All Products attribute
	rahul.findElement(By.xpath("//span[text()='Brand Family']")).click(); //Selecting BrandFamily Attribute
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Done'])[19]")).click();// clicking on done button
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_ChangeReport']")).click();//Clicking on Change report menu
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[text()='Metrics'])[1]")).click();//Clicking on Metrics
	Thread.sleep(2000);
	rahul.findElement(By.xpath("//td[@id='btnRowDelete']")).click(); //Deleting the existing metric
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//span[text()='Add']")).click();  // Adding the New Metric
	rahul.findElement(By.xpath("(//span[text()='None'])[1]")).click(); // Attempt to select Metric drop down
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//a[text()='$ Volume']")).click(); //Selected Volume Metric
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("//span[text()='Duration']/following::a[@id='select-duration-button']/descendant::span[text()='None']")).click(); // Attempt to select Duration drop down
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("//a[text()='52W']")).click(); //Selected 52Wk Value
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("//span[text()='Vs .']/following::a[@id='select-vs-button']/descendant::span[text()='None']")).click(); // Attempt to select Vs. drop down
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("//a[text()='CY']")).click(); //Selected CY from drop down
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//input[@name='measureDescription']")).clear();
	rahul.findElement(By.xpath("//input[@name='measureDescription']")).sendKeys("Report TEST-AUT");
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Done'])[22]")).click(); // clicking on done button
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Done'])[21]")).click(); // clicking on done button
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("//li[@data-menuname='generate']")).click(); // Clicking on generate button
	Thread.sleep(10000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text'])[30]")).click(); //Rotate 1
	Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text'])[30]")).click(); //Rotate 2
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("(//span[text()='Save'])[1]")).click();			//Clicking on Save button
	rahul.findElement(By.xpath("(//input[@name='name' and @id='rptName'])[2]")).sendKeys("Test Save Report AUT_EX");	
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Done'])[7]")).click();	
	//Thread.sleep(10000);
	rahul.findElement(By.xpath("(//span[text()='Save As'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//input[@name='name' and @id='rptName'])[2]")).sendKeys("_Save As");
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Done'])[7]")).click();	
	//Thread.sleep(10000);
	rahul.findElement(By.xpath("//li[@data-menuname='backButton']")).click();
	
	
	//WebDriverWait w4=new WebDriverWait(rahul,50);
	//w4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='NewReportlist']")));

	Thread.sleep(15000); 	//This need to be given to let page to load properly

File src23=rahul.getScreenshotAs(OutputType.FILE);
File dst23=new File("D:\\SE_Screenshots\\23_New Report Creation is Successful.png");
FileUtils.copyFile(src23,dst23);
	System.out.println("New Report Creation Process is Successful");
et.log(LogStatus.PASS, "New Report Creation Process is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\23_New Report Creation is Successful.png"));
	
	
//Deleting Report///////
	
	rahul.findElement(By.xpath("//span[text()='Test Save Report AUT_EX']/ancestor::li/descendant::span[@class='checkstyle']")).click();
	Thread.sleep(2000);
	rahul.findElement(By.xpath("//span[text()='Test Save Report AUT_EX_Save As']/ancestor::li/descendant::span[@class='checkstyle']")).click();
	///////
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@data-menuname='reportAction']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='Yes'])[1]")).click();
	//Thread.sleep(4000);
		
	//findElement is not working in this scenerio so used WebDriverWait
	
WebDriverWait w26=new WebDriverWait(rahul,100);
w26.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Report(s) deleted successfully.']")));

	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='OK'])[2]")).click();

	Thread.sleep(4000);
et.log(LogStatus.PASS,"Report Deleted Successful");

	rahul.findElement(By.xpath("//li[@data-menuname='Home']")).click();
	Thread.sleep(15000);			

		// Opening a existing report
		///////
	rahul.findElement(By.xpath("//div[@class='rpt-thumbnails lg-tile' and @tile-id='1']")).click();//opening User Access Tile
		//////
		//Thread.sleep(5000);	
			
WebDriverWait w27=new WebDriverWait(rahul,50);
w27.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='NewReportlist']")));
	Thread.sleep(4000);			
	rahul.findElement(By.xpath("//*[text()='Automation Reports']")).click();
	rahul.findElement(By.xpath("(//*[@id='473'])[1]")).click();
	Thread.sleep(15000);
File src24=rahul.getScreenshotAs(OutputType.FILE);
File dst24=new File("D:\\SE_Screenshots\\24_Opening Existing Report is Successful.png");
FileUtils.copyFile(src24,dst24);
	System.out.println("Opening Existing Report is Successful");
et.log(LogStatus.PASS, "Opening Existing Report is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\24_Opening Existing Report is Successful.png"));


//Exporting the report

	rahul.findElement(By.xpath("// li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
File src25=rahul.getScreenshotAs(OutputType.FILE);
File dst25=new File("D:\\SE_Screenshots\\25_Exporting Report is Successful.png");
FileUtils.copyFile(src25,dst25);
	System.out.println("Exporting Report is Successful");
	rahul.findElement(By.xpath("//li[@id='result-view_export' and @class='report-Action']")).click();
				
	Thread.sleep(5000);
et.log(LogStatus.PASS, "Report Exported Successfully");
	
	//unable to insert conditional wait since there is no element to find
	//WebDriverWait w28=new WebDriverWait(rahul,50);
	//w28.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Rotate']")));
			

//Applying Top Criteria	
	rahul.findElement(By.xpath("// li[@id='result-view_Options']")).click();
	rahul.findElement(By.xpath("//li[@id='result-view_topcriteria' and @class='report-Action']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//input[@id='topValue']")).clear();
	rahul.findElement(By.xpath("//input[@id='topValue']")).sendKeys("5");
	//Thread.sleep(2000);	
	rahul.findElement(By.xpath("((//div[@class='ui-grid-a ui-align-cstmbtn'])[3]/descendant::*)[13]")).click();	
	//Thread.sleep(4000);	
	//WebDriverWait w29=new WebDriverWait(rahul,50);
	//w29.until(ExpectedConditions.


//Generate button

	rahul.findElement(By.xpath("(//*[text()='Generate'][@data-bind='text: $data.text']) [last()-1]")).click();
	Thread.sleep(9000);
File src26=rahul.getScreenshotAs(OutputType.FILE);
File dst26=new File("D:\\SE_Screenshots\\25_Applying Top Criteria is Successful.png");
FileUtils.copyFile(src26,dst26);
	System.out.println("Applying Top Criteria is Successful");
et.log(LogStatus.PASS, "Applying Top Criteria is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\25_Applying Top Criteria is Successful.png"));
					
	//unable to use WebDriverWait due to improper xpath
	//WebDriverWait w30=new WebDriverWait(rahul,50);
	//w30.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Rotate']")));

File src27=rahul.getScreenshotAs(OutputType.FILE);
File dst27=new File("D:\\SE_Screenshots\\27_Report Generation is Successful.png");
FileUtils.copyFile(src27,dst27);
	System.out.println("Report Generation is Successful");


// Creating new custom metric
				
	rahul.findElement(By.xpath("// li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_addCustomColumn'] [@class='report-Action']")).click();
	//Thread.sleep(5000);	
	rahul.findElement(By.xpath("//input[@class='customexp-popup-input02 customexp-popup-input03 txtcustomExpColumnName ui-input-text ui-body-e ui-corner-all ui-shadow-inset']")).sendKeys("Test_CustMet_Aut_EX");
			//////	
Select drp_ChooseMetric_EX =new Select(rahul.findElement(By.xpath("(//select[@class='customexp-popup-select customMetricOption']) [last()-2]")));
drp_ChooseMetric_EX.selectByVisibleText("$ Volume-52W-CY");
			//////	
Select drp_ChooseDataType_EX =new Select(rahul.findElement(By.xpath("(//*[@class='customexp-popup-select customMetricDataType'])[last()-2]")));
drp_ChooseDataType_EX.selectByVisibleText("Numeric");
				
Select drp_Choose_Precesion_EX =new Select(rahul.findElement(By.xpath("(//*[@class='customexp-popup-select customMetricPrecision'])[last()-2]")));
drp_Choose_Precesion_EX.selectByVisibleText("2 Decimal");
				
	rahul.findElement(By.xpath("//*[@class='custom-functions ui-link'][contains(text(),'Sum')]")).click();
	rahul.findElement(By.xpath("(//a[text()='+'][@class='ui-link'])[1]")).click();
	rahul.findElement(By.xpath("(//a[text()='1'][@class='ui-link'])[1]")).click();
	//Thread.sleep(2000);	
	rahul.findElement(By.xpath("(//*[@class='customexp-popup-buttons']/descendant::span[@class='ui-btn-inner']/child::*)[2]")).click();
	///////
WebDriverWait w31=new WebDriverWait(rahul,50);
w31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Test_CustMet_Aut_EX']")));
	///////

File src28=rahul.getScreenshotAs(OutputType.FILE);
File dst28=new File("D:\\SE_Screenshots\\28_New Custom Metric Creation is Successful.png");
FileUtils.copyFile(src28,dst28);
	System.out.println("New Custom Metric Creation is Successful");
et.log(LogStatus.PASS, "New Custom Metric Creation is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\28_New Custom Metric Creation is Successful.png"));
						
								
// Linking a Report	
				
	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click(); 
	Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[contains(text(),'Link Reports')])[1]")).click();
	Thread.sleep(5000);
	rahul.findElement(By.xpath("(//a[@class='report-link ui-link'])[1]")).click();
	Thread.sleep(5000); //This need to be maintained since there is a minute page loading going on

	rahul.findElement(By.xpath("//span[@class='ui-btn-text' and contains(text(),'Reports')]//parent::span[@class='ui-btn-text']")).click();
	rahul.findElement(By.xpath("//span[@class='ui-btn-text' and contains(text(),'Explore Clif Bar')]//parent::span[@class='ui-btn-text']")).click();
	rahul.findElement(By.xpath("//*[text()='Automation Reports']")).click();  
	rahul.findElement(By.xpath("(//*[text()='Report 2_CRD_AUT'])[2]")).click();
	rahul.findElement(By.xpath("((//div[@class='ui-grid-c btnBarHeight'])[18]//descendant::*)[10]")).click();
	Thread.sleep(3000);  //Need to wait till the page is loaded
	rahul.findElement(By.xpath("(//table[@id='grid_table']/tbody/tr/td)[2]/a")).click();  // Need to change the report click value as per portal
	//Thread.sleep(8000);
	// To handle xpath after good number of trails
	//	int ok_size=driver.findElements(By.xpath("//button[text()='OK']")).size();
	//driver.findElements(By.xpath("//button[text()='OK']")).get(ok_size-1).click();
WebDriverWait w32=new WebDriverWait(rahul,50);
w32.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h3[text()='Do you want to save changes you made to Report ?'])[1]")));
rahul.findElement(By.xpath("(//span[@class='ui-btn-inner ui-btn-corner-all']/child::span[@class='ui-btn-text' and text()='No'])[8]")).click(); //earlier index was 8 but now changed to 7
	Thread.sleep(15000); // Need to wait till the page is loaded..
//WebDriverWait w33=new WebDriverWait(rahul,50);
//w33.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Rotate']")));
File src29=rahul.getScreenshotAs(OutputType.FILE);
File dst29=new File("D:\\SE_Screenshots\\29_Linking Report is Successful.png");
FileUtils.copyFile(src29,dst29);
	System.out.println("Linking Report is Successful");
et.log(LogStatus.PASS, "Linking Report is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\29_Linking Report is Successful.png"));

	rahul.findElement(By.xpath("//li[@data-menuname='backButton']")).click();
	//Thread.sleep(9000);

WebDriverWait w34=new WebDriverWait(rahul,50);
w34.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Explore Clif Bar'])[2]")));
	Thread.sleep(3000);

// CREATING NEW CUSTOM VALUE

	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_addCustomValue']/child::span[contains(text(),'New Custom Value')]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//input[@class='customexp-popup-input02 customexp-popup-input03 customValueName ui-input-text ui-body-e ui-corner-all ui-shadow-inset']")).sendKeys("Test_CustomValue_Aut_EX");
Select drp_newCustomValue_EX =new Select(rahul.findElement(By.xpath("(//select[@class='customexp-popup-select customDimensionOption'])[1]")));
drp_newCustomValue_EX.selectByValue("PRODUCT");	
Select drp_newCustomValue_ChooseAttributes_EX =new Select(rahul.findElement(By.xpath("(//select[@class='customexp-popup-select customAttrOption'])[1]")));
drp_newCustomValue_ChooseAttributes_EX.selectByValue("CLIF BAR");
	rahul.findElement(By.xpath("(//a[@class='ui-link'] [@href='#']/child::span[contains(text(),'*')])[2]")).click();
	rahul.findElement(By.xpath("(//a[@class='ui-link' and contains(text(),'1')])[2]")).click();
	rahul.findElement(By.xpath("(//a[@class='ui-link' and contains(text(),'0')])[2]")).click();
	rahul.findElement(By.xpath("(//a[@class='ui-link' and contains(text(),'0')])[2]")).click();
	
File src30=rahul.getScreenshotAs(OutputType.FILE);
File dst30=new File("D:\\SE_Screenshots\\30_New Custom Value Creation is Successful_EX.png");
FileUtils.copyFile(src30,dst30);
	System.out.println("New Custom Value Creation is Successful");	
et.log(LogStatus.PASS, "New Custom Value Creation is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\30_New Custom Value Creation is Successful_EX.png"));
			
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-inner']/child::span[@class='ui-btn-text' and text()='Done'])[9]")).click();
	//Thread.sleep(6000);

	
// ADDING FOOT NOTE
	
	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_addFootNote']/child::span[contains(text(),'Add Foot Note')]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//input[@name='footNoteText'])[1]")).sendKeys("Test_FootNote_AUT");
	rahul.findElement(By.xpath("(//span[@class='ui-btn-inner']/child::span[@class='ui-btn-text'])[36]")).click();
	Thread.sleep(3000);	
File src31=rahul.getScreenshotAs(OutputType.FILE);
File dst31=new File("D:\\SE_Screenshots\\31_Adding Foot Note is Successful_EX.png");
FileUtils.copyFile(src31,dst31);
	System.out.println("Adding Foot Note is Successful");
et.log(LogStatus.PASS, "Adding Foot Note is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\31_Adding Foot Note is Successful_EX.png"));


//	Checking the Tabular View 

	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("//li[@id='result-view_tabularView']/span [contains(text(),'Tabular View')]")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[contains(text(),'Product')])[5]")).click();  //earlier text was Report Dimension, may be changed due to build fix
	//Thread.sleep(5000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-inner ui-btn-corner-all']/child::span[@class='ui-btn-text' and text()='Done'])[7]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//li[@id='result-view_generate']")).click();

	Thread.sleep(8000); // //Need to wait till the page is loaded for report generation
File src32=rahul.getScreenshotAs(OutputType.FILE);
File dst32=new File("D:\\SE_Screenshots\\32_Applying Tabular View is Successful.png");
FileUtils.copyFile(src32,dst32);
	System.out.println("Applying Tabular View is Successful");
et.log(LogStatus.PASS, "Applying Tabular View is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\32_Applying Tabular View is Successful.png"));
	
// ROW COLUMN FUNCTIONS

	//Thread.sleep(10000);
	rahul.findElement(By.xpath("//li[@id='result-view_Options']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[contains(text(),'Row/Column Functions')])[1]")).click();
	//Thread.sleep(8000); 
	rahul.findElement(By.xpath("(//span[@id='customFunctionName' and contains(text(),'Sum')]/following::span[@class='checkstyle'])[2]")).click();
	//Thread.sleep(10000);
	rahul.findElement(By.xpath("(//span[@class='ui-btn-inner ui-btn-corner-all']/child::span[@class='ui-btn-text' and text()='Done'])[8]")).click();
	
	Thread.sleep(3000);	
File src33=rahul.getScreenshotAs(OutputType.FILE);
File dst33=new File("D:\\SE_Screenshots\\33_Implementing Row_Column Function is Successful.png");
FileUtils.copyFile(src33,dst33);
	System.out.println("Implementing Row/Column Function is Successful");
et.log(LogStatus.PASS, "Implementing Row/Column Function is Successful");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\33_Implementing Row_Column Function is Successful.png"));
		

//Charts validation
	System.out.println("");
	System.out.println("Charts Applied:-");
	
//Horizontal Bar Chart
	
	//Thread.sleep(10000);
	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//span[text()='Choose Attributes']/following::a[text()='Brand Family']")).click();	// Need to click on choose attributes as it's in tabular view
	rahul.findElement(By.xpath("(//span[text()='Choose Attributes']/following::span[text()='Done'])[1]")).click();	
		
	Thread.sleep(5000);
File src34=rahul.getScreenshotAs(OutputType.FILE);
File dst34=new File("D:\\SE_Screenshots\\34_Horizontal Bar chart.png");
FileUtils.copyFile(src34,dst34);
	System.out.println("Horizontal Bar Chart");
et.log(LogStatus.PASS, "Horizontal Bar Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\34_Horizontal Bar chart.png"));
		
//Vertical Bar Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Vertical Bar Chart']")).click();
	Thread.sleep(3000);
File src35=rahul.getScreenshotAs(OutputType.FILE);
File dst35=new File("D:\\SE_Screenshots\\35_Vertical Bar chart.png");
FileUtils.copyFile(src35,dst35);
	System.out.println("Vertical Bar Chart");
et.log(LogStatus.PASS, "Vertical Bar Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\35_Vertical Bar chart.png"));
				
//Pie Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Pie Chart']")).click();
	Thread.sleep(3000);
File src36=rahul.getScreenshotAs(OutputType.FILE);
File dst36=new File("D:\\SE_Screenshots\\36_Pie Chart.png");
FileUtils.copyFile(src36,dst36);	
	System.out.println("Pie Chart");
et.log(LogStatus.PASS, "Pie Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\36_Pie Chart.png"));
					
//Tree Map Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='TreeMap Chart']")).click();
	Thread.sleep(3000);
File src37=rahul.getScreenshotAs(OutputType.FILE);
File dst37=new File("D:\\SE_Screenshots\\37_Tree Map Chart.png");
FileUtils.copyFile(src37,dst37);	
	System.out.println("Tree Map Chart");
et.log(LogStatus.PASS, "Tree Map Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\37_Tree Map Chart.png"));
						
		
//Stacked Area Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Stacked Area Chart']")).click();
	Thread.sleep(3000);
File src38=rahul.getScreenshotAs(OutputType.FILE);
File dst38=new File("D:\\SE_Screenshots\\38_Stacked Area Chart.png");
FileUtils.copyFile(src38,dst38);		
	System.out.println("Stacked Area Chart");
et.log(LogStatus.PASS, "Stacked Area Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\38_Stacked Area Chart.png"));	

//Funnel Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Funnel Chart']")).click();
	Thread.sleep(3000);
File src39=rahul.getScreenshotAs(OutputType.FILE);
File dst39=new File("D:\\SE_Screenshots\\39_Funnel chart.png");
FileUtils.copyFile(src39,dst39);	
	System.out.println("Funnel Chart");
et.log(LogStatus.PASS, "Funnel Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\39_Funnel chart.png"));			
			
//Horizontal Target Bar Chart

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Horizontal Target Bar Chart']")).click();
	//Thread.sleep(3000);
///////		
Select drp_SourceItem_TargetChartProp_EX= new Select(rahul.findElement(By.xpath("//select[@id='currentMetric']")));
drp_SourceItem_TargetChartProp_EX.selectByVisibleText("$ Volume-52W-CY");
///////		
Select drp_TargetItem_TargetChartProp_EX= new Select(rahul.findElement(By.xpath("//select[@id='targetMetric']")));
drp_TargetItem_TargetChartProp_EX.selectByVisibleText("Test_CustMet_Aut");
		
	rahul.findElement(By.xpath("(//span[text()=' Target Bar Chart Properties']/following::div[@data-role='fieldcontain']/descendant::span[text()='Done'])[1]")).click();
	Thread.sleep(3000);
File src40=rahul.getScreenshotAs(OutputType.FILE);
File dst40=new File("D:\\SE_Screenshots\\40_Horizontal Target Bar Chart.png");
FileUtils.copyFile(src40,dst40);	
	Thread.sleep(5000);
	System.out.println("Horizontal Target Bar Chart");
et.log(LogStatus.PASS, "Horizontal Target Bar Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\40_Horizontal Target Bar Chart.png"));			
			
			
//Vertical Target Bar Chart
		
	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Vertical Target Bar Chart']")).click();
	Thread.sleep(3000);
File src41=rahul.getScreenshotAs(OutputType.FILE);
File dst41=new File("D:\\SE_Screenshots\\41_Vertical Target Bar Chart.png");
FileUtils.copyFile(src41,dst41);	
	//Thread.sleep(5000);
	System.out.println("Vertical Target Bar Chart");	
et.log(LogStatus.PASS, "Vertical Target Bar Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\41_Vertical Target Bar Chart.png"));			
					
	

//Mixed Line Chart	
	
	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Mixed Line-Bar Chart']")).click();
	//Thread.sleep(3000);
	///////		
Select drp_LineScale_EX=new Select(rahul.findElement(By.xpath("//select[@id='line-scale']")));
drp_LineScale_EX.selectByVisibleText("$ Volume-52W-CY");
	///////
	//Thread.sleep(2000);
		
Select drp_BarScale_EX=new Select(rahul.findElement(By.xpath("//select[@id='bar-scale']")));
drp_BarScale_EX.selectByVisibleText("Test_CustMet_Aut");
	//Thread.sleep(2000);
	//rahul.findElement(By.xpath("(//input[@name='checkbox-useSameScale'])[2]/preceding::span[@class='ui-icon ui-icon-shadow ui-icon-checkbox-off']")).click();
	//Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[text()=' Mixed Line-Bar Chart Properties']/following::span[text()='Done'])[1]")).click(); //Earlier its index was 1 but now changed to 8//Now again need to reset it to 1
	Thread.sleep(3000);
File src42=rahul.getScreenshotAs(OutputType.FILE);
File dst42=new File("D:\\SE_Screenshots\\42_Mixed Line Chart.png");
FileUtils.copyFile(src42,dst42);	
	System.out.println("Mixed Line Chart");			
et.log(LogStatus.PASS, "Mixed Line Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\42_Mixed Line Chart.png"));			
			

//Tile Chart	

	rahul.findElement(By.xpath("//li[@class='ui-ir-icon-panelchart ui-desktopIcons report-Action']/descendant::span[@data-bind='text: $data.text' and text()='Chart']")).click(); //clicking on chart option
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Change Chart Type'])[1]")).click();
	//Thread.sleep(3000);
	rahul.findElement(By.xpath("//a[text()='Tile Chart']")).click();
	//Thread.sleep(3000);	
	////////		
Select drp_tileCurrentMetric_EX=new Select(rahul.findElement(By.xpath("//select[@id='tileCurrentMetric']")));
drp_tileCurrentMetric_EX.selectByVisibleText("$ Volume-52W-CY");
	////////
	//Thread.sleep(2000);
		
Select drp_tileTargetMetric_EX =new Select(rahul.findElement(By.xpath("//select[@id='tileTargetMetric']")));
drp_tileTargetMetric_EX.selectByVisibleText("Test_CustMet_Aut");
	//Thread.sleep(2000);
		
	rahul.findElement(By.xpath("(//span[text()=' Tile Chart Properties']/following::span[text()='Done'])[1]")).click();
	Thread.sleep(3000);
File src43=rahul.getScreenshotAs(OutputType.FILE);
File dst43=new File("D:\\SE_Screenshots\\43_Tile Chart.png");
FileUtils.copyFile(src43,dst43);	
	System.out.println("Tile Chart");			
et.log(LogStatus.PASS, "Tile Chart");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\43_Tile Chart.png"));			
	System.out.println("All Charts are completed");

	Thread.sleep(3000);

// Adding Reports to Dashboard
	rahul.findElement(By.xpath("(//span[text()='Home'])[1]")).click();			//clicking on Home button
WebDriverWait w35=new WebDriverWait(rahul,50);
w35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Save Confirm'])[5]")));

	rahul.findElement(By.xpath("(//span[@class='ui-btn-text' and text()='No'])[16]")).click();			//clicking on 'No' button while saving
	rahul.findElement(By.xpath("//div[@tile-id='Dashboard-Tile']")).click();
	Thread.sleep(5000);

	rahul.findElement(By.xpath("(//span[text()='Dashboard Actions'])[1]")).click();
	rahul.findElement(By.xpath("(//span[text()='New Dashboard'])[1]")).click();	
	Thread.sleep(2000);
	rahul.findElement(By.xpath("(//span[text()='Add Report'])[1]")).click();
	Thread.sleep(5000);	
	rahul.findElement(By.xpath("//span[@class='dashboard-report-searchicon']")).click();
	rahul.findElement(By.xpath("//input[@id='myFilter']")).sendKeys("Report Access Count_crd",Keys.ENTER);

Actions a1=new Actions(rahul);
WebElement drag1=rahul.findElement(By.xpath("//a[text()='Report Access Count_crd']"));
WebElement drop1= rahul.findElement(By.xpath("//div[@id='dashboard-content']/div[@id='cell_R0C0']"));
a1.dragAndDrop(drag1,drop1).build().perform();
	Thread.sleep(5000);
	rahul.findElement(By.xpath("(//div[@class='dashboard-widget-menu-icon'])[1]/div")).click();
	rahul.findElement(By.xpath("(//li[@data-actionvalue='editReport'])[1]")).click();
	//MOVING DOWN
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[1]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[1]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[1]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[1]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[1]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[1]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[1]")).click();

	//MOVING RIGHT
	rahul.findElement(By.xpath("(//div[@class='ui-right-handler-out'])[1]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-right-handler-out'])[1]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-right-handler-out'])[1]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-right-handler-out'])[1]")).click();


	//ADDING ANOTHER REPORT TO DASHBOARD
	rahul.findElement(By.xpath("(//span[text()='Add Report'])[1]")).click();

Actions a2=new Actions(rahul);
WebElement drag2=rahul.findElement(By.xpath("//a[text()='Test_Report Access Count_crd']"));
WebElement drop2= rahul.findElement(By.xpath("//div[@id='dashboard-content']/div[@id='cell_R0C6']"));
a2.dragAndDrop(drag2, drop2).build().perform();
	Thread.sleep(5000);
	rahul.findElement(By.xpath("//div[@id='dvReportsPanel']/descendant::span[@class='lm-ui-reports-panel-close']")).click();
	rahul.findElement(By.xpath("(//div[@class='dashboard-widget-menu-icon'])[2]")).click();
	rahul.findElement(By.xpath("(//li[@data-actionvalue='editReport'])[2]")).click();

	//MOVING RIGHT
	rahul.findElement(By.xpath("(//div[@class='ui-right-handler-out'])[2]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-right-handler-out'])[2]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-right-handler-out'])[2]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-right-handler-out'])[2]")).click();	
	//MOVING DOWN
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[2]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[2]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[2]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[2]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[2]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[2]")).click();
	rahul.findElement(By.xpath("(//div[@class='ui-bottom-handler-out'])[2]")).click();		
	Thread.sleep(3000);	
	System.out.println("Reports added to Dashboard");
File src44=rahul.getScreenshotAs(OutputType.FILE);
File dst44=new File("D:\\SE_Screenshots\\44_Reports added to dashboard.png");
FileUtils.copyFile(src44,dst44);	
et.log(LogStatus.PASS, "Reports added to Dashboard");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\44_Reports added to dashboard.png"));

	// Save Report	
	rahul.findElement(By.xpath("(//div[@class='ui-desktopMenu'])[2]/descendant::span[text()='Save']")).click();
	rahul.findElement(By.xpath("(//*[@name='name' and @id='rptName'])[1]")).sendKeys("Dashboard_1 TEST-AUT");
	rahul.findElement(By.xpath("//a[@data-bind='click:saveDashboardWithConfirm']")).click();
et.log(LogStatus.PASS, "Save report");

WebDriverWait w36=new WebDriverWait(rahul,100);
w36.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Home'])[1]")));

	// Save As Report
	rahul.findElement(By.xpath("(//div[@class='ui-desktopMenu'])/descendant::span[text()='Save As']")).click();
	rahul.findElement(By.xpath("(//*[@name='name' and @id='rptName'])[1]")).clear();
	rahul.findElement(By.xpath("(//*[@name='name' and @id='rptName'])[1]")).sendKeys("Dashboard_2 TEST-AUT");
	rahul.findElement(By.xpath("//a[@data-bind='click:saveDashboardWithConfirm']")).click();
WebDriverWait w37=new WebDriverWait(rahul,100);
w37.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Home'])[1]")));
et.log(LogStatus.PASS, "Save As Report");

	// Storyboard creation

	rahul.findElement(By.xpath("(//span[text()='Dashboards'])[1]")).click();
	Thread.sleep(2000);		
	rahul.findElement(By.xpath("(//span[text()='Storyboard Actions'])[1]")).click();
	rahul.findElement(By.xpath("((//span[text()='Storyboard Actions'])[1]/following::span[text()='New'])[1]")).click();
	rahul.findElement(By.xpath("//input[@id='txtStoryName']")).sendKeys("Storyboard_TEST-AUT");
	rahul.findElement(By.xpath("(//span[text()='Save Storyboard']/following::span[text()='Done'])[1]")).click();
	Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Dashboard_1 TEST-AUT']/preceding::span[@class='checkstyle'])[last()]")).click();
	rahul.findElement(By.xpath("(//span[text()='Dashboard_2 TEST-AUT']/preceding::span[@class='checkstyle'])[last()]")).click();
	rahul.findElement(By.xpath("(//span[text()='Dashboard Actions'])[1]")).click();
	rahul.findElement(By.xpath("(//span[text()='Move To Storyboard'])[1]")).click();
Select drp_storyboard=new Select(rahul.findElement(By.xpath("//select[@id='select-StoryName']")));
drp_storyboard.selectByVisibleText("Storyboard_TEST-AUT");
rahul.findElement(By.xpath("(//span[text()='Select Storyboard']/following::span[text()='Done'])[1]")).click();
	Thread.sleep(3000);	

	rahul.findElement(By.xpath("(//span[text()='Home'])[1]")).click();
	Thread.sleep(5000);			
	rahul.findElement(By.xpath("(//span[text()='Storyboard_TEST-AUT'])")).click();
	Thread.sleep(5000);	
	rahul.findElement(By.xpath("(//span[text()='Options'])[1]")).click();
	rahul.findElement(By.xpath("(//span[text()='Add Dashboards to Powerpoint'])[1]")).click();
	rahul.findElement(By.xpath("(//span[text()='Add Dashboards to Powerpoint'])[3]/following::span[text()='Select All']")).click();
	rahul.findElement(By.xpath("(//span[text()='Add Dashboards to Powerpoint'])[3]/following::span[text()='Done']")).click();
WebDriverWait w38=new WebDriverWait(rahul,100);
w38.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Selected Dashboard(s) added to PPT successfully.']")));
	rahul.findElement(By.xpath("//*[text()='Selected Dashboard(s) added to PPT successfully.']/following::span[text()='OK']")).click();
	System.out.println("Dashboards added to Storyboard");
File src45=rahul.getScreenshotAs(OutputType.FILE);
File dst45=new File("D:\\SE_Screenshots\\45_Dashboards added to Storyboard.png");
FileUtils.copyFile(src45,dst45);	
et.log(LogStatus.PASS, "Dashboards added to Storyboard");
et.log(LogStatus.PASS, et.addScreenCapture("D:\\SE_Screenshots\\45_Dashboards added to Storyboard.png"));

	rahul.findElement(By.xpath("(//span[text()='Options'])[1]")).click();
	rahul.findElement(By.xpath("(//span[text()='View Powerpoint Images'])[1]")).click();
	rahul.findElement(By.xpath("(//span[text()='Export to PPT'])[1]")).click();
et.log(LogStatus.PASS, "Export to PPT is done");
	Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Home'])[1]")).click();			//clicking on Home button
	rahul.findElement(By.xpath("//div[@tile-id='Dashboard-Tile']")).click();
WebDriverWait w39=new WebDriverWait(rahul,100);
w39.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Storyboard_TEST-AUT'])[2]")));
	Thread.sleep(6000);
Actions a3=new Actions(rahul);
WebElement a=rahul.findElement(By.xpath("(//span[text()='Storyboard_TEST-AUT']/preceding::span[@class='checkstyle'])[last()]"));
a3.click(a).build().perform();
	//rahul.findElement(By.xpath("(//span[text()='Storyboard_TEST-AUT']/preceding::span[@class='checkstyle'])[last()]")).click();
	Thread.sleep(3000);
	rahul.findElement(By.xpath("(//span[text()='Storyboard Actions'])[1]")).click();
	rahul.findElement(By.xpath("((//span[text()='Storyboard Actions'])[1]/following::span[text()='Delete'])[1]")).click();
	rahul.findElement(By.xpath("((//span[text()='Delete Storyboard(s)']/following::h3[text()='Are you sure, you want to delete selected Storyboard(s)?'])[1]/following::span[text()='Yes'])[1]")).click();
	Thread.sleep(8200);
	System.out.println("Storyboard Deleted Successfully");
et.log(LogStatus.PASS, "Storyboard Deleted Successfully");
	rahul.findElement(By.xpath("(//span[text()='Home'])[1]")).click();	
	Thread.sleep(3000);
	rahul.findElement(By.xpath("//span[@class='ui-person']")).click();
	rahul.findElement(By.xpath("//a[text()='Logout']")).click();
	et.log(LogStatus.PASS, "Logged out Successfully");
	System.out.println("Rahul Congrats!!! Automation Process Phase-II is Successfully compleated");			
et.log(LogStatus.PASS, "Automation Process Phase-II is successfully completed");

er.endTest(et);
er.flush();
System.exit(0);
}		//Try block ended


	catch(Exception e)
		{
		er.endTest(et);
		er.flush();
		System.out.println(e);
		System.exit(0);
		}


	}

}
