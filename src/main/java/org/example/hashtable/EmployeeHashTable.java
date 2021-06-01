package org.example.hashtable;

/**
 * @author Castle
 * @Date 2021/6/1 11:44
 */
public class EmployeeHashTable {

    private EmployeeLinkedList[] employeeLinkedLists;
    private int size;

    public EmployeeHashTable(int size) {
        this.size = size;
        employeeLinkedLists = new EmployeeLinkedList[size];
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee employee) {
        int listNum = hash(employee.getId());
        employeeLinkedLists[listNum].add(employee);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i].list(i);
        }
    }

    public Employee findById(int id) {
        int listNum = hash(id);
        return employeeLinkedLists[listNum].findById(id);
    }

    public int hash(int i) {
        return i % size;
    }

}
