package ECommerceProject;

public class Shirt extends Product{
	static private int count=0;
	{
		count++;
	}
	public static int getCount() {
		return count;
	}
	private final int size;
	private final String color;
	private final String type; // half / full

	public Shirt(String brand, double price, int size, String color, String type) {
		super(brand, price);
		this.size = size;
		this.color = color;
		this.type = type;
	}
	
	public int getSize() {
		return size;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public void buy() {
		//code to process the purchase of the shirt
		System.out.println("Shirt bought: " + getBrand() + "\tSize: " + size + "\tColor: " + color + "\tType: " + type + "\tPrice: " + getPrice());
	}
	@Override
	public String toString() {
		return super.toString()+"\tSize: " + size + "\tColor: " + color + "\tType: " + type;
	}
	
}
