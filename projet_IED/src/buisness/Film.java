package buisness;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Film {

	private String title;
	private String released;
	private String genre;
	private String distributor;
	private double budget;
	private double domesticGross;
	private double worldwideGross;
	
}
