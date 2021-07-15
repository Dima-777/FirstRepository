package main;

import company.Departments;
import viewDepartments.View;

import java.io.*;

public class Transference {

    public static void main(String[] args) throws FileNotFoundException {

        String filePath = args[0];

        Departments departments= new Departments();
        departments.addDepartmentsFromFile(filePath);
        View.viewDepartments(departments);



    }

}
