package com.ocs.osj.model;

import java.util.List;

public class DiseasePrescriptionVO {
	private int diseasePresId;
	private int receiveId;
	private int diseaseId;
	private String disesYn;
	public int getDiseasePresId() {
		return diseasePresId;
	}
	public void setDiseasePresId(int diseasePresId) {
		this.diseasePresId = diseasePresId;
	}
	public int getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}
	public int getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getDisesYn() {
		return disesYn;
	}
	public void setDisesYn(String disesYn) {
		this.disesYn = disesYn;
	}
}
