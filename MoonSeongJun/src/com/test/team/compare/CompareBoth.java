package com.test.team.compare;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CompareBoth {



	public static void main(String[] args) {

		String url = "https://gpu.userbenchmark.com/Compare/Nvidia-GTX-1660-vs-Nvidia-GTX-980-Ti/4038vs3439"; //크롤링할 url지정
		Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] list = url.split("/");
		String[] yeah = list[4].split("-vs-");
		ArrayList<Element> right = doc.select("div.innercolright");
		ArrayList<Element> left = doc.select("div.innercolleft");
		System.out.println(yeah[0]+" : "+yeah[1]);
		System.out.println("============================================================");
		
		if(right.get(1).text().length()>left.get(1).text().length()){
			System.out.println(yeah[1]+"이 "+right.get(1).text()+"만큼 더 조음");
		} else {
			System.out.println(yeah[0]+"이 "+left.get(1).text()+"만큼 더 조음");
		}
		
		System.out.println("============================================================");

	}
}