package com.tictactoe.domain;

public class User {

	private String uuid;
	private String type;
	private String gid;

	public User(String uuid, String type, String gid) {
		this.uuid = uuid;
		this.type = type;
		this.gid = gid;
	}

	public String getUuid() {
		return uuid;
	}

	public String getType() {
		return type;
	}

	public String getGid() {
		return gid;
	}

	@Override
	public String toString() {
		return "User [uuid=" + uuid + ", type=" + type + ", gid=" + gid + "]";
	}
	
	

}
