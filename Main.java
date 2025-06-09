
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner inputManager = new Scanner(System.in);
    //A department list to hold all created departments
    static ArrayList<Department> departments = new ArrayList<>();

    public static void main(String[] args) {
        String userInput = "";
        while (!userInput.equals("4")) {
            System.out.println("""
            Welcome to the employer database\nHere are actions you may take:\n
            1.Department Creation\n
            2.New Employee\n
            3.Search for employee\n
            4.Exit Program\n
            """);

            userInput = inputManager.next();

            //Switch statement to check for the user's picks
            switch (userInput) {
                case "1" ->
                    departmentCreator(userInput);
                case "2" ->
                    employeeCreator(userInput);
                case "3" ->
                    searchEmployeesInDepartment(userInput);

            }

        }
    }

//This function creates a new department, and sets all the values of said department
    public static void departmentCreator(String userInput) {
        Department department = new Department();
        System.out.println("Enter Department ID: ");
        userInput = inputManager.next();
        department.setId(userInput);
        System.out.println("Enter Department Name: ");
        userInput = inputManager.next();
        department.setDeptName(userInput);
        System.out.println("Enter Head of Department Name: ");
        userInput = inputManager.next();
        department.setHead(userInput);
        System.out.println("Department created\nReturning to main page...\n");
        departments.add(department);

    };
    //This function creates an employee by setting all the values of a new employee object
    public static void employeeCreator(String userInput) {
        Employee newEmployee = new Employee();
        System.out.println("Enter First Name: ");
        userInput = inputManager.next();
        newEmployee.setFirstname(userInput);
        System.out.println("Enter Last Name: ");
        userInput = inputManager.next();
        newEmployee.setLastname(userInput);
        System.out.println("Enter Salary: ");
        userInput = inputManager.next();
        newEmployee.setSalary(userInput);
        System.out.println("Enter Position: ");
        userInput = inputManager.next();
        newEmployee.setPosition(userInput);
        System.out.println("Enter Employee ID: ");
        userInput = inputManager.next();
        newEmployee.setId(userInput);

        System.out.println("Assign Department: ");
        userInput = inputManager.next();
        searchForDepartment(userInput, newEmployee);

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void searchForDepartment(String userInput, Employee newEmployee) {
        //Checker for cases where no departments exist
        if (departments.isEmpty()) {
            System.out.println("No departments exists in the database, Enter: \n1. Create Department\n2. Exit");
            userInput = inputManager.next();
            if(userInput.equals("1")){
                departmentCreator(userInput);
                userInput = inputManager.next();
            }
            else
            {
                return;
            }
        }
        while (true) {
            for (int i = 0; i < departments.size(); i++) {
                if (userInput.equals(departments.get(i).getDeptName())) {
                    departments.get(i).addEmployee(newEmployee);
                    System.out.println(newEmployee.getFirstname() + " was added to " + departments.get(i).getDeptName() + "\n");
                    return;
                }

            }

            System.out.println(userInput + " does not exist\n");
            System.out.println("All departments: \n");
            for (int i = 0; i < departments.size(); i++) {
                System.out.println(departments.get(i).getDeptName() + "\n");
            }

            userInput = inputManager.next();
 
        }

    }

//This function iterates through all created departments and checks if an entered employee ID exists in that department
    public static void searchEmployeesInDepartment(String userInput) {
        while (!userInput.equals("2")) {
            System.out.println("Enter employee ID: ");
            userInput = inputManager.next();
            for (int i = 0; i < departments.size(); i++) {
                if (departments.get(i).searchForEmployeeById(userInput) != null) {
                    System.out.println("Name: " + departments.get(i).searchForEmployeeById(userInput).getName());
                    System.out.println("Department: " + departments.get(i).searchForEmployeeById(userInput).getDepartment());
                    System.out.println("Position: " + departments.get(i).searchForEmployeeById(userInput).getPosition());
                    System.out.println("Identification: " + departments.get(i).searchForEmployeeById(userInput).getId());
                    System.out.println("Salary: " + departments.get(i).searchForEmployeeById(userInput).getSalary());
                    return;
                }
            }
            System.err.println("Employee not found, Option: \n1.Try again\n2.Exit to main");
            userInput = inputManager.next();
        }
    }

}
