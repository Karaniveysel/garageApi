# Garage Api Project
This is a Garage Project developed with spring-boot

# Information
This is a car parking project. The vehicle buys a ticket when entering and returns the ticket when exiting.

Requirements
- *Java 1.8
- *Maven
- Postman


Built With : mvn clean install or "GarageApp" class run


# The Garage APIs endpoints:

How to call

Request port link = http://localhost:9001
# Park
- /park -> Parks Vehicle
```json
{
    "type":"cars",
    "color":"white",
    "plate":"34-lo-2018"    
}
```
return : 
> <br/>Allocated 1 slot
# Leave
- /leave/{id} -> Leaves Garage

With the entry ID given to the vehicles, it is possible to exit from three points.
# Status
- /status -> Garage Status

return: <br/>
  > Status:<br/>
  34-lo-2021 white [1]<br/>
  28-KA-2021 white [3, 4, 5, 6]<br/>
  81-VKA-2021 white [8, 9]<br/>


You can use posman to use existing APIs.

