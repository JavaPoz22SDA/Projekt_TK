package pl.sda.projekt;

public class Employee {
    private String firstName;
    private String lastName;
    private char gender;
    private int nrDepartment;
    private float salary;
    private int age;
    private int kids;
    private boolean maritalStatus;

    public Employee(String firstName, String lastName, char gender, int nrDepartment, float salary, int age, int kids, boolean maritalStatus) {
        this.firstName = checkSpelling(firstName);
        this.lastName = checkSpelling(lastName);
        this.gender = gender;
        this.nrDepartment = nrDepartment;
        this.salary = salary;
        this.age = age;
        this.kids = kids;
        this.maritalStatus = maritalStatus;
    }

    public Employee(String firstName, String lastName, char gender) {
        this.firstName = checkSpelling(firstName);
        this.lastName = checkSpelling(lastName);
        this.gender = gender;
    }


    public void setNrDepartment(int nrDepartment) {
        this.nrDepartment = nrDepartment;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setKids(int kids) {
        this.kids = kids;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public int getNrDepartment() {
        return nrDepartment;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getKids() {
        return kids;
    }

    public boolean isMarried() {
        return maritalStatus;
    }

    private String checkSpelling(String word) {
        return word.trim().substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    /**
     * Wyświetla wszystkie dane o pracowniku
     */
    public void displayAll() {
        StringBuilder builder = new StringBuilder();
        builder.append("Imię: " + getFirstName())
                .append("\nNazwisko: " + getLastName())
                .append("\nPłeć: " + ((getGender() == 'M') ? "mężczyzna" : "kobieta"))
                .append("\nNr działu: " + getNrDepartment())
                .append("\nPłaca: " + String.format("%.2f", getSalary()))
                .append("\nWiek: " + getAge())
                .append("\nLiczba dzieci: " + getKids())
                .append("\nStan cywilny: " + ((isMarried()) ? "mężatka / żonaty" : " panna / kawaler"));
        System.out.println(builder.toString());
    }

    /**
     * Wyświetla imię, nazwisko, płaca
     */
    public void displayNameAndSalary() {
        StringBuilder builder = new StringBuilder();
        builder.append(getFirstName())
                .append(" " + getLastName())
                .append(", Płaca: " + String.format("%.2f", getSalary()));
        System.out.println(builder.toString());
    }

    /**
     * Wyświetla imię i nazwisko dużymi literami
     */
    public String displayNameUpperCase() {
        return getFirstName().toUpperCase() + " " + getLastName().toUpperCase();
    }

    /**
     * Porównuje płace pracownika z @salaryToCompare
     *
     * @param salaryToCompare płaca do porównania
     * @return true jeżeli płaca jest powyżej @salaryToCompare, false poniżej lub równa
     */
    public boolean compareSalary(float salaryToCompare) {
        if (getSalary() <= salaryToCompare)
            return false;
        else
            return true;
    }

    /**
     * Zwiększ płacę o @percent
     * dodatkowo 2% za każde dziecko @kids
     * dodatkowo 3% za @maritalStatus = true
     *
     * @param percent
     * @return obliczoną wartość podwyżki lub -1 jeżeli błąd
     */
    public float calculateRaise(int percent) {
        int percentPerKid = 2, percentIfMarried = 3;
        float result = -1;
        if (percent > 0) {
            result = (percent / 100f) * getSalary();
            if (getKids() > 0)
                result += ((percentPerKid / 100f) * getSalary()) * getKids();
            if (isMarried())
                result += (percentIfMarried / 100f) * getSalary();
        }
        return result;
    }
}
