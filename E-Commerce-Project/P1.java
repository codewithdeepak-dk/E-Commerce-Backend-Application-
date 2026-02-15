package ECommerceProject;

public class P1 {
	public static void main(String[] args) {
		Mobile m1=new Mobile(null, 0, 0, null, 0);
		
		String s=m1.getClass().getName();
		System.out.println(s);
		System.out.println(s.substring(s.lastIndexOf('.')+1));
	}
}
