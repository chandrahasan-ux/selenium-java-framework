package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LoggerUtil;

import java.util.List;

/**
 * SearchResultsPage — Page Object for Wikipedia Search Results Page.
 * Contains all web elements and actions related to search results.
 */
public class SearchResultsPage {

    @FindBy(css = "div.mw-search-result-heading a")
    private List<WebElement> searchResults;

    @FindBy(id = "searchText")
    private WebElement searchInputField;

    @FindBy(css = "div.searchresults")
    private WebElement searchResultsContainer;

    @FindBy(xpath = "//p[contains(@class,'mw-search-nonefound')]")
    private WebElement noResultsMessage;

    public SearchResultsPage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }

    public int getResultCount() {
        int count = searchResults.size();
        LoggerUtil.info("Total search results found: " + count);
        return count;
    }

    public String getFirstResultTitle() {
        if (!searchResults.isEmpty()) {
            String title = searchResults.get(0).getText();
            LoggerUtil.info("First result title: " + title);
            return title;
        }
        LoggerUtil.warn("No search results found");
        return "";
    }

    public void clickFirstResult() {
        LoggerUtil.info("Clicking on the first search result");
        searchResults.get(0).click();
    }

    public boolean isResultsContainerDisplayed() {
        LoggerUtil.info("Checking if results container is displayed");
        return searchResultsContainer.isDisplayed();
    }

    public boolean hasResults() {
        return !searchResults.isEmpty();
    }

    public String getPageTitle() {
        return BaseClass.getDriver().getTitle();
    }
}
