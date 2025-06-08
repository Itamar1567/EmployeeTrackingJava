
import java.util.Scanner;

public class Employee {

    private final Scanner s = new Scanner(System.in);
    private int id;
    private float salary;
    private String position;
    private String department;
    private String firstname;
    private String lastname;

    public Employee() {
        id = 0;
        salary = 0;
        position = "";
        department = "";
        firstname = "";
        lastname = "";
    }

    public Employee(int id, float salary, String pos, String department, String firstname, String lastname) {
        this.id = 0;
        this.salary = salary;
        this.position = pos;
        this.department = department;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setId(String userInput) {
        boolean isValid = false;
        while (!isValid) {
            if (userInput.length() <= 6 && tryParseInt(userInput) != null && tryParseInt(userInput) > 0) {
                id = tryParseInt(userInput);
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
        while (!isValid) {
            if (tryParseInt(userInput) != null && tryParseInt(userInput) > 0) {
                salary = tryParseInt(userInput);
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
    }

    public void setLastname(String ln) {
        lastname = ln;
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

    public static Integer tryParseInt(String someText) {
        try {
            return Integer.parseInt(someText);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
