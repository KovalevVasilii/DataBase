import dataBase.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*DataBase data = new DataBase("C:\\Users\\user\\IdeaProjects\\dataBase\\src\\dataBase\\DataBase");
        motorShow MSH = new motorShow("Agat");
        data.addMotorShow(MSH);
        data.addCar(new car(MSH.getId(), "BMW X3"));
        data.addCar(new car(MSH.getId(), "UAZ PATRIOT"));
        System.out.println(data);
        System.out.println(data.searchCar("BMW X3"));
        //System.out.println(data.searchCar("BMW X$"));
        motorShow MSH2 = new motorShow("Nizhegorodec");
        data.addMotorShow(MSH2);
        data.addCar(new car(MSH2.getId(), "BMW X6"));
        data.addCar(new car(MSH2.getId(), "LR DISCO"));
        System.out.println("========");
        System.out.println(data);
        System.out.println(data.searchMotorShow(MSH2.getId()));
        //System.out.println(data.searchMotorShow("LEL"));
        data.deleteCar(data.searchCar("LR DISCO"));
        System.out.println("========");
        System.out.println(data);
        System.out.println("========");
        System.out.print(data.carsInMSh(data.searchMotorShow("Nizhegorodec")));
        data.saveDataBase();*/
        boolean flag=true;
        DataBase data = new DataBase("C:\\Users\\user\\IdeaProjects\\dataBase\\src\\dataBase\\DataBase");
        System.out.println("\n1-add motor show, 2-add car, 3-delete car,");
        System.out.println("4-delete motor show, 5-find car, 6-find motor show,");
        System.out.println("7-get car list, 8-print database,9-instructions, 10-exit");
        while(flag)
        { try {
            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Get choice");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Get name of Motor Show");
                    String MSHname=scan2.nextLine();
                    data.addMotorShow(new motorShow(MSHname));
                    data.saveDataBase();
                    break;
                case 2:
                    System.out.println("Get brand of car");
                    MSHname=scan2.nextLine();
                    System.out.println("Get name of Motor Show");
                    String MSH=scan2.nextLine();
                    data.addCar(new car(data.searchMotorShow(MSH).getId(), MSHname));
                    data.saveDataBase();
                    break;
                case 3:
                    System.out.println("Get brand of car");
                    MSHname=scan2.nextLine();;
                    data.deleteCar(data.searchCar(MSHname));
                    data.saveDataBase();
                    break;
                case 4:
                    System.out.println("Get name of Motor Show");
                    MSH=scan2.nextLine();
                    data.deleteMotorShow(data.searchMotorShow(MSH));
                    data.saveDataBase();
                    break;
                case 5:
                    System.out.println("Get brand of car");
                    MSHname=scan2.nextLine();
                    System.out.println(data.searchCar(MSHname));
                    data.saveDataBase();
                    break;
                case 6:
                    System.out.println("Get name of Motor Show");
                    MSH=scan2.nextLine();
                    System.out.println(data.searchMotorShow(MSH));
                    data.saveDataBase();
                    break;
                case 7:
                    System.out.println("Get name of Motor Show");
                    MSH=scan2.nextLine();
                    System.out.println(data.carsInMSh(data.searchMotorShow(MSH)));
                    data.saveDataBase();
                    break;
                case 8:
                    System.out.println(data);
                    break;
                case 10:
                    flag =false;
                    data.saveDataBase();
                    break;
                case 9:
                    System.out.println("1-add motor show, 2-add car, 3-delete car,");
                    System.out.println("4-delete motor show, 5-find car, 6-find motor show,");
                    System.out.println("7-get car list, 8-print database,9-instructions, 10-exit");
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
        catch(Exception exp)
        {
            System.out.println(exp);
        }
        }
        }


}
