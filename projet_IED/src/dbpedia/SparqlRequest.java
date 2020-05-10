package dbpedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

public class SparqlRequest {

	public SparqlRequest() {}
	
	public HashMap<String, ArrayList<String>> DbpediaRequest(String titleStr) {
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
							"SELECT distinct ?dname ?pname ?aname WHERE {\r\n" + 
							"?film rdf:type dbo:Film ;\r\n" + 
							" foaf:name \""+titleStr+"\"@en ;\r\n" + 
							" dbo:director ?dir ;\r\n" +
							" dbo:producer ?prod ;\r\n" + 
							" dbo:starring ?actor .\r\n" +
							"?actor foaf:name ?aname .\r\n" + 
							"?prod foaf:name ?pname .\r\n" + 
							"?dir foaf:name ?dname .\r\n" + 
							"}");
		Query query = QueryFactory.create(realisatorQuery);
		QueryExecution queryExe = QueryExecutionFactory.sparqlService(resourceURI, query);
		ResultSet results = queryExe.execSelect() ;
		List<QuerySolution> solutions= ResultSetFormatter.toList(results);
		HashMap<String, ArrayList<String>> strResults = new HashMap<String,ArrayList<String>>();
		ArrayList<String> actors = new ArrayList<String>();
		ArrayList<String> directors = new ArrayList<String>();
		ArrayList<String> producers = new ArrayList<String>();
		String actor = "";
		String director = "";
		String producer = "";
	//	ResultSetFormatter.out(System.out,results,query);
		for(QuerySolution qs:solutions) {
			actor = qs.get("aname").toString().replaceAll("@en", "");
			director = qs.get("dname").toString().replaceAll("@en", "");		
			producer = qs.get("pname").toString().replaceAll("@en", "");		
			
			if (!actors.contains(actor)) {
				actors.add(actor);
			}
			if (!producers.contains(producer)) {
				producers.add(producer);
			}
			if (!directors.contains(director)) {
				directors.add(director);
			}
		}

		strResults.put("actor",actors);
		strResults.put("director", directors);
		strResults.put("producer", producers);
		
		return strResults;
	}
}
