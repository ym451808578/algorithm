package org.example.greedy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Castle
 * @Date 2021/6/17 14:39
 */
@Data
@AllArgsConstructor
public class Job implements Comparable<Job> {
    private int id;
    private int time;

    @Override
    public int compareTo(Job job) {
        return Integer.compare(job.time,this.time);
    }
}
