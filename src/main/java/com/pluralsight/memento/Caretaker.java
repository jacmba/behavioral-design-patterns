package com.pluralsight.memento;

import java.util.Stack;

public class Caretaker {
    private final Stack<EmployeeMemento> employeeHistory;

    public Caretaker() {
        employeeHistory = new Stack<>();
    }

    public void save(Employee emp) {
        employeeHistory.push(emp.save());
    }

    public void revert(Employee emp) {
        emp.revert(employeeHistory.pop());
    }
}
