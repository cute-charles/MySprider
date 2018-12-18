
package edu.csuft.leb.MySprider;

import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App {
	//alt+/ 
	public static void main(String[] args) {
		
		//线程池
		//固定大小   核心*2-1
		ExecutorService pool = Executors.newFixedThreadPool(4);
		//线程数量不受限
		pool=Executors.newCachedThreadPool();
		//一个线程
//		pool=Executors.newSingleThreadExecutor();
		
		ArrayList<Film> list=new ArrayList<Film>();
		
		
		String url="https://movie.douban.com/top250?start=";
		for(int i=0;i<10;i++) {
		//String path=String.format("%s=%d",url,i*25);
		pool.submit(new Spider(url+25*i,list));
		}
		pool.shutdown();
		System.out.println(pool.isTerminated());
		while(!pool.isTerminated())
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list.size());
			for(Film film:list) {
				System.out.println(film.toCSV());
			}
			//
			String file="d:/film.csv";
			file="film.csv";
			
			//排序
			Collections.sort(list);
			
			
			
			try (FileWriter out = new FileWriter(file)){
				
				for (Film film : list) {
					out.write(film.toCSV());
					
				}
				System.out.println("OK");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
//		Thread thread1=new Thread(new Runnable() {public void run() {System.out.println("吉他");}});
//		Thread thread2=new Thread(new Runnable() {public void run() {System.out.println("鼓");}});
//		
//		thread1.start();
//		thread2.start();
		
		
		//设置路径
//		String url="https://movie.douban.com/top250";
//		//多线程
//		
//		
//		
//		//JSOUP
//        try {
//			Document doc= Jsoup.connect(url).get();
//			//class选择
//			Elements es=doc.select(".grid_view .item");
//			System.out.println(es.size());
//			
//			//
//			ArrayList<Film> list=new ArrayList<>();
//			
//			
//			
//			
//			for(Element e:es) {
//				Film f=new Film();
//				
//			    f.id=Integer.parseInt(e.select(".pic em").first().text());
//			    f.poster=e.select("img").first().attr("src");
//			    f.info=e.select(".bd p").first().text();
//			    f.title=e.select(".title").first().text();
//			    f.rating=Double.parseDouble(e.select(".rating_num").first().text());
//				String num=e.select(".star span").last().text();
//				f.num=Integer.parseInt(num.substring(0, num.length() - 3));
//				f.quote=e.select(".inq").first().text();
//				
//				System.out.println(f);
//			    		/*
//				Element t=e.select(".title").first();
//				//#代表id
//				String num=e.select(".star span").last().text();
//				System.out.println(t.text()+","+num);*/
//				
//				
//				list.add(f);
				
//			}
//			
//			
//			
//			
//			
//		    /*String title=doc.title();
//		    String data=doc.data();
//		 
//		    System.out.println(title);
//		    System.out.println(data);*/
//		
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		}

}
