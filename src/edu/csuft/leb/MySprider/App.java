
package edu.csuft.leb.MySprider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
	//alt+/ 
	public static void main(String[] args) {
		
		//设置路径
		String url="https://movie.douban.com/top250";
		//JSOUP
        try {
			Document doc= Jsoup.connect(url).get();
			//class选择
			Elements es=doc.select(".grid_view .item");
			System.out.println(es.size());
			
			//
			ArrayList<Film> list=new ArrayList<>();
			
			
			
			
			for(Element e:es) {
				Film f=new Film();
				
			    f.id=Integer.parseInt(e.select(".pic em").first().text());
			    f.poster=e.select("img").first().attr("src");
			    f.info=e.select(".bd p").first().text();
			    f.title=e.select(".title").first().text();
			    f.rating=Double.parseDouble(e.select(".rating_num").first().text());
				String num=e.select(".star span").last().text();
				f.num=Integer.parseInt(num.substring(0, num.length() - 3));
				f.quote=e.select(".inq").first().text();
				
				System.out.println(f);
			    		/*
				Element t=e.select(".title").first();
				//#代表id
				String num=e.select(".star span").last().text();
				System.out.println(t.text()+","+num);*/
				
				
				list.add(f);
				
			}
			
			
			
			
			
		    /*String title=doc.title();
		    String data=doc.data();
		 
		    System.out.println(title);
		    System.out.println(data);*/
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
