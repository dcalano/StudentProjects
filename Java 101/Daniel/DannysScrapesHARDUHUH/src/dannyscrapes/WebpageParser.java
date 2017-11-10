package dannyscrapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebpageParser extends Thread {
	
	String url;
	int wordCount[] = new int[Scraper.KEYWORDS.length];
	int iteration;
	
	static List<String> allWords = new ArrayList<>();
	static List<Integer> allWordAmounts = new ArrayList<>();
	
	public WebpageParser(String url, int iteration) {
		this.url = url;
		this.iteration = iteration;
		
		//fill wordCount w/ 0's
		for(int i = 0; i < wordCount.length; i++) {
			wordCount[i] = 0;
		}
	}
	
	public void run() {
		try {
			System.out.println("Started, scraping: " + url);
			Document doc = Jsoup.connect(url).followRedirects(true).get();
			Elements elements = doc.getAllElements();
			List<String> texts = elements.eachText();
			System.out.println("Connected to " + doc.title() + " (" + url + ")");
			
			for(int i = 0; i < texts.size(); i++) {
				String[] para = texts.get(i).toLowerCase().replace(".", "").replace(",", "").split(" ");
				System.out.println("Para (" + url + "): " + java.util.Arrays.toString(para));
				
				System.out.println("Original: " + texts.get(i));
				for(int j = 0; j < para.length; j++) {
					for(int k = 0; k < Scraper.KEYWORDS.length; k++) {
						
						System.out.println("Found word: " + para[j]);
						
						if(para[j].equals(Scraper.KEYWORDS[k])) {
							System.out.println("Match: " + para[j] + " = " + Scraper.KEYWORDS[k] + ", on " + url);
							wordCount[k]++;
						}
						
						addToAll(para[j]);
						
					}
					
				}
			}

			printMostCommon();
			
			System.out.println("Done with: " + url + "\nTitle: " + doc.title());
			
		} catch (Exception e) {
			System.out.println("Error with: " + url + ", error is: " + e.getMessage());
			e.printStackTrace();
		}
		
		Scraper.WORD_COUNTS[iteration] = wordCount;
		
	}
	
	static void addToAll(String s) {
		boolean found = false;
		for(int i = 0; i < allWords.size(); i++) {
			if(allWords.get(i).equals(s)) {
				allWordAmounts.set(i, allWordAmounts.get(i) + 1);
				found = true;
				break;
			}
		}
		
		if(!found) {
			allWords.add(s);
			allWordAmounts.add(0);
		}
	}
	
	static void printMostCommon() {
		
		List<Integer> sortedList = allWordAmounts;
		List<String> sortedWordList = allWords;

		System.out.println("sortedWordList 0: " + allWords.get(0));
		
		Collections.sort(sortedList);
		
		System.out.println("sortedWordList 0: " + sortedWordList.get(0));
		
		//search the original list for the indexes
		for(int i = 0; i < sortedList.size(); i++) {
			
			if(allWordAmounts.get(i) == sortedList.get(i)) {
				sortedWordList.add(allWords.get(i));
			}
			
		}
		
		//they're backwards oops
		Collections.reverse(sortedList);
		Collections.reverse(sortedWordList);
		
		int toCount = 10;
		System.out.println("Top " + toCount + " most common words:" + System.lineSeparator());
		for(int i = 0; i < toCount; i++) {
			System.out.println((i + 1) + ". " + sortedWordList.get(i) + " (" + sortedList.get(i) + " occurences)");
		}
	}
}
