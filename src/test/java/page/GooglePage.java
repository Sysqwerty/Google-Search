package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage {
  @FindBy(xpath = "//input[@name='q']")
  private WebElement searchField;

  public GooglePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public ResultsPage search(String searchTerm) {
    searchField.sendKeys(searchTerm);
    searchField.sendKeys(Keys.ENTER);
    return new ResultsPage(driver);
  }

  @Override
  public boolean isPageLoaded() {
    return searchField.isDisplayed();
  }
}
