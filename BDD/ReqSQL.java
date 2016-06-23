/** En cours de travail */

package BDD;
/** Atila Rives */
import java.util.ArrayList;

public class ReqSQL {

	private static final String NOM_DATABASE = "ProjetAndroid";
    
    private static final String NOM_TABLE_MEASURES = "Measures";
    private static final String NOM_COLLONE_PUISSANCE = "power";
    private static final String NOM_COLLONE_LATITUDE = "latitude";
    private static final String NOM_COLLONE_LONGITUDE = "longitude";
    private static final String NOM_COLLONE_NAMEWIFI = "nomReseau"; // ex : sfr
    private static final String NOM_COLLONE_PROTECTED = "protected";
    private static final String NOM_COLLONE_DATEACQUISIONT ="dateAcquisition";

    public static String getNomColloneNamewifi() {
		return NOM_COLLONE_NAMEWIFI;
	}

	public static String getNomColloneDateacquisiont() {
		return NOM_COLLONE_DATEACQUISIONT;
	}

	public static String SelectAll (){
        return ("SELECT * FROM "
                + NOM_TABLE_MEASURES + ";");
    }

    public static String SelectAllOpen (Boolean noYes){
        return
                ("SELECT * FROM "+ NOM_TABLE_MEASURES + "WHERE "	+ NOM_COLLONE_PROTECTED + "="+ noYes + ";");
    }

    public static String SelectAllOfThisPower (int powerValue){
        return
                ("SELECT * FROM "+ NOM_TABLE_MEASURES + "WHERE "	+ NOM_COLLONE_PUISSANCE + "="+ powerValue + ";");
    }

    public static String SelectThis (ArrayList<String> listOfNameWIFI){
        String nameWIFIToFind = "";
        for (int i = 0; i<listOfNameWIFI.size(); i++){
            nameWIFIToFind += NOM_COLLONE_NAMEWIFI + " = " + listOfNameWIFI.get(i) + " ";

            if (i!=listOfNameWIFI.size()-1){
                nameWIFIToFind += ", ";
            }
        }

        if (nameWIFIToFind != ""){
            return
                    ("SELECT * FROM "+ NOM_TABLE_MEASURES + "WHERE "	+ nameWIFIToFind + ";");
        }
        return "";
    }

    public static String SelectThis(String nameOfWIFI){
        return
                ("SELECT * FROM "+ NOM_TABLE_MEASURES + "WHERE "	+ NOM_COLLONE_NAMEWIFI + "=" +nameOfWIFI + ";");
    }



	public static String getNomColloneProtected() {
		return NOM_COLLONE_PROTECTED;
	}

	public static String getNomCollonePuissance() {
		return NOM_COLLONE_PUISSANCE;
	}

	public static String getNomColloneNameWIFI() {
		return NOM_COLLONE_NAMEWIFI;
	}

	public static String getNomColloneLatitude() {
		return NOM_COLLONE_LATITUDE;
	}

	public static String getNomColloneLongitude() {
		return NOM_COLLONE_LONGITUDE;
	}

	public static String getNomDatabase() {
		return NOM_DATABASE;
	}

	public static String getNomTableMeasures() {
		return NOM_TABLE_MEASURES;
	}







}
