package ParkingLot.entities;

import ParkingLot.Enum.VehicleSize;
import ParkingLot.Vehicle.Vehicle;

import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
public class ParkingFloor{
	private final int floorNumber;
	private final Map<String, ParkingSpot> spots;

	public ParkingFloor(int floorNumber){
		this.floorNumber = floorNumber;
		this.spots = new ConcurrentHashMap<>();
	}
	
	public void addspot(ParkingSpot spot) {
		spots.put(spot.getspotid, spot);
	}
	public synchronized Optional<ParkingSpot> findAvailableSpots(Vehicle vehicle){
		return spots.values().stream()
			.filter(spot -> !spot.isoccupied() && spot.canfitvehicle(vehicle))
			.sorted(Comparator.comparing(ParkingSpot :: getspotsize)
			.findFirst();
	}
	public void getavailability(){
		System.out.printf("--- Floor %d Availability ---\n", floorNumber);
        	Map<VehicleSize, Long> availableCounts = spots.values().stream()
                	.filter(spot -> !spot.isOccupied())
                	.collect(Collectors.groupingBy(ParkingSpot::getSpotSize, Collectors.counting()));

	        for (VehicleSize size : VehicleSize.values()) {
        	    System.out.printf("  %s spots: %d\n", size, availableCounts.getOrDefault(size, 0L));
        	}
	}
	
}
