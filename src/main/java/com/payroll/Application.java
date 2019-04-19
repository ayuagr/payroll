package com.payroll;

import com.payroll.ui.ConsoleUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String args[]) {
        System.out.println("welcome to payroll software");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("PayrollConfig.xml");
        ConsoleUserInterface cui = applicationContext.getBean(ConsoleUserInterface.class);
        cui.mainScreen();
    }

}
