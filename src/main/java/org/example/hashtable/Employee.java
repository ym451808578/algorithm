package org.example.hashtable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Castle
 * @Date 2021/6/1 10:24
 */
@Data
@ToString(exclude = "next")
public class Employee {
    private int id;
    private String name;
    private Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
