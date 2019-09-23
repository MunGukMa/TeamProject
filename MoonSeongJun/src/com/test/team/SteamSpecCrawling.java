package com.test.team;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class SteamSpecCrawling {

	public static void main(String[] args) {
		SteamSpecCrawling selTest = new SteamSpecCrawling();
		selTest.crawl();
	}

	//WebDriver
	private WebDriver driver;

	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:/ETC/PROJECT/chromedriver.exe";

	//크롤링 할 URL
	private String base_url;

	public SteamSpecCrawling() {
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
			base_url = "https://store.steampowered.com/app/238960";
			driver.get(base_url);
			//Thread.sleep(5000);


			List<WebElement> element = driver.findElements(By.className("bb_ul"));
			if(element.size()>0){
				String result=null;
				System.out.println("=========================================================================");
				for(WebElement ele : element){ 
					//if(ele.getText().contains("Processor")&&ele.getText().contains("Graphics"))
					result = ele.getText();

				}
				System.out.println(result);

				System.out.println("=========================================================================");
			} else { 
				if(driver.findElement(By.className("pageheader")).getText().equals("Oops, sorry!")){
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
				
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//driver.close();
		}
	}
	public void fullcrawl() {

		SteamDAO dao = new SteamDAO();
		ArrayList<SteamVO> list = dao.getAppid();
		try {
			for(int i = 0; i<list.size()-1;i++){

				base_url = "https://store.steampowered.com/app/"+list.get(i).getAppid();
				driver.get(base_url);
				Thread.sleep(5000);

				List<WebElement> element = driver.findElements(By.className("bb_ul"));
				if(element.size()>0){
					String result=null;
					System.out.println("=========================================================================");
					System.out.println(list.get(i).getName()+"의 사양");
					for(WebElement ele : element){ 
						if(ele.getText().contains("Processor")){
							result = ele.getText();
						}
					}
					System.out.println(result);
				} else {
					System.out.println(list.get(i).getName());
					Select age = new Select(driver.findElement(By.id("ageYear")));
	            	age.selectByValue("1999");
	            	System.out.println("시벌");
	            	
            		WebElement temp = driver.findElement(By.xpath("//*[@id='app_agegate']/div[1]/div[4]/a[1]"));

            		System.out.println("탱");
            		temp.click();
            		Thread.sleep(5000);
            		i--;
				}

				System.out.println("=========================================================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}