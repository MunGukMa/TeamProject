package com.test.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PassMarkParsing {

   public static void main(String[] args) {
      parsing();
   }

   public static void parsing() {
      String url = "https://www.cpubenchmark.net/ CPU_mega_page.html";
      try {
         Document doc = Jsoup.connect(url).get();
         ArrayList<Element> tempplist = doc.select("table#cputable");
         String[] strlist = null;
         String tmplist = null;
         for (Element em : tempplist) {
            strlist = em.text().split(" Samples:");
            tmplist = em.text();
            /*
             * if(count%12==0) { System.out.println("//////////////////////////////////"); }
             * count++;
             */
         }
         
         for(int i = 0;i<strlist.length;i++) 
         {
            System.out.println(i);
            System.out.println(strlist[i]);
         }
          
         
         /*
          * String tempstr = element.text(); String[] wht = tempstr.split("Samples:");
          * ArrayList<PMCpuVO> cpulist = new ArrayList<PMCpuVO>(); ArrayList<String>
          * templist = new ArrayList<String>(); for(int i = 0; i<wht.length;i++) {
          * 
          * countth++; if(wht[i].contains("Laptop")) { wht[i] = null; } if(wht[i]!=null)
          * { templist.add(wht[i]); String[] tempcpu = null; String cpuname = null;
          * String[] tempval = null; String val = null; String[] temprank= null; String
          * rank = null; if(wht[i].contains("*")) { tempcpu = wht[i].split("\\* "); }
          * else { tempcpu = wht[i].split("NA ",1); } if(tempcpu.length>1) {
          * cpuname=tempcpu[0]; tempval = tempcpu[1].split(" ",2); val=tempval[0];
          * temprank=wht[i].split("Rank: "); rank = temprank[temprank.length-1]; PMCpuVO
          * tempvo = new PMCpuVO(cpuname, val, rank); cpulist.add(tempvo); } }
          * 
          * }
          */

      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

}