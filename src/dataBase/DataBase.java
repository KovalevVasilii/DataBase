package dataBase;
import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class DataBase implements Serializable{

    private static final long serialVersionUID = 1L;
    private ArrayList<motorShow> motorShows;
    private ArrayList<car> cars;
    private File dataBaseFile;

    public DataBase(String fileName)
    {
        try
        {
            cars = new ArrayList<car>();
            motorShows = new ArrayList<motorShow>();
            dataBaseFile = new File(fileName);
            FileInputStream fileRead = new FileInputStream (dataBaseFile);
            ObjectInputStream objFile = new ObjectInputStream(fileRead);
            int countGroups = (int) objFile.readObject();
            int countStudents = (int) objFile.readObject();

            for(int i=0;i<countGroups;i++) {
                motorShows.add((motorShow) objFile.readObject());
            }

            for(int i=0;i<countStudents;i++) {
                cars.add((car)objFile.readObject());
            }
            objFile.close();
        }

        catch(FileNotFoundException exp)
        {
            System.out.println("File not found");
        }
        catch(ClassNotFoundException exp)
        {
            System.out.println("File not found");
        }
        catch (IOException exp)
        {
            //System.out.print("NICE");
        }

    }
    public void saveDataBase()
    {
        try
        {
            FileOutputStream  fileOut=new FileOutputStream (dataBaseFile);
            ObjectOutputStream objFileOut = new ObjectOutputStream(fileOut);
            objFileOut.writeObject(motorShows.size());
            objFileOut.writeObject(cars.size());
            for (motorShow group : motorShows)
            {
                objFileOut.writeObject(group);
            }
            for (car student : cars)
            {
                objFileOut.writeObject(student);
            }
            objFileOut.flush();
            objFileOut.close();
        }
        catch(FileNotFoundException exp)
        {
            System.out.println("File not found");
        }
        catch (IOException exp)
        {
            System.out.print(exp);
        }
    }
    public void addCar(car Car) throws DataException
    {
        try
        {
            this.searchCar(Car.getBrand());
        }
        catch(DataException exp)
        {
            try
            {
                this.searchMotorShow(Car.getMotorShowId());
                cars.add(Car);
            }
            catch(DataException exp2)
            {
                throw exp2;
            }
            return;
        }
        throw new DataException(Car.getBrand(),2);
    }
    public void addMotorShow(motorShow MotorShow) throws DataException
    {
        try
        {
            this.searchMotorShow(MotorShow.getId());
        }
        catch(DataException exp)
        {
            motorShows.add(MotorShow);
            return;
        }
        throw new DataException(MotorShow.getName(),2);
    }
    public void deleteCar(car Car) throws DataException
    {
        try
        {
            this.searchCar(Car.getBrand());
            cars.remove(Car);
            return;
        }
        catch(DataException exp)
        {
            throw exp;
        }
    }

    public void deleteMotorShow(motorShow MotorShow) throws DataException
    {
        try
        {
            this.searchMotorShow(MotorShow.getId());
            for (car Car : cars)
            {
                if (Car.getMotorShowId()==MotorShow.getId())
                {
                    cars.remove(Car);
                }
            }
            motorShows.remove(MotorShow);
        }
        catch(DataException exp)
        {
            throw exp;
        }
    }
    public car searchCar(String brand) throws DataException
    {
        for (car Car : cars)
        {
            if (Car.getBrand().compareTo(brand)==0)
            {
                return Car;
            }
        }
        throw new DataException(brand,1);
    }

    public motorShow searchMotorShow(String name) throws DataException
    {
        for (motorShow MotorShow : motorShows)
        {
            if (MotorShow.getName().compareTo(name)==0)
            {
                //System.out.println("Successfully search MSH");
                return MotorShow;
            }
        }
        //System.out.println("Unsuccessfully search MSh");
        throw new DataException(name,1);
    }
    public motorShow searchMotorShow(UUID id) throws DataException
    {
        for (motorShow MotorShow : motorShows)
        {
            if (MotorShow.getId()==id)
            {
                //System.out.println("Successfully search MSHid");
                return MotorShow;
            }
        }
        //System.out.println("Unsuccessfully search MSHid");
        throw new DataException("UUID",1);
    }
    public ArrayList<car> carsInMSh(motorShow MotorShow)
    {
        ArrayList<car> carsInMSh=new ArrayList<car>();
        for (car Car : cars)
        {
            if(Car.getMotorShowId()==MotorShow.getId())
            {
                carsInMSh.add(Car);
            }
        }
        return carsInMSh;
    }
    public String toString()
    {
        String Str=new String();
        for (motorShow MotorShow : motorShows)
        {
            Str+=MotorShow.toString()+"\n";
        }
        for (car Car : cars)
        {
            Str+=Car.toString()+"\n";
        }
        return Str;
    }




}
