package com.ocs.osj.model;

public class InjectionPrescriptionVO {
	private int injecPresId;
	private int receiveId;
	private String injecId;
	private String img;
	private String injecNameKor;
	
	public String getInjecNameKor() {
		return injecNameKor;
	}
	public void setInjecNameKor(String injecNameKor) {
		this.injecNameKor = injecNameKor;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getInjecPresId() {
		return injecPresId;
	}
	public void setInjecPresId(int injecPresId) {
		this.injecPresId = injecPresId;
	}
	public int getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}
	public String getInjecId() {
		return injecId;
	}
	public void setInjecId(String injecId) {
		this.injecId = injecId;
	}
}
