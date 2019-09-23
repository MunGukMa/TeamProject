package com.test.team;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RamDanawaCrawling {

	public static void main(String[] args) {

		RamDanawaCrawling selTest = new RamDanawaCrawling();
		selTest.crawl();

	}

	private WebDriver driver;
	//WebDriver

	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:/ETC/PROJECT/chromedriver.exe";

	//크롤링 할 URL
	private String base_url;

	public RamDanawaCrawling() {
		super();

		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		//Driver SetUp
		driver = new ChromeDriver();
		base_url = "http://prod.danawa.com/list/?cate=1131326&15main_11_03";
	}

	public void crawl() {

		try {
			int page=1;
			JavascriptExecutor js = (JavascriptExecutor)driver;
			//get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
			driver.get(base_url);
			/*WebElement element = driver.findElement(By.name("productName"));
            System.out.println(element.getText());*/
			while(true) {
				if(page>=2)
					js.executeScript("return movePage("+page+")");

				/*WebElement test = driver.findElement(By.xpath("//*[@id='tableDataForm:j_idt286']"));
            test.click();*/
				Thread.sleep(5000);
				List<WebElement> element = driver.findElements(By.className("prod_name"));
				if(element == null) break;
				System.out.println("=========================================================================");
				System.out.println("--"+page+" 페이지--");
				for(WebElement ele : element) 
					System.out.println(ele.getText());
				
				System.out.println("=========================================================================");
				page++;
			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			driver.close();
		}

	}

}
