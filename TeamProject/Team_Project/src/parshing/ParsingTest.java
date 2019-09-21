package parshing;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ParsingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = null;
		System.out.println(temp.length());
	}
	
	public static void parsing() 
	{
		String url="https://motherboarddb.com/motherboards/?dt=list&so=y&year=2010,2019&page=1";
		try {
			Document doc =Jsoup.connect(url).get();
			org.jsoup.select.Elements element =doc.select("ul.list-unstyled");
			String temp = element.text();
			Iterator<org.jsoup.nodes.Element> test = doc.select("ul.list-unstyled").iterator();
			System.out.println(temp);
			System.out.println("=============================");
			while(test.hasNext()) 
			{
				System.out.println(test.next().text());
			}
			
		}catch(Exception e) 
		{
			System.out.println("error");
		}
	}
	
}
