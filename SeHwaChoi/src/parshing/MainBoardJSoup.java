package parshing;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainBoardJSoup {
	public static void main(String[] args) {
		ArrayList<MainBoardVO> templist = new ArrayList<MainBoardVO>();
		for(int pcode = 0 ; pcode < 2000 ; pcode++) {
			String url="https://motherboarddb.com/motherboards/?dt=list&so=y&year=2010,2019&page=" + pcode + "/";
			try {
				MainBoardVO testvo = new MainBoardVO();
				Document doc =Jsoup.connect(url).get();
				
				
				org.jsoup.select.Elements element =doc.select("div.row");
				org.jsoup.select.Elements name = doc.select("div.row.mb-1");
				testvo.setName(name.text());
				String tempstr = element.text();
				String[] temp = tempstr.split(" / ");
				String addmemo = "";
/*				
				for(int i = 0 ; i < temp.length ; i++ ) { 
					if(temp[i].length() > 2) {
						if(temp[i].contains("����")) {
							testvo.setCsocket(temp[i]); 
						} else if(temp[i].substring(temp[i].length()-2).equals("nm")) { 
							testvo.setCprocess(temp[i]); 
						} else if(temp[i].substring(temp[i].length()-2).equals("�ھ�")) { 
							testvo.setCore(temp[i]); 
						} else if(temp[i].contains("������")) { 
							testvo.setThread(temp[i]); 
						} else if(temp[i].substring(temp[i].length()-3).equals("GHz")) { 
							testvo.setClock(temp[i]); 
						} else if(temp[i].contains("KB")) { 
							testvo.setL2memory(temp[i]); 
						} else if(temp[i].contains("MB")) { 
							testvo.setL3memory(temp[i]); 
						} else if(temp[i].substring(temp[i].length()-2).equals("��Ʈ")) { 
							testvo.setBit(temp[i]); 
						} else if(temp[i].substring(temp[i].length()-1).equals("W")) { 
							testvo.setPower(temp[i]); 
						} else if(temp[i].contains("HD")) { 
							testvo.setIngraphic(temp[i]); 
						} else if(temp[i].substring(temp[i].length()-3).equals("MHz")) { 
							testvo.setCorespeed(temp[i]); 
						} else if(temp[i].contains("DDR")) { 
							testvo.setDdrtype(temp[i]); 
						} else {
							addmemo= addmemo+temp[i]+"/";
						};// if3 end
					};//if2 end
				}; // for2 end
				testvo.setMore(addmemo);
				if(testvo.getCsocket()!=null&&testvo.getCprocess()!=null) {
					templist.add(testvo);
				}
*/				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} //for end
		for(MainBoardVO tmp:templist) {
			System.out.println(tmp);
		}
	}
}

