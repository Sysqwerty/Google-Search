package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearchTest extends BaseTest {

  @Test
  public void searchForText() {
    String searchTerm = "Selenium";

    Assert.assertTrue(googlePage.isPageLoaded(), "The page isn't loaded");
    ResultsPage resultsPage = googlePage.search(searchTerm);
    Assert.assertTrue(resultsPage.isPageLoaded(), "The page isn't loaded");
    Assert.assertEquals(resultsPage.getSearchResultsCount(), 10, "Results count isn't = 10");
    List<String> resultsList = resultsPage.getSearchResultsText();
    for (String result : resultsList) {
      Assert.assertTrue(result.contains(searchTerm), "Not all results contain " + searchTerm);
    }

    resultsPage = resultsPage.navigateToSecondPage();
    Assert.assertEquals(resultsPage.getSearchResultsCount(), 10, "Results count isn't = 10");
    resultsList = resultsPage.getSearchResultsText();
    for (String result : resultsList) {
      Assert.assertTrue(result.contains(searchTerm), "Not all results contain " + searchTerm);
    }
  }
}