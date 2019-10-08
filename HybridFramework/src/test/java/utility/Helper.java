package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {

	public void waitForTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.titleContains(title)));
	}

	public void waitForTitleExact(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.titleIs(title)));
	}

	public void waitForCurentURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));
	}

	public void acceptAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	public void dismissAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		;
	}

	public static String getScreenshot(WebDriver driver) {
		String path = System.getProperty("user.dir") + "/Screenshots" + System.currentTimeMillis() + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshots " + e.getMessage());
		}

		return path;

	}

	public static String getScreenshot(WebDriver driver, String nameOfScreenShot) {
		String path = System.getProperty("user.dir") + "/Screenshots" + nameOfScreenShot + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshots " + e.getMessage());
		}

		return path;

	}
}
