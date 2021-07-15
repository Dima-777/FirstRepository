package company;

import human.Department;
import human.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class Departments {
    private Map<String, Department> departments = new HashMap<>();


    public void addDepartmentsFromFile(String filePath) {
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                if (split.length != 3) {
                    System.out.println("Format not support  - " + line);
                    continue;
                }
                String employeeName = split[0];
                String departmentName = split[1];
                BigDecimal salary = BigDecimal.valueOf(Double.parseDouble(split[2]));

                Employee employee = new Employee(employeeName, salary);
                Department department = departments.get(departmentName);
                if (department == null) {
                    department = new Department(departmentName);
                    department.addEmployee(employee);
                    departments.put(departmentName, department);
                } else {
                    department.addEmployee(employee);
                }
            }

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }

    }

    public List<Department> getDepartments() {
        List<Department> result = new ArrayList<>();
        for (Map.Entry<String, Department> department : departments.entrySet()) {
            result.add(department.getValue());
        }
        return result;
    }
}
