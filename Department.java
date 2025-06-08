import java.util.ArrayList;

public class Department{
    private int id;
    private int totalEmployees;
    private String head;
    private String name;
    private ArrayList<Employee> employees;

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
    }

    public Employee searchForEmployeeById(int id){
        for(int i = 0; i < employees.size(); i++)
        {
            if(employees.get(i).getId() == id){
                return employees.get(i);
            }
            
        }

        System.out.println("Employee not in database");
        return null;
    }
    
    
}