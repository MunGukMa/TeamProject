package team.hundred.fitc.dao;

import java.io.File;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Repository
public class BoardDAO {

	@Autowired
	public SqlSession sqlSession;
	
	public String tesseract(File formData){

		ITesseract tess = new Tesseract();
		tess.setDatapath("C:/Programming/4. Tesseract/tessdata/");
		tess.setLanguage("eng+kor");
		String str = null;

		try {
			str = tess.doOCR(formData);
			return str;
		} catch (TesseractException e) {
			e.printStackTrace();
		}
		return str;
	}
}
