package ECommerceProject;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Service {
	Map<String, Product> products=new HashMap<>();
	Scanner sc=new Scanner(System.in);
	
	
	static
	{
		System.out.println("Application starts!!");
		
	}
	
	{
		products.put("P101", new Shirt("Polo", 1999.99, 40, "Blue", "Full"));
		products.put("P102", new Mobile("Samsung", 15999.99, 6, "Black", 128));
		products.put("P103", new Laptop("Dell", 55999.99, 8, "Silver", 512));
		products.put("P104", new Shirt("Levis", 2499.99, 42, "White", "Half"));
		products.put("P105", new Mobile("Apple", 69999.99, 4, "White", 64));
		products.put("P106", new Laptop("HP", 45999.99, 16, "Black", 1024));
		products.put("P107", new Shirt("Arrow", 2999.99, 38, "Pink", "Full"));
		products.put("P108", new Mobile("OnePlus", 39999.99, 8, "Red", 256));
		products.put("P109", new Laptop("Lenovo", 35999.99, 12, "Grey", 512));
		products.put("P110", new Shirt("Polo", 2999.99, 38, "green", "half"));
	}
	public void start() {
		System.out.println("Enter Admin/User: ");
		String choice=sc.nextLine();
		if(choice.equalsIgnoreCase("admin")) {
			//admin code
			//validation code for admin
			do {
				adminAccess();
			}while(selectContinue());
			System.out.println("Thank You! Application Ends!");
			
		}else if(choice.equalsIgnoreCase("user")) {
			//user code
			//validation code for user
			do {
				userAccess();
			}while(selectContinue());
			System.out.println("Thank You! Application Ends!");
		}else {
			System.out.println("Invalic choice!Please select valid options");
			start();
		}
	}
	public void adminAccess() {
		System.out.println("Press 1 to Access all products");
		System.out.println("Press 2 to add products");
		System.out.println("Press 3 to Remove a product with given ProductId");
		System.out.println("Press 4 to Count all Products of any Type");
		System.out.println("Press 5 to get details about all products");
		System.out.println("Press 6 to know count about each products");
		int choice=Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				System.out.println("Product List: ");
				products.forEach((k,v)->{
					System.out.println("ProductId: "+k+"\t"+v);
				});
				break;
			case 2:
				addProduct();
				break;
			case 3:
				System.out.println("Enter ProductId to remove: ");
				String pid=sc.nextLine();
				if(products.containsKey(pid)) {
					products.remove(pid);
					System.out.println("Product with ProductId "+pid+" removed successfully!");
				}else
					System.out.println("Such product is NOT Found!!");
					break;
			case 4:
				System.out.println("Enter the product Type: ");
				String productType=sc.nextLine();
				if(productType.equalsIgnoreCase("mobile"))
					System.out.println("Total Mobile Products are: "+Mobile.getCount());
				else if(productType.equalsIgnoreCase("shirt"))
					System.out.println("Total Shirt Products are: "+Shirt.getCount());
				else if(productType.equalsIgnoreCase("laptop"))
					System.out.println("Total Laptop Products are: "+Laptop.getCount());
				else
					System.out.println("Unknown Type Product Found!");
				break;
			case 5:
				printAllProductDetails();
				break;
			case 6:
				printAllProductCount();
				break;
			default:
				System.out.println("Invalid Choice! Please select valid option");
		}
	}
	
	public void userAccess() {
		
	}
	public void addProduct() {
		System.out.println("Enter ProductId: ");
		String pid=sc.nextLine();
		products.put(pid, getProduct());
	}
	public  Product   getProduct() {
		System.out.println("Press 1 for Shirt");
		System.out.println("Press 2 for Mobile");
		System.out.println("Press 3 for Laptop");
		int choice=Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				System.out.println("Enter Brand: ");
				String sBrand=sc.nextLine();
				System.out.println("Enter Price: ");
				double sPrice=Double.parseDouble(sc.nextLine());
				System.out.println("Enter Size: ");
				int sSize=Integer.parseInt(sc.nextLine());
				System.out.println("Enter Color: ");
				String sColor=sc.nextLine();
				System.out.println("Enter Type (half/full): ");
				String sType=sc.nextLine();
				return new Shirt(sBrand, sPrice, sSize, sColor, sType);
			case 2:
				System.out.println("Enter Brand: ");
				String mBrand=sc.nextLine();
				System.out.println("Enter Price: ");
				double mPrice=Double.parseDouble(sc.nextLine());
				System.out.println("Enter RAM Size: ");
				int mRam=Integer.parseInt(sc.nextLine());
				System.out.println("Enter Color: ");
				String mColor=sc.nextLine();
				System.out.println("Enter HD Size: ");
				int mHd=Integer.parseInt(sc.nextLine());
				return new Mobile(mBrand, mPrice, mRam, mColor, mHd);
			case 3:
				System.out.println("Enter Brand: ");
				String lBrand=sc.nextLine();
				System.out.println("Enter Price: ");
				double lPrice=Double.parseDouble(sc.nextLine());
				System.out.println("Enter RAM Size: ");
				int lRam=Integer.parseInt(sc.nextLine());
				System.out.println("Enter Color: ");
				String lColor=sc.nextLine();
				System.out.println("Enter HD Size: ");
				int lHd=Integer.parseInt(sc.nextLine());
				return new Laptop(lBrand, lPrice, lRam, lColor, lHd);
			default:
				System.out.println("Invalid Choice! Please select valid option");
				return getProduct();
		}
	}
	public boolean selectContinue() {
		System.out.println("Press Yes to Continue... ");
		String choice=sc.nextLine();
	return choice.equalsIgnoreCase("yes");
	}
	
	public void printAllProductDetails() {
		Set<String> p=new HashSet<>();
		for(String k:products.keySet()) {
			String n=products.get(k).getClass().getName();
			String name=n.substring(n.lastIndexOf('.')+1);
			p.add(name);
		}
		System.out.println("All Products are: "+p);
		System.out.println("Total products are: "+p.size());
	}
	public void printAllProductCount() {
		Map<String, Integer> m=new HashMap<>();
		for(String k:products.keySet()) {
			String n=products.get(k).getClass().getName();
			String name=n.substring(n.lastIndexOf('.')+1);
			int val=m.getOrDefault(name, 0);
			m.put(name, val+1);
		}
		System.out.println("All Product counts: ");
		m.forEach((k,v)-> System.out.println(k+" product is: "+v));
	}

}





