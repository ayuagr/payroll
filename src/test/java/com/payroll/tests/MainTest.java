package com.payroll.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("PayrollConfigTest.xml");
        EmpTest et = applicationContext.getBean(EmpTest.class);
        AccTest ac = applicationContext.getBean(AccTest.class);
        AttTest at = applicationContext.getBean(AttTest.class);
        et.crudTest();
        ac.crudTest();
        at.crudTest();
    }
}
