package pl.sda.projekt;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        EmployeeManager employeeManager=new EmployeeManager();

        employeeManager.employees.add(new Employee("Tomasz","Wostocki",'M',5,5000f,43,2,true));
        employeeManager.employees.add(new Employee("Marcin","Kowlaski",'M',3,3500f,33,2,true));
        Scanner scanner=new Scanner(System.in);

        boolean isContinued=true;
        String mainMenu = "\nWitaj w systemie ERP!\n"+
                "1. Pokaż wszyskich pracowników - krótka wersje\n"+
                "2. Dodaj nowego pracownika\n"+
                "3. Export do pliku danych pracownika\n"+
                "4. Usuń pracownika\n"+
                "5. Edycja danych pracownika\n"+
                "6. Przejście do podmenu 1...\n"+
                "7. Export danych i przejście do podmenu 2...\n"+
                "8. Informacja o systemie\n"+
                "0. Wyjście z systemu";

        String subMenu1 = "\nJesteś w podmenu 1!\n"+
                "1. Pokaż pracowników zarabiających nie mniej niż\n"+
                "2. Wyświetl średnia płaca w dziale\n"+
                "3. Wyświetl najwyższe płace\n"+
                "4. Wyświetl dane działów\n"+
                "5. Wyświelt średnią płacę kobiet i mężczyzn\n"+
                "6. Zwiększenie pensji o 10% + bonusy\n"+
                "7. Zwiększenie płacy o daną kwotę\n"+
                "8. Sortowanie wg nazwiska\n"+
                "9. Sortowanie wg płacy";

        String subMenu2 = "\nJesteś w podmenu 2!\n"+
                "1. Wyświetl dane pracownika z najdłuższym nazwiskiem\n"+
                "2. Wyświetl średni wiek pracowników posiadających dzieci\n"+
                "3. Zakoduj dane\n"+
                "4. Utwórz HTML";

        while (isContinued){
        System.out.println(mainMenu);
        System.out.print("Twój wybór: ");
        switch (scanner.nextInt()){
            case 0:
                isContinued=false;
                break;
            case 1:
                employeeManager.employees.stream().forEach(Employee::displayNameAndSalary);
                break;
            case 2:
                employeeManager.addEmployee();
                break;
            case 3:
                employeeManager.saveFile();
            case 4:
                employeeManager.deleteEmployee();
        }
        }
    }
}
