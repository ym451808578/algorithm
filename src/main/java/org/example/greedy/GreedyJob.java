package org.example.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Castle
 * @Date 2021/6/17 14:42
 */
public class GreedyJob {
    public int greedy(int[] jobTimes, int numOfMachine) {
        int numOfJob = jobTimes.length;
        int totalTime = 0;
        if (numOfJob <= numOfMachine) {
            for (int i = 0; i < numOfJob; i++) {
                totalTime += jobTimes[i];
            }
            return totalTime;
        } else {
            //工作排序
            List<Job> jobList = new ArrayList<>();
            for (int i = 0; i < numOfJob; i++) {
                jobList.add(new Job(i + 1, jobTimes[i]));
            }
            Collections.sort(jobList);
            //设备列表
            LinkedList<Machine> machineList = new LinkedList<>();
            for (int i = 0; i < numOfMachine; i++) {
                machineList.add(new Machine(i + 1, 0));
            }

            //开始分配设备
            for (Job job : jobList) {
                Collections.sort(machineList);
                Machine nextMachine = machineList.peek();
                System.out.println("为" + nextMachine.getId() + "设备分配任务" + job.getId() + ", 任务时长：" + job.getTime());
                nextMachine.setAvail(nextMachine.getAvail() + job.getTime());
                totalTime += job.getTime();
            }
            return totalTime;
        }
    }
}
