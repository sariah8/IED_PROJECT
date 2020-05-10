package mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import buisness.Film;
import buisness.ResumeRequest;
import dbpedia.SparqlRequest;

public class Mediator {

	public Mediator() {}
	
	public Film FilmByTitle(String titleString){
		Film film = new Film();
		//JDBC Request
		
		//En attendant :
		film.setTitle(titleString);
		
		
		//Sparql Request to dbpedia
		SparqlRequest sparqlRequest = new SparqlRequest();
		HashMap<String,ArrayList<String>> resultSparql = new HashMap<String,ArrayList<String>>();
		resultSparql = sparqlRequest.DbpediaRequest(film.getTitle());
		film.setActors(resultSparql.get("actor"));
		film.setProducers(resultSparql.get("producer"));
		if (!resultSparql.get("director").isEmpty()){
			film.setDirector(resultSparql.get("director").get(0));
		}else {
			film.setDirector(null);
		}

		//HTML GET method to Omdb
		ResumeRequest resumeRequest = new ResumeRequest();
		String resumeString = "";
		try {
			resumeString = resumeRequest.ResumeRequest(film.getTitle(), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		film.setResume(resumeString);
		
		return film;
	}
	
	public ArrayList<Film> FilmsByActor(String actorString){
		ArrayList<Film> films = new ArrayList<Film>();
		//JDBC Request
		
		
		for(Film film : films) {
			//Sparql Request to dbpedia
			SparqlRequest sparqlRequest = new SparqlRequest();
			HashMap<String,ArrayList<String>> resultSparql = new HashMap<String,ArrayList<String>>();
			resultSparql = sparqlRequest.DbpediaRequest(film.getTitle());
			film.setActors(resultSparql.get("actor"));
			film.setProducers(resultSparql.get("producer"));
			film.setDirector(resultSparql.get("director").get(0));
		
			//HTML GET method to Omdb
			ResumeRequest resumeRequest = new ResumeRequest();
			String resumeString = "";
			try {
				resumeString = resumeRequest.ResumeRequest(film.getTitle(), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			film.setResume(resumeString);
		}
		return films;
	}
}
