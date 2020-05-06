package scraping_jsoup;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) throws IOException {		
		// TODO Auto-generated method stub
		
		Scraper scraper = new Scraper();
		String basic_URL = "https://www.the-numbers.com/market";
        ArrayList<String> genre_liste = new ArrayList<>();
        
        genre_liste.add("Adventure");
        genre_liste.add("Comedy");
        genre_liste.add("Drama");
        genre_liste.add("Action");
        genre_liste.add("Thriller-or-Suspense");
        genre_liste.add("Romantic-Comedy");

        for (String genre : genre_liste) {
        	FileWriter csvWriter = scraper.create_writer(genre + ".csv", genre);
        	
        	for (int year = 2000; year < 2016; year++) {
        		
        		String URL = basic_URL + "/" + year + "/" + "genre" + "/" + genre;        		
                scraper.scrap_page(URL,genre,csvWriter);
			}
    		csvWriter.flush();
            csvWriter.close();   
            System.out.println(genre + " done!");
        }
		}
}
