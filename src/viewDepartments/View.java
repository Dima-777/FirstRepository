package viewDepartments;

import company.Departments;
import human.Department;
import human.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class View {
    private static List<Employee> candidates = new ArrayList<>();

    public static void viewDepartments(Departments departments) {
        for (Department department : departments.getDepartments()) {
            System.out.println("Department - " + department.getName() + " : " + " Average salary -  " + department.getAvgSalary());
            for (Employee employee : department.getEmployeeList()) {

               System.out.format("%s  -  %1s %n", employee.getName(), employee.getSalary());

             //   System.out.println(employee.getName() + " " + " - " + employee.getSalary());

            }

            System.out.println("-------");
        }

    }

    public static void findCandidates(Departments departments) {
        for (Department department : departments.getDepartments()) {
            int countEmployees = department.getEmployeeList().size();
            if (countEmployees < 2) {
                continue;
            }
            BigDecimal avgSalary = department.getAvgSalary();
            BigDecimal totalSalary = department.getSalary();
            for (Employee employee : department.getEmployeeList()) {
                BigDecimal localAvgSalary = totalSalary.subtract(employee.getSalary()).divide(BigDecimal.valueOf(countEmployees - 1), 2, RoundingMode.HALF_UP);
                if (avgSalary.compareTo(localAvgSalary) < 0) {
                    System.out.println("Candidate " + employee.getName() + ", Avgsalary before = " + avgSalary + ", Avgsalary after =  " + localAvgSalary);

                    candidates.add(employee);
                }

            }
        }
        System.out.println();
    }

    public static void moveCandidates(Departments departments) {
        for (Employee candidate : candidates) {
            for (Department department : departments.getDepartments()) {
                BigDecimal avgSalary = department.getAvgSalary();
                department.addEmployee(candidate);
                BigDecimal newAvgSalary = department.getAvgSalary();
                if (avgSalary.compareTo(newAvgSalary) < 0) {
                    System.out.println("Candidate - " + candidate.getName() + ", Avgsalary before = " + avgSalary + ", Avgsalary after =  " + newAvgSalary + ", In to department name = " + department.getName());

                }
                department.removeLastEmployee();
            }
        }
    }


}

