package com.ocs.osj.model;

import java.sql.Date;
import java.sql.Timestamp;

public class ReceiveVO {
	private int receiveId;
	private int patientId;
	private String userId;
	private Date receiveDate;
	private String fmyn;
	private String treatStatus;
	private String receiptYn;
	private String injecYn;
	public String getInjecYn() {
		return injecYn;
	}
	public void setInjecYn(String injecYn) {
		this.injecYn = injecYn;
	}
	public int getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getFmyn() {
		return fmyn;
	}
	public void setFmyn(String fmyn) {
		this.fmyn = fmyn;
	}
	public String getTreatStatus() {
		return treatStatus;
	}
	public void setTreatStatus(String treatStatus) {
		this.treatStatus = treatStatus;
	}
	public String getReceiptYn() {
		return receiptYn;
	}
	public void setReceiptYn(String receiptYn) {
		this.receiptYn = receiptYn;
	}
}