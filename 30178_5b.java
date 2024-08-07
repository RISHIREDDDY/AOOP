// Employee class to manage employee details
public class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

// SalaryCalculator class to handle salary calculations
public class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        switch (employee.getRole()) {
            case "Developer":
                return 5000.0;
            case "Manager":
                return 7000.0;
            default:
                return 3000.0;
        }
    }
}

// Main class to demonstrate SRP
public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", "Developer");
        Employee emp2 = new Employee("Bob", "Manager");

        SalaryCalculator salaryCalculator = new SalaryCalculator();
        System.out.println(emp1.getName() + "'s Salary: " + salaryCalculator.calculateSalary(emp1));
        System.out.println(emp2.getName() + "'s Salary: " + salaryCalculator.calculateSalary(emp2));
    }
}
