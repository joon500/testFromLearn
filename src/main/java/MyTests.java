import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class MyTests {

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
      WebDriver.Timeouts ff =   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//Но стоит принимать во внимание, что если DOM не загрузился к тому моменту, вы получите TimeoutException.

        driver.get(url);
        System.out.println("сайт открыт");
    }

    @Test()
    public void myTest5(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));





    }
/*    @Test()
    public void myTest4() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath("//div[@class='index-add-button-wrapper-s0SLe']/a[@href='#login?next=%2Fadditem&authsrc=ca']"));
        WebElement element2 = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).pause(1000).clickAndHold().pause(1000).moveToElement(element2).release().build().perform();
       // actions.dragAndDropBy(element1,700,270);

    }*/




/*    @Test()
    public void myTest3(){

        WebElement element3 = driver.findElement(By.xpath("//input[@data-marker=\"search-form/suggest\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       element3.clear();
        element3.sendKeys("samsung", Keys.ENTER);

        System.out.println("samsung");

    }*/

/*    @Test(priority = 1,groups = "1") // тест для уроков по автоматизаци
    public void myTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element1 = driver.findElement(By.xpath("//div[@class='category-with-counters-item-HDr9u']/a[contains(@href,'transport')]"));


        String par = element1.getAttribute("href");
        String par2 = element1.getCssValue("display");
        System.out.println(par2);
        System.out.println(par);


        WebElement hooo =  new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("main-locationWrapper-R8itV")));// ожиданеи элемента если нету то пауза

    }*/

/*
    @Test()
    public void myTest2(){
        driver.get("https://www.avito.ru/rossiya/transport");
        WebElement element2 = driver.findElement(By.cssSelector(".page-title-count-wQ7pG"));
        String par2 = element2.getText();//19 284 005
        System.out.println(par2);
    }
*/

    @AfterSuite
    public void cleanUp() {
      //  driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));//поосто ожидание
        driver.quit();
        System.out.println("Все активноcти закрыты");
    }




}
