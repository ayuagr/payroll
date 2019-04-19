package com.payroll.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.payroll.dao.EmployeeDAO;
import com.payroll.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpMenu {

    @Autowired
    EmployeeDAO ed;

    Scanner scanner = new Scanner(System.in);

    public void getEmpbyID() throws ClassNotFoundException, SQLException {
        System.out.println("Please enter Employee ID");
        long id = scanner.nextLong();
        scanner.nextLine();
        Employee emp = ed.getEmployee(id);
        System.out.println(emp);
    }

    public void getAllEmp() throws ClassNotFoundException, SQLException {
        List<Employee> employees = ed.getAll();
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            System.out.println(emp);
            System.out.println("-------------------");
        }
    }

    public void createEmp() throws ClassNotFoundException, SQLException {
        System.out.println("please enter employee name ");
        String name = scanner.nextLine();
        System.out.println("please enter address of employee");
        String addrs = scanner.nextLine();
        System.out.println("please enter salary of employee");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        Employee emp = new Employee(name, addrs, salary);
        ed.createEmployee(emp);
    }

    public void updateEmp() throws ClassNotFoundException, SQLException {
        System.out.println("please enter employee id ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("please enter employee name ");
        String name = scanner.nextLine();
        System.out.println("please enter address of employee");
        String addrs = scanner.nextLine();
        System.out.println("please enter salary of employee");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        Employee emp = new Employee(id, name, addrs, salary);
        ed.updateEmployee(emp);
    }

    public void deleteEmp() throws ClassNotFoundException, SQLException {
        System.out.println("Please enter Employee ID");
        long id = scanner.nextLong();
        scanner.nextLine();
        ed.deleteEmployee(id);
    }
}