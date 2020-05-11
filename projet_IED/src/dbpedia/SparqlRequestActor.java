package dbpedia;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

public class SparqlRequestActor {
	
	public ArrayList<String> DbpediaRequestActor (String actorString) {
		final String resourceURI = "http://dbpedia.org/sparql";		
		String realisatorQuery = (
							"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
							"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" + 
							"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
							"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
							"PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" + 
							"PREFIX dc: <http://purl.org/dc/elements/1.1/>\n" +
							"PREFIX dbo: <http://dbpedia.org/ontology/>\n" +
							"PREFIX : <http://dbpedia.org/resource/>\n" + 
							"PREFIX dbpedia2: <http://dbpedia.org/property/>\n" + 
							"PREFIX dbpedia: <http://dbpedia.org/>\n" + 
							"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>" +
							"PREFIX dbo: <http://dbpedia.org/ontology/>" +
							"\n"+
							"SELECT ?tfilm WHERE {\r\n" + 
							"?film rdf:type dbo:Film ;\r\n" + 
							"      foaf:name ?tfilm ;\r\n" + 
							"      dbo:starring ?actor .\r\n" + 
							"?actor foaf:name \""+actorString+"\"@en .\r\n" + 
							"}");
		Query query = QueryFactory.create(realisatorQuery);
		QueryExecution queryExe = QueryExecutionFactory.sparqlService(resourceURI, query);
		ResultSet results = queryExe.execSelect() ;
		List<QuerySolution> solutions= ResultSetFormatter.toList(results);
		ArrayList<String> titleMovies = new ArrayList<String>();
		String titleMovie = "";
	//	ResultSetFormatter.out(System.out,results,query);
		for(QuerySolution qs:solutions) {
			titleMovie = qs.get("tfilm").toString().replaceAll("@en", "");		
			
			if (!titleMovies.contains(titleMovie)) {
				titleMovies.add(titleMovie);
			}

		}
		
		return titleMovies;
	}
}
