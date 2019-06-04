package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

  @Test
  public void searchForText() {
    String searchTerm = "Selenium";

    Assert.assertTrue(googlePage.isPageLoaded(), "The page isn't loaded");
    ResultsPage resultsPage = googlePage.search(searchTerm);
    Assert.assertTrue(resultsPage.isPageLoaded(), "The page isn't loaded");
    Assert.assertEquals(resultsPage.getSearchResultsCount(), 10, "Results count isn't = 10");
    Assert.assertTrue(resultsPage.getSearchResultsText().contains(searchTerm),
      "Not all results contain " + searchTerm);
    resultsPage = resultsPage.navigateToSecondPage();
    Assert.assertEquals(resultsPage.getSearchResultsCount(), 10, "Results count isn't = 10");
    Assert.assertTrue(resultsPage.getSearchResultsText().contains(searchTerm),
      "Not all results contain " + searchTerm);

  }
}