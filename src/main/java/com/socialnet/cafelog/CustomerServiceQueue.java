package com.socialnet.cafelog;

import java.util.LinkedList;
import java.util.Queue;

class CustomerServiceQueue {
    private Queue<String> queue = new LinkedList<>();
    private int totalWaitTime = 0;
    private int servedCustomers = 0;

    public void enqueue(String customerName) {
        queue.add(customerName);
        System.out.println(customerName + " added to the service queue.");
    }

    public void dequeue() {
        if (queue.isEmpty()) {
            System.out.println("No customers in the queue.");
            return;
        }
        String customer = queue.poll();
        int waitTime = (int) (Math.random() * 10) + 1; // Simulating wait time (1-10 minutes)
        totalWaitTime += waitTime;
        servedCustomers++;
        System.out.println(customer + " served. Wait time: " + waitTime + " minutes.");
    }

    public void displayQueue() {
        System.out.println("Service Queue: " + queue);
    }

    public void averageWaitTime() {
        if (servedCustomers == 0) {
            System.out.println("No customers served yet.");
        } else {
            System.out.println("Average Wait Time: " + (totalWaitTime / servedCustomers) + " minutes.");
        }
    }
}
