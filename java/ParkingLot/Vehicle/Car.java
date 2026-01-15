package ParkingLot.Vehicle;

import ParkingLot.Enum.VehicleSize;

public class Car extends Vehicle{
	public Car(String LicenseNumber){
		super(LicenseNumber, VehicleSize.MEDIUM);
	}
}

