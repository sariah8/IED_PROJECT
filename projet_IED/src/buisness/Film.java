package buisness;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Film {

	private String title;
	private String releaseDate;
	private String genre;
	private String distributor;
	private String budget;
	private String usaGross;
	private String worldwideGross;
	private String director;
	private ArrayList<String> actors;
	private ArrayList<String> producers;
	private String resume;
	
	public Film() {
		String title;
		String releaseDate;
		String genre;
		String distributor;
		String budget;
		String usaGross;
		String worldwideGross;
		String director;
		ArrayList<String> actors = new ArrayList<String>();
		ArrayList<String> producers  = new ArrayList<String>();
		String resume;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getUsaGross() {
		return usaGross;
	}
	public void setUsaGross(String usaGross) {
		this.usaGross = usaGross;
	}
	public String getWorldwideGross() {
		return worldwideGross;
	}
	public void setWorldwideGross(String worldwideGross) {
		this.worldwideGross = worldwideGross;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public ArrayList<String> getActors() {
		return actors;
	}
	public void setActors(ArrayList<String> actors) {
		this.actors = actors;
	}
	public ArrayList<String> getProducers() {
		return producers;
	}
	public void setProducers(ArrayList<String> producers) {
		this.producers = producers;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}



@Override
public String toString() {
	
	return
			//title
			"\nTitle  :  "+ title +
			//realseDate
			"Realse date   :   "+releaseDate +
			//genre
			"Genre   :   "+genre +
			//distributor
			"Distributor   :   "+distributor +
			//budget
			"Budget   :   "+budget +
			//usa gross
			"Usa Gross   :   "+usaGross +
			//worldwide gross
			"Wordlwide Gross    :   "+worldwideGross +
			//director
			"Director    :   "+director +
			//resume
			"Resume   :   "+resume +
			//actors
			"Actors   :   "+String.join(", ",actors) +
			//producers
			"Producers   :   "+String.join(", ",producers);
}

public String toStringRequest1() {

	return
			//title
			"\nTitle  :  "+ title +
			//realseDate
			"\nRealse date   :   "+releaseDate +
			//genre
			"\nGenre   :   "+genre +
			//distributor
			"\nDistributor   :   "+distributor +
			//budget
			"\nBudget   :   "+budget +
			//usa gross
			"\nUsa Gross   :   "+usaGross +
			//worldwide gross
			"\nWordlwide Gross    :   "+worldwideGross +
			//director
			"\nDirector    :   "+director +
			//resume
			"\nResume   :   "+resume +
			//actors
			"\nActors   :   "+String.join(", ",actors);
}

public String toStringRequest2() {
	return
			//title
			"\nTitle  :  "+ title +
			//realseDate
			"\nRealse date   :   "+releaseDate +
			//genre
			"\nGenre   :   "+genre +
			//distributor
			"\nDistributor   :   "+distributor +
			//director
			"\nDirector    :   "+director +
			//actors
			"\nProducers   :   "+String.join(", ",producers);
}


}