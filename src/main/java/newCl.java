import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class newCl {

    String locatorLogin = "//a[contains(@class,'login-new-item_enter')]/div[@class='desk-notif-card__login-new-item-title']";

    private WebDriver driver;

    @BeforeSuite()
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
    @BeforeClass()
    public void appSetup() {


        String url = "https://yandex.ru/";
       // String url = "https://www.avito.ru/";
        driver.get(url);

        System.out.println("сайт открыт");
    }
    @Test()
    public void myTest2(){
        //WebElement element3 = driver.findElement(By.xpath("//a[contains(@class,'login-new-item_enter')]/div[@class='desk-notif-card__login-new-item-title']"));
        //WebElement element3 = driver.findElement(By.xpath("//input[@data-marker=\"search-form/suggest\"]"));
       String title = driver.getTitle();
        System.out.println(title);
       // Assert.assertEquals(title,"Ави0то: недвижимость, транспорт, работа, услуги, вещи");
        Assert.assertTrue(driver.findElement(By.xpath(locatorLogin)).getText().equals("Войти"), "Отображается кнопка Войти");

    }
}
