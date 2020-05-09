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

		ResumeRequest resumeRequest = new ResumeRequest();
		String result = resumeRequest.ResumeRequest("Batman", null);
		System.out.println(result);
		String result2 = resumeRequest.ResumeRequest("Batman", "1998");
		System.out.println(result2);
	}
}
