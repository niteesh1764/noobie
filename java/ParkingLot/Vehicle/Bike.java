package ParkingLot.Vehicle
import ParkingLot.Enum.VehicleSize

public class Bike extends Vehicle{
	public Bike(String LicenseNumber ){
		super(LicenseNumber, VehicleSize.SMALL);
	}
}
