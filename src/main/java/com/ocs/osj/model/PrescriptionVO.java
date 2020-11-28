package com.ocs.osj.model;

public class PrescriptionVO {
	private int prescriptionId;
	private int patientId;
	private int diseaseId;
	private int drugId;
	private int days;
	private int oneDosage;
	private int dayDosage;
	private String injectionId;
	private String sugaId;
	private String receiptYn;
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getOneDosage() {
		return oneDosage;
	}
	public void setOneDosage(int oneDosage) {
		this.oneDosage = oneDosage;
	}
	public int getDayDosage() {
		return dayDosage;
	}
	public void setDayDosage(int dayDosage) {
		this.dayDosage = dayDosage;
	}
	public String getInjectionId() {
		return injectionId;
	}
	public void setInjectionId(String injectionId) {
		this.injectionId = injectionId;
	}
	public String getSugaId() {
		return sugaId;
	}
	public void setSugaId(String sugaId) {
		this.sugaId = sugaId;
	}
	public String getReceiptYn() {
		return receiptYn;
	}
	public void setReceiptYn(String receiptYn) {
		this.receiptYn = receiptYn;
	}
	
}
