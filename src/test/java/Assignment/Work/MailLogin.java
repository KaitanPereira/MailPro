package Assignment.Work;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MailLogin extends ClassBase {
	
	By signBtn = By.cssSelector("a[class='btn btn-ghost btn-short']");
	By Username = By.id("username");
	By Password = By.id("password");
	By Submit = By.cssSelector("button[class='button button-large button-solid-norm w100 mt1-75']");
	By NewMail = By.cssSelector("button[class='button button-large button-solid-norm text-bold mt0-25 w100 no-mobile']");
	By ToMail = By.cssSelector("input[placeholder='Email address']");
	By MailSubject = By.cssSelector("input[placeholder='Subject']");
	By Iframe = By.cssSelector("iframe[class='w100 h100 squireIframe']");
	By Body = By.id("squire");

		@Test
		public void SenderLogin() throws InterruptedException, AWTException, IOException{
			
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));

			driver.findElement(signBtn).click();
			driver.findElement(Username).sendKeys("there9082@protonmail.com");
			driver.findElement(Password).sendKeys("Always@101");

			driver.findElement(Submit).click();
			driver.findElement(NewMail).click();
			driver.findElement(ToMail).sendKeys("AlwaysProton111@protonmail.com");
			driver.findElement(MailSubject).sendKeys("Sending you a word file");

			driver.switchTo().frame(driver.findElement(Iframe));
			driver.findElement(Body).sendKeys("Please find the word document below in this email, if any queries please reply back to this email");

			driver.switchTo().defaultContent();
			
			driver.findElement(By.cssSelector("label[class='button button-for-icon button-outline-weak inline-block text-center inline-flex']"));
			fileupload();
			System.out.println("File Uploaded Successfully");

			driver.findElement(By.cssSelector("span[class='pl1 pr1 no-mobile']")).click();
		}

		public WebElement fileupload() throws InterruptedException, AWTException {

			WebElement file = driver.findElement(By.cssSelector("label[class='button button-for-icon button-outline-weak inline-block text-center inline-flex']"));

			file.click();
			Thread.sleep(2000);
			Robot rb = new Robot();

			StringSelection str = new StringSelection("C:\\Users\\kaitan.pereira\\Desktop\\Test.docx");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			return file;

		}



		@AfterTest
		public void closebrowser() {
		driver.findElement(By.cssSelector("span[class='mtauto mbauto center']")).click();
			driver.findElement(By.cssSelector("button[class='button button-solid-norm w100 flex flex-justify-center flex-align-items-center']")).click();
		driver.close();
		}
	}


	
