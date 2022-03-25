package newPac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewClass {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\jon\\Desktop\\java\\chromedriver2.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//все вызовы элементов driver.findElement()
        // будут продолжаться то тех пор,
        // пока элемент не будет найден или будет достигунта граница времени ожидания.

        System.out.println("Установка законченна");
    }

    @BeforeClass
    public void appSetup() {

        String url = "https://www.avito.ru/";
        WebDriver.Timeouts ff = driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//Но стоит принимать во внимание, что если DOM не загрузился к тому моменту, вы получите TimeoutException.
        driver.get(url);

        System.out.println("сайт открыт");
    }

    /*    @Test()
        public void myTest3() {
            LoginPage lp = new LoginPage();
            lp.login("admin", "123");

        }*/
    @Test()
    public void myTest3(){

        //WebElement element3 = driver.findElement(By.xpath("//input[@data-marker=\"search-form/suggest\"]"));
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Авито: недвижимость, транспорт, работа, услуги, вещи");

    }



    @AfterSuite
    public void cleanUp() {
        //  driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));//поосто ожидание
        driver.quit();
        System.out.println("Все активноcти закрыты");
    }
}
