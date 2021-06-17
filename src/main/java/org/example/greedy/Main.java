package org.example.greedy;

/**
 * @author Castle
 * @Date 2021/6/17 15:04
 */
public class Main {
    public static void main(String[] args) {
        int[] jobTimes = {5, 4, 2, 14, 16, 6, 5, 3};
        GreedyJob greedyJob = new GreedyJob();
        greedyJob.greedy(jobTimes, 3);

        //int[][] courses = {{6, 17}, {5, 17}, {4, 13}, {6, 17}, {1, 7}, {1, 11}, {9, 10}, {4, 4,}, {5, 16}};
        int[][] courses = {{5, 5}, {4, 6}, {2, 6}};
        LeetCode630 leetCode630 = new LeetCode630();
        int i = leetCode630.scheduleCourse(courses);
        System.out.println(i);
    }
}
