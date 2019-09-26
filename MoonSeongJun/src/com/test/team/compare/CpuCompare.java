package com.test.team.compare;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CpuCompare {

	public static void main(String[] args) {

		CpuCompare selTest = new CpuCompare();
		selTest.crawl();

	}

	private WebDriver driver;
	//WebDriver

	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:/ETC/PROJECT/chromedriver.exe";

	//크롤링 할 URL
	private String base_url;

	public CpuCompare() {
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
			ArrayList<CpuCompareVO> vo_list = new ArrayList<>();
			int cnt = 0;
			int num = 0;
			int page = 1;
			driver.get(base_url);

			Thread.sleep(3000);
			while(page<25){
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
						vo_list.add(new CpuCompareVO(++num,rating[3],rating[5]));
					} /*else {
						String cpu_name = "";
						if(rating[5].contains("AMD")){
							String[] amd = rating[5].split("-");
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
						vo_list.add(new CpuCompareVO(++num,cpu_name,"m"+rating[4]));
					}*/
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
