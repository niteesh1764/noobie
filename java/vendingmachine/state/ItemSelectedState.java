package vendingmachine.state;

import vendingmachine.service.VendingMachineService;
import vendingmachine.enums.Coin;

public class ItemSelectedState extends VendingMachineState{
	public ItemSelectedState(VendingMachineState vendingMachine){
		super(vendingMachine);
	}

	@Override
	public void insertCoin(Coin coin){
		vendingMachine.addBalance(coin.getValue());
		System.out.println("Coin Inserted" + coin.getValue());
		int price = vendingMachine.getSelectedItem().getPrice();
		if(vendingMachine.getBalance() >= price){
			System.out.println("Sufficient Money Recieved");
			vendingMachine.setState(new HasMoneyState(vendingMachine);
		}
	}

	@Override
	public void ItemSelect(String code){
		System.out.println("Item already selected");
	}

	@Override
	public void dispense(){
		System.out.println("Please insert Money");	
	}

	@Override
	public coid refund(){
		vendingMachine.reset();
		vendingMachine.setState(new IdleState(vendingMachine));
	}
}
