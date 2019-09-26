package com.test.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
public class Jsoup_spec_Crawling {


	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:/ETC/PROJECT/chromedriver.exe";

	//크롤링 할 URL

	public static void main(String[] args) {

		String url = "https://store.steampowered.com/agecheck/app/261640/"; //크롤링할 url지정
		Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Element> list = doc.select("ul.bb_ul");
		System.out.println(list.size());
		System.out.println("============================================================");
		if(list.size()==0){
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

			//Driver SetUp
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			WebDriver driver = new ChromeDriver(options);
			try {
				
				String result = null;
				JavascriptExecutor js = (JavascriptExecutor)driver;
				driver.get(url);
				//Thread.sleep(2000);
				Select age = new Select(driver.findElement(By.id("ageYear")));
				age.selectByValue("1999");
				js.executeScript("return ViewProductPage()");
				//WebElement temp = driver.findElement(By.xpath("//*[@id='app_agegate']/div[1]/div[4]/a[1]"));
				/*WebElement temp = driver.findElement(By.className("btnv6_blue_hoverfade btn_medium"));
				temp.click();*/
				Thread.sleep(2000);
				String image = driver.findElement(By.className("game_header_image_full")).getAttribute("src");
				System.out.println(image+"\n");
				List<WebElement> element = driver.findElements(By.className("bb_ul"));
				int cnt = 0;
				for(WebElement ele : element){ 
					if(ele.getText().contains("OS")){
							result = ele.getText();
					}
				}
				System.out.println(result);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				driver.close();
			}
		} else {
			System.out.println("Jsoup 사용");
			String image = doc.select("img.game_header_image_full").attr("src");
			System.out.println(image+"\n");

			int cnt = 0;
			for(int i = 0;i<list.size();i++){
				if(list.get(i).text().contains("OS")) {
						if(list.get(i).text().contains("Mac"))
							break;
					cnt = i;
				}
			}
			System.out.println();
			Iterator<Element> ie = list.get(cnt).select("li").iterator();

			while (ie.hasNext()) {
				System.out.println(ie.next().text());
			}
			
		}
		System.out.println("============================================================");
	}
}