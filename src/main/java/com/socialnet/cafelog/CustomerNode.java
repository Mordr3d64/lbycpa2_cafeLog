package com.socialnet.cafelog;

import java.time.LocalDateTime;
import java.time.Duration;

class CustomerNode {
    String customerName;
    LocalDateTime loginTime;
    LocalDateTime logoutTime;
    CustomerNode next;

    public CustomerNode(String customerName, LocalDateTime loginTime) {
        this.customerName = customerName;
        this.loginTime = loginTime;
        this.next = null;
    }

    public long getUsageDuration() {
        if (logoutTime == null) return 0;
        return Duration.between(loginTime, logoutTime).toMinutes();
    }
}

class LoginLogoutSystem {
    private CustomerNode head;

    public void login(String customerName) {
        CustomerNode newNode = new CustomerNode(customerName, LocalDateTime.now());
        newNode.next = head;
        head = newNode;
        System.out.println(customerName + " logged in at " + newNode.loginTime);
    }

    public void logout(String customerName) {
        CustomerNode current = head;
        while (current != null) {
            if (current.customerName.equals(customerName) && current.logoutTime == null) {
                current.logoutTime = LocalDateTime.now();
                System.out.println(customerName + " logged out. Duration: " + current.getUsageDuration() + " minutes");
                return;
            }
            current = current.next;
        }
        System.out.println("Customer " + customerName + " is not logged in!");
    }

    public void displayActiveUsers() {
        CustomerNode current = head;
        System.out.println("Active Users:");
        while (current != null) {
            if (current.logoutTime == null) {
                System.out.println("- " + current.customerName + " (Logged in at: " + current.loginTime + ")");
            }
            current = current.next;
        }
    }
}
