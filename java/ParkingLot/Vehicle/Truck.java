package ParkingLot.Vehicle
import ParkingLot.Enum.VehicleSize

public class Truck extends Vehicle{
	public Truck(String LicenseNumber){
		super(LicenseNumber, VehicleSize.LARGE);
	}
}
