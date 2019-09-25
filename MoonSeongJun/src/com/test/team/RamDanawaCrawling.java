package com.test.team;

import java.util.List;
import java.util.NoSuchElementException;
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
		driver = new ChromeDriver(options);
		base_url = "http://prod.danawa.com/list/?cate=1131326&15main_11_03";
	}

	public void crawl() {

		try {
			int page=1;
			String name = null;
			String spec = null;
			String src_link = null;
			JavascriptExecutor js = (JavascriptExecutor)driver;
			driver.get(base_url);

			while(true) {
				js.executeScript("return movePage("+page+")");

				Thread.sleep(3000);
				List<WebElement> element = driver.findElements(By.className("prod_main_info"));
				
				System.out.println("=========================================================================");
				System.out.println("--"+page+" 페이지--");


				for(WebElement ele : element){
					try {
						if(ele.findElement(By.name("productName")).getText().length()>5){
							name = ele.findElement(By.name("productName")).getText();
						spec = ele.findElement(By.className("spec_list")).getText();
						src_link = ele.findElement(By.className("image_lazy")).getAttribute("data-original");
						System.out.println(name);
						System.out.println(spec);
						System.out.println(src_link);
						System.out.println();
						}
					} catch (Exception e) {
					}
				}
				System.out.println("=========================================================================");
				page++;
				if(page==31)
					break;
			}
		} catch (Exception e) {

			//e.printStackTrace();

		} finally {

			//driver.close();
		}
		driver.close();

	}

}
