package com.insu.Genericutils;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

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



public class WebDriverUtility {
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait until elements in the page gets load
	 * @param driver
	 * @param duration
	 */
	public void implicitWait(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * This method will wait until elements in the page gets load
	 * @param driver
	 * @param duration
	 * @param url
	 */
	public void explicitWait(WebDriver driver, int duration, String url) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(url));
		}
	/**
	 * This method will wait until the title page get loaded
	 * @param driver
	 * @param duration
	 * @param expectedTitle
	 */
	public void waitUntilTitleLoads(WebDriver driver,int duration, String expectedTitle) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));	
	}
	/**
	 * The Method will wait until the element in the page is clickable
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementToBeVisible(WebDriver driver,int duration, WebElement element) {
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will ignore NoSuchElementException and continue execution
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver,int duration) {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		 wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method will wait until the element will visible in the webpage
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			
			}
			catch(Exception e) {
				Thread.sleep(1000);
				
			}
		}
	}
	/**
	 * This method is used to select dropdown based on  index
	 * @param element
	 * @param index
	 */
  public void selectDropDown(WebElement element, int index) {
	  Select s=new Select(element);
	  s.selectByIndex(index);
  }
  /**
   * This method is used to select dropdown based on value
   * @param element
   * @param value
   */
  public void selectDropDown(WebElement element, String value) {
	  Select s=new Select(element);
	  s.selectByValue(value);
  }
  /**
   * This method is used to select dropdown based on text
   * @param text
   * @param element
   */
  public void selectDropDown(String text,WebElement element) {
	  Select s=new Select(element);
	  s.selectByVisibleText(text);
  }
  /**
   * This method is used to mouseover on the element
   * @param driver
   * @param element
   */
  public void mouseOverOnElement(WebDriver driver, WebElement element) {
	  Actions action=new Actions(driver);
	  action.moveToElement(element).perform();
  }
  /**
   * This method is used to draganddrop the element on the webpage
   * @param driver
   * @param src
   * @param dst
   */
  public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst) {
	  Actions action=new Actions(driver);
	  action.dragAndDrop(src, dst);
  }
  /**
   * This method is used doubleclick on the webpage
   * @param driver
   * @param element
   */
  public void doubleClick(WebDriver driver, WebElement element) {
	  Actions action=new Actions(driver);
	  action.doubleClick(element).perform();
  }
  /**
   * This method is used to rightclick on the element
   * @param driver
   * @param element
   */
  public void rightClick(WebDriver driver,WebElement element) {
	  Actions action=new Actions(driver);
	  action.contextClick(element).perform();
  }
  /**
   * This method is used to click on the enter button
   * @param driver
   * @param element
   */
  public void clickOnEnterKey(WebDriver driver,WebElement element) {
	  Actions action=new Actions(driver);          // Robot rb=new Robot(); rb.KeyPress(KeyEvent.VK_ENTER);
	   action.sendKeys(Keys.ENTER).perform();
  }
  /**
   * This method is used to release the key 
   * @param driver
   * @throws Throwable
   */
  public void enterRelease(WebDriver driver) throws Throwable {
	  Robot rb=new Robot();
	  rb.keyRelease(KeyEvent.VK_ENTER);
  }
  /**
   * This method is used to switch from one frame to another frame using index
   * @param driver
   * @param index
   */
  public void switchFrame(WebDriver driver, int index) {
	  driver.switchTo().frame(index);
  }
  /**
   * This method is used to switch from one frame to another by using id
   * @param driver
   * @param id
   */
  public void switchFrame1(WebDriver driver, int id) {
	  driver.switchTo().frame(id);
  }
  /**
   * This method is used to switch from one frame to another by using Webelement
   * @param driver
   * @param element
   */
  public void switchFrame(WebDriver driver, WebElement element) {
	  driver.switchTo().frame(element);
  }
  /**
   * This method is used to switch to mainframe
   * @param driver
   */
  public void switchToMainFrame(WebDriver driver) {
	  driver.switchTo().defaultContent();
  }
  /**
   * This method is used to accept the popup
   * @param driver
   * @param expectedMsg
   */
  public void acceptAlertPopUp(WebDriver driver, String expectedMsg) {
	  Alert alt=driver.switchTo().alert();
	  if(alt.getText().equalsIgnoreCase(expectedMsg)) {
		  System.out.println("Alert message is verified");
	  }
	  else {
		  System.out.println("Alert message is not verified");
	  }
	  alt.accept();
  }
  /**
   * This method is used to dismiss the popup
   * @param driver
   * @param expectedMsg
   */
  public void dismissAlertPopUp(WebDriver driver, String expectedMsg) {
	  Alert alt=driver.switchTo().alert();
	  if(alt.getText().equalsIgnoreCase(expectedMsg)) {
		  System.out.println("Alert message is verified");
	  }
	  else {
		  System.out.println("Alert message is not verified");
	  }
	  alt.dismiss();
  }
  /**
   * This method is used to switch the window using getWindowHandles
   * @param driver
   */
  public void switchWindow(WebDriver driver) {
	  Set<String> set = driver.getWindowHandles();
	  for(String str :set) {
		  driver.switchTo().window(str);
	  }
  }
  /**
   * This method is used to switch from one window to another based on title
   * @param driver
   * @param expectedTitle
   */
  public void switchWindowBasedOnTitle(WebDriver driver, String expectedTitle) {
	  Set<String> set = driver.getWindowHandles();
	  for(String str:set) {
		  driver.switchTo().window(str);
		  String title=driver.getTitle();
		  if(title.contains(expectedTitle)) {
			  break;
		  }
	  }
  }
  /**
   * This method is used to switch from one window to another based on url
   * @param driver
   * @param expectedUrl
   */
 public void switchWindowBasedOnUrl(WebDriver driver,String expectedUrl) {
	 Set<String> set = driver.getWindowHandles();
	 Iterator<String> it = set.iterator();
	 while(it.hasNext()) {
		 String wid = it.next();
		 driver.switchTo().window(wid);
		 String url = driver.getCurrentUrl();
		 if(url.contains(expectedUrl)) {
			 break;
		 }
	 }
 }
 /**
  * This method is used to take screenshot
  * @param driver
  * @param screenShotname
  * @return
  */
 public static String takeScreenShot(WebDriver driver,String screenShotname) {
	 TakesScreenshot t=(TakesScreenshot)driver;
	File src = t.getScreenshotAs(OutputType.FILE);
	File dst=new File("./screenshots/"+screenShotname+".png");
	try {
		Files.copy(src, dst);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return screenShotname;
	 
 }
 /**
  * This method is used to scroll to particular element
  * @param driver
  * @param element
  */
 public void scrollToParticularElement(WebDriver driver,WebElement element) {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView", element);
 }
 /**
  * This method will perform random scroll
  * @param driver
  */
 
 public void ScrollBarAction(WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)", "");
 }
 /**
  * This method will scroll until specified element is found
  * @param driver
  * @param element
  */
 public void scrollAction(WebDriver driver,WebElement element) {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 int y=element.getLocation().getY();
	 js.executeScript("argument[0].scrollIntoView()", element);
 }
}