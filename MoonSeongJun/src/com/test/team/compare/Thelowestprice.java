package com.test.team.compare;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.test.team.RamVO;

public class Thelowestprice {
	private WebDriver driver;

	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:/ETC/PROJECT/chromedriver.exe";

	//크롤링 할 URL
	private static String cpu_url;
	private static String gpu_url;
	private static String ram_url;
	private static String motherboard_url;
	private static String case_url;
	private static String power_url;
	
	public static void main(String[] args) {

		String Cpu = "i9-9세대 9900K";
		String Gpu = "RTX 2080 Ti";
		String Motherboard = "";
		String Ram = "";
		String Power = "";
		String Case = "";
		
		Thelowestprice selTest = new Thelowestprice();
		
		try {
			selTest.crawl(Cpu, cpu_url);
			Thread.sleep(500);
			selTest.crawl(Gpu, gpu_url);
			Thread.sleep(500);
			selTest.crawl(Motherboard, ram_url);
			Thread.sleep(500);
			selTest.crawl(Ram, motherboard_url);
			Thread.sleep(500);
			selTest.crawl(Power, power_url);
			Thread.sleep(500);
			selTest.crawl(Case, case_url);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Thelowestprice() {
		super();

		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		//Driver SetUp
		driver = new ChromeDriver();
		cpu_url = "http://prod.danawa.com/list/?cate=113973";
		gpu_url = "http://prod.danawa.com/list/?cate=112753";
		ram_url = "http://prod.danawa.com/list/?cate=1131326";
		motherboard_url = "http://prod.danawa.com/list/?cate=112751";
		case_url = "http://prod.danawa.com/list/?cate=112775";
		power_url = "http://prod.danawa.com/list/?cate=112777";
	}

	public void crawl(String part, String url) {

		try {

			System.out.println("=========================================================================");
			driver.get(url);

			Thread.sleep(500);

			System.out.println(part);
			driver.findElement(By.className("search_input")).sendKeys(part);
			driver.findElement(By.className("submit_search_list")).click();

			Thread.sleep(500);

			driver.findElement(By.xpath("//*[@id='productListArea']/div[2]/div[1]/ul/li[3]/a")).click();
			Thread.sleep(500);
			WebElement element  = driver.findElement(By.className("price_sect"));

			//for(WebElement ele : element)
			String[] price = element.getAttribute("innerHTML").split("strong");
			System.out.println(price[1].substring(1, price[1].length()-2));

			System.out.println("=========================================================================");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			//driver.close();
		}

	}

}
