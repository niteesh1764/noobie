package vendingmachine.state;


import vendingmachine.enums.Coin;
import vendingmachine.entity.*;
import vendingmachine.service.VendingMachineService;

public class IdleState extends VendingMachineState{
	public IdleState(VendingMachineService vendingMachine){
		super(vendingMachine);
	}

	@Override 
	public void insertCoin(Coin coin){
		System.Out.Println("Please select an Item first");

	}

	@Override 
	public void selectItem(String code){
		if(!vendingMachine.getInventory().isAvailable(code){
			System.Out.Println("Out of Stock");
			return;
		}	
		vendingMachine.setSelectedItem(code);
		vendingMachine.setState(new ItemSelectedState(vendingMachine);
		System.out.println("Item Selected: " + code);
	}

	@Override
	public void dispense(){
		System.out.println("Please select an Item first");
	}

	@Override
	public void refund(){
		System.out.println("Please select an Item first");
	}

}
