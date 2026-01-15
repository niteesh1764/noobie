package ParkingLot.strategy;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.entities.ParkingFloor;
import ParkingLot.entities.ParkingSpot;

import java.util.List;
import java.util.Optional;
import java.util.Collections;
import java.until.ArrayList;

public interface Parking{
	Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}

public class BestFitParking implements Parking{
	@Override
	public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors , Vehicle vehicle){
		Optional<ParkingSpot> bestSpot = Optional.empty();

        	for (ParkingFloor floor : floors) {
        	    Optional<ParkingSpot> spotOnThisFloor = floor.findAvailableSpot(vehicle);

        		if (spotOnThisFloor.isPresent()) {
            		    if (bestSpot.isEmpty()) {
                    // If this is the first spot we've found, it's the best one so far.
            	      		  bestSpot = spotOnThisFloor;
            	    	} else {
                    // A smaller spot size enum ordinal means a tighter fit.
               		     if (spotOnThisFloor.get().getSpotSize().ordinal() < bestSpot.get().getSpotSize().ordinal()) {
                	        bestSpot = spotOnThisFloor;
               			     	}
               		 	}
            		}
        	}
        	return bestSpot;		
	}
}

public class FarthestFirstParking implements Parking{
	@Override
	public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors , Vehicle vehicle){
		
	}
}

