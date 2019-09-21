package parshing;

import java.io.Serializable;

public class PMCpuVO implements Serializable
{
	int cpunum;
	String cpuname;
	String price;
	String cpuMark;
	String cpuval;
	String threadMark;
	String threadVal;
	String tdp;
	String powerf;
	String date;
	String socket;
	String category;
	String rank;
		
	public PMCpuVO() {
		// TODO Auto-generated constructor stub
	}

	public PMCpuVO(String cpuname, String price, String cpuMark, String cpuval, String threadMark, String threadVal,
			String tdp, String powerf, String date, String socket, String category, String rank) {
		super();
		this.cpuname = cpuname;
		this.price = price;
		this.cpuMark = cpuMark;
		this.cpuval = cpuval;
		this.threadMark = threadMark;
		this.threadVal = threadVal;
		this.tdp = tdp;
		this.powerf = powerf;
		this.date = date;
		this.socket = socket;
		this.category = category;
		this.rank = rank;
	}

	public int getCpunum() {
		return cpunum;
	}

	public void setCpunum(int cpunum) {
		this.cpunum = cpunum;
	}

	public String getCpuname() {
		return cpuname;
	}

	public void setCpuname(String cpuname) {
		this.cpuname = cpuname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCpuMark() {
		return cpuMark;
	}

	public void setCpuMark(String cpuMark) {
		this.cpuMark = cpuMark;
	}

	public String getCpuval() {
		return cpuval;
	}

	public void setCpuval(String cpuval) {
		this.cpuval = cpuval;
	}

	public String getThreadMark() {
		return threadMark;
	}

	public void setThreadMark(String threadMark) {
		this.threadMark = threadMark;
	}

	public String getThreadVal() {
		return threadVal;
	}

	public void setThreadVal(String threadVal) {
		this.threadVal = threadVal;
	}

	public String getTdp() {
		return tdp;
	}

	public void setTdp(String tdp) {
		this.tdp = tdp;
	}

	public String getPowerf() {
		return powerf;
	}

	public void setPowerf(String powerf) {
		this.powerf = powerf;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "PMCpuVO [cpunum=" + cpunum + ", cpuname=" + cpuname + ", price=" + price + ", cpuMark=" + cpuMark
				+ ", cpuval=" + cpuval + ", threadMark=" + threadMark + ", threadVal=" + threadVal + ", tdp=" + tdp
				+ ", powerf=" + powerf + ", date=" + date + ", socket=" + socket + ", category=" + category + ", rank="
				+ rank + "]";
	}

	
	
	
		
}
