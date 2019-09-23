package com.test.team;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

 
public class SteamAppidCrawlingTest {
 
    public static void main(String[] args) {
    	SteamAppidCrawlingTest selTest = new SteamAppidCrawlingTest();
        selTest.crawl();
    }
 
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "D:/ETC/PROJECT/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SteamAppidCrawlingTest() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver();
    }
 
    public void crawl() {

    	SteamDAO dao = new SteamDAO();
    	
        try {

        	base_url = "https://steamdb.info/graph/";
        	driver.get(base_url);
            Thread.sleep(5000);
            
            ArrayList<SteamVO> list = new ArrayList<SteamVO>();
            
            Select length = new Select(driver.findElement(By.name("table-apps_length")));
        	length.selectByVisibleText("All");
        	Thread.sleep(5000);
            
        	for(int i = 2 ; i < 1191 ; i++){
        		SteamVO vo = new SteamVO();
        		
        		By appidInfo = By.xpath("//*[@id='table-apps']/tbody/tr[" + i + "]/td[2]");
        		By nameInfo = By.xpath("//*[@id='table-apps']/tbody/tr[" + i + "]/td[3]");
        		
        		String appid = driver.findElement(appidInfo).getText();
        		String name = driver.findElement(nameInfo).getText();
        		
        		vo.setAppid(appid);
        		vo.setName(name);
        		
        		list.add(vo);
        	}
        	dao.insertSteam(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }
}