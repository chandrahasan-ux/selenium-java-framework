package utils;

import base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ScreenshotUtil — Captures and saves screenshots on test failure.
 */
public class ScreenshotUtil {

    public static String capture(String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        String screenshotPath = System.getProperty("user.dir")
                + "/test-output/screenshots/" + screenshotName;

        try {
            File srcFile = ((TakesScreenshot) BaseClass.getDriver())
                    .getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, destFile);
            LoggerUtil.info("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            LoggerUtil.error("Failed to capture screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }
}
