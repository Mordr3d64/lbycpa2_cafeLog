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

    public String login(String customerName) {
        CustomerNode newNode = new CustomerNode(customerName, LocalDateTime.now());
        newNode.next = head;
        head = newNode;
        return customerName + " has logged in at \n" + LocalDateTime.now();
    }

    public String logout(String customerName) {
        CustomerNode current = head;
        while (current != null) {
            if (current.customerName.equals(customerName) && current.logoutTime == null) {
                current.logoutTime = LocalDateTime.now();
                System.out.println(customerName + " logged out. Duration: " + current.getUsageDuration() + " minutes");
                return "Customer " + customerName + " has logged out.\nDuration: " + current.getUsageDuration() + " minutes";
            }
            current = current.next;
        }
        System.out.println("Customer " + customerName + " is not logged in!");
        return "Customer " + customerName + " is not logged in!";
    }

    public Object displayActiveUsers() {
        CustomerNode current = head;
        System.out.println("Active Users:");
        while (current != null) {
            if (current.logoutTime == null) {
                System.out.println("- " + current.customerName + " (Logged in at: " + current.loginTime + ")");
                return "- " + current.customerName + " (Logged in at: " + current.loginTime + ")";

            }
            current = current.next;
        }
        return null;
    }
}