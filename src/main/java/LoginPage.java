import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private final WebDriver driver = new ChromeDriver();

    private final WebElement loginInput = driver.findElement(By.id("login"));
    private final WebElement passInput = driver.findElement(By.id("pass"));
    private final WebElement enter = driver.findElement(By.id("enter"));

    public void login(String login, String pass) {
        loginInput.sendKeys(login);
        passInput.sendKeys(pass);
        enter.click();
    }

}
