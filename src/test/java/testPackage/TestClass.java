package testPackage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagesPackage.LoanCalculatorPage;

public class TestClass extends BaseClass{
	
	/*Both user stories have 6 test cases each for different combinations of Interest rate and duration.
	Please refer to the TestData_AutoCalc.xlsx file to see the test case combination*/
	
	
	@Test(description = "Test to validate price reminder when no price is entered", priority = 0)
	public void UserStory1() throws HeadlessException, AWTException, IOException
	{		
		testLog.log(Status.INFO, "NoPrice test started");
		
		//Initiate and validate Calculate Home Page
		LoanCalculatorPage loan_cal = new LoanCalculatorPage();		
		loan_cal.validateCalHomePage();
		testLog.log(Status.INFO, "Loan calculator page launched");
		
		//Tester can choose which test case to execute by simply passing the test case ID from TestData_AutoCalc.xlsx  
		int testCaseID = 1;
		
		//Validate the error message when no amount is input		
		loan_cal.validateNoPrice(testCaseID);
	}
	
	
	@Test(description = "Test to validate the EMI feature with different tenure and interest rate", priority = 0)
	public void UserStory2() throws HeadlessException, AWTException, IOException
	{		
		testLog.log(Status.INFO, "EMI test started");
		
		//Initiate and validate Calculate Home Page
		LoanCalculatorPage loan_cal = new LoanCalculatorPage();
		loan_cal.validateCalHomePage();
		testLog.log(Status.INFO, "Loan calculator page launched");

		//Tester can choose which test case to execute by simply providing the test case ID in GetEMIWithDefferData 
		int testCaseID = 3;
		
		//Enter the values in calculator and validate output
		loan_cal.ValidateDetails(loan_cal.GetEMIWithDefferData(testCaseID));
	}
}
