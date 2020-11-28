package com.ocs.osj.model;

public class PastReceiveVO {
	private String drugName;
	private String diseaseNameKor;
	private String injecNameKor;
	private int receiveId;
	public int getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDiseaseNameKor() {
		return diseaseNameKor;
	}
	public void setDiseaseNameKor(String diseaseNameKor) {
		this.diseaseNameKor = diseaseNameKor;
	}
	public String getInjecNameKor() {
		return injecNameKor;
	}
	public void setInjecNameKor(String injecNameKor) {
		this.injecNameKor = injecNameKor;
	}
}
