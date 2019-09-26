package team.hundred.fitc.dao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

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
		
		/*
		Calendar cal = Calendar.getInstance();
		long todayMil = cal.getTimeInMillis();
		long oneDayMil = 24*60*60*1000;
		Calendar fileCal = Calendar.getInstance() ;
		Date fileDate = null;

		File path = new File("C:/Programming/SpringHome/FitC/src/main/webapp/resources/images/") ;
		File[] list = path.listFiles();
		*/
		
		try{
			System.out.println("저장시작");
			File convert = new File(file.getOriginalFilename());
			convert.createNewFile(); 
		    FileOutputStream fos = new FileOutputStream(convert); 
		    fos.write(file.getBytes());
		    fos.close(); 
		    
			String resizeImage = "C:/Programming/SpringHome/FitC/src/main/webapp/resources/images/"
												+ file.getName() + "_resized.jpg";
			
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
			System.out.println("저장종료");
			try {
				System.out.println("리딩시작");
				String str = tess.doOCR(new File(resizeImage));
				System.out.println("리딩중");
				String[] split = str.split("\n");
				result.add(split[1]); // cpu
				result.add(split[2]); // mainboard
				result.add(split[4]); // vga
				result.add(split[8]); // ram
				
				for(int i =0;i<split.length;i++)
				{
					System.out.println(split[i]);
				}
				
				
				System.out.println("리딩종료");
				return result;
				
			} catch (TesseractException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		/*
		for(int j=0 ; j < list.length; j++){
		    fileDate = new Date(list[j].lastModified()) ;
		    fileCal.setTime(fileDate);
		    long diffMil = todayMil - fileCal.getTimeInMillis() ;
		    int diffDay = (int)(diffMil/oneDayMil) ;
		    if(diffDay > 7 && list[j].exists()){
		        list[j].delete() ;
		    }
		}
		*/
		return result;
	}
}
