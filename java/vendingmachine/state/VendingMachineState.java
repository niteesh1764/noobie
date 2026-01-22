package vendingmachine.state;

import vendingmachine.enums.Coin;
import vendingmachine.service.VendingMachineService;

public abstract class VendingMachineState{
	VendingMachineService vendingMachine;

	VendingMachineState(VendingMachineState vendingMachine){
		this.vendingMachine = vendingMachine;
	}

	public abstract void insertCoin(Coin coin);
	public abstract void selectItem(String code);
	public abstract void dispense();
	public abstract void refund();
}
