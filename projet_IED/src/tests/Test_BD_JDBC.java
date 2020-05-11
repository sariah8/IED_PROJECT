package tests;
import java.io.IOException;

import buisness.Film;
import persistance.Film_persistance;

public class Test_BD_JDBC {

	public static void main(String[] args)throws Exception, IOException {
		// TODO Auto-generated method stub
				Film_persistance persistance = new Film_persistance() ;
				Film film = persistance.readFilmByTitle("Shaft");					
				System.out.print(film);
	}

}

