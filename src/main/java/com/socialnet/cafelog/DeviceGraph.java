package com.socialnet.cafelog;

import java.util.HashMap;
import java.util.HashSet;

class DeviceGraph {
    private HashMap<String, HashSet<String>> graph = new HashMap<>();

    public void addDevice(String device) {
        graph.putIfAbsent(device, new HashSet<>());
        System.out.println(device + " added to the network.");
    }

    public void connectDevices(String device1, String device2) {
        if (graph.containsKey(device1) && graph.containsKey(device2)) {
            graph.get(device1).add(device2);
            graph.get(device2).add(device1);
            System.out.println(device1 + " connected to " + device2);
        } else {
            System.out.println("One or both devices are not in the network.");
        }
    }

    public void displayNetwork() {
        System.out.println("Device Network:");
        for (String device : graph.keySet()) {
            System.out.println(device + " -> " + graph.get(device));
        }
    }

    public void findAvailableDevices() {
        System.out.println("Available Devices:");
        for (String device : graph.keySet()) {
            if (graph.get(device).isEmpty()) {
                System.out.println("- " + device);
            }
        }
    }
}
