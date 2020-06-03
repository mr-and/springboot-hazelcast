package com.example.springhazelcast.cluster_demo;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.config.Config;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;


public class HZFirstMember {

    public static void main(String[] args) throws InterruptedException {
        Config cfg = new Config();
        HazelcastInstance hz = HazelcastClient.newHazelcastClient();
        IMap<Integer, String> mapNames = hz.getMap("List of Names");
        mapNames.put(1, "Joe Smith");
        mapNames.put(2, "Jane Doe");
        mapNames.put(3, "Fred Rogers");
        System.out.println(mapNames.getName());

        for (Integer key : mapNames.keySet()) {
            String value = mapNames.get(key);
            System.out.println(key + ". " + value);
        }

        System.out.println("Number of Entries: " + mapNames.size());

        Thread.sleep(20000);

        System.out.println("Number of Entries: " + mapNames.size());

        mapNames.clear();

    }

}
