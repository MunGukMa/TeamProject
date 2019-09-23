package com.test.team;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CompareParsingTest {

	public static void main(String[] args) {

		CompareParsingTest selTest = new CompareParsingTest();
		selTest.crawl();

	}

	private WebDriver driver;
	//WebDriver

	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:/ETC/PROJECT/chromedriver.exe";

	//크롤링 할 URL
	private String base_url;

	public CompareParsingTest() {
		super();

		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		//Driver SetUp
		driver = new ChromeDriver(options);
		base_url = "https://gpu.userbenchmark.com";
	}

	public void crawl() {

		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			//get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
			driver.get(base_url);
			/*WebElement element = driver.findElement(By.name("productName"));
            System.out.println(element.getText());*/


				/*WebElement test = driver.findElement(By.xpath("//*[@id='tableDataForm:j_idt286']"));
            test.click();*/
				Thread.sleep(3000);
				List<WebElement> element = driver.findElements(By.className("semi-strongs lighterblacktexts"));
				System.out.println("=========================================================================");
				for(WebElement ele : element) 
					System.out.println(ele.getAttribute("a href"));
				
				System.out.println("=========================================================================");
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			driver.close();
		}

	}

}
