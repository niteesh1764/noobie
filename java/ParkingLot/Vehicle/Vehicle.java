package ParkingLot.Vehicle;
import ParkingLot.Enum.VehicleSize;

public abstract class Vehicle{
	private final String LicenseNumber;
	private final VehicleSize size;

	public Vehicle(String LicenseNumber , VehicleSize size){
		this.LicenseNumber = LicenseNumber;
		this.size = size;
	}

	public String getlicense(){
		return LicenseNumber;
	}
	public VehicleSize getsize(){
		return size;
	}
}
