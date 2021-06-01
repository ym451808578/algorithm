package org.example.hashtable;

/**
 * @author Castle
 * @Date 2021/6/1 11:53
 */
public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "张三");
        Employee employee2 = new Employee(3, "李四");
        Employee employee3 = new Employee(5, "王五");
        Employee employee4 = new Employee(7, "赵柳");
        Employee employee5 = new Employee(8, "苏琪");
        Employee employee6 = new Employee(11, "丁坝");
        EmployeeHashTable hashTable = new EmployeeHashTable(7);
        hashTable.add(employee1);
        hashTable.add(employee2);
        hashTable.add(employee3);
        hashTable.add(employee4);
        hashTable.add(employee5);
        hashTable.add(employee6);
        hashTable.list();
        System.out.println(hashTable.findById(8));
        System.out.println(hashTable.findById(13));
    }
}
