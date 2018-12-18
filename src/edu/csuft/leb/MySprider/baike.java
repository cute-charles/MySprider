package edu.csuft.leb.MySprider;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class baike {
	public static void main(String[] args) {
     String url="https://baike.baidu.com/item/%E8%8E%B1%E6%98%82%E7%BA%B3%E5%A4%9A%C2%B7%E8%BF%AA%E5%8D%A1%E6%99%AE%E9%87%8C%E5%A5%A5/1243185?fromtitle=%E8%8E%B1%E6%98%82%E7%BA%B3%E5%A4%9A&fromid=5753";
	try {
		Document d= Jsoup.connect(url).get();
		Elements es=d.select(".row");
		System.out.println(es.size());
		
		
		ArrayList<auchor> list=new ArrayList<>();
		for(Element e:es) {
			
			
			
			auchor xixi=new auchor();
			xixi.list=e.select("span").last().text();
			xixi.movie=e.select(".column a").last().text();
			System.out.println(xixi);
			
			list.add(xixi);
		}
		
		
		
	}
		catch (Exception e) {
		// TODO: handle exception
	}

}}
