package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LoggerUtil;

/**
 * HomePage — Page Object for Wikipedia Home Page.
 * Contains all web elements and actions related to the home page.
 */
public class HomePage {

    @FindBy(id = "searchInput")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(css = "div.central-featured-logo")
    private WebElement wikipediaLogo;

    public HomePage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }

    public boolean isLogoDisplayed() {
        LoggerUtil.info("Checking if Wikipedia logo is displayed");
        return wikipediaLogo.isDisplayed();
    }

    public void enterSearchKeyword(String keyword) {
        LoggerUtil.info("Entering search keyword: " + keyword);
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    public void clickSearchButton() {
        LoggerUtil.info("Clicking search button");
        searchButton.click();
    }

    public SearchResultsPage search(String keyword) {
        enterSearchKeyword(keyword);
        clickSearchButton();
        return new SearchResultsPage();
    }
}
