package Ebanking.utilities;


// Listener class used to generate extend reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onstart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //Time Stamp
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/test-output/"+repName));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Enviornment","QA");
		extent.setSystemInfo("user","Rahul");
		extent.setSystemInfo("Browser", "browser");

		
		htmlReporter.config().setDocumentTitle("Ebanking Test Project"); // Tile of report
		htmlReporter.config().setReportName("Automation Report"); // Name of the report
		//htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName()); //Create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName()+" PASSED ",ExtentColor.GREEN));

	}
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //Create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName()+" FAILED ",ExtentColor.RED));
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName() +".png";

		File f =new File(screenshotPath);

		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public void onTestSKipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //Create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName()+" SKIPPED ",ExtentColor.ORANGE));

	}
	public void onFinish(ITestResult testContext)
	{
		extent.flush();
	}
}



