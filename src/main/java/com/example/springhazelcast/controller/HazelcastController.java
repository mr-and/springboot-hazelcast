package com.example.springhazelcast.controller;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hazelcast")
@Slf4j
@RequiredArgsConstructor
public class HazelcastController {

    private final HazelcastInstance hazelcastInstance;

    @PostMapping("/write-data")
    public String writeData(@RequestParam String key, @RequestParam String value) {
        IMap<String, String> hazelcastInstanceMap = hazelcastInstance.getMap("test-map");
        hazelcastInstanceMap.put(key, value);
        return "Data is stored.";
    }


    @GetMapping("/read-data")
    public String readData(@RequestParam String key){
        IMap<String, String> hazelcastInstanceMap = hazelcastInstance.getMap("test-map");
        hazelcastInstanceMap.put("test", "value");
        hazelcastInstanceMap.put("test2", "value");
        return hazelcastInstanceMap.get(key);
    }

    @GetMapping("/get-alldata")
    public IMap<String, String> readAllData(){
        return hazelcastInstance.getMap("test-map");
    }
}
