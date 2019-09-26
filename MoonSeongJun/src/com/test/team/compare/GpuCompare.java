package com.test.team.compare;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GpuCompare {

	public static void main(String[] args) {

		GpuCompare selTest = new GpuCompare();
		selTest.crawl();

	}

	private WebDriver driver;
	//WebDriver

	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:/ETC/PROJECT/chromedriver.exe";

	//크롤링 할 URL
	private String base_url;

	public GpuCompare() {
		super();

		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		//Driver SetUp
		driver = new ChromeDriver(options);
		base_url = "https://gpu.userbenchmark.com/";
	}

	public void crawl() {

		try {
			ArrayList<GpuCompareVO> vo_list = new ArrayList<>();
			int cnt = 0;
			int num = 0;
			int page = 1;
			driver.get(base_url);

			Thread.sleep(3000);
			while(page<14){
				if(page!=1){
					WebElement element = driver.findElement(By.xpath("//*[@id='tableDataForm:j_idt286']"));
					element.click();
				}
				Thread.sleep(3000);
				WebElement col = driver.findElement(By.xpath("//*[@id='tableDataForm:mhtddyntac']/table"));

				List<WebElement> list = col.findElements(By.className("smallp"));
				System.out.println("==================================================================");
				System.out.println(page + " : "+list.size());
				for(WebElement ele : list) {
					String result = ele.findElement(By.className("nodec")).getAttribute("href");
					//System.out.println(++cnt+" "+result);
					String[] rating = result.split("/");
					if(result.contains("Rating")){
						System.out.println(++cnt+" "+result);
						System.out.println(rating[3]+" : "+rating[5]);
						vo_list.add(new GpuCompareVO(++num,rating[3],rating[5]));
					} 
				}
				System.out.println("==================================================================");
				page++;
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			driver.close();
		}

	}

}
