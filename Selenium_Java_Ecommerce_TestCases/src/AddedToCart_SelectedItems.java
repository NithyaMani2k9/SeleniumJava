/*Topic - 1.Add specified items to cart 
*		  2. Thread, Implicit and Explicit Wait is implemented 
*/
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddedToCart_SelectedItems {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	driver.manage().window().maximize();
	
	//Thread.sleep(5000);
	
	//Implicit wait mechanism
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Explicit Wait object creation
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
			
	String[] itemstoCart = {"Brocolli","Water Melon","Strawberry","Mango","Corn"};	
	AddItemstoCart(driver,itemstoCart);
	driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	
	driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	//explicit wait
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));
	driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
	
	
	driver.findElement(By.cssSelector("button.promoBtn")).click();
	//explicit wait
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
	System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	
	driver.quit();
	
}

 
//Method to add items mentioned in itemstoCart array to the cart
	
public static void AddItemstoCart(WebDriver driver, String[] itemstoCart) throws InterruptedException 
{
	String[]  name;
	String  formattedName;
	
	List<WebElement> listofProducts = driver.findElements(By.className("product-name"));
	List<String> items = Arrays.asList(itemstoCart);
		
	for(int i=0; i<listofProducts.size();i++)
	{
		 int itemCount = 0;
		 name = listofProducts.get(i).getText().split("-");
		 formattedName = name[0].trim();
		if(items.contains(formattedName))
		{
			driver.findElements(By.cssSelector("div.product-action button")).get(i).click();
			itemCount++;
			if(itemCount == itemstoCart.length)
			break; //break the loop if all the required items are added to cart
		}
	}
}

}



