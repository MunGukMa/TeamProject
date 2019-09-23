package com.test.team;

public class GraphicCardVO {
	private int gpu_sec;
	private String company;
	private String product_name;
	private String chip;
	private String released_date;
	private String bus;
	private String m_size;
	private String m_ddr;
	private String m_bit;
	private String g_clock;
	private String m_clock;
	private String tdp;
	private int rank;
	
	public GraphicCardVO() {
		// TODO Auto-generated constructor stub
	}

	public GraphicCardVO(int gpu_sec, String company, String product_name, String chip, String released_date,
			String bus, String m_size, String m_ddr, String m_bit, String g_clock, String m_clock, String tdp,
			int rank) {
		super();
		this.gpu_sec = gpu_sec;
		this.company = company;
		this.product_name = product_name;
		this.chip = chip;
		this.released_date = released_date;
		this.bus = bus;
		this.m_size = m_size;
		this.m_ddr = m_ddr;
		this.m_bit = m_bit;
		this.g_clock = g_clock;
		this.m_clock = m_clock;
		this.tdp = tdp;
		this.rank = rank;
	}

	public int getGpu_sec() {
		return gpu_sec;
	}

	public void setGpu_sec(int gpu_sec) {
		this.gpu_sec = gpu_sec;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getReleased_date() {
		return released_date;
	}

	public void setReleased_date(String released_date) {
		this.released_date = released_date;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public String getM_size() {
		return m_size;
	}

	public void setM_size(String m_size) {
		this.m_size = m_size;
	}

	public String getM_ddr() {
		return m_ddr;
	}

	public void setM_ddr(String m_ddr) {
		this.m_ddr = m_ddr;
	}

	public String getM_bit() {
		return m_bit;
	}

	public void setM_bit(String m_bit) {
		this.m_bit = m_bit;
	}

	public String getG_clock() {
		return g_clock;
	}

	public void setG_clock(String g_clock) {
		this.g_clock = g_clock;
	}

	public String getM_clock() {
		return m_clock;
	}

	public void setM_clock(String m_clock) {
		this.m_clock = m_clock;
	}

	public String getTdp() {
		return tdp;
	}

	public void setTdp(String tdp) {
		this.tdp = tdp;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "GraphicCardVO [gpu_sec=" + gpu_sec + ", company=" + company + ", product_name=" + product_name
				+ ", chip=" + chip + ", released_date=" + released_date + ", bus=" + bus + ", m_size=" + m_size
				+ ", m_ddr=" + m_ddr + ", m_bit=" + m_bit + ", g_clock=" + g_clock + ", m_clock=" + m_clock + ", tdp="
				+ tdp + ", rank=" + rank + "]";
	}

	
	
	
}
