package com.example.services.serviceImpl;

import com.example.services.entity.Garage;
import com.example.services.entity.Vehicle;
import com.example.services.model.GarageDto;
import com.example.services.model.StatusType;
import com.example.services.model.VehicleType;
import com.example.services.service.GarageService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.example.services.util.core.concurrentFullMap;

@Service
public class GaraceServiceImpl implements GarageService {

    protected final static int capacity=10;
    ConcurrentHashMap<Integer, Garage> conHashMap=concurrentFullMap(capacity);
    boolean[] parkUsed = new boolean[capacity];

    @Override
    public Garage park(Vehicle vehicle) {
        Garage garage = new Garage();
        vehicle.setSlots(VehicleType.valueOf(vehicle.getType().toLowerCase(Locale.ROOT)).getWidth());
        garage.setVehicle(vehicle);
        garage.setStatus(StatusType.ALLOCATED.toString());
        garage.setGarageId(1L);
        addPark(garage);
        return garage;
    }

    public void addPark(Garage garage){
        int sayac=0;
        for (int i=0; i< capacity; i++) {
            if (parkUsed[i]==false) {
//                if (garage.getVehicle().getSlots() == 1) {
//                        conHashMap.put(i, garage);
//                        parkUsed[i] = true;
//                }  else
                //&& garage.getVehicle().getSlots() > 1

                // ilk slot 1 kontrol et
                // sonra slot 4 lü olanları
                if (sayac == 0 ) {
                    for (int j = 1; j < garage.getVehicle().getSlots(); j++) {
                        if (parkUsed[i] != parkUsed[i + j] || i + garage.getVehicle().getSlots() > capacity) {
                            sayac = 0;
                            break;
                        }
                        sayac++;
                    }
                    if(sayac>0 || garage.getVehicle().getSlots()==1){
                        for (int l = i; l < i+garage.getVehicle().getSlots(); l++) {
                            conHashMap.put(l, garage);
                            parkUsed[l] = true;
                        }
                        break;
                    }
                }

            }


                // While veya for kurulaması gerekiyor.
                //Alt tarafa buna göre düzenleme yap
//                while(){
//                    conHashMap.put(i, garage);
//                    parkUsed[i] = true;
//                }
//                if (sayac > 0) {
//                    conHashMap.put(i, garage);
//                    parkUsed[i] = true;
//                }else{
//                    conHashMap.put(i, garage);
//                    parkUsed[i] = true;
//                    break;
//                }

        }
    }
    public void garageControl(Vehicle vehicle){
        VehicleType.valueOf(vehicle.getType()).getWidth();
        for (int i=1; i<conHashMap.size(); i++){

        }

    }

    @Override
    public Garage leave(Garage dto) {
        return null;
    }

    @Override
    public String status() {
        return "Status:" + System.lineSeparator() +
                conHashMap.values().stream().map(x->x.toString())
                        .collect(Collectors.joining(System.lineSeparator()));
    }
//
//    public String park2(Vehicle vehicle) {
//        if (vehicle.getSize() > GARAGE_CAPACITY) {
//            return "Vehicle does not fit in this garage.";
//        }
//
//        for (int i = 1; i < GARAGE_CAPACITY + 1; i++) {
//            if (isParkingAvailableForVehicleStartingFromIndex(vehicle, i)) {
//                return parkToSlotStartingFrom(vehicle, i);
//            }
//        }
//
//        return "Garage is full.";
//    }
//
//    private boolean isParkingAvailableForVehicleStartingFromIndex2(Vehicle vehicle, int i) {
//        if (!parkingLotUsed[i - 1] && !parkingLotUsed[i]) {
//            for (int j = 1; j < vehicle.getSize() + 1; j++) {
//                if (i + j < GARAGE_CAPACITY + 2) {
//                    if (parkingLotUsed[i + j]) {
//                        return false;
//                    }
//                } else {
//                    return false;
//                }
//            }
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    private String parkToSlotStartingFrom(Vehicle vehicle, int index) {
//        vehicle.setParkingIndexStart(index);
//        vehicleMap.put(ticketIndex++, vehicle);
//        for (int i = index; i < index + vehicle.getSize(); i++) {
//            parkingLotUsed[i] = true;
//        }
//        return "Allocated " + vehicle.getSize() + (vehicle.getSize() == 1 ? " slot." : " slots.");
//    }
//
//    public void leave2(int ticketId) {
//        Vehicle parkedVehicle = vehicleMap.get(ticketId);
//        if (parkedVehicle != null) {
//            for (int i = parkedVehicle.getParkingIndexStart(); i < parkedVehicle.getParkingIndexStart() + parkedVehicle.getSize(); i++) {
//                parkingLotUsed[i] = false;
//            }
//            vehicleMap.remove(ticketId);
//        } else {
//            throw new RuntimeException("No matching ticket exists with id: " + ticketId);
//        }
//    }
//
//    public String status2() {
//        return "Status:" + System.lineSeparator() +
//                vehicleMap.values().stream()
//                        .sorted()
//                        .map(Object::toString)
//                        .collect(Collectors.joining(System.lineSeparator()));
//    }
}
