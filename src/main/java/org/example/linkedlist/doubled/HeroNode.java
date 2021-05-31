package org.example.linkedlist.doubled;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author castle
 */
@Data
@AllArgsConstructor
@ToString(exclude = {"next", "prev"})
public class HeroNode {
    private int id;
    private String name;
    private HeroNode next;
    private HeroNode prev;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
