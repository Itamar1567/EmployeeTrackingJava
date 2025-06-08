import java.util.ArrayList;

public class Main{

    public static void main(String[] args)
    {
        ArrayList<Employee> maintananceEmployees = new ArrayList<>();
        Employee employee_1 = new Employee(1,100,"Genator", "Maintanance", "John", "Doe");
        Employee employee_2 = new Employee(2,200,"Plungerer", "Maintanance", "Jo", "Do");
        Employee employee_3 = new Employee(3,300,"Cleaner", "Maintanance", "John", "Wick");
        maintananceEmployees.add(employee_1);
        maintananceEmployees.add(employee_2);
        maintananceEmployees.add(employee_3);
        Department maintanance = new Department(1, "George", "Maintanance", maintananceEmployees);
        System.out.println(employee_1.getId()); 
        System.out.println(maintanance.searchForEmployeeById(1).getFirstname());
    }

}