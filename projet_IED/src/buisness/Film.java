package buisness;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Film {

	private String title;
	private String releaseDate;
	private String genre;
	private String distributor;
	private double budget;
	private double domesticGross;
	private double worldwideGross;
	private String realisator;
	private String director;
	private ArrayList<String> actors;
	private ArrayList<String> producers;
	private String resume;
	
	public Film() {
		String title;
		String releaseDate;
		String genre;
		String distributor;
		double budget;
		double domesticGross;
		double worldwideGross;
		String realisator;
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
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public double getDomesticGross() {
		return domesticGross;
	}
	public void setDomesticGross(double domesticGross) {
		this.domesticGross = domesticGross;
	}
	public double getWorldwideGross() {
		return worldwideGross;
	}
	public void setWorldwideGross(double worldwideGross) {
		this.worldwideGross = worldwideGross;
	}
	public String getRealisator() {
		return realisator;
	}
	public void setRealisator(String realisator) {
		this.realisator = realisator;
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
		return "Film [title=" + title + ", releaseDate=" + releaseDate + ", genre=" + genre + ", distributor="
				+ distributor + ", budget=" + budget + ", domesticGross=" + domesticGross + ", worldwideGross="
				+ worldwideGross + ", realisator=" + realisator + ", director=" + director + ", actors=" + actors
				+ ", producers=" + producers + ", resume=" + resume + "]";
	}
	
}
