package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    private static final String DB_URL = "jdbc:sqlite:resources/employee_db.sqlite";

    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS employees (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "position TEXT NOT NULL," +
                "salary REAL NOT NULL," +
                "hire_date TEXT NOT NULL)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(query);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employees (name, position, salary, hire_date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setDouble(3, employee.getSalary());
            pstmt.setString(4, employee.getHireDate());
            pstmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            System.out.println("Error while adding employee: " + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");
                String hireDate = rs.getString("hire_date"); // Извлекаем строку даты

                Employee employee = new Employee(id, name, position, salary, hireDate);
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching employees: " + e.getMessage());
        }
        return employees;
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Employee deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error while deleting employee: " + e.getMessage());
        }
    }

    public void updateEmployee(Employee employee) {
        String query = "UPDATE employees SET name = ?, position = ?, salary = ?, hire_date = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setDouble(3, employee.getSalary());
            pstmt.setString(4, employee.getHireDate());
            pstmt.setInt(5, employee.getId());
            pstmt.executeUpdate();
            System.out.println("Employee updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error while updating employee: " + e.getMessage());
        }
    }
}
