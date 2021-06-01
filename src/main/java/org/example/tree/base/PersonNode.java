package org.example.tree.base;

import lombok.Data;
import lombok.ToString;

/**
 * @author Castle
 * @Date 2021/6/1 16:35
 */
@Data
@ToString(exclude = {"left", "right"})
public class PersonNode {
    private int id;
    private String name;
    private PersonNode left;
    private PersonNode right;

    public PersonNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
