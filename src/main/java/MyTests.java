import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyTests {

    private WebDriver driver;

    @BeforeSuite(groups = "two")
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\jon\\Desktop\\java\\chromedriver2.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//все вызовы элементов driver.findElement()
        // будут продолжаться то тех пор,
        // пока элемент не будет найден или будет достигунта граница времени ожидания.
     //   WebElement hooo =  new WebDriverWait(driver, Duration.ofSeconds(5))
       //  .until(ExpectedConditions.presenceOfElementLocated(By.className("main-locationWrapper-R8itV")));// ожиданеи элемента если нету то пауза

     //   WebDriver.Timeouts ff = driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//Но стоит принимать во внимание, что если DOM не загрузился к тому моменту, вы получите TimeoutException.

        System.out.println("Установка законченна");
    }

    //@Parameters({"ggg"})
    @BeforeClass()
    public void appSetup() {
        //  System.out.println(ggg);
        String url = "https://www.avito.ru/";
        WebDriver.Timeouts ff = driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//Но стоит принимать во внимание, что если DOM не загрузился к тому моменту, вы получите TimeoutException.
        driver.get(url);

        System.out.println("сайт открыт");
    }
//берет  метод из класса LoginPage
/*    @Test()
    public void myTest3() {
        LoginPage lp = new LoginPage();
        lp.login("admin", "123");
}*/

    //дата провайдер
/*    @DataProvider(name = "db")
    public static Object[][] dbData(){
        return new Object[][]{{"sql",new Integer(10)}
                ,{"sql2", 20}};
    }*/

/*

    @Test(groups = "two",dataProvider = "db")
    //получения значении в метод
    public void myTest3(String a,int b){
        System.out.println( " "+a+" "+b);


    }
*/
    //зависимость от метода "myTest3"
    /*  @Test(groups = "one", dependsOnMethods = "myTest3"
      ,alwaysRun = true)*/

    @Test
    public void myTest2() {
//получение заголовка и сравнение его
        //WebElement element3 = driver.findElement(By.xpath("//input[@data-marker=\"search-form/suggest\"]"));
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Ави0то: недвижимость, транспорт, работа, услуги, вещи");

    }


/*
//переключение по окнам броузера
    @Test()
    public void openAndSwitchToWindow() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String window1 = driver.getWindowHandle();
        System.out.println(window1);//дескриптор текущего окна
        js.executeScript("window.open()"); //открыть нове окно

        Set<String> currentWindows = driver.getWindowHandles(); //набор окон
        String window2 = null;
        for (String windows: currentWindows
             ) {if (!windows.equals(window1))
        {window2 = windows; break;}
        }
        driver.switchTo().window(window2); //перключение на новое окно
        System.out.println(window2);
        Thread.sleep(2220);
        driver.switchTo().window(window1);
        Thread.sleep(2220);
        driver.close(); //закрыть текущею вкладку
        Thread.sleep(2220);
        driver.switchTo().window(window2);

    }*/

//работа с js алертом
/*    @Test()
    public void toAllertJS(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.xpath("//input[]"));
        element.click();//клик по ссылке которая должна отобразить алерт
        Alert alert = wait.until(alertIsPresent());//ожиданеи появление алерта
        alert.accept();
      //  alert.dismiss();

    }*/
//ждать пока не исчезнет 5й элемент
/*    @Test()
    public void myTest5(){
      List<WebElement> element = (List<WebElement>) driver.findElement(By.xpath("//input[]"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//ждать пока не исчезнет 5й элемент
        wait.until(ExpectedConditions.stalenessOf(element.get(5)));



    }*/
    //перетягивание элемента
/*    @Test()
    public void myTest4() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath("//div[@class='index-add-button-wrapper-s0SLe']/a[@href='#login?next=%2Fadditem&authsrc=ca']"));
        WebElement element2 = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).pause(1000).clickAndHold().pause(1000).moveToElement(element2).release().build().perform();
       // actions.dragAndDropBy(element1,700,270);

    }*/



//отправить запрос в поисковике
/*    @Test()
    public void myTest3(){

        WebElement element3 = driver.findElement(By.xpath("//input[@data-marker=\"search-form/suggest\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        element3.clear();
        element3.sendKeys("samsung", Keys.ENTER);

    }*/
//получить атрибут и получить значение класса
/*    @Test(priority = 1,groups = "1") // тест для уроков по автоматизаци
    public void myTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element1 = driver.findElement(By.xpath("//div[@class='category-with-counters-item-HDr9u']/a[contains(@href,'transport')]"));

        String par = element1.getAttribute("href");
        String par2 = element1.getCssValue("display");
        System.out.println(par2);
        System.out.println(par);



    }*/

/* // наити по cssSelector
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
