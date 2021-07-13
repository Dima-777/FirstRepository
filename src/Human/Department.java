package Human;

import java.math.BigDecimal;
import java.util.Map;

public class Department {
    private Map<String, Employee> employeesByName;


    public Department(Map<String, Employee> employeesByName) {
        this.employeesByName = employeesByName;
    }

    public void addEmployee(Employee employee){
        this.employeesByName.put(employee.getName(),employee);
    }

    public Map<String, Employee> getEmployeesByName() {
        return employeesByName;
    }

      public BigDecimal getAvgSalary() {
          if (employeesByName.size() == 0) {
              return BigDecimal.valueOf(0);
          }

          //sum all employeesByName.salary  /  count (employeesByName.size())
          BigDecimal sum = BigDecimal.valueOf(0);
          for (Map.Entry<String, Employee> entry : employeesByName.entrySet()) {
              sum = sum.add(entry.getValue().getSalary());
          }
          return sum.divide(BigDecimal.valueOf(employeesByName.size()));


      }
}
