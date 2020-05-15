package pl.sda.projekt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    List<Employee> employees = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addEmployee() {
        System.out.print("Podaj imię:");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko:");
        String lastName = scanner.nextLine();
        System.out.print("Podaj płeć 'K' - kobieta, 'M' - mężczyzna:");
        char gender = scanner.next().toUpperCase().charAt(0);
        Employee employee = new Employee(name, lastName, gender);
        System.out.print("Podaj nr działu:");
        employee.setNrDepartment(scanner.nextInt());
        System.out.print("Podaj wynagrodzenie:");
        employee.setSalary(scanner.nextFloat());
        System.out.print("Podaj wiek:");
        employee.setAge(scanner.nextInt());
        System.out.print("Podaj liczbę dzieci:");
        employee.setKids(scanner.nextInt());
        System.out.print("Podaj stan cywilny (true - mężatka/żonaty):");
        employee.setMaritalStatus(scanner.nextBoolean());

        employees.add(employee);
    }

    public void saveFile() throws IOException {
        System.out.print("Podaj nazwę pliku do zapisu: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);
        for (Employee e : employees) {
            writer.write(e.getLastName() + ", " + e.getFirstName() + ", " + e.getGender() + ", " +
                    e.getNrDepartment() + ", " + e.getSalary() + ", " + e.getAge() + ", " + e.getKids());
            writer.write("\n");
        }
        writer.flush();
        writer.close();
        System.out.println("Zapisano do pliku.");
    }

    public void deleteEmployee() {
        int i = 1;
        System.out.println("\nWybierz pracownika do usunięcia.");
        for (Employee e : employees) {
            System.out.println("\nPracownik - " + i++);
            e.displayAll();
        }
        System.out.println("\nTwój wybór (numer): ");
        int selected = scanner.nextInt();
        if (selected <= employees.size()) {
            employees.remove(selected - 1);
            System.out.println("Usunięto pracownika!");
        }
    }
}
