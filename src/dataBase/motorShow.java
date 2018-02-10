package dataBase;


import java.io.Serializable;
import java.util.UUID;


public class motorShow implements Serializable{
    private UUID id;
    private String name;
    private static final long serialVersionUID = 1L;

    public motorShow(String name){
        id =new uniqueID().creatID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public motorShow(){}
    public String toString()
    {
        return "Name of MSH: "+ name;
    }

}
