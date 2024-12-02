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

    public String displayNetwork() {
        StringBuilder text = new StringBuilder("Device Network:\n");
        for (String device : graph.keySet()) {
            text.append(device).append(" -> ").append(graph.get(device)).append("\n");
        }
        return text.toString();
    }


    public String findAvailableDevices() {
        StringBuilder text = new StringBuilder("Available Devices:\n");
        for (String device : graph.keySet()) {
            if (graph.get(device).isEmpty()) {
                text.append("- ").append(device).append("\n");
            }
        }
        return text.toString();
    }
}
