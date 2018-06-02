package com.xidian.project7;

import java.util.PriorityQueue;
import java.util.Random;

public class Test5 {
    public static void main(String[] args) {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<Double>();
        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            priorityQueue.offer(random.nextDouble());
        }
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
    }
}
