package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.LoggerUtil;

/**
 * SearchTest — Test cases for Wikipedia Search functionality.
 * Includes data-driven tests using @DataProvider.
 */
public class SearchTest extends BaseClass {

    @DataProvider(name = "searchKeywords")
    public Object[][] searchKeywords() {
        return new Object[][] {
                {"Python programming"},
                {"Automation Testing"},
                {"Artificial Intelligence"},
                {"Graphene"},
                {"TestNG framework"}
        };
    }

    @Test(description = "Verify search returns results for a valid keyword")
    public void verifyValidSearchReturnsResults() {
        LoggerUtil.info("TEST: verifyValidSearchReturnsResults");
        HomePage homePage = new HomePage();
        SearchResultsPage resultsPage = homePage.search("Automation");

        Assert.assertTrue(resultsPage.hasResults(),
                "Search should return results for keyword: Automation");
        Assert.assertTrue(resultsPage.getResultCount() > 0,
                "Result count should be greater than 0");
    }

    @Test(description = "Verify first search result title is not empty")
    public void verifyFirstResultTitleNotEmpty() {
        LoggerUtil.info("TEST: verifyFirstResultTitleNotEmpty");
        HomePage homePage = new HomePage();
        SearchResultsPage resultsPage = homePage.search("TestNG");

        String firstTitle = resultsPage.getFirstResultTitle();
        Assert.assertFalse(firstTitle.isEmpty(),
                "First search result title should not be empty");
        LoggerUtil.info("First result title: " + firstTitle);
    }

    @Test(dataProvider = "searchKeywords",
          description = "Data-driven test — verify search works for multiple keywords")
    public void verifySearchWithMultipleKeywords(String keyword) {
        LoggerUtil.info("TEST: verifySearchWithMultipleKeywords — keyword: " + keyword);
        HomePage homePage = new HomePage();
        SearchResultsPage resultsPage = homePage.search(keyword);

        Assert.assertTrue(resultsPage.hasResults(),
                "Search should return results for keyword: " + keyword);
        LoggerUtil.info("Results found for keyword '" + keyword
                + "': " + resultsPage.getResultCount());
    }

    @Test(description = "Verify clicking first result opens the article page")
    public void verifyClickingFirstResultOpensArticle() {
        LoggerUtil.info("TEST: verifyClickingFirstResultOpensArticle");
        HomePage homePage = new HomePage();
        SearchResultsPage resultsPage = homePage.search("Selenium WebDriver");

        Assert.assertTrue(resultsPage.hasResults(), "Search results should exist");
        resultsPage.clickFirstResult();

        ArticlePage articlePage = new ArticlePage();
        Assert.assertTrue(articlePage.isArticleContentDisplayed(),
                "Article content should be displayed after clicking a search result");
        LoggerUtil.info("Article opened: " + articlePage.getArticleHeading());
    }

    @Test(description = "Verify article heading is not empty after navigation")
    public void verifyArticleHeadingAfterNavigation() {
        LoggerUtil.info("TEST: verifyArticleHeadingAfterNavigation");
        HomePage homePage = new HomePage();
        SearchResultsPage resultsPage = homePage.search("Maven build tool");

        resultsPage.clickFirstResult();
        ArticlePage articlePage = new ArticlePage();

        String heading = articlePage.getArticleHeading();
        Assert.assertFalse(heading.isEmpty(),
                "Article heading should not be empty");
        LoggerUtil.info("Article heading verified: " + heading);
    }
}
