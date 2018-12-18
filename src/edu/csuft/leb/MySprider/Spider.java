package edu.csuft.leb.MySprider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * ץȡӰƬ��Ϣ
 * @author HP
 *
 */

public class Spider implements Runnable{
	String url;
	
	/**
	 * ץȡ��Ϣ
	 */
	ArrayList<Film>list;
	
	public Spider(String url, ArrayList<Film> list) {
	super();
	this.url = url;
	this.list = list;
	}

	public void run() {
			//����߳���
		String name=Thread.currentThread().getName();	
		System.out.println(name+"�߳� ����"+url);
		
		//JSOUP
	 try {
		Document doc=Jsoup.connect(url).get();
		//���ĵ����в��ҽڵ�
		Elements es=doc.select(".grid_view .item");
		//�����б�
		
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
			//#����id
			String num=e.select(".star span").last().text();
			System.out.println(t.text()+","+num);*/
			
			list.add(f);
	}
		System.out.println(name+"�߳� ���: "+url);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
