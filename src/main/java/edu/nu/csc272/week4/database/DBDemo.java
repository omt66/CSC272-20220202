package edu.nu.csc272.week4.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author omt
 */
public class DBDemo {
    public static void main(String[] args) {
        System.out.println("--- DB Demo (24 Feb 2022/Thr) ---");
        
        try {
            demo1();
        }
        catch (SQLException ex) {
            System.err.println("Opps. Exception: " + ex.getMessage());
        }
    }
    
    static void demo1() throws SQLException {
        System.out.println("DB demo1");
        String connUrl = "jdbc:mysql://localhost/csc272-20220224?user=odb1&password=odb1";
        Statement statement;
        PreparedStatement preparedStatement;
        
        try (Connection conn = DriverManager.getConnection(connUrl)) {
            String minSalary = "100";
            preparedStatement = conn.prepareStatement("SELECT * FROM employee WHERE salary > ?");
            preparedStatement.setString(1, minSalary);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String employeeId = resultSet.getString("employeeId");
                String location = resultSet.getString("location");
                String salary = resultSet.getString("salary");
                String departmentNo = resultSet.getString("departmentNo");
                
                String formatStr = "Employee: id: %d name: %s employeeId: %s location: %s salary: %s departmentNo: %s\n";
                System.out.printf(formatStr, id, name, employeeId, location, salary, departmentNo);
            }
        }
    }
}
