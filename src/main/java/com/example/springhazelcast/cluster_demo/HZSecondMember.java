package com.example.springhazelcast.cluster_demo;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.config.Config;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HZSecondMember {

    public static void main(String[] args) throws InterruptedException {
        Config cfg = new Config();
        HazelcastInstance hz = HazelcastClient.newHazelcastClient();
        IMap<Integer, String> mapNames = hz.getMap("List of Names");
        mapNames.put(4, "Tarkan Tevetoglu");
        mapNames.put(5, "Farrokh Bulsara");
        mapNames.put(6, "Gordon Sumner");
        mapNames.put(7, "Seven");
        System.out.println(mapNames.getName());

        for (Integer key : mapNames.keySet()) {
            String value = mapNames.get(key);
            System.out.println(key + ". " + value);
        }
        System.out.println("Number of Entries: " + mapNames.size());

        hz.shutdown();

    }
}
