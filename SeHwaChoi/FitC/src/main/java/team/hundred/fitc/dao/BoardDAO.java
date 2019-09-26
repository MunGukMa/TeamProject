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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Repository
public class BoardDAO {

	@Autowired
	public SqlSession sqlSession;
	
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
												+ file.getName() + "_resized" + math + ".jpg";
			
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

			try {
				
				String str = tess.doOCR(new File(resizeImage));
				String[] split = str.split("\n");

				// Split Check
				for(int i = 0 ; i < split.length ; i++){
					result.add(split[i]);
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
}
