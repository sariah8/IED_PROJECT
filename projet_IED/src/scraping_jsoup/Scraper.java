package scraping_jsoup;

import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
	
	public Scraper() {}
	
	public void scrap_page(String url, String genre,FileWriter csvWriter) throws IOException {
		
		Document docc = Jsoup.connect(url).get();
		Elements tables = docc.select("table");
		Element table = tables.get(1);
		Elements rows = table.select("tr");	    

		for (int i = 1; i < rows.size()-2; i++) { //first row is the col names so skip it.
			Element row = rows.get(i);
		    Elements cols = row.select("td");
		    
		    for (int j = 0; j < cols.size()-3; j++) {
		    	
		    	if (j==2) {
				String x="s";	
				}
		    	else if (j == 3) {
		    		String str =  cols.get(j).text(); 
		    		csvWriter.append(str.replaceAll(",", "&"));
		    		csvWriter.append(",");
					csvWriter.append(genre);
				}
		    	else {
		    		String str =  cols.get(j).text(); 
		    		csvWriter.append(str.replaceAll(",", "&"));
			    	csvWriter.append(",");
				}
			}
		    csvWriter.append("\n");
		}
	}
	
	public FileWriter create_writer(String file_name,String genre) throws IOException {

		FileWriter csvWriter = new FileWriter(file_name);
		
		csvWriter.append("rank");
		csvWriter.append(",");
		csvWriter.append("title");
		csvWriter.append(",");
		csvWriter.append("distributor");
		csvWriter.append(",");
		csvWriter.append(genre);
		csvWriter.append("\n");

		return csvWriter;
	}
	

}
