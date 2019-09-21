package parshing;

public class NaverCaseVO 
{
	String casename;
	String rowprice;
	String power;
	String mainboardsize;
	String casesize;
	String addop;
	
	public NaverCaseVO() {
		// TODO Auto-generated constructor stub
	}

	public NaverCaseVO(String casename, String rowprice, String power, String mainboardsize, String casesize,
			String addop) {
		super();
		this.casename = casename;
		this.rowprice = rowprice;
		this.power = power;
		this.mainboardsize = mainboardsize;
		this.casesize = casesize;
		this.addop = addop;
	}
	
	
	
	public String getCasename() {
		return casename;
	}

	public void setCasename(String casename) {
		this.casename = casename;
	}

	public String getRowprice() {
		return rowprice;
	}

	public void setRowprice(String rowprice) {
		this.rowprice = rowprice;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getMainboardsize() {
		return mainboardsize;
	}

	public void setMainboardsize(String mainboardsize) {
		this.mainboardsize = mainboardsize;
	}

	public String getCasesize() {
		return casesize;
	}

	public void setCasesize(String casesize) {
		this.casesize = casesize;
	}

	public String getAddop() {
		return addop;
	}

	public void setAddop(String addop) {
		this.addop = addop;
	}

	@Override
	public String toString() {
		return "NaverCaseVO [casename=" + casename + ", rowprice=" + rowprice + ", power=" + power + ", mainboardsize="
				+ mainboardsize + ", casesize=" + casesize + ", addop=" + addop + "]";
	}
	
}
