package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.GooglePage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
  protected WebDriver driver;
  GooglePage googlePage;

  @BeforeMethod
  void beforeMethod() {
    WebDriverManager.chromedriver().setup();

    //set default browser locale
    ChromeOptions options = new ChromeOptions();
    DesiredCapabilities jsCapabilities = DesiredCapabilities.chrome();
    Map<String, Object> prefs = new HashMap<String, Object>();
    prefs.put("intl.accept_languages", "en");
    options.setExperimentalOption("prefs", prefs);
    jsCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

    // initialize WebDriver
    driver = new ChromeDriver(options);

    // setup config
    driver.get("https://www.google.com");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   // set WebDriver implicitly wait()

    // open start page
    googlePage = new GooglePage(driver);
  }

  @AfterMethod
  void afterMethod() {
    driver.quit();
  }
}
