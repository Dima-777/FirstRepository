import Human.Department;
import Human.Employee;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Transference {

    public static void main(String[] args) throws FileNotFoundException {

        String filePath = "C:\\Users\\dgladilin\\IdeaProjects\\Test\\src\\sotrudniki.txt";

        Map<String, Department> departments = new HashMap<>();
        try(Scanner scanner = new Scanner(new FileInputStream(filePath))){



        while (scanner.hasNext()){
           String line= scanner.nextLine();
            String[] split = line.split(";");
            if (split.length!=3){
                throw new RuntimeException("Split not 3");
            }
            String employeeName = split[0];
            String departmentId = split[1];
            BigDecimal salary = BigDecimal.valueOf(Double.parseDouble(split[2]));
            Employee employee = new Employee(employeeName, salary);
            Department department = departments.get(departmentId);
            if (department == null){
                Map<String, Employee> employees = new HashMap<>();
                employees.put(employeeName, employee);
                department = new Department(employees);
                departments.put(departmentId, department);
            }else {
                department.addEmployee(employee);
            }

        }


        for (Map.Entry<String, Department> department : departments.entrySet()) {
            System.out.println(department.getKey());
            //for department.getValue().getEmployeesByName(){
              //  System.out.println(employee.getKey() + " " + employee.getSalary);
            //}
            System.out.println("---");
            System.out.println(department.getValue().getAvgSalary());
        }
        }catch (Throwable e){
        System.out.println("Error: " + e.getMessage());
    }
    }
}
