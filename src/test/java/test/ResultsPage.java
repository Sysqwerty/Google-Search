package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends BasePage {

  @FindBy(xpath = "//div[@id='center_col']")
  private WebElement results;

  @FindBy(xpath = "//a[@aria-label='Page 2']")
  private WebElement pagination2Button;

  @FindBy(xpath = "//a//h3")
  private List<WebElement> searchResultElements;

  public ResultsPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(results));
  }

  protected ResultsPage navigateToSecondPage() {
    pagination2Button.click();
    return this;
  }

  public int getSearchResultsCount() {
    return searchResultElements.size();
  }

  public List<String> getSearchResultsText() {
    List<String> searchResultsList = new ArrayList<String>();
    for (WebElement searchResultElement : searchResultElements) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResultElement);
      String searchResultText = searchResultElement.getText();
      System.out.println(searchResultText + "\n");
      searchResultsList.add(searchResultText);
    }
    return searchResultsList;
  }

  @Override
  protected boolean isPageLoaded() {
    return results.isDisplayed();
  }
}
