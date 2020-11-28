package com.ocs.osj.model;

import java.util.List;

public class DrugVO {
	private int drugId;
	private int drugCost;
	private String drugName;
	private String injectCourse;
	private String companyName;
	private String standard;
	private String drugUnit;
	private String spyn;
	private List<DrugVO> DrugVOList;

	public List<DrugVO> getDrugVOList() {
		return DrugVOList;
	}
	public void setDrugVOList(List<DrugVO> drugVOList) {
		DrugVOList = drugVOList;
	}
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public int getDrugCost() {
		return drugCost;
	}
	public void setDrugCost(int drugCost) {
		this.drugCost = drugCost;
	}
	public String getInjectCourse() {
		return injectCourse;
	}
	public void setInjectCourse(String injectCourse) {
		this.injectCourse = injectCourse;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDrugUnit() {
		return drugUnit;
	}
	public void setDrugUnit(String drugUnit) {
		this.drugUnit = drugUnit;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSpyn() {
		return spyn;
	}
	public void setSpyn(String spyn) {
		this.spyn = spyn;
	}
	
}
