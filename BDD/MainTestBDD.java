package BDD;
/** Atila Rives */
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainTestBDD {

    public static void main(String[] args) {
    	DataBaseManager dataBaseManager = new DataBaseManager("Database.db");
        dataBaseManager.connect();

        dataBaseManager.close();


    }


}