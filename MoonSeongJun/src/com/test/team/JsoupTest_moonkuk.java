package com.test.team;

import java.io.IOException;
import java.util.ArrayList;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupTest_moonkuk {

	
	public static void main(String[] args) 
	{
		ArrayList<ParsingVO> templist = new ArrayList<ParsingVO>();
		for(int pcode = 6066000;pcode<6066500;pcode++) {
			System.out.println(pcode);
			String url="http://prod.danawa.com/info/?pcode="+pcode+"&cate=112747#bookmark_product_information";
			try {
				ParsingVO testvo = new ParsingVO();
				Document doc =Jsoup.connect(url).get();
				org.jsoup.select.Elements element =doc.select("div.items");
				org.jsoup.select.Elements name = doc.select("h3.prod_tit");
				testvo.setName(name.text());
				String tempstr = element.text();
				String[] temp = tempstr.split(" / ");
				String addmemo = "";
				for(int i = 0;i<temp.length;i++ ) 
				{ 
					if(temp[i].length()>2) {
						if(temp[i].contains("소켓")) 
						{
							testvo.setCsocket(temp[i]); 
						}else if(temp[i].substring(temp[i].length()-2).equals("nm")) 
						{ 
							testvo.setCprocess(temp[i]); 
						} else if(temp[i].substring(temp[i].length()-2).equals("코어")) 
						{ 
							testvo.setCore(temp[i]); 
						}else if(temp[i].contains("쓰레드")) 
						{ 
							testvo.setThread(temp[i]); 
						}else if(temp[i].substring(temp[i].length()-3).equals("GHz")) 
						{ 
							testvo.setClock(temp[i]); 
						}else if(temp[i].contains("KB")) 
						{ 
							testvo.setL2memory(temp[i]); 
						}else if(temp[i].contains("MB")) 
						{ 
							testvo.setL3memory(temp[i]); 
						}else if(temp[i].substring(temp[i].length()-2).equals("비트")) 
						{ 
							testvo.setBit(temp[i]); 
						}else if(temp[i].substring(temp[i].length()-1).equals("W")) 
						{ 
							testvo.setPower(temp[i]); 
						}else if(temp[i].contains("HD")) 
						{ 
							testvo.setIngraphic(temp[i]); 
						}else if(temp[i].substring(temp[i].length()-3).equals("MHz")) 
						{ 
							testvo.setCorespeed(temp[i]); 
						}else if(temp[i].contains("DDR")) 
						{ 
							testvo.setDdrtype(temp[i]); 
						} else 
						{
							addmemo= addmemo+temp[i]+"/";
						};// if3 end
					};//if2 end
				}; // for2 end
				testvo.setMore(addmemo);
				if(testvo.getCsocket()!=null&&testvo.getCprocess()!=null) 
				{
					templist.add(testvo);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} //for end
		for(ParsingVO tmp:templist) 
		{
			System.out.println(tmp);
		}
		
	}

	
	
	
}
