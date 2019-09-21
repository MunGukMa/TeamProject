package sesoc.global.web.parsing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import sesoc.global.web.vo.NaverCaseVO;
import sesoc.global.web.vo.TechCpuVO;

public class Parsing 
{
	
	public static void caseParsing() 
	{
		String url="https://search.shopping.naver.com/search/all.nhn?origQuery=%EC%BB%B4%ED%93%A8%ED%84%B0%20%EC%BC%80%EC%9D%B4%EC%8A%A4&pagingIndex=1&pagingSize=80&viewType=list&sort=rel&cat_id=50001621&frm=NVSHCAT&query=%EC%BB%B4%ED%93%A8%ED%84%B0%20%EC%BC%80%EC%9D%B4%EC%8A%A4";
		
		try {
			Document doc =Jsoup.connect(url).get();
			Iterator<Element> element =doc.select("ul.goods_list div.info").iterator();
			ArrayList<NaverCaseVO> caselist = new ArrayList<NaverCaseVO>();
			while(element.hasNext()) 
			{
				String temp = element.next().text();
				if(!temp.contains("광고")) 
				{
					NaverCaseVO tempvo = new NaverCaseVO();
					String[] tempname = null;
					tempname= temp.split("최저");
					String casename = tempname[0];
					String[] temprowprice = tempname[1].split("원 판");
					String rowprice = temprowprice[0];
					String[] addop = temprowprice[1].split("PC케이스 ");
					String[] plusop = addop[1].split("\\|");
					tempvo.setCasename(casename);
					tempvo.setRowprice(rowprice);
					String casesize = null;
					String tempcasesize = null;
					String tempaddop = null;
					for(int i=0;i<plusop.length-1;i++) 
					{
						if(plusop[i].contains("파워규격")) 
						{
							String[] tmlist = plusop[i].split(" : ");
							tempvo.setPower(tmlist[tmlist.length-1]);
							
						}else if(plusop[i].contains("메인보드 규격")) 
						{
							String[] tmlist = plusop[i].split(" : ");
							tempvo.setMainboardsize(tmlist[tmlist.length-1]);
							
						}else if(plusop[i].contains("케이스 크기")||plusop[i].contains("품목")) 
						{
							String[] tmlist = plusop[i].split(" : ");
							casesize = tmlist[tmlist.length-1];
						} else if(plusop[i].startsWith("폭")||plusop[i].startsWith("높")||plusop[i].startsWith("깊")) 
						{
							if(tempcasesize!=null) 
							{
								tempcasesize = tempcasesize+" / "+plusop[i];
							}else 
							{
								tempcasesize = " "+plusop[i];
							}
						} else 
						{
							if(tempaddop!=null) 
							{
								tempaddop = tempaddop+"/"+plusop[i];
							} else 
							{
								tempaddop = plusop[i];
							}
						}
					}
					if(!plusop[plusop.length-1].contains(" : ")) 
					{
						String[] tmlist =  plusop[plusop.length-1].split(" 리");
						if(tmlist[0].contains(", ")) 
						{
							tmlist[0] = tmlist[0].replaceAll(" ", "");
							tmlist[0] = tmlist[0].replaceAll(",", "/");
						}
						tempvo.setMainboardsize(tempvo.getMainboardsize()+"/"+tmlist[0]);
					}
					if(tempcasesize!=null) 
					{
						tempvo.setCasesize(casesize+tempcasesize);
					} else 
					{
						tempvo.setCasesize(casesize);
					}
					tempvo.setAddop(tempaddop);
					caselist.add(tempvo);
					System.out.println(tempvo);
					System.out.println();
				}
			}
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void cpuParsing(int year) 
	{
		ArrayList<TechCpuVO> cpulist = new ArrayList<TechCpuVO>();
		String url="https://www.techpowerup.com/cpudb/?released="+year+"&mobile=No&server=No&sort=name";
		try {
			Document doc =Jsoup.connect(url).get();
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
		for(TechCpuVO tempvo:cpulist) 
		{
			System.out.println(tempvo);
		}
	}
	
	
}
