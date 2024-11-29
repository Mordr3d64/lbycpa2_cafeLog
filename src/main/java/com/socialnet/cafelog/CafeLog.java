package com.socialnet.cafelog;

public class CafeLog {
    public static void main(String[] args) {
        // Login/Logout System
        LoginLogoutSystem loginSystem = new LoginLogoutSystem();
        loginSystem.login("Alice");
        loginSystem.login("Bob");
        loginSystem.displayActiveUsers();
        loginSystem.logout("Alice");

        // Customer Service Queue
        CustomerServiceQueue serviceQueue = new CustomerServiceQueue();
        serviceQueue.enqueue("Charlie");
        serviceQueue.enqueue("Dave");
        serviceQueue.displayQueue();
        serviceQueue.dequeue();
        serviceQueue.averageWaitTime();

        // Device Connection Graph
        DeviceGraph deviceGraph = new DeviceGraph();
        deviceGraph.addDevice("PC1");
        deviceGraph.addDevice("PC2");
        deviceGraph.connectDevices("PC1", "PC2");
        deviceGraph.displayNetwork();
        deviceGraph.findAvailableDevices();
    }
}
