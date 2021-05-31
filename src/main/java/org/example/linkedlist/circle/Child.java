package org.example.linkedlist.circle;

import lombok.Data;
import lombok.ToString;

/**
 * @author castle
 */
@Data
@ToString(exclude = "next")
public class Child {
    private int id;
    private Child next;

    public Child(int id) {
        this.id = id;
    }
}
