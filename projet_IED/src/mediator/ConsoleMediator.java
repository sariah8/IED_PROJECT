package mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import buisness.Film;
import dbpedia.SparqlRequestTitle;

public class ConsoleMediator {

	public static void main(String[] args) throws Exception, IOException {
		Mediator mediator = new Mediator();
		String request = "";
		Scanner sc = new Scanner(System.in);
		while(request != "acteur" && request != "titre"){
			System.out.println("Entrez votre requête : titre / acteur");
			request = sc.nextLine();
			if(request.equals("titre")) {
				System.out.println("Entrez le titre du film :");
				String titleString = sc.nextLine();
				Film film = new Film();
				film = mediator.FilmByTitle(titleString);
				if(film.getTitle().equals(null)) {
					System.out.println("No result");
				}
				System.out.println("\n\n--------------------   Information :   --------------------\n");
				System.out.println(film.toStringRequest1());
				break;
			}
			if(request.contentEquals("acteur")) {
				System.out.println("Entrez le nom de l'acteur :");
				String actorString = sc.nextLine();
				ArrayList<Film> films = new ArrayList<Film>();
				films = mediator.FilmsByActor(actorString);
				int index = 1;
				System.out.println("\n\n--------------------   Movies "+actorString+" starred in :   --------------------   \n");
				for (Film film : films) {
					System.out.println("	Movie "+index+" :	");
					System.out.println(film.toStringRequest2());
					index = index + 1;
					
				}
				if(films.size() == 0) {
					System.out.println("No result");
				}
				break;
			}
		}
	}
}
