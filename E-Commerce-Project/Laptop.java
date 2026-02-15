package ECommerceProject;

public class Laptop extends Product{
	static private int count=0;
	{
		count++;
	}
	public static int getCount() {
		return count;
	}
	private final int ram;
	private final String color;
	private final int hd;
	Laptop(String brand, double price, int ram, String color,int hd){
		super(brand, price);
		this.ram=ram;
		this.color=color;
		this.hd=hd;
	}
	public int getRam() {
		return ram;
	}
	public String getColor() {
		return color;
	}
	public int getHd() {
		return hd;
	}
	@Override
	public void buy() {
		//code to process the purchase of the mobile
		System.out.println("Laptop bought: " + getBrand() + "\tRAM: " + ram + "GB\tColor: " + color + "\tHD: " + hd + "GB\tPrice: " + getPrice());
	}
	@Override
	public String toString() {
		return super.toString()+"\tRAM: " + ram + "GB\tColor: " + color + "\tHD: " + hd + "GB";
	}

}
