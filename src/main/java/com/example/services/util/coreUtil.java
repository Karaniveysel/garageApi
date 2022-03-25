package com.example.services.util;

import com.example.services.entity.Garage;
import com.example.services.enums.StatusType;

import java.util.concurrent.ConcurrentHashMap;

public class coreUtil {
    public static ConcurrentHashMap<Integer, Garage>  garageHashMap(int limit){
        Garage garage=null;
        ConcurrentHashMap<Integer, Garage> map=new ConcurrentHashMap<>();
        for (int i=1;i<limit+1;i++){
            garage=new Garage();
            garage.setStatus(StatusType.AVAILABLE);
            map.put(i,garage);
        }
        return map;
    }


}
