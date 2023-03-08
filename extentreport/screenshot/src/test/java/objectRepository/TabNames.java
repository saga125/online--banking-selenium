package objectRepository;

public enum TabNames {

	STAFFLOGIN ("Staff Login"),
	HOME("Home"),
	ABOUTUS("About Us"),
	CONTACTUS("Contact Us");
	
	private String tabName;
	
	private TabNames(String tabName) {
		this.tabName = tabName;
	}
	
	public String getTab() {
		return tabName;
	}
}
