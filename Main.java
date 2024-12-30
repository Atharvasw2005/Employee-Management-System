
import java.util.*;

abstract class Employee
{
    private String Name;
    private int ID;
    protected double Mountly_Salary;
    
        public Employee(String Name,int ID)
        {
            this.Name=Name;
            this.ID=ID;
        }
       
        public String getEmployee_Name()
        {
            return this.Name;
        }
    
        public int getEmployee_ID()
        {
            return this.ID;
        }
    
        public void update_Name(String Name)
        {
            this.Name=Name;
        }

        public void update_Salary(double Salary)
        {
            this.Mountly_Salary=Salary;
        }
        public abstract double Claculate_Salary();
    
        @Override
        public String toString()
        {
         return "Employee:\n \tName : "+this.Name+"\n\tID : "+this.ID+"\n\tSalary : "+this.Claculate_Salary();
        }
    
        @Override
        public boolean equals(Object o)
        {
            Employee e = (Employee)o;
            return ID==e.ID;
        }
    
        public int hashCode()
        {
            return Objects.hashCode(ID);
        }
    }
    
    class Full_Time_Employee extends Employee
    {
        public Full_Time_Employee(String Name,int ID,Double Mountly_Salary) {
            super(Name, ID);
            super.Mountly_Salary=Mountly_Salary;
    }

    @Override
    public double Claculate_Salary()
    {
            return Mountly_Salary;
    }
}

class Part_Time_Employee extends Employee
{
    private double Working_hours;
    private double hours_salary;

    public Part_Time_Employee(String Name,int ID,double hours_salary,double Working_hours)
    {
        super(Name, ID);
        this.hours_salary=hours_salary;
        this.Working_hours=Working_hours;
        super.Mountly_Salary = Working_hours*hours_salary*30;
    }

    @Override
    public double Claculate_Salary()
    {
        
        return  Mountly_Salary;
    }
}

class Payroll_System
{
    private Set<Employee> emplist;

    public Payroll_System()
    {
        emplist = new HashSet<>();
    }

    public void Add_Employee(Employee emp)
    {
        emplist.add(emp);
    }
    public void Remove_Employee(int ID)
    {
        Employee emp_to_remove = null;

        for(Employee e : emplist)
        {
           if(e.getEmployee_ID()==ID)
           {
                emp_to_remove=e;
                break;
           }
        }
        if(emp_to_remove!=null)
        {
            emplist.remove(emp_to_remove);
            System.out.println("EMPLOYEE REMOVE SUCCESSFULLY");
        }
        else{
            System.out.println("EMPLOYEE NOT FOUND");
        }
    }

    public void Display_Employee()
    {
        for(Employee emp : emplist)
        {
            System.out.println(emp);
        }
    }

    public void Update_Employee()
    {
        Scanner sn = new Scanner(System.in);

        System.out.println("Enter Employee ID to Upadate Record : ");
        int ID = sn.nextInt();
        Employee emp1=null;
        
        
            for(Employee emp : emplist)
            {
                if(emp.getEmployee_ID()==ID)
                {
                    emp1=emp;
                    break;
                }
            }

            if(emp1!=null)
            {
                System.out.println("Enter your Choice to Upadate : ");
                System.out.println("1.Name");
                System.out.println("2.Salary");
                int c = sn.nextInt();

               switch(c)
               {
                case 1:
                    System.out.println("Enter Update Name Of Employee : ");
                    String name = sn.next();
                    emp1.update_Name(name);
                break;
                case 2:
                    System.out.println("Enter Update Slary Of Employee : ");
                    double sal= sn.nextDouble();
                    emp1.update_Salary(sal);
                break;
                }
            }
        
    }
}

public class Main
{
    public static void main(String args[])
    {
        Payroll_System p1 = new Payroll_System();
        int c=0,ID;
        String Name;
        double sal;
        while(c!=5)
        {
            System.out.println("\n**********Employee Payroll System************");
            System.out.println("1.Add Employee");
            System.out.println("2.Delete Employee");
            System.out.println("3.Display");
            System.out.println("4.Update Employee");
            System.out.println("5.Exit!!!");
            System.out.println("Enter Your Choice : ");
            Scanner sn = new Scanner(System.in);
             c = sn.nextInt();
            switch(c)
            {
                case 1:
                    System.out.println("Add :\n1.Full Time Employee \t2.Part Time Employee");
                    int empt = sn.nextInt();
                    switch(empt)
                    {
                        case 1:
                            System.out.println("Enter ID Of Employee : ");
                             ID = sn.nextInt();
                            
                            System.out.println("Enter Name Of Employee : ");
                             Name = sn.next();
                         
                            System.out.println("Enter Salary Of Employee : ");
                             sal = sn.nextDouble();
                            
                            Full_Time_Employee emp1 = new  Full_Time_Employee(Name,ID,sal);
                            p1.Add_Employee(emp1);

                            System.out.println("-----------Employee ADD Successfully------------");

                        break;
                        case 2:
                        System.out.println("Enter ID Of Employee : ");
                             ID = sn.nextInt();
                            
                            System.out.println("Enter Name Of Employee : ");
                            Name = sn.next();
                         
                            System.out.println("Enter Working Hours of Employee : ");
                            int work_R = sn.nextInt();

                            System.out.println("Enter Hours Salary Of Employee : ");
                            sal = sn.nextDouble();

                            Part_Time_Employee emp2 = new Part_Time_Employee(Name,ID,sal,work_R);
                            p1.Add_Employee(emp2);
                            System.out.println("-----------Employee ADD Successfully------------");

                        break;
                    }
                break;
                case 3:
                        p1.Display_Employee();
                break;
                case 4:
                        p1.Update_Employee();
                break;
                case 5:
                    System.out.println("Exit");
                break;
            }
        }

    }
}