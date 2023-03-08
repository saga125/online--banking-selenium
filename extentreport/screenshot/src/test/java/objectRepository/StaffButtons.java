package objectRepository;

public enum StaffButtons {
	APPROVEPENDINGACCOUNT("Approve Pending Account"),
	VIEWCUSTOMERBYACCNO("View Customer by A/c No"),
	VIEWACTIVECUSTOMER("View Active Customer"),
	DELETECUSTOMERACCNO("Delete Customer A/c"),
	CREDITCUSTOMER("Credit Customer");
	
private String btnName;
	
	private StaffButtons(String btnName) {
		this.btnName = btnName;
	}
	
	public String getButton() {
		return btnName;
	}
	
}
