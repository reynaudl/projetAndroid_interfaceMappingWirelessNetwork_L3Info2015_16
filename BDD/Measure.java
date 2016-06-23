package BDD;
/** Atila Rives */
import java.sql.Date;

public class Measure {
    private int id_measure;
    private int power_measure;
    private double longitude_measure;
    private double latitude_measure;
    private Date dateAcquisition_measure;
    
    public Measure(int power_measure,double latitude_measure, double longitude_measure) {
 super();
 this.power_measure = power_measure;
 this.longitude_measure = longitude_measure;
 this.latitude_measure = latitude_measure;

}

    public Measure(int power_measure, double latitude_measure, double longitude_measure,
                   Date dateAcquisition_measure) {
        super();
        this.power_measure = power_measure;
        this.longitude_measure = longitude_measure;
        this.latitude_measure = latitude_measure;
        this.dateAcquisition_measure = dateAcquisition_measure;
    }

    public Measure(int id_measure, int power_measure, double latitude_measure, double longitude_measure,
                   Date dateAcquisition_measure) {
        super();
        this.id_measure = id_measure;
        this.power_measure = power_measure;
        this.longitude_measure = longitude_measure;
        this.latitude_measure = latitude_measure;
        this.dateAcquisition_measure = dateAcquisition_measure;
        
    }

    public int getId_measure() {
        return id_measure;
    }

    public void setId_measure(int id_measure) {
        this.id_measure = id_measure;
    }

    public int getPower_measure() {
        return power_measure;
    }

    public void setPower_measure(int power_measure) {
        this.power_measure = power_measure;
    }

    public double getLongitude_measure() {
        return longitude_measure;
    }

    public void setLongitude_measure(float longitude_measure) {
        this.longitude_measure = longitude_measure;
    }

    public double getLatitude_measure() {
        return latitude_measure;
    }

    public void setLatitude_measure(float latitude_measure) {
        this.latitude_measure = latitude_measure;
    }

    public Date getDateAcquisition_measure() {
        return dateAcquisition_measure;
    }

    public void setDateAcquisition_measure(Date dateAcquisition_measure) {
        this.dateAcquisition_measure = dateAcquisition_measure;
    }


}
