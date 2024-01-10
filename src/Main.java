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


    @Override
    public String toString(){
        return "Employee[name" + name  +", id:" + id +" sallery:" + calculatesallery() +"]";
    }
}




public  class   Main{


    public static void main(String[] args) {
        System.out.println("payroll management system");
    }
}