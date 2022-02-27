import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*Steps:
 *1.Goto www.amazon.com
 *2.Check navigation account by Mouseover action
 *3.Click search box and type "HELLO" and select "HELLO"
*/
public class ActionClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver","C:\\BrowserDrivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.amazon.com/");
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
	action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.LEFT_SHIFT).sendKeys("hello").doubleClick().build().perform();
	}

}
