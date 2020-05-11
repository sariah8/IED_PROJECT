package mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import buisness.Film;
import buisness.ResumeRequest;
import dbpedia.SparqlRequestActor;
import dbpedia.SparqlRequestTitle;
import persistance.FilmPersistance;

public class Mediator {

	public Mediator() {}
	
	public Film FilmByTitle(String titleString){
		Film film = new Film();
		
		//JDBC Request
		FilmPersistance persistance = new FilmPersistance() ;
		film = persistance.readFilmByTitle(titleString);	
	
		//Sparql Request to dbpedia
		SparqlRequestTitle sparqlRequest = new SparqlRequestTitle();
		HashMap<String,ArrayList<String>> resultSparql = new HashMap<String,ArrayList<String>>();
		resultSparql = sparqlRequest.DbpediaRequestTitle(titleString);
		if(!resultSparql.get("actor").isEmpty()) {
			film.setActors(resultSparql.get("actor"));
		}else {
			film.setActors(null);
		}
		if (!resultSparql.get("producer").isEmpty()){
			film.setProducers(resultSparql.get("producer"));
		}else {
			film.setProducers(null);
		}
		if (!resultSparql.get("director").isEmpty()){
			film.setDirector(resultSparql.get("director").get(0));
		}else {
			film.setDirector(null);
		}

		//HTML GET method to Omdb
		ResumeRequest resumeRequest = new ResumeRequest();
		String resumeString = "";
		try {
			resumeString = resumeRequest.ResumeRequest(titleString, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		film.setResume(resumeString);
		
		return film;
	}
	
	public ArrayList<Film> FilmsByActor(String actorString){
		ArrayList<Film> films = new ArrayList<Film>();
		FilmPersistance persistance = new FilmPersistance() ;
		
		//Sparql Request to dbpedia
		SparqlRequestActor sparqlRequestActor = new SparqlRequestActor();
		ArrayList<String> titlesString = new ArrayList<String>();
		titlesString = sparqlRequestActor.DbpediaRequestActor(actorString);
		System.out.println("DEBUG Dbpedia request result :\n"+String.join(",", titlesString));
		
		for(String titleString : titlesString) {
			Film film = new Film();
			//JDBC Request;
			
			film = persistance.readFilmByTitle(titleString);

			if (film.getTitle() ==  null) {
				continue;
			}
			System.out.println("DEBUG JDBC Set film find :" +film.getTitle());
			
			//Sparql Request to dbpedia
			SparqlRequestTitle sparqlRequestTitle = new SparqlRequestTitle();
			HashMap<String,ArrayList<String>> resultSparql = new HashMap<String,ArrayList<String>>();
			resultSparql = sparqlRequestTitle.DbpediaRequestTitle(titleString);
			if (!resultSparql.get("producer").isEmpty()){
				film.setProducers(resultSparql.get("producer"));
			}else {
				film.setProducers(null);
			}
			if (!resultSparql.get("director").isEmpty()){
				film.setDirector(resultSparql.get("director").get(0));
			}else {
				film.setDirector(null);
			}
			
			films.add(film);
		}
		return films;
	}
}
