package team.hundred.fitc.dao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.ibatis.session.SqlSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import team.hundred.fitc.vo.CpuVO;
import team.hundred.fitc.vo.GpuVO;
import team.hundred.fitc.vo.MainBoardVO;
import team.hundred.fitc.vo.PcVO;
import team.hundred.fitc.vo.RamVO;

@Repository
public class BoardDAO {

	@Autowired
	public SqlSession sqlSession;

	public ArrayList<CpuVO> searchCPU(String cpuname){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.searchCPU(cpuname);
	}

	public ArrayList<MainBoardVO> searchMB(String name){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.searchMB(name);
	}

	public ArrayList<GpuVO> searchGP(String product_name){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.searchGP(product_name);
	}

	public ArrayList<RamVO> searchRAM(String name){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.searchRAM(name);
	}

	public ArrayList<String> tesseract(MultipartFile file){

		ArrayList<String> result = new ArrayList<String>();
		ITesseract tess = new Tesseract();
		tess.setDatapath("C:/Programming/4. Tesseract/tessdata/");
		tess.setLanguage("eng+kor");

		Calendar cal = Calendar.getInstance();
		long todayMil = cal.getTimeInMillis();
		long oneDayMil = 24*60*60*1000;
		Calendar fileCal = Calendar.getInstance() ;
		Date fileDate = null;

		File path = new File("C:/Programming/SpringHome/FitC/src/main/webapp/resources/images/") ;
		File[] list = path.listFiles();

		try{

			File convert = new File(file.getOriginalFilename());
			convert.createNewFile(); 
			FileOutputStream fos = new FileOutputStream(convert); 
			fos.write(file.getBytes());
			fos.close(); 

			// adding random number, length of 5
			int math = (int)(Math.random() * 100000); 
			String resizeImage = "C:/Programming/SpringHome/FitC/src/main/webapp/resources/images/"
					+ file.getName() + "_resized_" + math + ".jpg";
			String machineLearningImage = "C:/Programming/SpringHome/FitC/src/main/webapp/resources/machine/"
					+ file.getName() + "_machineLearning_" + math + ".jpg";

			Image image = ImageIO.read(convert);
			int imageWidth = image.getWidth(null);
			int imageHeight = image.getHeight(null);
			int ratio = 2;
			int resizeWidth = imageWidth * ratio;
			int resizeHeight = imageHeight * ratio;

			Image resized = image.getScaledInstance(resizeWidth, resizeHeight, Image.SCALE_SMOOTH);
			BufferedImage newImage = new BufferedImage(resizeWidth, resizeHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = newImage.getGraphics();
			g.drawImage(resized, 0, 0, null);
			g.dispose();

			ImageIO.write(newImage, "jpg", new File(resizeImage));
			ImageIO.write(newImage, "jpg", new File(machineLearningImage));

			try {

				String str = tess.doOCR(new File(resizeImage));
				String[] split = str.split("\n");

				// CPU
				result.add(split[1]);
				System.out.println(split[1]);

				// Split Check
				for(int i = 0 ; i < split.length ; i++){
					if(split[i].contains("[")){
						// Mainboard
						result.add(split[i]);
						System.out.println(split[i]);
						// Graphics
						result.add(split[i + 2]);
						System.out.println(split[i + 2]);
						// RAM
						String[] ram = split[i + 10].split("GB");
						result.add(ram[0] + "GB" );
						System.out.println(ram[0]);
					}
				}

				return result;

			} catch (TesseractException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		// Image File Delete Method
		for(int j=0 ; j < list.length; j++){
			fileDate = new Date(list[j].lastModified()) ;
			fileCal.setTime(fileDate);
			long diffMil = todayMil - fileCal.getTimeInMillis() ;
			int diffDay = (int)(diffMil/oneDayMil) ;
			if(diffDay > 7 && list[j].exists()){
				list[j].delete() ;
			}
		}

		return result;
	}
	public PcVO lowestPrice(PcVO vo){
		WebDriver driver;

		String WEB_DRIVER_ID = "webdriver.chrome.driver";
		String WEB_DRIVER_PATH = "D:/ETC/PROJECT/chromedriver.exe";

		//크롤링 할 URL
		String cpu_url = "http://prod.danawa.com/list/?cate=113973";
		String gpu_url = "http://prod.danawa.com/list/?cate=112753";
		String ram_url = "http://prod.danawa.com/list/?cate=1131326";
		String motherboard_url = "http://prod.danawa.com/list/?cate=112751";
		String case_url = "http://prod.danawa.com/list/?cate=112775";
		String power_url = "http://prod.danawa.com/list/?cate=112777";

		PcVO lowest = new PcVO();
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		driver = new ChromeDriver(options);
		
		String[] parts = {vo.getCpu(), vo.getRam(),vo.getGpu(),vo.getMainboard(), vo.getPower(), vo.getPc_case()};
		String[] url = {cpu_url, ram_url, gpu_url, motherboard_url,power_url,case_url};
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i<3;i++){
			try {

				System.out.println("=========================================================================");
				driver.get(url[i]);

				Thread.sleep(750);

				System.out.println(parts[i]);
				driver.findElement(By.className("search_input")).sendKeys(parts[i]);
				driver.findElement(By.className("submit_search_list")).click();

				Thread.sleep(750);

				driver.findElement(By.xpath("//*[@id='productListArea']/div[2]/div[1]/ul/li[3]/a")).click();

				Thread.sleep(750);
				WebElement element  = driver.findElement(By.className("price_sect"));

				String[] price = element.getAttribute("innerHTML").split("strong");
				
				System.out.println(price[1].substring(1, price[1].length()-2));
				result.add(price[1].substring(1, price[1].length()-2));

				System.out.println("=========================================================================");

			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		lowest.setCpu(result.get(0));
		lowest.setRam(result.get(1));
		lowest.setGpu(result.get(2));
		/*lowest.setMainboard(result.get(3));
		lowest.setPower(result.get(4));
		lowest.setPc_case(result.get(5));*/
		System.out.println(lowest);
		driver.close();
		return lowest;
	}

}
