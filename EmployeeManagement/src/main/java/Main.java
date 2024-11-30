import data.Employee;
import data.EmployeeData;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EmployeeData employeeData = new EmployeeData();
        employeeData.createTable(); // Создаем таблицу, если её еще нет

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Выводим меню
            System.out.println("Menu:");
            System.out.println("1. Create Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Read Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // Создание сотрудника
                    System.out.println("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter employee position: ");
                    String position = scanner.nextLine();
                    System.out.println("Enter employee salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter hire date (yyyy-MM-dd): ");
                    String hireDate = scanner.nextLine();

                    Employee newEmployee = new Employee(0, name, position, salary, hireDate);
                    employeeData.addEmployee(newEmployee);
                    break;

                case 2:
                    // Удаление сотрудника
                    System.out.println("Enter employee ID to delete: ");
                    int idToDelete = Integer.parseInt(scanner.nextLine());
                    employeeData.deleteEmployee(idToDelete);
                    break;

                case 3:
                    // Обновление данных сотрудника
                    System.out.println("Enter employee ID to update: ");
                    int idToUpdate = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new position: ");
                    String newPosition = scanner.nextLine();
                    System.out.println("Enter new salary: ");
                    double newSalary = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter new hire date (yyyy-MM-dd): ");
                    String newHireDate = scanner.nextLine();

                    Employee updatedEmployee = new Employee(idToUpdate, newName, newPosition, newSalary, newHireDate);
                    employeeData.updateEmployee(updatedEmployee);
                    break;

                case 4:
                    // Чтение всех сотрудников
                    List<Employee> employees = employeeData.getAllEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("No employees found in the database.");
                    } else {
                        System.out.println("All employees:");
                        for (Employee emp : employees) {
                            System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Position: " + emp.getPosition() +
                                    ", Salary: " + emp.getSalary() + ", Hire Date: " + emp.getHireDate());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 5); // Цикл продолжается, пока пользователь не выберет "Exit"
    }
}
