package com.insurance.ASTL.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtilities 
{
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	public void minimizeBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method wait until element in page gets loaded
	 * @param driver
	 * @param duration
	 */
	public void implicitWait(WebDriver driver,int duration)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * This method waits until expected url gets loaded
	 * @param driver
	 * @param duration
	 * @param expectedurl
	 */
	public void waitUntilUrlLoads(WebDriver driver,int duration,String expectedurl)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedurl));
	}
	/**
	 * This method will wait until the title gets loaded
	 * @param driver
	 * @param duration
	 * @param expectedTitle
	 */
	public void waitUntilTitleLoad(WebDriver driver,int duration,String expectedTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(0));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	/**
	 * This method will wait until the element in the page gets loaded
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver,int duration,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will ignore no such element exception
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver,int duration)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public void customWait(WebElement element)
	{
		int count=0;
		while(count<20)
		{
			try {
				element.click();
				break;
			}
			catch(Exception e)
			{
				
			}
		}
	}
	/**
	 * This method will select drop down based on index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method will select drop down based on values
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method will select drop down based on visible text
	 * @param text
	 * @param element
	 */
	public void selectDropDown(String text,WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method will mouse over on element
	 * @param driver
	 * @param element
	 */
	public void mouseOverElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method will right click on web element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method will click on enter key
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void enterRelease(WebDriver driver) throws AWTException
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to switch frames using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch frames using id
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 * This method is used to switch frames using web element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to accept alert popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void acceptAlertPopup(WebDriver driver,String expectedMsg)
	{
		Alert alt=driver.switchTo().alert();
		if(alt.getText().equalsIgnoreCase(expectedMsg))
		{
			System.out.println("Alert message is verified");
		}
		else
		{
			System.out.println("Alert message is not verified");
		}
		alt.accept();
	}
	/**
	 * This method is used to dismiss the alert popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void dismissAlertPopup(WebDriver driver,String expectedMsg)
	{
		Alert alt=driver.switchTo().alert();
		if(alt.getText().equalsIgnoreCase(expectedMsg))
		{
			System.out.println("Alert message is verified");
		}
		else
		{
			System.out.println("Alert message is not verified");
		}
		alt.dismiss();
	}
	/**
	 * This method is used to switch from one window to another window based on title
	 * @param driver
	 * @param expectedtitle
	 */
	public void switchWindowBasedOnTitle(WebDriver driver,String expectedtitle)
	{
		Set<String> set = driver.getWindowHandles();
		for(String str:set)
		{
			driver.switchTo().window(str);
			String title = driver.getTitle();
			if(title.contains(expectedtitle))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to switch from one window to another window based on url
	 * @param driver
	 * @param expectedtitle
	 */
	
	public void switchWindowBasedOnUrl(WebDriver driver,String expectedurl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String windowid = it.next();
			driver.switchTo().window(windowid);
			String url = driver.getCurrentUrl();
			if(url.contains(expectedurl))
			{
				break;
			}
		}
	}
	/**
	 * This method will take screen shot whenever test script is getting failed
	 * @param driver
	 * @param screenshotname
	 * @return
	 */
	public static String takeScreenShot(WebDriver driver,String screenshotname)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des=new File("./screecShot"+screenshotname+".png");
		try
		{
			Files.copy(src, des);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return screenshotname;
	}
	/**
	 * This method is used to scroll to particular element
	 * @param driver
	 * @param element
	 */
	public void scrollToParticularElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,0)","");
	}
	
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
}
