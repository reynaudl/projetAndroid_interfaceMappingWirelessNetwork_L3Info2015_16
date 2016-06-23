package BDD;
/** Atila Rives */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InnitialisationBDD {
	
	
	
	
	public void InnitalisationBDD(){
		DataBaseManager dataBaseManager = new DataBaseManager(ReqSQL.getNomDatabase()+".db");
		dataBaseManager.connect();
		ArrayList<Measure> fausseMeasures=new ArrayList<Measure>();
		fausseMeasures.add(new Measure(2, 42.674688, 2.848075));
		fausseMeasures.add(new Measure(3, 42.674680, 2.848074));
		fausseMeasures.add(new Measure(3, 42.674690, 2.848072));
		fausseMeasures.add(new Measure(4, 42.674685, 2.848090));
		fausseMeasures.add(new Measure(2, 42.674689, 2.848085));
		fausseMeasures.add(new Measure(1, 42.674688, 2.848073));
		fausseMeasures.add(new Measure(1, 42.674678, 2.848065));
		fausseMeasures.add(new Measure(3, 42.674655, 2.848070));
		fausseMeasures.add(new Measure(3, 42.674632, 2.848048));
		
		
		ReseauWIFI fauxReaseau = new ReseauWIFI(fausseMeasures);
		
		
		
	    dataBaseManager.query("CREATE DATABASE "+ReqSQL.getNomDatabase()+";");
	    //id_measure, power, latitude, longitude, nomReseau, protected, dateAcquisition
	    //auto_increment, 1, 42.675024, 2.847717 , sfr, false
	    

	    dataBaseManager.execute("CREATE TABLE "+ ReqSQL.getNomTableMeasures()+
	    		"(id_measure INTEGER PRIMARY KEY AUTOINCREMENT, "+ReqSQL.getNomCollonePuissance()+" INT,"+ReqSQL.getNomColloneLatitude()+" DOUBLE,"
	    				+ ReqSQL.getNomColloneLongitude()+ " DOUBLE " + ReqSQL.getNomColloneNameWIFI()+" VARCHAR, "+
	    				ReqSQL.getNomColloneProtected()+" BOOLEAN, "+ReqSQL.getNomColloneDateacquisiont()+" DATE));");
	    
		
	    dataBaseManager.execute("INSERT INTO "+ReqSQL.getNomTableMeasures()+"( VALUES (12345);");
	 
	    ResultSet valeur = dataBaseManager.query(ReqSQL.SelectAll());
	    try {
	        System.out.println(valeur.getInt(1) );
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    dataBaseManager.close();
	}
	
	

}
