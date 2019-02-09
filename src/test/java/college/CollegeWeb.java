package college;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class CollegeWeb 
{
  WebDriver driver;
  @Test
  public void testWebsite() throws Exception 
  {
	  List<WebElement> lst = driver.findElements(By.tagName("a"));
	  System.out.println("Number of Anchor TAGS ===> "+lst.size());
	  for (WebElement we : lst) 
	  {
		  String url = we.getAttribute("href");
		  test(url);
	  }
  }
  
  public void test(String urln) throws Exception 
  {
		URL url = new URL(urln);
		HttpURLConnection ht = (HttpURLConnection) url.openConnection();
		ht.setConnectTimeout(800);
		ht.connect();
		Thread.sleep(800);
		if(ht.getResponseCode()==200)
		{
			System.out.println("Link Test Pass ==> "+url);
		}
		else
			System.out.println("Link Test Failed ==> "+url);
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver = new FirefoxDriver();
	  driver.get("http://techsumtechnology.com");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

  
}
