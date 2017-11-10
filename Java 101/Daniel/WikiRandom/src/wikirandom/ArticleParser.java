package wikirandom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ArticleParser implements Runnable {
	static String url;
	static List<String> foundStrs = new ArrayList<>();
	public static String mostPop;
	
	
	public ArticleParser(String url) {
		this.url = url;
		run();
	}
	
	public void run() {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		Elements els = doc.getAllElements();
		String allText = "";
		
		for(int i = 0; i < els.size(); i++) {
			allText += els.get(i).text();
		}
		
        String[] textArr = allText.split(" ");
        String mostPop = findPopular(textArr);
        
        
        for(int i = 0; i < foundStrs.size(); i++) {
        	mostPop = findPopular(textArr);
        	if(foundStrs.contains(mostPop)) {
        		i = 0;
        		
        		//remove the word from textArr
        		for(int j = 0; j < textArr.length; j++) {
        			if(mostPop.equals(textArr[j])) {
        				//bc if they're the same the new word will pop up again
        				textArr[j] = WikiRandom.getRandWord();
        			}
        		}
        	}
        }
        
        foundStrs.add(mostPop);
        this.mostPop = mostPop;
		} catch (Exception e) {
			e.printStackTrace();
			this.mostPop = "Failed to load word (" + e.getMessage() + ")";
		}
	}
	
	
	
	public static String findPopular (String[] array) { // thx stackoverflow <3
	    List<String> list = Arrays.asList(array);
	    Map<String, Integer> stringsCount = new HashMap<String, Integer>();
	    for(String string: list)
	    {
	        if (string.length() > 0) {
	            string = string.toLowerCase();
	            Integer count = stringsCount.get(string);
	            if(count == null) count = new Integer(0);
	            count++;
	            stringsCount.put(string,count);
	        }
	    }
	    Map.Entry<String,Integer> mostRepeated = null;
	    for(Map.Entry<String, Integer> e: stringsCount.entrySet())
	    {
	        if(mostRepeated == null || mostRepeated.getValue()<e.getValue())
	            mostRepeated = e;
	    }
	    try {
	        return mostRepeated.getKey();
	    } catch (NullPointerException e) {
	        System.out.println("Cannot find most popular value at the List. Maybe all strings are empty");
	        return "";
	    }

	}
}