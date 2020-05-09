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
	
}
