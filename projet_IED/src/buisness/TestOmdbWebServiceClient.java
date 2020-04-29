package buisness;
import buisness.OmdbWebServiceClient;

public class TestOmdbWebServiceClient {
	public static void main(String[] args) {
		String jsonResponse = OmdbWebServiceClient.searchMovieByAttribut("t","","batman","", OmdbWebServiceClient.apikey1);
		System.out.println(jsonResponse);
		
		String jsonResponse2 = OmdbWebServiceClient.searchMovieByAttribut("t", "batman", "y", "1998", OmdbWebServiceClient.apikey1);
		System.out.println("\nWith year = 1998 : \n"+jsonResponse2);
	}
}
