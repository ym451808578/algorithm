package org.example.tree.base.thread;

import lombok.Data;
import lombok.ToString;

/**
 * @author Castle
 * @Date 2021/6/2 16:34
 */
@Data
@ToString(exclude = {"left", "right"})
public class PersonNode {
    private int id;
    private String name;
    private PersonNode left;
    private PersonNode right;
    /**
     * 0为左子节点，1为前驱
     */
    private int leftType;
    /**
     * 0为右子节点，1为后驱
     */
    private int rightType;

    public PersonNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
