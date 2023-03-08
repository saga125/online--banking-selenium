package objectRepository;

public enum IBRegstrtnTxFlds {
	HOLDER_NAME("holder_name"),
	ACCNUM("accnum"),
	DBTCARD("dbtcard"),
	DBTPIN("dbtpin"),
	MOBILE("mobile"),
	PAN_NO("pan_no"),
	DOB("dob"),
	LAST_TRANS("last_trans"),
	PASSWORD("password"),
	CNFRM_PASSWORD("cnfrm_password"),
	SUBMIT("submit");
	
private String txFldAttr;
	
	private IBRegstrtnTxFlds(String txFldAttr) {
		this.txFldAttr = txFldAttr;
	}
	
	public String getAttr() {
		return txFldAttr;
	}
}
