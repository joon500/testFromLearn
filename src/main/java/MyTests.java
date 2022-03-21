import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyTests {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\jon\\Desktop\\java\\chromedriver2.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Установка законченна");
    }
    @BeforeClass
    public void appSetup() {
        String url = "https://www.avito.ru/";
        driver.get(url);
        System.out.println("сайт открыт");
    }

    @Test() // тест для уроков по автоматизаци
    public void myTest(){

        WebElement element1 = driver.findElement(By.xpath("//div[@class='category-with-counters-item-HDr9u']/a[contains(@href,'transport')]"));


        String par = element1.getAttribute("href");
        String par2 = element1.getCssValue("display");
        System.out.println(par2);
        System.out.println(par);


        WebElement hooo =  new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("main-locationWrapper-R8itV")));// ожиданеи элемента если нету то пауза






    }
    @Test()
    public void myTest2(){
        driver.get("https://www.avito.ru/rossiya/transport");
        WebElement element2 = driver.findElement(By.cssSelector(".page-title-count-wQ7pG"));
        String par2 = element2.getText();//19 284 005
        System.out.println(par2);
    }

    @AfterSuite
    public void cleanUp() {
      //  driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));//поосто ожидание
        driver.quit();
        System.out.println("Все активновти закрыты");
    }




}
