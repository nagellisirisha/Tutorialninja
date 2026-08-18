package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
  public WebDriver driver;
  public Properties p;
  protected Logger logger;
  
  @BeforeClass(groups={"main"})
  @Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
	  logger=LogManager.getLogger(this.getClass());
	  p = new Properties();

      FileInputStream file =
              new FileInputStream("src/test/resources/config.properties");

      p.load(file);
      if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
    	  DesiredCapabilities capabilities = new DesiredCapabilities();
    	  switch(os.toLowerCase()) {
    	  case "windows":capabilities.setPlatform(Platform.WIN11);break;
    	  case "mac": capabilities.setPlatform(Platform.MAC);break;
    	  default : System.out.print("Invalid os");return;
    	  }
    	  switch(br) {
    	  case "chrome":capabilities.setBrowserName("chrome");break;
    	  case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
    	  default : System.out.print("Invalid os");return;
    	  }
    	  driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
      }
      if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
      switch(br) {
      case "edge":driver=new EdgeDriver();break;
      case "chrome":driver=new ChromeDriver();break;
      case "firefox": driver=new FirefoxDriver();break;
      default : System.out.print("Invalid");return;
      }
      }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups={"main"})
	public void teardown() {
		driver.quit();
	}
	public String randomAlpha(int num) {
	    return RandomStringUtils.randomAlphabetic(num);
	}

	public String randomNumber(int num) {
	    return RandomStringUtils.randomNumeric(num);
	}
 }
