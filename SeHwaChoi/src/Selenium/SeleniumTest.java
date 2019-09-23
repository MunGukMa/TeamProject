package Selenium;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import parshing.MainBoardVO;
 
public class SeleniumTest {
 
    public static void main(String[] args) {
        SeleniumTest selTest = new SeleniumTest();
        selTest.crawl();
    }
 
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Programming/2. JAR, WAR/Selenium/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumTest() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver();
    }
 
    public void crawl() {
    	
    	MainBoardDAO dao = new MainBoardDAO();
    	
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
        	for(int page = 1 ; page < 84 ; page++){
  
            	base_url = "https://motherboarddb.com/motherboards/?dt=list&so=y&year=2010,2019&page=" + page;
            	driver.get(base_url);
                Thread.sleep(5000);
               
                ArrayList<MainBoardVO> list = new ArrayList<MainBoardVO>();
                
                String pagesize = driver.findElement(By.xpath("//*[@id='table-wrapper']/div[1]/div[1]/ul/li[2]")).getText();
                String[] tempp = pagesize.split("-");
                String[] temppp = tempp[0].split(" ");
                String[] tempppp = tempp[tempp.length - 1].split(" ");
                int startnum = Integer.parseInt(temppp[temppp.length - 1]);
                int endnum = Integer.parseInt(tempppp[tempppp.length - 3]);
                
                for(int num = 2 ; num < endnum - startnum + 3 ; num++){
                	
                	MainBoardVO vo = new MainBoardVO();
                	
                	//메인보드 제품명	
	                String name = driver.findElement(By.xpath("//*[@id='table-wrapper']/div[" + num + "]/div[2]/div[1]/a/h4")).getText();
	                vo.setName(name);
	                
	                //제품정보1
	                String info1 = driver.findElement(By.xpath("//*[@id='table-wrapper']/div[" + num + "]/div[2]/div[2]/div[1]/ul")).getText();
	                String[] data1 = info1.split("\n");
	                for(int x = 0 ; x < data1.length ; x++){
	                	String[] result = data1[x].split(":");
	                	for(int y = 0 ; y < result.length; y++){
		                	if(result.length == 2 && result[y].contains("Socket(s)")){
		                		vo.setSockets(result[y+1]);
		                	} else if(result.length == 1 && result[y].contains("Socket(s)")){
		                		vo.setSockets("NA");
	                		} else if(result.length == 2 && result[y].contains("Form Factor")){
		                		vo.setFormFactor(result[y+1]);
		                	} else if(result.length == 1 && result[y].contains("Form Factor")){
		                		vo.setFormFactor("NA");
		                	} else if(result.length == 2 && result[y].contains("Chipset")){
		                		vo.setChipSet(result[y+1]);
		                	} else if(result.length == 1 && result[y].contains("Chipset")){
		                		vo.setChipSet("NA");
		                	} else if(result.length == 2 && result[y].contains("RAM")){
		                		vo.setRAM(result[y+1]);
		                	} else if(result.length == 1 && result[y].contains("RAM")){
		                		vo.setRAM("NA");
		                	} else if(result.length == 2 && result[y].contains("Release Year")){
		                		vo.setReleaseDate(result[y+1]);
		                	} else if(result.length == 1 && result[y].contains("Release Year")){
		                		vo.setReleaseDate("NA");
		                	} else {

		                	}
	                	}
	                }
            
            		//제품정보2
	                String info2 = driver.findElement(By.xpath("//*[@id='table-wrapper']/div[" + num + "]/div[2]/div[2]/div[2]")).getText();
	                String[] data2 = info2.split("\n");
	                for(int x = 0 ; x < data2.length ; x++){
	                	String[] result = data2[x].split(":");
	                	for(int y = 0 ; y < result.length; y++){
	                		if(result.length == 2 && result[y].contains("Audio Chip")){
		                		vo.setAudioChip(result[y+1]);
		                	} else if(result.length == 1 && result[y].contains("Audio Chip")){
		                		vo.setAudioChip("NA");
	                		} else if(result.length == 2 && result[y].contains("USB 2.0 Header")){
		                		vo.setUsb2(result[y+1]);
		                	} else if(result.length == 1 && result[y].contains("USB 2.0 Header")){
		                		vo.setUsb2("NA");
		                	} else if(result.length == 2 && result[y].contains("USB 3.0 Header")){
		                		vo.setUsb3(result[y+1]);
		                	} else if(result.length == 1 && result[y].contains("USB 3.0 Header")){
		                		vo.setUsb3("NA");
		                	} else if(result.length == 2 && result[y].contains("SATA3")){
		                		vo.setSata(result[y+1]);
		                	} else if(result.length == 1 && result[y].contains("SATA3")){
		                		vo.setSata("NA");
		                	} else {

		                	}
	                	}
	                } // last for end
	                list.add(vo);
	        	} // second for end       
                dao.insertMainBoard(list);
        	} // first for end
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        } // first try end
    } // class end
}