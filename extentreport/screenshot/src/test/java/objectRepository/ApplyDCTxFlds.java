package objectRepository;

public enum ApplyDCTxFlds {
	
	HOLDER_NAME("holder_name"),
	DOB("dob"),
	PAN("pan"),
	MOB("mob"),
	ACC_NO("acc_no"),
	SUBMIT("dbt_crd_submit");
	
private String txFldName;
	
	private ApplyDCTxFlds(String txFldName) {
		this.txFldName = txFldName;
	}
	
	public String getTxFld() {
		return txFldName;
	}
}
