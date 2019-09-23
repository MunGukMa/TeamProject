package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
 
public class SeleniumTest3 {
 
    public static void main(String[] args) {
        SeleniumTest3 selTest = new SeleniumTest3();
        selTest.crawl();
    }
 
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Programming/2. JAR, WAR/Selenium/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumTest3() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver();
    }
 
    public void crawl() {

    	//GameDAO dao = new GameDAO();
    	
        try {

        	base_url = "https://store.steampowered.com/games/#p=0&tab=TopSellers";
        	driver.get(base_url);
            Thread.sleep(5000);
            
            //ArrayList<GameVO> list = new ArrayList<GameVO>();
            
            for(int page = 2 ; page < 31 ; page ++){
	            for(int num = 1 ; num < 16 ; num++){
	            	By first = By.xpath("//*[@id='TopSellersRows']/a[" + num + "]");
		            driver.findElement(first).click();
		            List<WebElement> path = driver.findElements(By.xpath("/html/body/div[1]/div[7]/div[4]/div[1]/div[2]/div[2]/div[2]/div/div[3]"));
		            if(path.size() > 0){
		            	String name = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[4]/div[1]/div[2]/div[2]/div[2]/div/div[3]")).getText();
			            By fullList = By.className("game_area_sys_req_full");
			            By leftList = By.className("game_area_sys_req_leftCol");
			        	By rightList = By.className("game_area_sys_req_rightCol");
			        	List<WebElement> full = driver.findElements(fullList);
			        	List<WebElement> left = driver.findElements(leftList);
			        	List<WebElement> right = driver.findElements(rightList);
			        	
			        	System.out.println(name);
			        	
			        	for(WebElement e : full){
			        		System.out.println(e.getText());
			        	}
			        	
			        	for(WebElement e : left){
			        		System.out.println(e.getText());
			        	}
			        	
			        	for(WebElement e : right){
			        		System.out.println(e.getText());
			        	}
			        	
			        	Thread.sleep(5000);
			        	driver.navigate().back();
			        	
		            } else if(driver.findElement(By.id("app_agegate")).isDisplayed()) {
		            	Select age = new Select(driver.findElement(By.id("ageYear")));
		            	age.selectByValue("1999");
		            	System.out.println("시벌");
		            	
	            		WebElement temp = driver.findElement(By.xpath("//*[@id='app_agegate']/div[1]/div[4]/a[1]"));

	            		System.out.println("탱");
	            		temp.click();
	            		Thread.sleep(5000);
		            	String name = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[4]/div[1]/div[2]/div[2]/div[2]/div/div[3]")).getText();
		            	By fullList = By.className("game_area_sys_req_full");
			            By leftList = By.className("game_area_sys_req_leftCol");
			        	By rightList = By.className("game_area_sys_req_rightCol");
			        	List<WebElement> full = driver.findElements(fullList);
			        	List<WebElement> left = driver.findElements(leftList);
			        	List<WebElement> right = driver.findElements(rightList);
			        	
			        	System.out.println(name);
			        	
			        	for(WebElement e : full){
			        		System.out.println(e.getText());
			        	}
			        	
			        	for(WebElement e : left){
			        		System.out.println(e.getText());
			        	}
			        	
			        	for(WebElement e : right){
			        		System.out.println(e.getText());
			        	}
			        	
			        	Thread.sleep(5000);
			        	driver.navigate().to(base_url);
				        	
		            } else {
		            	
		            }
	            }
	            By pagenum = By.xpath("//*[@id='TopSellers_links']/span[" + page + "]");
	            driver.findElement(pagenum).click();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }
}