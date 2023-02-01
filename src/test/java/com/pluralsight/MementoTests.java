package com.pluralsight;

import com.pluralsight.memento.Caretaker;
import com.pluralsight.memento.Employee;
import com.pluralsight.memento.EmployeeMemento;
import org.junit.Test;
import static org.junit.Assert.*;

public class MementoTests {
    @Test
    public void testEmployeeInfoToString() {
        Employee employee = new Employee();
        employee.setName("John");
        employee.setPhone("555");
        employee.setAddress("Sesame street");

        String expected = "Employee{name='John', phone='555', address='Sesame street'}";
        assertEquals(expected, employee.toString());
    }

    @Test
    public void testGeneratedMementoObject() {
        Employee employee = new Employee();
        employee.setName("Pepito");
        employee.setPhone("+34123");

        EmployeeMemento memento = employee.save();

        assertEquals("Pepito", memento.getName());
        assertEquals("+34123", memento.getPhone());
    }

    @Test
    public void testRevertMemento() {
        Employee employee = new Employee();
        employee.setName("Marcial");
        employee.setAddress("Alcafran");
        employee.setPhone("+34 555");

        String expected = "Employee{name='Marcial', phone='+34 555', address='Alcafran'}";

        EmployeeMemento memento = employee.save();

        employee.setName("Onofre");
        employee.setPhone("+34 123 555");

        employee.revert(memento);

        assertEquals("Marcial", employee.getName());
        assertEquals("Alcafran", employee.getAddress());
        assertEquals("+34 555", employee.getPhone());
    }

    @Test
    public void testEmployeeHistory() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setAddress("Helm Street");
        employee.setPhone("123");

        Caretaker history = new Caretaker();
        history.save(employee);

        employee.setPhone("555");
        history.save(employee);

        employee.setPhone("123 555");

        assertEquals("John Doe", employee.getName());
        assertEquals("Helm Street", employee.getAddress());
        assertEquals("123 555", employee.getPhone());

        history.revert(employee);
        assertEquals("John Doe", employee.getName());
        assertEquals("Helm Street", employee.getAddress());
        assertEquals("555", employee.getPhone());

        history.revert(employee);
        assertEquals("John Doe", employee.getName());
        assertEquals("Helm Street", employee.getAddress());
        assertEquals("123", employee.getPhone());
    }
}
