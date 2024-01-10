import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;
abstract class Employee{
    private String name;
    private int id;


    Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

    public String get_name(){
        return name;
    }

    public int get_id(){
        return id;
    }


   public abstract Double calculatesallery();

    public abstract String Role();


    @Override
    public String toString(){
        return "Employee[name:" + name  +", id:" + id +" sallery:" + calculatesallery() + "Role:" + Role() + "]";
    }
}


class FullTimeEmployee extends Employee{

    private  Double monthlysallery ;


    public FullTimeEmployee(String name,int id, Double sallery){
        super(name ,id);
        this.monthlysallery=sallery;
    }


    public Double  calculatesallery(){
       return monthlysallery;
    }
    public String Role(){
        return "full time employee";
    }

}


class PartTimeEmployee extends Employee{


    private int  Hoursworked;
    private double hoursrate;


    public PartTimeEmployee(String name, int id, int hoursworked, double hoursrate){
        super(name,id);
        this.Hoursworked=  hoursworked;
        this.hoursrate=hoursrate;
    }




    public Double calculatesallery(){
        return Hoursworked*hoursrate;
    }

    public String Role(){
        return "parttime employee";
    }
}



class PayRollSystem {
    private ArrayList<Employee>employeelist;


    public PayRollSystem(){
        employeelist=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeelist.add(employee);
    }

    public void RemoveEmployee (int id){
        Employee removeemployee=null;
        for( Employee employe:employeelist){
            if(employe.get_id()==id){
                removeemployee=employe;
                break;
            }


        }
        if (removeemployee != null) {
            employeelist.remove(removeemployee);
            System.out.println("Employee with ID " + id + " removed successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void displayEmployee()
    {
        for(Employee employee:employeelist)
        {
            System.out.println(employee);
        }
    }

}

public  class   Main{



    public  static void  menu(){
        System.out.println("welcome to payroll management system");
        System.out.println("1:Add Employee");
        System.out.println("2:Display Employee:");
        System.out.println("3:Remove Employee");
        System.out.println("press 0 to exit");


    }
//


    public static void main(String[] args) {

        int emptype;
        String name;
        int id;
        Double sallery;
        int hoursworked;
        Double hoursrate;
        PayRollSystem payroll=new PayRollSystem();

        menu();
        int choice=100;


        while (choice!=0){
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    System.out.println("5:full time employee:");
                    System.out.println("6:parttime employee");
                    System.out.println("niroj satyal");

                    emptype=sc.nextInt();
                    sc.nextLine();
                    if(emptype==5)
                    {

                        System.out.println("enter the employee name");
                        name = sc.nextLine();
                        System.out.println("enter the employee id");
                        id=sc.nextInt();
                        System.out.println("enter the monthly sallery");
                        sallery=sc.nextDouble();
                        FullTimeEmployee emp1=new FullTimeEmployee(name,id,sallery);
                        payroll.addEmployee(emp1);
                        System.out.println("employee added succesfully");
                        menu();
                        break;

                    }
                    else if (emptype==6)
                    {

                                System.out.println("enter the employee name");
                                name= sc.nextLine();
                                System.out.println("enter the employee id");
                                id=sc.nextInt();
                                sc.nextLine();
                                System.out.println("enter the total hours worked:");
                                hoursworked=sc.nextInt();
                                System.out.println("enter the total hours worked rate:");
                                hoursrate=sc.nextDouble();
                                PartTimeEmployee emp2=new PartTimeEmployee(name,id,hoursworked,hoursrate);
                                payroll.addEmployee(emp2);
                                System.out.println("employee added successfully");
                                menu();

                    }
                    else
                    {

                        break;


                    }
                    break;

                case 2:
                    payroll.displayEmployee();
                    menu();
                    break;
                case 3:
                    System.out.println("enter the id of the employee:");
                    id=sc.nextInt();
                    payroll.RemoveEmployee(id);
                    menu();
                    break;
                default:
                    System.out.println("please enter right choice:");
                    menu();
                    break;

            }







            }
        System.out.println("visit again");
        System.exit(0);
        }

    }
