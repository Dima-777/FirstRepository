package main;

import company.Departments;
import viewDepartments.View;


public class Transference {

    public static void main(String[] args) {

        String filePath = args[0];

        Departments departments= new Departments();
        departments.addDepartmentsFromFile(filePath);
        View.viewDepartments(departments);
        View.findCandidates(departments);
        View.moveCandidates(departments);



    }

}
