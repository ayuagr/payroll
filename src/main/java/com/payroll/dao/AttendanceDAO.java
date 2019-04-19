package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.payroll.pojo.Attendance;
import com.payroll.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttendanceDAO{
    @Autowired
    EmployeeDAO empdao;

    @Autowired
    DBAdmin dbAdmin;

    public List<Attendance> getAttById(long id) throws Exception {
        Connection conn = dbAdmin.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from attendance where empid = " + id);
        return createObjectFromRs(rs);
    }

    public List<Attendance> getAttByDate(java.sql.Date d1, java.sql.Date d2) throws Exception {
        Connection conn = dbAdmin.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from attendance where date >= '" + d1 + "' and date <= '" + d2 + "'");
        return createObjectFromRs(rs);
    }

    public List<Attendance> createObjectFromRs(ResultSet rs) throws Exception {
        List<Attendance> attendance = new ArrayList<Attendance>();
        while (rs.next()) {
            long attid = rs.getLong("attid");
            Date date = rs.getDate("date");
            int hours = rs.getInt("hours");
            long empid = rs.getLong("empid");
            Employee emp = empdao.getEmployee(empid);
            Attendance att = new Attendance(attid, date, hours, emp);
            attendance.add(att);
        }
        return attendance;
    }

    public List<Attendance> getAttByDateAndEmp(java.sql.Date d1, java.sql.Date d2, long id) throws Exception {
        Connection conn = dbAdmin.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from attendance where empid = " + id + " and date >= '" + d1 + "' and date <= '" + d2 + "'");
        return createObjectFromRs(rs);
    }

    public void createAtt(Attendance att) throws ClassNotFoundException, SQLException {
        Connection conn = dbAdmin.getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into attendance(date,hours,empid) values (?,?,?)");
        stmt.setDate(1, (java.sql.Date) att.getDate());
        stmt.setInt(2, att.getHours());
        stmt.setLong(3, att.getEmp().getEmpid());
        stmt.execute();
    }

    public void deleteAtt(long id) throws SQLException, ClassNotFoundException {
        Connection conn = dbAdmin.getConnection();
        PreparedStatement stmt = conn.prepareStatement("delete from attendance where attid = ?");
        stmt.setLong(1, id);
        stmt.execute();
    }

    public void updateAtt(Attendance att) throws SQLException, ClassNotFoundException {
        Connection conn = dbAdmin.getConnection();
        PreparedStatement stmt = conn.prepareStatement("update attendance set date=?,hours=?,empid=? where attid=?");
        stmt.setDate(1, (java.sql.Date) att.getDate());
        stmt.setInt(2, att.getHours());
        stmt.setLong(3, att.getEmp().getEmpid());
        stmt.setLong(4, att.getAttid());
        stmt.execute();
    }
}
