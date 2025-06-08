import java.util.ArrayList;
import java.util.Scanner;
public class Department{
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
        while(tryParseInt(id) == null){
            System.out.println("Please Enter a valid Id: ");
            id = s.next();
        }

        empId = Integer.parseInt(id);

        
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
        while(!isValid){
            if(id.length() <= 4 && tryParseInt(id) != null && tryParseInt(id) > 0)
            {
                this.id = tryParseInt(id);
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

    public static Integer tryParseInt(String someText) {
        try {
            return Integer.parseInt(someText);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
   
}
