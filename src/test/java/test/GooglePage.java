package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePage;

public class GooglePage extends BasePage {
  @FindBy(xpath = "//input[@name='q']")
  private WebElement searchField;

  @FindBy(xpath = "???")
  private WebElement searchButton;

  public GooglePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @Override
  protected boolean isPageLoaded() {
    return searchField.isDisplayed();
  }

  public ResultsPage search(String searchTerm) {
    searchField.sendKeys(searchTerm);
    searchField.sendKeys(Keys.ENTER);
    return new ResultsPage(driver);
  }
}