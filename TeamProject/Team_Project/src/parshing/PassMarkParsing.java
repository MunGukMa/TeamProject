package parshing;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PassMarkParsing {

	public static void main(String[] args) 
	{
		parsing();
		/*
		 * Scanner scan = new Scanner(System.in); System.out.print("CPU �𵨸� : "); String
		 * model = scan.next(); String result = test(model); if(result!=null)
		 * System.out.println("BenchMark : "+ result);
		 */
	}

	public static void parsing() {
		String url = "https://www.cpubenchmark.net/CPU_mega_page.html";
		try {
			Document doc = Jsoup.connect(url).get();
			ArrayList<Element> tempplist = doc.select("table#cputable td");
			ArrayList<PMCpuVO> cpulist = new ArrayList<PMCpuVO>(); 
			int count = 1; 
			PMCpuVO tmvo = new PMCpuVO(); 
			for (Element em : tempplist) 
			{ 
				switch (count) 
				{ 
				case 1:
					tmvo.setCpuname(em.text()); 
					count++; 
					break; 
				case 2: 
					tmvo.setPrice(em.text());
					count++; 
					break; 
				case 3: 
					tmvo.setCpuMark(em.text()); 
					count++; 
					break; 
				case 4:
					tmvo.setCpuval(em.text()); 
					count++; 
					break; 
				case 5:
					tmvo.setThreadMark(em.text()); 
					count++; 
					break; 
				case 6:
					tmvo.setThreadVal(em.text()); 
					count++; 
					break; 
				case 7: 
					tmvo.setTdp(em.text());
					count++; 
					break; 
				case 8: 
					tmvo.setPowerf(em.text()); 
					count++; 
					break; 
				case 9:
					tmvo.setDate(em.text()); 
					count++; 
					break; 
				case 10: 
					tmvo.setSocket(em.text());
					count++; 
					break; 
				case 11: 
					tmvo.setCategory(em.text()); 
					count++; 
					break; 
				case 12: 
					String[] tmpstr = em.text().split("Rank: "); 
					String[] tmppstr =tmpstr[tmpstr.length - 1].split(" "); 
					if(isNum(tmppstr[0])) 
					{
						tmvo.setRank(tmppstr[0]); 
					} else 
					{ 
						tmvo.setRank("NA"); 
					} 
					cpulist.add(tmvo);
					count = 1; 
					tmvo = new PMCpuVO(); 
					break; 
				default:
					System.out.println("!!!!!!!!!!!!!!!!!!DEFAULT!!!!!!!!!!!!!!!!!"); 
				} 
			}
			readfile(cpulist);
			/*
			 * ParshingServ serv = new ParshingServ(); serv.setPM(cpulist);
			 */
			System.out.println("end!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean isNum(String str) 
	{
		try 
		{
			Double.parseDouble(str);
			return true;
		} catch(Exception e) 
		{
			return false;
		}
	}

	public static void readfile(ArrayList<PMCpuVO> vo) 
	{
		System.out.println(vo.get(0));
		File file = new File("C:\\test\\test.txt");
		OutputStream out = null;
		BufferedOutputStream bf = null;
		ObjectOutputStream oos = null;
		try 
		{
			out = new FileOutputStream(file,false);
			String enter = "\r\n";
			for(int i = 0; i<vo.size();i++) 
			{
				out.write(vo.get(i).getCpuname().toString().getBytes());
				out.write(enter.getBytes());
			}
			System.out.println("ok");
			out.close();

		} catch(Exception e) 
		{
			e.printStackTrace();
		}


	}


	public static String test(String model) 
	{
		String url = "https://www.cpubenchmark.net/cpu.php?cpu="+model+"+%40";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements tempplist = doc.select("span");
			for(Element tl : tempplist) 
			{
				String style = tl.attr("style");
				if(style.contains("bold; color: red;")) 
				{ 
					return tl.text();
				} 
			}
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

}
