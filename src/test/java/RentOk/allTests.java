package RentOk;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class allTests extends CAPABLEs {

	AndroidDriver<AndroidElement> driver;
	ExtentReports reports;
	ExtentTest test;
	String email = "testhirakprop@gmail.com";
	String password = "abcd1234";
	String[] Unames = {"a","testhirakprop@gmail.com","c","","","testhirakprop@gmail.com","!@#$%^&*","testhirakprop@gmail.com","testhirakprop@gmail.com"}; // add uname with spaces at starting and end
	String[] Pass = {"abcd1234","abcdefgh","abcdefgh","","abcd1234","","abcd1234","!@#$%^&*","abcd1234"}; // add pass with spaces at starting and end
	String[] otpplace1 = {"1","7","0","1","a","@",""};
	String[] otpplace2 = {"2","8","0","1","b","!",""};
	String[] otpplace3 = {"3","9","0","1","c","#",""};
	String[] otpplace4 = {"4","0","0","1","d","$",""};
	String[] otpplace5 = {"5","1","0","1","e","%",""};
	String[] otpplace6 = {"6","2","0","1","f","&",""};
	String myEmailID = "hirakgoswami7076@gmail.com";
	String[] PhNumbers = {"123456789","12ab34cd56","12@#34#$5&","abcdefghij","@#!$%^&*()","987654321"};
	String[] PhNumber2 = {"1234567890","9876543210","0000000000","1111111111","1010101010","0022003300"};
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		// Initializing all report's location and test's name
		
		reports = new ExtentReports("C:\\Users\\User\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\RentOK\\CWreport.html");
		test = reports.startTest("RentOkTests");
		
		// calling the capabilities from cap method from capabilities class
		
		driver = cap();
		
		// adding implicit wait
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	}
	
	@Test(priority = 0)
	public void LoginLogout() {
		
		test.log(LogStatus.PASS, "Opened the APP Successfully");
		
		driver.findElement(MobileBy.AccessibilityId("Cancel")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")).click();
		driver.findElement(MobileBy.AccessibilityId("Login")).click();
		
		test.log(LogStatus.PASS, "Reached the login section");
		
		for(int i=0;i<Unames.length;i++) {
			
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/emailEditText")).sendKeys(Unames[i]);
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/passwordEditText")).sendKeys(Pass[i]);
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/tv_loginButton")).click();
			
			test.log(LogStatus.PASS, "Email and Password "+i+" Tested");
			
		}
		
		test.log(LogStatus.PASS, "All error messages are showed and no more error");
		
		driver.findElement(MobileBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();	
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"net.eazypg.eazypgmanager:id/iv_icon\").instance(0)")).click();
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Security Settings\"))"));
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(10)")).click();
		String name = driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/tv_email")).getText();
		Assert.assertEquals(name, email);
		
		test.log(LogStatus.PASS, "Checked that after login i am redirented to the expected account not in any other account");
		
		driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/bt_logout")).click();
		driver.findElement(MobileBy.id("android:id/button1")).click();
		
		test.log(LogStatus.PASS, "Loged out Successfully");
		
	}
	
	@Test(priority = 1)
	public void ForgotPassword() {
		
		test.log(LogStatus.PASS, "Checking the forgot Password section");
		
		driver.findElement(MobileBy.AccessibilityId("Cancel")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")).click();
		driver.findElement(MobileBy.AccessibilityId("Login")).click();
		driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/forgotPasswordTextView")).click();
		
		test.log(LogStatus.PASS, "Clicked the forgot password option");
		
		driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/etEmailAddress")).sendKeys(email);
		
		test.log(LogStatus.PASS, "Entered the email");
		
		driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/btnSendOtp")).click();
		
		test.log(LogStatus.PASS, "OTP sent");
		
		test.log(LogStatus.PASS, "Testing the OTP field");
		
		for(int j=0;j<otpplace1.length;j++) {
			
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp1")).sendKeys(otpplace1[j]);
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp2")).sendKeys(otpplace2[j]);
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp3")).sendKeys(otpplace3[j]);
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp4")).sendKeys(otpplace4[j]);
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp5")).sendKeys(otpplace5[j]);
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp6")).sendKeys(otpplace6[j]);
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/btnProceed")).click();
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp1")).clear();
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp2")).clear();
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp3")).clear();
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp4")).clear();
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp5")).clear();
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_otp6")).clear();
			
			test.log(LogStatus.PASS, "OTP "+j+" Tested");
			
		}
		
		test.log(LogStatus.PASS, "OTP testing Done");
		
		driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/ivBack")).click();
		driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/ivBack")).click();
		
	}
	
	@Test(priority = 2)
	public void GoogleLogin() {
		
		test.log(LogStatus.PASS, "Testing the Google Login");
		
		driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/bt_google")).click();
		String emailID = driver.findElement(MobileBy.id("com.google.android.gms:id/account_name")).getText();
		Assert.assertEquals(emailID, myEmailID);
		
		test.log(LogStatus.PASS, "The Device loged in Email is viewed and asking to create account first");
		
		driver.findElement(MobileBy.AccessibilityId("Cancel")).click();
		
	}
	
	@Test(priority = 3)
	public void TeamMemberLogin() {
		
		test.log(LogStatus.PASS, "Testing the Team Member login");
		
		driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/bt_team_login")).click();
		
		test.log(LogStatus.PASS, "Redirected to the first page of the app before login");
		
	}
	
	@Test(priority = 4)
	public void LoginPhoneNo() {
		
		test.log(LogStatus.PASS, "Testing the login with phone number option");
		
		driver.findElement(MobileBy.AccessibilityId("Cancel")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")).click();
		driver.findElement(MobileBy.AccessibilityId("Login")).click();
		driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/bt_phone_login")).click();
		driver.findElement(MobileBy.AccessibilityId("Cancel")).click();
		
		for(int k=0;k<PhNumbers.length;k++) {
			
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_number")).sendKeys(PhNumbers[k]);
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_number")).clear();
			
			test.log(LogStatus.PASS, "Phone number "+k+" Tested");
			
		}
		
		for(int l=0;l<PhNumber2.length;l++) {
			
			test.log(LogStatus.PASS, "Phone number "+((PhNumbers.length+l)-1)+" Tested");
			
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_number")).sendKeys(PhNumber2[l]);
			driver.findElement(MobileBy.AccessibilityId("Sign Up")).click();
			String actualNo = driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/tv_phone")).getText();
			Assert.assertEquals(actualNo, PhNumber2[l]);
			
			test.log(LogStatus.PASS, "Phone number matched with the entered one");
			
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_number")).clear();
			
		}
		
		test.log(LogStatus.PASS, "Phone number testing done");
		
		driver.findElement(MobileBy.id("net.eazypg.eazypgmanager:id/et_number")).sendKeys("7076432958");
		driver.findElement(MobileBy.AccessibilityId("Sign Up")).click();
		
		test.log(LogStatus.PASS, "Successfully tested with the valid Phone Number");
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		test.log(LogStatus.PASS, "Done Testing the login feature");
		
	}
	
	@AfterTest
	public void flush() {
		
		// Flushing the reports generating the reports file
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		reports.flush();
		reports.endTest(test);
		
		// Ending of the tests
		
	}
	
}
