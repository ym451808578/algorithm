package org.example.hashtable;

/**
 * @author Castle
 * @Date 2021/6/1 11:32
 */
public class EmployeeLinkedList {
    private Employee head;

    public void add(Employee employee) {
        if (head == null) {
            head = employee;
            return;
        }
        Employee temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(employee);
    }

    public void list(int num) {
        System.out.println("第" + num + "条链表的信息：");
        Employee temp = head;
        if (temp == null) {
            System.out.println("空链表");
            return;
        }
        System.out.println(temp);
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp);
        }
    }

    public Employee findById(int id) {
        if (head == null) {
            return null;
        }
        Employee temp = head;
        while (temp != null) {
            if (temp.getId() == id) {
                return temp;
            } else {
                temp = temp.getNext();
            }
        }
        return null;
    }
}
