package buisness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OmdbWebServiceClient {

	public static String apikey1 = "406e127";
	public static String SEARCH_URL = "http://www.omdbapi.com/?ATTRIBUT=VALUE&apikey=APIKEY";
	public static String SEARCH_URL2 = "http://www.omdbapi.com/?ATTRIBUT=VALUE&ATTRIBUT2=VALUE2&apikey=APIKEY";
	
	public static String sendGetRequest(String requestUrl) {
		StringBuffer response = new StringBuffer();
		
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line;
			while ((line = buffer.readLine())!= null) {
				response.append(line);
			}
			buffer.close();
			connection.disconnect();
			
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.toString();
	}
	
	public static String searchMovieByAttribut(String attribut,String attribut2, String value, String value2, String key) {
		if (attribut2 == "" && value2 == "") {
			String requestUrl = SEARCH_URL
				.replaceAll("VALUE", value)
				.replaceAll("ATTRIBUT", attribut)
				.replaceAll("APIKEY", key);
			return sendGetRequest(requestUrl);
		}
		else {
			String requestUrl = SEARCH_URL2
				.replaceAll("VALUE", value)
				.replaceAll("ATTRIBUT", attribut)
				.replaceAll("VALUE2", value2)
				.replaceAll("ATTRIBUT2", attribut2)
				.replaceAll("APIKEY", key);
			return sendGetRequest(requestUrl);
		}
	}
}