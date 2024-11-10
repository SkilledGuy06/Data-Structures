import java.util.LinkedList;
import java.util.Queue;

public class Department {
    private String name;
    private Queue<Executive> executives;

    public Department(String name) {
        this.name = name;
        executives = new LinkedList<>();
    }

    public void addExecutive(Executive exec) {
        executives.add(exec);
        exec.setDepartment(name);
    }

    public void removeExecutive(Executive exec) {
        executives.remove(exec);
    }
    
    public Queue<Executive> getExecutives() {
        return executives;
    }

    public int calculateSalary(Executive exec) {
        int baseSalary = 40000;
        int extraSalary = 5000 * (executives.size() - 1);
        return baseSalary + extraSalary;
    }
}
