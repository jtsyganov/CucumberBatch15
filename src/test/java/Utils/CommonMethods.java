package Utils;

import StepDefinitions.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {
 public static WebDriver driver;
    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties();
        String browserType=ConfigReader.getPropertyValue("browserType");
        switch (browserType){
            case "Chrome":
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--no-sandbox");
                ops.addArguments("--remote-allow-origins=*");
                if(ConfigReader.getPropertyValue("Headless").equals("true")){
                    ops.addArguments("--headless=new");
                }
                driver=new ChromeDriver(ops);
                break;
            case "Firefox":
                driver=new FirefoxDriver();
                break;
            case "IE":
                driver=new InternetExplorerDriver();
                break;
            default:
                driver=new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));
        initializePageObjects();
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("This is the beginning of my Test case");
        Log.info("My test case is executing right now");
        Log.warning("My test case might have some trivial issues");
    }
    public static void closeBrowser(){
        Log.info("This test case is about to get completed");
        Log.endTestCase("This test case is finished");
        driver.close();
    }

    public static void doClick(WebElement element){

        element.click();
    }

        public static void sendText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public static Select clickOnDropDown(WebElement element){
        Select select=new Select(element);
        return select;
    }
    public static Actions moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        return actions;
    }
    public static void selectByValue(WebElement element,String value){
        clickOnDropDown(element).selectByValue(value);
    }
    public static void selectByVisibleText(WebElement element, String text){
        clickOnDropDown(element).selectByVisibleText(text);
    }
    public static void selectByIndex(WebElement element, int index){
        clickOnDropDown(element).selectByIndex(index);
    }
    public static void selectByOptions(WebElement element, String text){
        List<WebElement> options = clickOnDropDown(element).getOptions();
        for (WebElement option:options) {
            String ddlOptionText = option.getText();
            if (ddlOptionText.equals(text)){
                option.click();
            }

        }
    }
    public static byte[] takeScreenshot(String imageName){
        TakesScreenshot ts= (TakesScreenshot)driver;
        byte[] picBytes=ts.getScreenshotAs(OutputType.BYTES);

        File sourcePath = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourcePath, new File(Constants.SCREENSHOT_FILEPATH+imageName+getTimeStemp("yyyy-MM-dd-hh-mm-ss")+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picBytes;
    }
    public static String getTimeStemp(String pattern){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
