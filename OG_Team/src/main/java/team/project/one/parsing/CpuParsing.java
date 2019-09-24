import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import javax.swing.plaf.SliderUI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CpuParsing {

	
	public static void main(String[] args) 
	{
    for(int i = 2011;i<2020;i++)
    {
      parsing(i);
    }
	}

	public static void parsing(int year) 
	{
		ArrayList<TechCpuVO> cpulist = new ArrayList<TechCpuVO>();
		String url="https://www.techpowerup.com/cpudb/?released="+year+"&mobile=No&server=No&sort=name";
		try {
			Document doc =Jsoup.connect(url).get();
			org.jsoup.select.Elements element =doc.select("thead ~ tbody");
			String temp = element.text();
			Iterator<org.jsoup.nodes.Element> test = doc.select("td").iterator();
			
			int count =0;
			TechCpuVO vo = new TechCpuVO();
			while(test.hasNext()) 
			{
				switch (count) {
				case 0: 
					vo.setCpuname(test.next().text());
					count++;
					break;
				case 1: 
					vo.setCpucode(test.next().text());
					count++;
					break;
				case 2: 
					vo.setCores(test.next().text());
					count++;
					break;
				case 3: 
					vo.setClock(test.next().text());
					count++;
					break;
				case 4: 
					vo.setSocket(test.next().text());
					count++;
					break;
				case 5: 
					vo.setProcess(test.next().text());
					count++;
					break;
				case 6: 
					vo.setL3cache(test.next().text());
					count++;
					break;
				case 7: 
					vo.setTdp(test.next().text());
					count++;
					break;
				case 8:
					vo.setReleased(test.next().text());
					cpulist.add(vo);
					vo=new TechCpuVO();
					count=0;
					break;
				default:
					break;
				}	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ParshingServ serv = new ParshingServ();
		serv.setTech(cpulist);
		cpulist = serv.gettechlist();
		for(TechCpuVO tempvo:cpulist) 
		{
			System.out.println(tempvo);
		}
	}
}
