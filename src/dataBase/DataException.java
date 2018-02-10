package dataBase;

import java.io.Serializable;

public class DataException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String Error;

    public DataException(String description, int error)
    {
        switch(error)
        {
            case 1:
                Error=description+" is mot found!\n";
                break;
            case 2:
                Error=description+" is already added!\n";
                break;
            case 3:
                Error=description+" is undentifine! \n";
                break;
            default:
                break;
        }
    }
    public String toString()
    {
        return Error;
    }

}
