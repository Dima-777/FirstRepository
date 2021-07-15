package viewDepartments;

import company.Departments;
import human.Department;
import human.Employee;

import java.util.List;
import java.util.Map;

public class View {

        public static void viewDepartments(Departments departments) {
        for (Department department : departments.getDepartments()) {
            System.out.println("Department - " + department.getName() + " : " + " Average salary -  " + department.getAvgSalary());
            for (Employee employee : department.getEmployeeList()) {

                System.out.println(employee.getName() + " " + " - " + employee.getSalary());
            }

            System.out.println("-------");
        }

    }
}
