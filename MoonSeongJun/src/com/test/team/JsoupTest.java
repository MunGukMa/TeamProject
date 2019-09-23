package com.test.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class JsoupTest {

	public static void main(String[] args) {
		// Jsoup를 이용해서 http://www.cgv.co.kr/movies/ 크롤링
		String url = "https://www.cpubenchmark.net/CPU_mega_page.html"; //크롤링할 url지정
		Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> list = new ArrayList<String>();
		//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
		Elements element = doc.select("div").select("table").select("tbody").select("tr").select("td").select("a");    

		System.out.println("============================================================");
		//for(Element test: element) 
		//Iterator을 사용하여 하나씩 값 가져오기
		Iterator<Element> ie1 = element.iterator();
		//System.out.println(test.text());

		//Iterator<Element> ie2 = element.select("strong.title").iterator();
		        
		while (ie1.hasNext()) {
			System.out.println(ie1.next().text());
		}
		
//		while (ie1.hasNext()) {
//			System.out.println(ie1.next().text());
//		}
		
		System.out.println("============================================================");
		
		
	}
}