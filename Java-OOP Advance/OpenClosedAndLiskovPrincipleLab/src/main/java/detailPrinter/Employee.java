package detailPrinter;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(this);
    }

    private String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
