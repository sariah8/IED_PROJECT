package mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import buisness.Film;
import dbpedia.SparqlRequest;

public class ConsoleMediator {

	public static void main(String[] args) throws Exception, IOException {
		Mediator mediator = new Mediator();
		String request;
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre requête : titre / acteur \n");
		request = sc.nextLine();
		if(request.equals("titre")) {
			System.out.print("Entrez le titre du film :");
			String titleString = sc.nextLine();
			Film film = new Film();
			film = mediator.FilmByTitle(titleString);
			//title
			System.out.println("Title  :  "+ film.getTitle());
			//realseDate
			System.out.println("Realse date   :   "+film.getReleaseDate());
			//genre
			System.out.println("Genre   :   "+film.getGenre());
			//distributor
			System.out.println("Distributor   :   "+film.getDistributor());
			//budget
			System.out.println("Budget   :   "+film.getBudget());
			//usa gross
			System.out.println("Usa Gross   :   "+film.getUsaGross());
			//worldwide gross
			System.out.println("Wordlwide Gross    :   "+film.getWorldwideGross());
			//director
			System.out.println("Director    :   "+film.getDirector());
			//resume
			System.out.println("Resume   :   "+film.getResume());
			//actors
			System.out.println("Actors   :   "+String.join(", ",film.getActors()));
			
		}
		if(request.contentEquals("acteur")) {
			System.out.println("Entrez le nom de l'acteur :");
			String actorString = sc.nextLine();
			ArrayList<Film> films = new ArrayList<Film>();
			films = mediator.FilmsByActor(actorString);
			for (Film film : films) {
				//le titre
				//la date de sortie
				//le genre
				//le distributeur
				//le réalisateur
				//le producteur
				
			}

		}

	}

}
