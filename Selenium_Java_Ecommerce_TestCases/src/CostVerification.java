/*TEST SCENARIO - 2: 
 * 
 * TITLE: Verify Cost of Product in List Page = Cost OF Product in detail page
 * 
 * Steps:
 * 1. Goto https://live.techpanda.org
 * 2. Click on 'Mobile' menu
 * 3. In the list of all mobile, read the cost of Sony Xperia mobile.Note this value.
 * 4. Click on Sony Xperia mobile
 * 5. Read the cost of Sony Xperia mobile from detail page
 * 6. Compare value in Step 3 & step 5 
 * 
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CostVerification {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://live.techpanda.org");
		driver.findElement(By.cssSelector("li[class*=nav-1]")).click();
		
		String listpagePrice=null;
				
		List<WebElement> nameList = driver.findElements(By.cssSelector("li[class='item last']"));
		for(int i=0; i<nameList.size();i++)
		{
			if(nameList.get(i).findElement(By.cssSelector("h2 a")).getText().contains("XPERIA"))
			{
				listpagePrice = nameList.get(i).findElement(By.cssSelector("[class='price']")).getText();
				nameList.get(i).findElement(By.cssSelector("h2 a")).click();
				break;
			}
		}
		String detailspagePrice = driver.findElement(By.cssSelector(".price")).getText();
		Assert.assertEquals(listpagePrice, detailspagePrice);
		driver.quit();
	}
	
}
