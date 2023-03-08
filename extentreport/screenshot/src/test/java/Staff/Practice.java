package Staff;

public class Practice {
	
	public static void main(String[] args) {
		String tabXpath = "%s";
		String xpath = String.format(tabXpath, "contact");
	//	String xpath = tabXpath.replace("%s", "contact");
		System.out.println(xpath);
	}
	
/*	public static void main(String[] args) {
		String tabXpath = "//a[.='%s']";
		String xpath = String.format(tabXpath, "contact");
	//	String xpath = tabXpath.replace("%s", "contact");
		System.out.println(xpath);
	}
	
	String a ="abc";
	public static void main(String[] args) {
	//	System.out.println(a);
		Practice x = new Practice();
		System.out.println(x.aa());
		System.out.println(Practice.class);
	}
	
	public String aa() {
		System.out.println(this);
		return this.a;
	}  */

}
