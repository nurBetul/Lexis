import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GoToPage {



    public static By googleSearch = By.name("q");
    public static  By resultStatus = By.cssSelector("div#result-stats");
    public static By thirdResult = By.xpath("//h3[@class='LC20lb DKV0Md'][contains(text(), 'Wikipedia')]");
    public static By thirdResult2 = By.xpath("//cite[@class='iUh30 bc tjvcx'][contains(text(),'en.wikipedia.org › wiki › LexisNexis')]");
    public static By firstHeading = By.cssSelector("h1#firstHeading");

    public static void searchForLexisNexis(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(googleSearch).click();
        driver.findElement(googleSearch).sendKeys("LexisNexis");
        driver.findElement(googleSearch).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultStatus));
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(thirdResult));
        jse.executeScript("arguments[0].click()", driver.findElement(thirdResult));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstHeading));
        System.out.println(driver.getTitle());

    }

    public static void main(String[] args) {
        searchForLexisNexis();
    }

}
