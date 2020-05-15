package pl.sda.projekt;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee=new Employee("Tomasz","Wostocki",'M',5,5000f,43,2,true);
    @org.junit.jupiter.api.Test
    void displayNameUpperCase() {
        //given

        //when
        String result = employee.displayNameUpperCase();

        //then
        assertEquals("TOMASZ WOSTOCKI",result);
    }

    @org.junit.jupiter.api.Test
    void should_return_false_when_compare_5500() {
        //given

        //when
        boolean result=employee.compareSalary(5500f);

        //then
        assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void should_return_true_when_compare_4500() {
        //given

        //when
        boolean result=employee.compareSalary(4500f);

        //then
        assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    void calculateRaise() {
        //given

        //when
        float raise = employee.calculateRaise(10);

        //then
        assertEquals(850f,raise);

    }
}