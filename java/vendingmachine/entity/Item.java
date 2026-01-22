package vendingmachine.entity;

public class Item{
	private String name;
	private String code;
	private int price;

	public Item(String name, String code, int price) {
		this.name = name;
		this.code = code;
		this.price = price;
	}

	public int getPrice(){
		return price;
	}
	
	public String getCode(){
		return code;
	}

	public String getName(){
		return name;
	}

}
