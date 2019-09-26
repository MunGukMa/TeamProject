package com.test.team;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

	public static void main(String[] args) {

		SeleniumTest selTest = new SeleniumTest();
		selTest.crawl();

	}

	private WebDriver driver;
	//WebDriver

	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:/ETC/PROJECT/chromedriver.exe";

	//크롤링 할 URL
	private String base_url;

	public SeleniumTest() {
		super();

		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		//Driver SetUp
		driver = new ChromeDriver(options);
		base_url = "https://cpu.userbenchmark.com/";
	}

	public void crawl() {

		try {
			// JavascriptExecutor js = (JavascriptExecutor)driver;
			//get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
			driver.get(base_url);
			/*WebElement element = driver.findElement(By.name("productName"));
            System.out.println(element.getText());*/

			//js.executeScript("return movePage(2)");

			/*WebElement test = driver.findElement(By.xpath("//*[@id='tableDataForm:j_idt286']"));
            test.click();*/
			Thread.sleep(2000);
			WebElement col = driver.findElement(By.xpath("//*[@id='tableDataForm:mhtddyntac']/table"));
			//List<WebElement> list = driver.findElements(By.xpath("//*[@id='tableDataForm:mhtddyntac']/table"));
			WebElement element = driver.findElement(By.xpath("//*[@id='tableDataForm:j_idt286']"));
			element.click();
			List<WebElement> list = col.findElements(By.className("smallp"));
			System.out.println(list.size());
			ArrayList<String> temp = new ArrayList<>();
			int cnt = 0;
			for(WebElement ele : list) {
				String result = ele.findElement(By.className("nodec")).getAttribute("href");
				System.out.println(++cnt+" "+result);
				String[] rating = result.split("/");
				if(result.contains("Rating")){
					System.out.println(rating[3]+" : "+rating[5]);
				} else {
					String cpu_name = "";
					if(rating[5].contains("AMD")){
						String[] amd = rating[5].split("-");
						int index = 0;
						if(rating[5].contains("with")) {
							for(int i = 0; i<amd.length;i++){
								cpu_name+=amd[i];
								if(amd[i+1].contains("with"))
									break;
								cpu_name+="-";
							}
						} else
							cpu_name = amd[0]+"-"+amd[1]+"-"+amd[2]+"-"+amd[3];
					} else if(rating[5].contains("Intel")){
						String[] intel = rating[5].split("-");
						cpu_name = intel[0]+"-"+intel[1]+"-"+intel[2]+"-"+intel[3];
					}

					System.out.println(cpu_name+" : m"+rating[4]);
				}
				System.out.println();
			}



		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			driver.close();
		}

	}

}
