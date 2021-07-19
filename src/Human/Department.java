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


    public void removeLastEmployee() {
        if (this.employeeList.isEmpty()) {
            return;
        }
        this.employeeList.remove(this.employeeList.size() - 1);
    }

    public void removeEmployee(Employee employee) {
       int index = this.employeeList.indexOf(employee);
       if (index==-1){
           return;
       }
       this.employeeList.remove(index);
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

        return getSalary().divide(BigDecimal.valueOf(employeeList.size()), 2, RoundingMode.HALF_UP);
    }


    public BigDecimal getSalary() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Employee employee : employeeList) {
            sum = sum.add(employee.getSalary());
        }
        return sum;
    }
}
