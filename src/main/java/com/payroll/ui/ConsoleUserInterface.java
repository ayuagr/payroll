package com.payroll.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.payroll.menu.EmpMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsoleUserInterface {

    private Scanner scanner = new Scanner(System.in);

    @Autowired
    private EmpMenu emp;

    public void mainScreen() {
        boolean continueMainMenu = true;
        while (continueMainMenu) {
            System.out.println("please select your option");
            System.out.println(
                    "1: Employee details\n2: Employee Account\n3: Employee Attendance\n4: Exit\n------------------------------");
            int val = scanner.nextInt();
            switch (val) {
                case 1:
                    EmployeeMenu();
                    break;
                case 2:
                    AccountMenu();
                    break;
                case 3:
                    AttendanceMenu();
                    break;
                case 4:
                    continueMainMenu = false;
                    break;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }
    }

    private void AttendanceMenu() {

    }

    private void AccountMenu() {

    }

    private void EmployeeMenu() {
        boolean continueEmpMenu = true;
        while (continueEmpMenu) {
            System.out.println("please select your option");
            System.out.println("1: Create new employee data\n2: Fetch Employee data by ID\n3: Fetch All Employee data\n4: Update Existing Employee data\n5: Delete employee data\n6: Go back to main");
            System.out.println("------------------------------");
            int val = scanner.nextInt();
            switch (val) {
                case 1:
                    try {
                        emp.createEmp();
                    } catch (ClassNotFoundException e) {
                        System.out.println("Emp class not found error, contact support" + e.getMessage());
                    } catch (SQLException e) {
                        System.out.println("SQL error, contact support" + e.getSQLState());
                    }
                    break;
                case 2:
                    try {
                        emp.getEmpbyID();
                    } catch (ClassNotFoundException e) {
                        System.out.println("Emp class not found error, contact support" + e.getMessage());
                    } catch (SQLException e) {
                        System.out.println("SQL error, contact support" + e.getSQLState());
                    }
                    break;
                case 3:
                    try {
                        emp.getAllEmp();
                    } catch (ClassNotFoundException e) {
                        System.out.println("Emp class not found error, contact support" + e.getMessage());
                    } catch (SQLException e) {
                        System.out.println("SQL error, contact support" + e.getSQLState());
                    }
                    break;
                case 4:
                    try {
                        emp.updateEmp();
                    } catch (ClassNotFoundException e) {
                        System.out.println("Emp class not found error, contact support" + e.getMessage());
                    } catch (SQLException e) {
                        System.out.println("SQL error, contact support" + e.getSQLState());
                    }
                    break;
                case 5:
                    try {
                        emp.deleteEmp();
                    } catch (ClassNotFoundException e) {
                        System.out.println("Emp class not found error, contact support" + e.getMessage());
                    } catch (SQLException e) {
                        System.out.println("SQL error, contact support" + e.getSQLState());
                    }
                    break;
                case 6:
                    continueEmpMenu = false;
                    break;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
            System.out.println("------------------------------");
        }
    }
}
