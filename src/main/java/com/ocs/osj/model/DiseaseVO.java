package com.ocs.osj.model;

import java.util.List;

public class DiseaseVO {
	private String diseaseId;
	private String diseaseCode;
	private String diseaseNameKor;
	private String diseaseNameEng;
	private List<DiseaseVO> DiseaseVOList;
	public List<DiseaseVO> getDiseaseVOList() {
		return DiseaseVOList;
	}
	public void setDiseaseVOList(List<DiseaseVO> diseaseVOList) {
		DiseaseVOList = diseaseVOList;
	}
	public String getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getDiseaseNameKor() {
		return diseaseNameKor;
	}
	public void setDiseaseNameKor(String diseaseNameKor) {
		this.diseaseNameKor = diseaseNameKor;
	}
	public String getDiseaseNameEng() {
		return diseaseNameEng;
	}
	public void setDiseaseNameEng(String diseaseNameEng) {
		this.diseaseNameEng = diseaseNameEng;
	}
}
