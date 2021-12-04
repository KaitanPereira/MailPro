package Assignment.Work;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassBase {
	
	public WebDriver driver;
	public Properties prop;
	
	
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaitan.pereira\\Desktop\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		prop= new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\kaitan.pereira\\eclipse-workspace\\Work\\src\\main\\java\\Assignment\\Work\\data.properties");
		prop.load(fis);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}

