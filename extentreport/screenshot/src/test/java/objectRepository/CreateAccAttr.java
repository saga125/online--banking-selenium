package objectRepository;

public enum CreateAccAttr {
	NAME("name"),
	MOBILE("mobile"),
	EMAIL("email"),
	LANDLINE("landline"),
	DOB("dob"),
	PANNO("pan_no"),
	CITIZENSHIP("citizenship"),
	HOMEADDRESS("homeaddrs"),
	OFFICEADDRESS("officeaddrs"),
	PIN("pin"),
	AREALOC("arealoc"),
	NOMINEENAME("nominee_name"),
	NOMINEEACCNO("nominee_ac_no");
	
	private String name_;
	
	private CreateAccAttr(String name_) {
		this.name_ = name_;
	}
	
	public String getName() {
		return name_;
	}

}
