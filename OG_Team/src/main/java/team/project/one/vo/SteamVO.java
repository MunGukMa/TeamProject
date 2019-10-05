package com.test.team;

public class SteamVO {
	int num;
	String appid;
	String name;
	
	public SteamVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SteamVO(int num, String appid, String name) {
		super();
		this.num = num;
		this.appid = appid;
		this.name = name;
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("SteamVO [num=%d, appid=%s, name=%s]", num, appid, name);
	}
}
