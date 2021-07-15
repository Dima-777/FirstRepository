package human;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Department {
    private List<Employee> employeeList = new ArrayList<>();
    private String name;


    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }


    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }


    public BigDecimal getAvgSalary() {
        if (employeeList.size() == 0) {
            return BigDecimal.valueOf(0);
        }


        BigDecimal sum = BigDecimal.valueOf(0);
        for (Employee employee : employeeList) {
            sum = sum.add(employee.getSalary());
        }

        return sum.divide(BigDecimal.valueOf(employeeList.size()), 2, RoundingMode.HALF_UP);


    }
}
