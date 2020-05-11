package tests;
import java.io.IOException;

import buisness.Film;
import persistance.FilmPersistance;

public class Test_BD_JDBC {

	public static void main(String[] args)throws Exception, IOException {
		// TODO Auto-generated method stub
				FilmPersistance persistance = new FilmPersistance() ;
				Film film = persistance.readFilmByTitle("Ed Wood");					
				System.out.print(film);
	}

}

