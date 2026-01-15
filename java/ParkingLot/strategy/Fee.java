package ParkingLot.strategy

import ParkingLot.entities.ParkingTicket
import ParkingLot.Enum.VehicleSize;

import java.util.Map;


public interface Fee{
	double calculateFee(ParkingTicket parkingticket); 
}

public class FlatRateFeeStrategy implements Fee{
	private static final double RATE_PER_HOUR = 10.0;

	@Override
	public double calculateFee(ParkingTicket parkingticket){
		long duration = parkingticket.getExitTime() - parkingticket.getEnterTime();
		long hours = (duration/(1000 * 60 * 60)) + 1;
		return hours * RATE_PER_HOUR;
	}
}

public class VehicleBasedFeeStrategy implements Fee{
	private static final Map<VehicleSize, Double> HourlyRates = Map.of(
		VehicleSize.SMALL , 10.0, 
		VehicleSize.MEDIUM , 20.0,
		VehicleSize.LARGE , 30.0
	);

	@Override 
	public double calculateFee(ParkingTicket parkingticket){
		long duration = parkingticket.getExitTime() - parkingticket.getEnterTime();
		long hours = (duration / (1000 * 60 * 60)) + 1;
		return hours * HourlyRate.get(parkingticket.getvehicle().getsize())
	}
}
