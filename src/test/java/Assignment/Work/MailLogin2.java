package Assignment.Work;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;
import java.io.FileInputStream;

public class MailLogin2 extends ClassBase{
	
	By signBtn = By.cssSelector("a[class='btn btn-ghost btn-short']");
	By Username = By.id("username");
	By Password = By.id("password");
	By Submit = By.cssSelector("button[class='button button-large button-solid-norm w100 mt1-75']");

		@Test
		public void ReceiverLogin() throws InterruptedException, FileNotFoundException, IOException{
			
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));

			driver.findElement(signBtn).click();
			driver.findElement(Username).sendKeys("AlwaysProton111@protonmail.com");
			driver.findElement(Password).sendKeys("Always@101");

			driver.findElement(Submit).click();
			Thread.sleep(9000);

			driver.findElement(By.cssSelector("span[class='inline-block max-w100 text-ellipsis']")).click();

			Thread.sleep(5000);
			driver.findElement(By.cssSelector("button[class='inline-flex p0-5 no-pointer-events-children flex-item-noshrink border-left message-attachmentSecondaryAction interactive']")).click();
			Thread.sleep(10000);
			XWPFDocument docx= new XWPFDocument(new FileInputStream("C:\\Users\\kaitan.pereira\\Downloads\\Test.docx"));

			@SuppressWarnings("resource")
			XWPFWordExtractor wt= new XWPFWordExtractor(docx);
			Thread.sleep(6000);
			System.out.println(wt.getText());

		}


		@AfterTest
		public void closebrowser() {
			driver.close();
		}
	}



