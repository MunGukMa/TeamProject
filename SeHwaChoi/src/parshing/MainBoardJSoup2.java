package parshing;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainBoardJSoup2 {

	public static void main(String[] args) {
		parsing();
	}

	public static void parsing() {
	   for(int pcode = 1 ; pcode < 2 ; pcode++){
		   try {
				  String url = "https://motherboarddb.com/motherboards/?dt=list&so=y&year=2010,2019&page=" + pcode + "/";
				  Document doc = Jsoup.connect(url).get();
				  
				  System.out.println(doc);
				  
				  Elements element = doc.select("div#table-wrapper");

				  System.out.println("?");
				  
				  for (Element e : element) {
					  System.out.println(e.text());
				  }
				  
				  System.out.println("ㄴㄷ");
		   } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
		   }
		}
	}
}