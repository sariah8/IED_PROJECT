package buisness;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import buisness.OmdbWebServiceClient;

public class TestOmdbWebServiceClient {
	public static void main(String[] args) throws Exception, IOException {

		//String xmlResponse = OmdbWebServiceClient.searchMovieByAttribut("t","","batman","", OmdbWebServiceClient.apikey1);
		//System.out.println(xmlResponse);
		
		String xmlResponse2 = OmdbWebServiceClient.searchMovieByAttribut("t", "", "titanic", "", OmdbWebServiceClient.apikey1);
 
		try (PrintWriter out = new PrintWriter("/src/movieOmdb.xml")) {
		    out.println(xmlResponse2);
		}
		
		//System.out.println("\nWith year = 1998 : \n"+xmlResponse2);
		
		String result = (String)XPathFilm.XPathGet("/src/movieOmdb.xml", "/root/movie/@plot", XPathConstants.STRING);
		
		System.out.println(result);
		
	}
}
