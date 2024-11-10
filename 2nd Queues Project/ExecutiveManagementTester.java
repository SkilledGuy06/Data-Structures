import java.util.HashMap;
import java.util.Scanner;

public class ExecutiveManagementTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Executive> executives = new HashMap<>();
        HashMap<String, Department> departments = new HashMap<>();

        while (true) {
            System.out.print("> ");
            String command = scanner.next();

            switch (command) {
                case "Add":
                    String deptName = scanner.next();
                    departments.put(deptName, new Department(deptName));
                    System.out.println("Added department: " + deptName);
                    break;

                case "Hire":
                    String execName = scanner.next();
                    executives.put(execName, new Executive(execName));
                    System.out.println("Hired executive: " + execName);
                    break;

                case "Join":
                    execName = scanner.next();
                    deptName = scanner.next();
                    if (executives.containsKey(execName) && departments.containsKey(deptName)) {
                        Executive exec = executives.get(execName);
                        Department dept = departments.get(deptName);
                        dept.addExecutive(exec);
                        System.out.println(execName + " joined " + deptName);
                    } else {
                        System.out.println("Invalid executive or department.");
                    }
                    break;

                case "Quit":
                    execName = scanner.next();
                    if (executives.containsKey(execName)) {
                        Executive exec = executives.get(execName);
                        Department dept = departments.get(exec.getDepartment());
                        if (dept != null) {
                            dept.removeExecutive(exec);
                            System.out.println(execName + " has quit.");
                        }
                    } else {
                        System.out.println("Executive not found.");
                    }
                    break;
                    
                case "Change":
                    execName = scanner.next();
                    deptName = scanner.next();
                    if (executives.containsKey(execName) && departments.containsKey(deptName)) {
                        Executive exec = executives.get(execName);
                        Department currentDept = departments.get(exec.getDepartment());
                        Department newDept = departments.get(deptName);
                        
                        if (currentDept != null) {
                            currentDept.removeExecutive(exec);  // Remove from current department
                            newDept.addExecutive(exec);         // Add to new department
                            exec.setDepartment(deptName);        // Update executive's department
                            System.out.println(execName + " has been transferred to " + deptName);
                        }
                    } else {
                        System.out.println("Invalid executive or department.");
                    }
                    break;

                case "Payroll":
                    for (String key : departments.keySet()) {
                        Department dept = departments.get(key);
                        System.out.println("Department: " + key);
                        for (Executive exec : dept.getExecutives()) {
                            int salary = dept.calculateSalary(exec);
                            System.out.println(exec.getName() + ": $" + salary);
                        }
                    }
                    break;

                case "Salary":
                    execName = scanner.next();
                    if (executives.containsKey(execName)) {
                        Executive exec = executives.get(execName);
                        Department dept = departments.get(exec.getDepartment());
                        if (dept != null) {
                            int salary = dept.calculateSalary(exec);
                            System.out.println(execName + "'s salary: $" + salary);
                        } else {
                            System.out.println("Executive is unemployed.");
                        }
                    } else {
                        System.out.println("Executive not found.");
                    }
                    break;

                case "Exit":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}
