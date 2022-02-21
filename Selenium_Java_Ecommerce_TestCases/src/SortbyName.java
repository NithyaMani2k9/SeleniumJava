/*TEST SCENARIO - 1: 
 * 
 * TITLE: Verify item in Mobile List page can be sorted by Name
 * 
 * Steps:
 * 1. Goto -  https://live.techpanda.org/index.php/
 * 2. Click on 'MOBLILE' menu
 * 3. In the list of all mobile, select 'SORT BY' dropdown as 'name'
 * 4. Verify all products are sorted by name
 * 
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortbyName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://live.techpanda.org/index.php");
		driver.findElement(By.cssSelector("li[class*=nav-1]")).click();
		
		WebElement staticList = driver.findElement(By.cssSelector("select[title='Sort By']"));
		Select sortbyList = new Select(staticList);
		sortbyList.selectByVisibleText("Name");
				
		List<WebElement> nameList = driver.findElements(By.cssSelector("li[class='item last']"));
		
		boolean bSorted = IsSorted(nameList);
		if(bSorted == true)
			System.out.println("Mobile names are sorted by alphabetical order!!");
		else
			System.out.print("Mobile names are not sorted by alphabetocal order!!");
		driver.quit();
			
	}

	//Method to check if list is alphabetically sorted
	public static boolean IsSorted(List<WebElement> mobNames) 
	{
		boolean bSort = true;
		String prevName = mobNames.get(0).findElement(By.cssSelector("h2 a")).getText();
		for(int i=1; i<mobNames.size();i++)
		{
			String name = mobNames.get(i).findElement(By.cssSelector("h2 a")).getText();
			if(prevName.compareToIgnoreCase(name) > 0)
			{
				bSort = false;
				break;
			}
			else
			{
				prevName = name;
			}
		}
		
		return bSort;
	}
	
}
