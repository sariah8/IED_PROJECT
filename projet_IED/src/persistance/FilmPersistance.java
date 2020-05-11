package persistance;
import java.util.ArrayList;

import buisness.Film;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmPersistance {

	private Connection dbConnection;
	
	public FilmPersistance() {
		this.dbConnection = ConnectionDB.getConnection();
	}

	public Film readFilmByTitle(String title) {
		Film film = new Film();
		try {
			String selectFilmQuery = "SELECT * FROM movies WHERE movie = ? ";
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectFilmQuery);
			preparedStatement.setString(1, title);
			ResultSet result = preparedStatement.executeQuery();
			
			while (result.next()) {
				
				/*private String genre;
				private String distributor;*/
				film.setTitle(result.getString("movie"));
				film.setReleaseDate(result.getString("release_date"));
				film.setBudget(result.getString("production_budget"));
				film.setUsaGross(result.getString("domestic_gross"));
				film.setWorldwideGross(result.getString("wordwide_gross"));
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(" hoy "+se.getMessage());
		}

		return film;
	}

}