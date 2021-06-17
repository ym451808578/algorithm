package org.example.greedy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Castle
 * @Date 2021/6/17 14:38
 */
@Data
@AllArgsConstructor
public class Machine implements Comparable<Machine> {
    private int id;
    private int avail;

    @Override
    public int compareTo(Machine machine) {
        return Integer.compare(this.avail, machine.avail);
    }
}
