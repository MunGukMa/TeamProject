package Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import parshing.PowerVO;
 
public class SeleniumTest2 {
 
    public static void main(String[] args) {
        SeleniumTest2 selTest = new SeleniumTest2();
        selTest.crawl();
    }
 
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Programming/2. JAR, WAR/Selenium/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumTest2() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver();
    }
 
    public void crawl() {
    	
    	PowerDAO dao = new PowerDAO();
    	
        try {
        	for(int page = 10127 ; page < 10135 ; page++){ // 10127 ~ 10135
  
            	base_url = "https://search.shopping.naver.com/search/all.nhn?origQuery=%EC%BB%B4%ED%93%A8%ED%84%B0%20%ED%8C%8C%EC%9B%8C&spec=M1863%7CM" + page +
            			"&pagingIndex=1&pagingSize=20&viewType=list&sort=rel&frm=NVSHATT&query=%EC%BB%B4%ED%93%A8%ED%84%B0%20%ED%8C%8C%EC%9B%8C";
            	driver.get(base_url);
                Thread.sleep(5000);
               
                ArrayList<PowerVO> list = new ArrayList<PowerVO>();
   
                By myList = By.className("info");
                List<WebElement> elements = driver.findElements(myList);
                for(WebElement e : elements){ 
                	if(!e.getText().contains("광고")){
                		PowerVO vo = new PowerVO();
                		String[] data = e.getText().split("\n");
	                		
                		// 제품명 data[0]
                		//System.out.println(data[0]);
                		vo.setName(data[0]);
                		
                		// 제품가격 data[1]
                		String[] price = data[1].split("원");
                		if(price[0].contains("최저")){
	                		String[] price1 = price[0].split("저");
	                		//System.out.println(price1[1]);
	                		vo.setPrice(price1[1]);
                		} else {
                			//System.out.println(price[0]);
                			vo.setPower(price[0]);
                		}
                		
                		// 제품규격 data[3]
                		String[] spec = data[3].split("\\|");
                		for(int i = 0 ; i < spec.length ; i++){
                			
                			// 파워 규격
                			if(spec[i].contains("파워 규격")){
                				String[] power = spec[i].split(": ");
                				//System.out.println(power[1]);
                				vo.setPower(power[1]);
                			}
                			
                			// 정격 출력
                			else if(spec[i].contains("정격 출력")){
                				String[] output = spec[i].split(": ");
                				//System.out.println(output[1]);
                				vo.setOutput(output[1]);
                			}
                			
                			// 쿨링팬 크기
                			else if(spec[i].contains("쿨링팬 크기")){
                				String[] fanSize = spec[i].split(": ");
                				//System.out.println(fanSize[1]);
                				vo.setFanSize(fanSize[1]);
                			}
                			
                			// 쿨링팬 개수
                			else if(spec[i].contains("쿨링팬 개수")){
                				String[] fanNum = spec[i].split(": ");
                				//System.out.println(fanNum[1]);
                				vo.setFanNum(fanNum[1]);
                			}
                			
                			// ATX 12V 규격
                			else if(spec[i].contains("ATX 12V 규격")){
                				String[] atx = spec[i].split(": ");
                				//System.out.println(atx[1]);
                				vo.setAtx(atx[1]);
                			}
                			
                			// sata 커넥터
                			else if(spec[i].contains("SATA 커넥터")){
                				String[] sata = spec[i].split(": ");
                				//System.out.println(sata[1]);
                				vo.setSata(sata[1]);
                			}
                			
                			// 커넥터
                			else if(spec[i].contains("커넥터")){
                				String[] connecter = spec[i].split(": ");
                				//System.out.println(connecter[1]);
                				vo.setConnecter(connecter[1]);
                			}
                			
                			// 부가기능
                			else if(spec[i].contains("부가기능")){
                				String[] etc = spec[i].split(": ");
                				//System.out.println(etc[1]);
                				vo.setEtc(etc[1]);
                			}
                		}
                		
                		// 제품등록일 data[?]
                		for(int y = 0 ; y < data.length ; y++){
                			if(data[y].contains("등록일")){
		                		String[] date = data[y].split("록일 ");
		                		String[] date1 = date[1].split("찜하기");
		                		//System.out.println(date1[0]);
		                		vo.setReleaseDate(date1[0]);
                			}
                		}
                		list.add(vo);
                	}	
                }
                dao.insertPower(list);
                /*
                for(PowerVO test : list){
                	System.out.println(test);
                }
                */
        	}
        	
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }
}