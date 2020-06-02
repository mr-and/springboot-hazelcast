package com.example.springhazelcast.getting_started;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.Queue;

public class BaseExample {

    public static void main(String[] args) {
        Config config = new Config();
        HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);
        IMap<Integer, String> customers = hz.getMap("customers");
        customers.put(1, "Joe");
        customers.put(2, "Ali");
        customers.put(3, "Avi");

        System.out.println("Customer with key 1: " + customers.get(1));
        System.out.println("Map Size: " + customers.size());

        Queue<String> qCustomers = hz.getQueue("customers");
        qCustomers.offer("Tom");
        qCustomers.offer("Mary");
        qCustomers.offer("Jane");
        System.out.println("First customer: " + qCustomers.poll());
        System.out.println("Second customer: " + qCustomers.poll());
        System.out.println("Queue size: " + qCustomers.size());
    }

}
