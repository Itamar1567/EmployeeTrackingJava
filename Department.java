import java.util.ArrayList;
import java.util.Scanner;
public class Department{

    /*
    This class's purpose is to create department object with criteria such as:

    ID
    Name
    Head of Department
    etc..

    and add employees into that department
    */

    private final Validation validation = new Validation();
    private final Scanner s = new Scanner(System.in);
    private int totalEmployees;
    private int id;
    private String head;
    private String name;
    private final ArrayList<Employee> employees;

    public Department(){
        id = 0;
        totalEmployees = 0;
        head = "";
        name = "";
        employees = new ArrayList<>();
    }
    public Department(int id, String head, String name, ArrayList<Employee> employees){
        this.id = id;
        this.head = head;
        this.name = name;
        this.employees = employees;
        totalEmployees = employees.size();
    }

    public void addEmployee(Employee emp){
        employees.add(emp);
        totalEmployees += 1;
        emp.setDepartment(getDeptName());
    }

    public Employee searchForEmployeeById(String id){
        int empId;
        Integer parsedString = validation.tryParseInt(id);
        while(parsedString == null){
            System.out.println("Please Enter a valid Id: ");
            id = s.next();
            parsedString = validation.tryParseInt(id);
        }

        empId = parsedString;

        
        for(int i = 0; i < employees.size(); i++)
        {
            if(employees.get(i).getId() == empId){
                return employees.get(i);
            }
        }

       //System.out.println("Employee not in database");
        return null;
    }

    public void setId(String id)
    {
        boolean isValid = false;
        Integer parsedString;
        //Makes sure the user enters a valid ID
        while(!isValid){
            parsedString = validation.tryParseInt(id);
            if(id.length() <= 4 && parsedString != null && parsedString > 0)
            {
                this.id = parsedString;
                isValid = true;

            }
            else
            {
                System.out.println("Entered: " + id);
                System.out.println("Restrictions: \n 1.Must be non negative\n 2. Max 4 Digits\n 3. Must be a number\n Enter ID: ");
                id = s.next();
            }
            
        }
        
    }

    public void setHead(String name)
    {
        head = name;
    }

    public void setDeptName(String name)
    {
        this.name = name;
    }
    public int getID()
    {
        return id;   
    }

    public String getHead()
    {
        return head;
    }

    public String getDeptName()
    {
        return name;
    }

    public int getEmployeesInDepartment(){
        return totalEmployees;
    }   
   
}
