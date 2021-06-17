package org.example.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 这里有 n 门不同的在线课程，他们按从 1 到 n 编号。每一门课程有一定的持续上课时间（课程时间）t 以及关闭时间第 d 天。一门课要持续学习 t 天直到第 d 天时要完成，你将会从第 1 天开始。
 * <p>
 * 给出 n 个在线课程用 (t, d) 对表示。你的任务是找出最多可以修几门课。
 * <p>
 *
 * @author Castle
 * @Date 2021/6/17 15:23
 */
public class LeetCode630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            //按课程关闭时间从小到大排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int totalTime = 0;
        int totalCourse = 0;
        for (int i = 0; i < courses.length; i++) {
            if (totalTime + courses[i][0] <= courses[i][1]) {
                totalTime += courses[i][0];
                courses[totalCourse++] = courses[i];
            } else {
                int temp = i;
                for (int j = totalCourse - 1; j >= 0; j--) {
                    if (courses[j][0] > courses[temp][0]) {
                        temp = j;
                    }
                }
                if (courses[temp][0] > courses[i][0]) {
                    totalTime = totalTime - courses[temp][0] + courses[i][0];
                    courses[temp] = courses[i];
                }
            }
        }
        return totalCourse;

    }
}
