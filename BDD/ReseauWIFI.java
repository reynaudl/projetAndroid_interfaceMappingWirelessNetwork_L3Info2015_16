package BDD;
/** Atila Rives */
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReseauWIFI {


    private String nameWIFI;
    private boolean open; //reflechir pour les doublons de  noms
    private ArrayList<Coordonnees> puissanceForte;
    private ArrayList<Coordonnees> puissanceMoyenne;
    private ArrayList<Coordonnees> puissanceFaible;
    private ArrayList<Measure> listOfMeasures;
    
    public ReseauWIFI ( ArrayList<Measure> listOfMeasures){
    	this.listOfMeasures=listOfMeasures;
    }



    public ReseauWIFI(ArrayList<Measure> listeOfMeasures, String name, boolean open) {
    	this(listeOfMeasures);
        this.nameWIFI = name;
        this.open = open;

    }


    public ReseauWIFI(ArrayList<Measure> listeOfMeasures, String name, boolean open, ArrayList<Coordonnees> puissanceFaible,  ArrayList<Coordonnees> puissanceMoyenne ,ArrayList<Coordonnees> puissanceForte ) {
        this(listeOfMeasures, name, open);
        this.puissanceFaible = puissanceFaible;
        this.puissanceMoyenne = puissanceMoyenne;
        this.puissanceForte = puissanceForte;
    }

    
    public void FullCoordonnees (){
    	
    	for (int i=0; i< listOfMeasures.size(); i++){
	    	switch (listOfMeasures.get(i).getPower_measure()) {
			case 1:
				this.puissanceFaible.add(new Coordonnees(
							listOfMeasures.get(i).getLatitude_measure(),listOfMeasures.get(i).getLongitude_measure()));
				break;
			case 2:
				this.puissanceMoyenne.add(new Coordonnees(
						listOfMeasures.get(i).getLatitude_measure(),listOfMeasures.get(i).getLongitude_measure()));
				break;
			case 3:
				this.puissanceForte.add(new Coordonnees(
						listOfMeasures.get(i).getLatitude_measure(),listOfMeasures.get(i).getLongitude_measure()));
				break;
	
			default:
				break;
	    	}
    	}
    }

    public void ReqFull(ReqSQL reqSQL,  DataBaseManager dataBaseManager ){

        ResultSet result;
        ResultSet sizeCalcul;
        int size=0;


//		result =dataBaseManager.query( "SELECT * FROM reseau_WIFI WHERE name_WIFI = "
//											+ nameWIFI
//											+ ");"
//											);

        result = dataBaseManager.query(ReqSQL.SelectAll());


        sizeCalcul=result;
        //size of result
        try {
            while(sizeCalcul.next()) {
                size++;
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        //this.nameWIFI= nameWIFI;

        try {
            this.open=result.getBoolean("open");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<Integer> puissance;
        ArrayList<Double> listOfLatitude;
        ArrayList<Double> listOfLongitude;
        
        for (int i = 0; i< size; i++){
            //cree un objet mesure pour chaque ligne de la base de donnée.
            try {
            	puissance =(ArrayList<Integer>) result.getArray(ReqSQL.getNomCollonePuissance());
            	listOfLatitude = (ArrayList<Double>) result.getArray(ReqSQL.getNomColloneLatitude());
            	listOfLongitude = (ArrayList<Double>) result.getArray(ReqSQL.getNomColloneLongitude());
            	switch (puissance.get(i)) {
				case 1:
					this.puissanceFaible.add(new Coordonnees(listOfLatitude.get(i), listOfLongitude.get(i)));
					break;
				case 2:
					this.puissanceMoyenne.add(new Coordonnees(listOfLatitude.get(i), listOfLongitude.get(i)));
					break;
				case 3:
					this.puissanceForte.add(new Coordonnees(listOfLatitude.get(i), listOfLongitude.get(i)));
					break;

				default:
					break;
				}
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

    }




}