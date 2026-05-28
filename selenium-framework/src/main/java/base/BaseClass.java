package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.LoggerUtil;

import java.time.Duration;

/**
 * BaseClass — Initializes and tears down the WebDriver for every test.
 * All test classes extend this class.
 */
public class BaseClass {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    private static final int IMPLICIT_WAIT  = 10;
    private static final int EXPLICIT_WAIT  = 15;

    @BeforeMethod
    public void setUp() {
        LoggerUtil.info("=== Setting up WebDriver ===");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        // Uncomment below line to run in headless mode (no browser window):
        // options.addArguments("--headless=new");

        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.set(chromeDriver);
        wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_WAIT)));

        String url = ConfigReader.get("base.url");
        getDriver().get(url);
        LoggerUtil.info("Navigated to: " + url);
    }

    @AfterMethod
    public void tearDown() {
        LoggerUtil.info("=== Tearing down WebDriver ===");
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
            wait.remove();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }
}
