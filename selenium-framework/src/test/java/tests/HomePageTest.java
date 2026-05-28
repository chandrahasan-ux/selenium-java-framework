package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.LoggerUtil;

/**
 * HomePageTest — Test cases for Wikipedia Home Page.
 */
public class HomePageTest extends BaseClass {

    @Test(description = "Verify Wikipedia home page loads successfully")
    public void verifyHomePageLoads() {
        LoggerUtil.info("TEST: verifyHomePageLoads");
        String title = getDriver().getTitle();
        Assert.assertTrue(title.contains("Wikipedia"),
                "Page title should contain 'Wikipedia' but was: " + title);
        LoggerUtil.info("Home page title verified: " + title);
    }

    @Test(description = "Verify Wikipedia logo is displayed on home page")
    public void verifyLogoIsDisplayed() {
        LoggerUtil.info("TEST: verifyLogoIsDisplayed");
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isLogoDisplayed(),
                "Wikipedia logo should be visible on home page");
        LoggerUtil.info("Wikipedia logo is displayed successfully");
    }

    @Test(description = "Verify search box is functional and navigates to results page")
    public void verifySearchFunctionality() {
        LoggerUtil.info("TEST: verifySearchFunctionality");
        HomePage homePage = new HomePage();
        SearchResultsPage resultsPage = homePage.search("Selenium WebDriver");

        Assert.assertTrue(resultsPage.hasResults(),
                "Search results should be displayed for 'Selenium WebDriver'");
        LoggerUtil.info("Search results count: " + resultsPage.getResultCount());
    }

    @Test(description = "Verify search results page title contains the search keyword")
    public void verifySearchResultsPageTitle() {
        LoggerUtil.info("TEST: verifySearchResultsPageTitle");
        HomePage homePage = new HomePage();
        String keyword = "Java Programming";
        homePage.search(keyword);

        SearchResultsPage resultsPage = new SearchResultsPage();
        String pageTitle = resultsPage.getPageTitle();

        Assert.assertTrue(pageTitle.contains("Java"),
                "Results page title should contain 'Java' but was: " + pageTitle);
        LoggerUtil.info("Results page title verified: " + pageTitle);
    }
}
