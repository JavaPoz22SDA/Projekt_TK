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
int i;
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
    public void editEmployee() {
        int i = 1;
        boolean isContinued=true;
        Employee tempEmployee;
        System.out.println("\nWybierz pracownika do edycji.");
        for (Employee e : employees) {
            System.out.println("\nPracownik - " + i++);
            e.displayAll();
        }
        System.out.println("\nTwój wybór (numer): ");
        int selected = scanner.nextInt()-1;
//        if (scanner.nextInt() <= employees.size()) {
//        }
        tempEmployee=employees.get(selected);
        System.out.println("Wybrano pracownika: " + tempEmployee.displayNameUpperCase());
        while (isContinued) {
            System.out.println("Wybierz dane do edycji:");
            System.out.println("1. Nazwsko (tylko kobiety)");
            System.out.println("2. Nr działu");
            System.out.println("3. Płaca");
            System.out.println("4. Wiek");
            System.out.println("5. Liczba dzieci");
            System.out.println("6. Stan cywilny");
            System.out.println("0. Zapisz zmiany");
            System.out.println("\nTwój wybór (numer): ");
            int selectedSubMenu = scanner.nextInt();
            switch (selectedSubMenu) {
                case 1:
                    if (tempEmployee.getGender() == 'M')
                        System.out.println("Ten pracownik nie jest kobietą.");
                    else {
                        System.out.print("Podaj nowe nazwisko: ");
                        tempEmployee.setLastName(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.print("Podaj nowy nr działu: ");
                    tempEmployee.setNrDepartment(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Podaj nowe zarobki: ");
                    tempEmployee.setSalary(scanner.nextFloat());
                    break;
                case 4:
                    System.out.print("Podaj nowy wiek: ");
                    tempEmployee.setAge(scanner.nextInt());
                    break;
                case 5:
                    System.out.print("Podaj nową liczbę dzieci: ");
                    tempEmployee.setKids(scanner.nextInt());
                    break;
                case 6:
                    System.out.print("Podaj nowy stan cywilny (true - mężatka/żonaty): ");
                    tempEmployee.setMaritalStatus(scanner.nextBoolean());
                    break;
                case 0:
                    employees.remove(selected);
                    employees.add(tempEmployee);
                    System.out.println("Zapisano zmiany.");
                    isContinued=false;
                    break;

            }
        }
    }
}
