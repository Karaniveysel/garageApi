package com.example.services.util;

import com.example.services.entity.Garage;

import java.util.concurrent.ConcurrentHashMap;

public class core {
    public static ConcurrentHashMap<Integer, Garage>  concurrentFullMap(int limit){
        Garage garage=null;
        ConcurrentHashMap<Integer, Garage> conHashMap=new ConcurrentHashMap<>();
        for (int i=0;i<limit;i++){
            garage=new Garage();
            conHashMap.put(i,garage);
        }

        return conHashMap;
    }


}
