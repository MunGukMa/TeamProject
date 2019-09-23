package com.test.team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ParshingTest 
{
	static URL url=null;
	static URLConnection conn=null;
	
	public static void main(String[] args) 
	{
		ArrayList<ParsingVO> testlist = new ArrayList<ParsingVO>();
		
		try {
		for(int j = 6066000;j<6066500;j++) 
		{
			System.out.println(j);
			url = new URL("http://prod.danawa.com/info/?pcode="+j+"&cate=112747#bookmark_product_information");
			conn= url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String addmemo = "[추가] "; 
			addmemo.concat("dd");
			char[] buff = new char[512];
			int len = -1;
			
			ParsingVO testvo = new ParsingVO();
			while(br.ready()) 
			{
				String s = br.readLine();
				if(s.contains("\"Description\" content")) 
				{
					String name = s.substring(s.lastIndexOf("=\"")+2,s.indexOf("가격비교"));
					testvo.setName(name);
					int targetnum = s.indexOf("요약정보 : ")+6;
					int lastnum = s.length()-4;
					s= s.substring(targetnum+1,lastnum);
					String[] temp = s.split(" / ");
					for(int i = 0;i<temp.length;i++ ) 
					{ 
						/* temp[i]=temp[i].substring(0, temp[i].indexOf("<")); */
						if(temp[i].length()>3) {
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
							};// if2 end
						}
					}; // for2 end
					
					testvo.setMore(addmemo);
					
				};//if1 end
				
			}; //while end
			
				if(testvo.getCsocket()!=null&&testvo.getCprocess()!=null) 
				{
					testlist.add(testvo);
				}
			 };  //for1 end
			 
			for(int t =0;t<testlist.size();t++) 
			{
				System.out.println(testlist.get(t)); 
			}
			 
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
