package edu.csuft.leb.MySprider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 抓取影片信息
 * @author HP
 *
 */

public class Spider implements Runnable{
	String url;
	
	/**
	 * 抓取信息
	 */
	ArrayList<Film>list;
	
	public Spider(String url, ArrayList<Film> list) {
	super();
	this.url = url;
	this.list = list;
	}

	public void run() {
			//获得线程名
		String name=Thread.currentThread().getName();	
		System.out.println(name+"线程 处理："+url);
		
		//JSOUP
	 try {
		Document doc=Jsoup.connect(url).get();
		//从文档树中查找节点
		Elements es=doc.select(".grid_view .item");
		//遍历列表
		
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
			
			System.out.println(name+":"+f);
		    		/*
			Element t=e.select(".title").first();
			//#代表id
			String num=e.select(".star span").last().text();
			System.out.println(t.text()+","+num);*/
			
			list.add(f);
	}
		System.out.println(name+"线程 完成: "+url);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
