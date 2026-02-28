/*
Single Responsibility Principle (SRP)
Principle: A class should have only one reason to change, meaning it should have a single, focused job.

Violation Example: An Employee class that handles employee data, salary calculation, and saving to a 
database. Changes in any of these unrelated areas would require modifying the same class.

Adherence Example: Separate the responsibilities into distinct classes:
Employee class to hold employee data (name, date of birth, etc.).
EmployeeSalaryCalculator class to handle salary calculations.
EmployeeRepository class to manage database persistence.
*/
 
import java.util.Date;

class SRP {
    public static void main(String[] args) {
        System.out.println("Single Responsibility Principle (SRP) Example");
    }
}

class EmployeeV1 {
    private String name;
    private Date dateOfBirth;

    public EmployeeV1(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public double calculateSalary() {
        // Complex salary calculation logic
        return 0.0; // Placeholder
    }

    public void saveToDatabase() {
        // Code to save employee data to a database
    }
}

class EmployeeV2 {
    private String name;
    private Date dateOfBirth;

    public EmployeeV2(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}

class EmployeeSalaryCalculator {
    public double calculateSalary(EmployeeV2 employee) {
        // Complex salary calculation logic
        return 0.0; // Placeholder
    }
}

class EmployeeRepository {
    public void saveToDatabase(EmployeeV2 employee) {
        // Code to save employee data to a database
    }
}