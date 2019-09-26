package com.test.team;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class GpuParsingTest {



	public static void main(String[] args) {
		// Jsoup를 이용해서 http://www.cgv.co.kr/movies/ 크롤링

		String kaisha = "amd";
		int index = 0;
		ArrayList<GraphicCardVO> list = new ArrayList<GraphicCardVO>();
		String tdp = null; 
		for(int year = 2014;year<2020;year++){
			String url_tdp = "https://www.techpowerup.com/gpu-specs/?mfgr="+kaisha+"&released="+year+"&sort=name"; //크롤링할 url지정
			Document doc_tdp = null;        //Document에는 페이지의 전체 소스가 저장된다

			try {
				doc_tdp = Jsoup.connect(url_tdp).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
			Elements element_tdp = doc_tdp.select("select#tdp");
			//Elements element = doc.select("div.table-wrapper").select("tbody").select("tr").select("td");    

			//for(Element test: element) 
			//Iterator을 사용하여 하나씩 값 가져오기
			Iterator<Element> ie_tdp = element_tdp.iterator();
			//System.out.println(test.text());
			String[] tdp_string = ie_tdp.next().text().split(" ");
			//Iterator<Element> ie2 = element.select("strong.title").iterator();
			System.out.println("========================================================================");
			String url = null;
			for(int i=1;i<tdp_string.length;i++) {
				if(i%3==1){
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(kaisha +"-"+ year+"년도 "+tdp_string[i]+"W");
					if(!tdp_string[i].equals("unknown")) 
						url = "https://www.techpowerup.com/gpu-specs/?mfgr="+kaisha+"&released="+year+"&tdp="+tdp_string[i]+"%20W&sort=name";
					 else
						url = "https://www.techpowerup.com/gpu-specs/?mfgr="+kaisha+"&released="+year+"&tdp=unknown&sort=name";
					Document doc = null; 
					try {
						doc = Jsoup.connect(url).get();
					} catch (IOException e) {
						e.printStackTrace();
					}
					Elements element = doc.select("div.table-wrapper").select("tbody").select("tr").select("td");
					Iterator<Element> ie = element.iterator();
					//System.out.println(kaisha +"-"+ year+"년도");
					GraphicCardVO vo = new GraphicCardVO();
					while (ie.hasNext()) {

						switch (index) {
						case 0:
							vo.setCompany(kaisha);
							index++;
							break;
						case 1: //봐줬다.
							vo.setProduct_name(ie.next().text());
							index++;
							break;
						case 2:
							vo.setChip(ie.next().text());
							index++;
							break;
						case 3:
							vo.setReleased_date(ie.next().text());
							index++;
							break;
						case 4:
							vo.setBus(ie.next().text());
							index++;
							break;
						case 5:
							String result = ie.next().text();
							if(!result.equals("System Shared")){
								String[] memory = result.split(", ");	
								vo.setM_size(memory[0]);
								vo.setM_ddr(memory[1]);
								vo.setM_bit(memory[2]);
							}
							else {
								vo.setM_size("System Shared");
								vo.setM_ddr("System Shared");
								vo.setM_bit("System Shared");
							};
							index++;
							break;
						case 6:
							vo.setG_clock(ie.next().text());
							index++;
							break;
						case 7:
							vo.setM_clock(ie.next().text());
							vo.setTdp(tdp_string[i]+tdp_string[i+1]);
							list.add(vo);
							index=0;
							System.out.println(vo);
							vo = new GraphicCardVO();
							ie.next();
							break;
						default:
							break;
						}

						//System.out.println((cnt++) +" "+ ie.next().text());
					}
				}
			}
			System.out.println("========================================================================");
			//		while (ie.hasNext()) {
			//			System.out.println(ie.next().text());
			//		}

			if(kaisha=="nvidia"&&year==2019) {
				kaisha = "amd";
				year=2009;
			}
			if(kaisha=="amd"&&year==2019) {
				kaisha = "intel";
				year=2009;
			}
		}
		System.out.println(list.size());
		//jdbc(list);
		for(GraphicCardVO vo : list) {
			System.out.println(vo);
		}

	}
	public static void jdbc(ArrayList<GraphicCardVO> list) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			for (GraphicCardVO vo : list) {
				vo.setRank(0);
				con = ConnectionManager.getConnection();
				String sql = "INSERT INTO GRAPHICCARD VALUES (GPU_SEC.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getCompany());
				pstmt.setString(2, vo.getProduct_name());
				pstmt.setString(3, vo.getChip());
				pstmt.setString(4, vo.getReleased_date());
				pstmt.setString(5, vo.getBus());
				pstmt.setString(6, vo.getM_size());
				pstmt.setString(7, vo.getM_ddr());
				pstmt.setString(8, vo.getM_bit());
				pstmt.setString(9, vo.getG_clock());
				pstmt.setString(10, vo.getM_clock());
				pstmt.setString(11, vo.getTdp());
				pstmt.setInt(12, vo.getRank());
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println("JDBC 에러");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				System.out.println("JDBC2 에러");
				e2.printStackTrace();
			}
		}
	}
}