public class Executive {
    private String name;
    private String department;

    public Executive(String name) {
        this.name = name;
        this.department = "Unemployed";
    }

    public String getName() {
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
