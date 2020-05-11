package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import buisness.Film;
import dbpedia.SparqlRequestTitle;

public class TestSparqlRequest {
	public static void main(String[] args) throws Exception, IOException {
		SparqlRequestTitle sparqlRequest = new SparqlRequestTitle();
		HashMap<String,ArrayList<String>> resultSparql = new HashMap<String,ArrayList<String>>();
		resultSparql = sparqlRequest.DbpediaRequestTitle("X-Men: The Last Stand");
		Film film = new Film();
		film.setActors(resultSparql.get("actor"));
		film.setProducers(resultSparql.get("producer"));
		film.setDirector(resultSparql.get("director").get(0));
		System.out.println("Actors :");
		for (String actor : film.getActors()) {
			System.out.println(actor);
		}
		System.out.println("Producers :");
		for (String producer : film.getProducers()) {
			System.out.println(producer);
		}
		System.out.println("Director :");
		System.out.println(film.getDirector());	
	}
}

/*
SELECT ?aname ?pname ?dname WHERE { 
		?film rdf:type dbo:Film ; 
		 foaf:name "X-Men: The Last Stand"@en ; 
		 dbo:starring ?actor ; 
		 dbo:producer ?prod ; 
		 dbo:director ?dir . 
		?actor foaf:name ?aname . 
		?prod foaf:name ?pname . 
		?dir foaf:name ?dname . 
		}
*/