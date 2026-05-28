package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LoggerUtil;

/**
 * ArticlePage — Page Object for a Wikipedia Article Page.
 * Contains all web elements and actions related to an article.
 */
public class ArticlePage {

    @FindBy(id = "firstHeading")
    private WebElement articleHeading;

    @FindBy(id = "mw-content-text")
    private WebElement articleContent;

    @FindBy(css = "div#toc")
    private WebElement tableOfContents;

    @FindBy(css = "a#ca-edit")
    private WebElement editPageLink;

    @FindBy(css = "li#ca-history a")
    private WebElement viewHistoryLink;

    public ArticlePage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }

    public String getArticleHeading() {
        String heading = articleHeading.getText();
        LoggerUtil.info("Article heading: " + heading);
        return heading;
    }

    public boolean isArticleContentDisplayed() {
        LoggerUtil.info("Checking if article content is displayed");
        return articleContent.isDisplayed();
    }

    public boolean isTableOfContentsDisplayed() {
        try {
            return tableOfContents.isDisplayed();
        } catch (Exception e) {
            LoggerUtil.warn("Table of contents not found on this page");
            return false;
        }
    }

    public String getPageTitle() {
        return BaseClass.getDriver().getTitle();
    }

    public String getCurrentUrl() {
        return BaseClass.getDriver().getCurrentUrl();
    }
}
