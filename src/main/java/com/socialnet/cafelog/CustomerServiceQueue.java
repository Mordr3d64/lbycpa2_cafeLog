package com.socialnet.cafelog;

import java.util.LinkedList;
import java.util.Queue;

class CustomerServiceQueue {
    private final Queue<String> queue = new LinkedList<>();
    private int totalWaitTime = 0;
    private int servedCustomers = 0;

    public String enqueue(String customerName) {
        queue.add(customerName);
        System.out.println(customerName + " added to the service queue.");
        return customerName + " added to \nthe service queue.";
    }

    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("No customers in the queue.");
            return "No customers in\nthe queue.";
        }
        String customer = queue.poll();
        int waitTime = (int) (Math.random() * 10) + 1; // Simulating wait time (1-10 minutes)
        totalWaitTime += waitTime;
        servedCustomers++;
        System.out.println(customer + " served. Wait time: " + waitTime + " minutes.");
        return customer + " served. \nWait time: " + waitTime + " minutes.";
    }

    public void displayQueue() {
        System.out.println("Service Queue: " + queue);
    }

    public String averageWaitTime() {
        if (servedCustomers == 0) {
            System.out.println("No customers served yet.");
            return "No customers served yet.";
        } else {
            System.out.println("Average Wait Time: " + (totalWaitTime / servedCustomers) + " minutes.");
            return "\nAverage Wait Time:" + (totalWaitTime / servedCustomers) + " minutes.";
        }
    }
}
