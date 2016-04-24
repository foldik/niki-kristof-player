package com.tictactoe.http.domain.request;

public class StatusRequest {

	private String gid;

	public StatusRequest(String gid) {
		this.gid = gid;
	}

	@Override
	public String toString() {
		return "StatusRequest [gid=" + gid + "]";
	}

}
