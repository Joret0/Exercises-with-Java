package Pr4.CompanyRoster;


public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private Integer age;

    public Employee(String name, double salary, String position, String department, String email, Integer age) {
        this.setName(name);
        this.setSalary(salary);
        this.setPosition(position);
        this.setDepartment(department);
        this.setEmail(email);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return this.salary;
    }
    private void setSalary(double salary) {
        this.salary = salary;
    }
    public String getPosition() {
        return this.position;
    }
    private void setPosition(String position) {
        this.position = position;
    }
    public String getDepartment() {
        return this.department;
    }
    private void setDepartment(String department) {
        this.department = department;
    }
    public String getEmail() {
        return this.email;
    }
    private void setEmail(String email) {
        if (email == null) {
            this.email = "n/a";
            return;
        }
        this.email = email;
    }
    public Integer getAge() {
        return this.age;
    }
    private void setAge(Integer age) {
        if (age == null) {
            this.age = -1;
            return;
        }
        this.age = age;
    }

    public String toString() {
        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }
}
