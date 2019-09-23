package com.test.team;

public class SteamVO {
	String appid;
	String name;
	
	public SteamVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SteamVO(String appid, String name) {
		super();
		this.appid = appid;
		this.name = name;
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
		return String.format("SteamVO [appid=%s, name=%s]", appid, name);
	}
}