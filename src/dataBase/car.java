package dataBase;
import java.io.Serializable;
import java.util.UUID;


public class car implements Serializable{
    private String brand;
    private UUID id;
    private UUID motorShowId;
    private static final long serialVersionUID = 1L;
    public car(UUID motorShowID, String brand){
        this.brand=brand;
        this.id=new uniqueID().creatID();
        this.motorShowId=motorShowID;

    }
    public void changeMotorShow(UUID newMSHID)
    {
        this.motorShowId=newMSHID;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMotorShowId() {
        return motorShowId;
    }

    public void setMotorShowID(UUID motorShowID) {
        this.motorShowId = motorShowID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public car(){}

    public String toString()
    {
        return("brand: "+brand);
    }

}
