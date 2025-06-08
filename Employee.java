public class Employee
{
    private int id;
    private float salary;
    private String position;
    private String department;
    private String firstname;
    private String lastname;
    
    public Employee()
    {
        id = 0;
        salary = 0;
        position = "";
        department = "";
        firstname = "";
        lastname = ""; 
    }
    public Employee(int id, float salary, String pos, String department, String firstname, String lastname)
    {
        setId(id);
        this.salary = salary;
        this.position = pos;
        this.department = department;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public void setId(int number)
    {
        if(Integer.toString(number).length() > 6 || number < 0)
        {
            System.out.println("The entered id number must be under 6 digits and positive");
        }
        else
        {
            id = number;
        }
    }
    public void setSalary(float s)
    {
        salary = s;
    }
    public void setPosition(String pos)
    {
        position = pos;
    }
    public void setDepartment(String dept)
    {
        department = dept;
    }
    public void setFirstname(String fn)
    {
        firstname = fn;
    }
    public void setLastname(String ln)
    {
        lastname = ln;
    }

    public int getId()
    {
        return id;
    }
    public float getSalary()
    {
        return salary;
    }
    public String getPosition()
    {
        return position;
    }
    public String getDepartment()
    {
        return department; 
    }
    public String getFirstname()
    {
        return firstname;
    }
    public String getLastname()
    {
        return firstname;
    }

}