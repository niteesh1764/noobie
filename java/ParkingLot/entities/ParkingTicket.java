package ParkingLot.entities

import ParkingLot.Vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket{
	private final String Ticketid;
	private final Vehicle vehicle;
	private final ParkingSpot spot;
	private final long entryTimeStamp;
	private long exitTimeStamp;

	public ParkingTicket(Vehicle vehicle , ParkingSpot spot){
		this.Ticketid = UUID.randomUUID().toString();
		this.vehicle = vehicle;
		this.spot = spot;
		this.entryTimeStamp = new Date().getTime();
	}
	public String getticketid(){
		return Ticketid;
	}
	public Vehicle getvehicle(){
		return vehicle;
	}
	public ParkingSpot getspot(){
		return spot;
	}
	public long getExitTime(){
		return exitTimeStamp;
	}
	public long getEnterTime(){
		return entryTimeStamp;
	}
	public long setExitTime(){
		this.exitTimeStamp = new Date().getTime();
	}
}

