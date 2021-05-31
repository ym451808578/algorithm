package org.example.linkedlist.single;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author castle
 */
@Data
@AllArgsConstructor
@ToString(exclude = "next")
public class HeroNode {
    private HeroNode next;
    private int id;
    private String name;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
