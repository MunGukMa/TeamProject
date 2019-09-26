package com.test.team.compare;

public class GpuCompareVO {
	private int num;
	private String name;
	private String id;
	
	public GpuCompareVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public GpuCompareVO(int num, String name, String id) {
		super();
		this.num = num;
		this.name = name;
		this.id = id;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CpuCompareVO [num=" + num + ", name=" + name + ", id=" + id + "]";
	}
	
}
