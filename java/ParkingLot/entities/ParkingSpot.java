package ParkingLot.entities;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Enum.VehicleSize;

public class ParkingSpot{
	private final String spotid;
	private Vehicle Parkedvehicle;
	private boolean isOccupied;
	private final VehicleSize spotsize;

	public ParkingSpot(String spotid , VehicleSize spotsize){
		this.spotid = spotid;
		this.spotsize = spotsize;
		this.isOccupied = false;
		this.Parkedvehicle = null;
	}

	public String getspotid(){
		return spotid;
	}
	public VehicleSize getspotsize(){
		return spotsize;
	}
	public synchronized boolean isavailable(){
		return !isOccupied;
	}
	public boolean isoccupied(){
		return isOccupied;
	}
	public synchronized void parkVehicle(Vehicle vehicle){
		this.Parkedvehicle = vehicle;
		this.isOccupied = true;
	}
	public synchronized void unparkVehicle(){
		this.Parkedvehicle = null;
		this.isOuccupied = false;
	}
	public boolean canfitvehicle(Vehicle vehicle){
		if(isOccupied) return false;
		switch(vehicle.getsize()){
			case SMALL: 
				return spotsize == VehicleSize.SMALL;
			case MEDIUM:
				return spotsize == VehicleSize.MEDIUM || spotsize == VehicleSize.LARGE;
			case LARGE:
				return spotsize == VehicleSize.LARGE;
			default: 
				return false;
		}
	}
}
