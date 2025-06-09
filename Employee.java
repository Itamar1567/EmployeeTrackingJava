
import java.util.Scanner;

public class Employee {

 /*
 This class's purpose is to create employee objects with given criteria such as

 ID
 name
 Assigned Department
 Salary
 etc...

 and add these employee objects to departments

 */
    private final Validation validation = new Validation();
    private final Scanner s = new Scanner(System.in);
    private int id;
    private float salary;
    private String position;
    private String department;
    private String firstname;
    private String lastname;
    private String name;

    public Employee() {
        id = 0;
        salary = 0;
        position = "";
        department = "";
        firstname = "";
        lastname = "";
        name = "";
    }

    public Employee(int id, float salary, String pos, String department, String firstname, String lastname) {
        this.id = 0;
        this.salary = salary;
        this.position = pos;
        this.department = department;
        this.firstname = firstname;
        this.lastname = lastname;
        name = firstname + " " + lastname;
    }

    public void setId(String userInput) {
        boolean isValid = false;
        Integer parsedString;
        while (!isValid) {
            parsedString = validation.tryParseInt(userInput);
            if (userInput.length() <= 6 && parsedString != null && parsedString > 0) {
                id = parsedString;
                isValid = true;

            } else {
                System.out.println("Entered: " + userInput);
                System.out.println("Restrictions: \n 1.Must be non negative\n 2. Max 6 Digits\n 3. Must be a number\n Enter ID: ");
                userInput = s.next();
            }

        }
    }

    public void setSalary(String userInput) {

        boolean isValid = false;
        Integer parsedString;
        while (!isValid) {
            parsedString = validation.tryParseInt(userInput);
            if (parsedString != null && parsedString > 0) {
                salary = parsedString;
                isValid = true;

            } else {
                System.out.println("Entered: " + userInput);
                System.out.println("Restrictions: \n 1.Must be non negative\n 2.Must be a number\n Enter ID: ");
                userInput = s.next();
            }

        }
    }

    public void setPosition(String pos) {
        position = pos;
    }

    public void setDepartment(String dept) {
        department = dept;
    }

    public void setFirstname(String fn) {
        firstname = fn;
        setName();  
    }

    public void setLastname(String ln) {
        lastname = ln;
        setName();
    }

    public void setName(){
        name = lastname + " " + firstname;
    }

    public int getId() {
        return id;
    }

    public float getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName(){
        return name;
    }

}
