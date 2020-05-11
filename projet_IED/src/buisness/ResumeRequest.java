package buisness;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.xpath.XPathConstants;

public class ResumeRequest {

	public String ResumeRequest(String title, String year) throws IOException {
		String optionalAttribut =  null;
		if(title == null) {
			return null;
		}
		if (year != null) {
			optionalAttribut = "y";
		}
		String xmlResponse = OmdbWebServiceClient.searchMovieByAttribut("t", optionalAttribut, title, year, OmdbWebServiceClient.apikey1);
		try (PrintWriter out = new PrintWriter("movieOmdb.xml")) {
		    out.println(xmlResponse);
		}
		String result = (String)XPathFilm.XPathGet("movieOmdb.xml", "/root/movie/@plot", XPathConstants.STRING);
		return result;
	}
}
