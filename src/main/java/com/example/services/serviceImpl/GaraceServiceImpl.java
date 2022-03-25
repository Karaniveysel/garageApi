package com.example.services.serviceImpl;

import com.example.services.entity.Garage;
import com.example.services.entity.Vehicle;
import com.example.services.enums.StatusType;
import com.example.services.enums.VehicleType;
import com.example.services.service.GarageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.example.services.util.coreUtil.garageHashMap;

@Service
public class GaraceServiceImpl implements GarageService {
    private static final Logger log = LogManager.getLogger(GaraceServiceImpl.class);

    protected final static int capacity=10;
    ConcurrentHashMap<Integer, Garage> conHashMap=garageHashMap(capacity);
    protected int sequence=0;

    @Override
    public String park(Vehicle vehicle) {
        return addCarToPark(vehicle);
    }

    public String addCarToPark(Vehicle vehicle) {
        int count = 0;
        String strValue = "";
        //String strUUID = UUID.randomUUID().toString().replace("-", "");
        Garage garage = new Garage();
        vehicle.setSlots(VehicleType.valueOf(vehicle.getType().toLowerCase(Locale.ROOT)).getWidth());
        garage.setVehicle(vehicle);
        for (int i = 1; i < capacity + 1; i++) {
            if (conHashMap.get(i).getStatus().equals(StatusType.AVAILABLE) ){
                if (i + garage.getVehicle().getSlots()  > capacity) {
                    strValue = "Garage is full.";
                    break;
                }
                    if (count == 0) {
                        for (int j = 1; j < garage.getVehicle().getSlots() + 1; j++) {
                            if (!conHashMap.get(i).getStatus().equals(conHashMap.get(i + j).getStatus()) || i + garage.getVehicle().getSlots()> capacity) {
                                    count = 0;
                                    break;
                                 }
                            count++;
                            if (count > 0 || garage.getVehicle().getSlots() == 1) {
                                sequence++;
                                for (int l = i; l <= i + garage.getVehicle().getSlots(); l++) {
                                    garage = new Garage();
                                    vehicle.setSlots(VehicleType.valueOf(vehicle.getType().toLowerCase(Locale.ROOT)).getWidth());
                                    garage.setVehicle(vehicle);
                                    //garage.setUuid(strUUID);
                                    garage.setUuid(sequence+"");
                                    if(i==1 && l==i+garage.getVehicle().getSlots())
                                        break;
                                    if(l==i){
                                        garage.setStatus(i==1?StatusType.ALLOCATED:StatusType.LEFT);
                                    }else{
                                        garage.setStatus(StatusType.ALLOCATED);
                                    }
                                    conHashMap.put(l, garage);
                                }
                                strValue = StatusType.ALLOCATED.strValue() + " " + VehicleType.valueOf(vehicle.getType().toLowerCase(Locale.ROOT)).getWidth() + " slot";
                                break;
                            }
                        }
                        break;



                    }

                }
        }
        return strValue;
    }

    @Override
    public void leave(String uuid) {
        try {
            conHashMap.values().stream().filter(x->(x.getStatus().equals(StatusType.ALLOCATED) ||x.getStatus().equals(StatusType.LEFT)) && x.getUuid().equals(uuid)).forEach(x->{
                x.setStatus(StatusType.AVAILABLE);
                x.setVehicle(null);
                x.setUuid(null);
            });
            sequence--;
        }catch(Exception e) {
            log.debug(e.getMessage());

        }

    }

    @Override
    public String status() {
        StringBuffer strValue=new StringBuffer("");
        String uuid="";
        strValue.append("Status:").append(System.lineSeparator());
        for (Garage garage:conHashMap.values()) {
            if(garage.getStatus().equals(StatusType.ALLOCATED) && !uuid.equals(garage.getUuid())){
            strValue.append(garage.getVehicle().getPlate()).append(" ")
                    .append(garage.getVehicle().getColor()).append(" ")
                    .append(conHashMap.entrySet().stream().filter(y->y.getValue().getStatus()
                                    .equals(StatusType.ALLOCATED) && y.getValue().getUuid().equals(garage.getUuid()))
                                    .map(y->y.getKey()).collect(Collectors.toList()).toString())
                    .append(System.lineSeparator());
             uuid=garage.getUuid();
             }
        }
        return strValue.toString();
    }

}
