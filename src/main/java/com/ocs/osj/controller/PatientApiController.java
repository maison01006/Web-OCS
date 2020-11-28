package com.ocs.osj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocs.osj.model.DepartmentService;
import com.ocs.osj.model.DepartmentVO;
import com.ocs.osj.model.DiseasePrescriptionService;
import com.ocs.osj.model.DiseasePrescriptionVO;
import com.ocs.osj.model.DiseaseService;
import com.ocs.osj.model.DiseaseVO;
import com.ocs.osj.model.DrugService;
import com.ocs.osj.model.DrugVO;
import com.ocs.osj.model.InjectionPrescriptionService;
import com.ocs.osj.model.InjectionPrescriptionVO;
import com.ocs.osj.model.InjectionService;
import com.ocs.osj.model.InjectionVO;
import com.ocs.osj.model.PastReceiveService;
import com.ocs.osj.model.PastReceiveVO;
import com.ocs.osj.model.PatientService;
import com.ocs.osj.model.ReceivePatientService;
import com.ocs.osj.model.ReceivePatientVO;
import com.ocs.osj.model.SugaService;
import com.ocs.osj.model.SugaVO;
import com.ocs.osj.model.UserService;
import com.ocs.osj.model.UserVO;

@RestController
public class PatientApiController {

	@Autowired
	PatientService patientService;
	@Autowired
	DrugService drugService;
	@Autowired
	DiseaseService diseaseService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	UserService userService;
	@Autowired
	ReceivePatientService receivePatientService;
	@Autowired
	InjectionService injectionService;
	@Autowired
	DiseasePrescriptionService diseasePrescriptionService;
	@Autowired
	SugaService sugaService;
	@Autowired
	InjectionPrescriptionService injectionPrescriptionService;
	@Autowired
	PastReceiveService pastReceiveService;
	
	@GetMapping(value = "/getPatient",produces="text/plain;charset=UTF-8")
	public String getPatient(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("patientName");
		JSONArray ja = new JSONArray();
		
		
		for( int i=0; i<patientService.getPatient(name).size();i++) {
			JSONObject jo = new JSONObject();
			jo.put(0, patientService.getPatient(name).get(i).getId());
			jo.put(1, patientService.getPatient(name).get(i).getGender());
			jo.put(2, patientService.getPatient(name).get(i).getRegNo());
			jo.put(3, patientService.getPatient(name).get(i).getAddress());
			jo.put(4, patientService.getPatient(name).get(i).getName());
			jo.put(5, patientService.getPatient(name).get(i).getAge());
			jo.put(6, patientService.getPatient(name).get(i).getTel());
			jo.put(7, patientService.getPatient(name).get(i).getEtc());
			ja.add(jo);
		}
		
		return ja.toJSONString();
	}
	@GetMapping(value = "/getDrug",produces="text/plain;charset=UTF-8")
	public String getDrug(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		JSONArray ja = new JSONArray();
		List<DrugVO> drugList = drugService.getDrug(name);
		for( int i=0; i<drugList.size();i++){
			JSONObject jo = new JSONObject();
			jo.put(0, drugList.get(i).getDrugId());
			jo.put(1, drugList.get(i).getDrugName());
			jo.put(2, drugList.get(i).getDrugCost());
			jo.put(3, drugList.get(i).getInjectCourse());
			jo.put(4, drugList.get(i).getCompanyName());
			jo.put(5, drugList.get(i).getStandard());
			jo.put(6, drugList.get(i).getDrugUnit());
			jo.put(7, drugList.get(i).getSpyn());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	@GetMapping(value = "/getDisease",produces="text/plain;charset=UTF-8")
	public String getDisease(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		JSONArray ja = new JSONArray();
		List<DiseaseVO> diseaseList = diseaseService.getDisease(name);
		for( int i=0; i<diseaseList.size();i++){
			JSONObject jo = new JSONObject();
			jo.put(0, diseaseList.get(i).getDiseaseId());
			jo.put(1, diseaseList.get(i).getDiseaseNameEng());
			jo.put(2, diseaseList.get(i).getDiseaseCode());
			jo.put(3, diseaseList.get(i).getDiseaseNameKor());
			
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	@GetMapping(value = "/getInjection",produces="text/plain;charset=UTF-8")
	public String getInjection(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		JSONArray ja = new JSONArray();
		List<InjectionVO> injectionList = injectionService.getInjection(name);
		for( int i=0; i<injectionList.size();i++){
			JSONObject jo = new JSONObject();
			jo.put(0, injectionList.get(i).getInjecId());
			jo.put(1, injectionList.get(i).getGroupNum());
			jo.put(2, injectionList.get(i).getInjecNameKor());
			jo.put(3, injectionList.get(i).getInjecNameEnt());
			
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	@GetMapping(value = "/getMajor",produces="text/plain;charset=UTF-8")
	public String getDepartment(HttpServletRequest request, HttpServletResponse response) {
		JSONArray ja = new JSONArray();
		List<DepartmentVO> departmentList = departmentService.getDepartment();
		for( int i=0; i<departmentList.size();i++){
			JSONObject jo = new JSONObject();
			jo.put(0, departmentList.get(i).getId());
			jo.put(1, departmentList.get(i).getMajor());
			jo.put(2, departmentList.get(i).getMajorAbb());
			
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	@GetMapping(value = "/getDoc",produces="text/plain;charset=UTF-8")
	public String getDoc(HttpServletRequest request, HttpServletResponse response) {
		JSONArray ja = new JSONArray();
		int id = Integer.parseInt(request.getParameter("id"));
		List<UserVO> userList = userService.getMajorUser(id);
		for( int i=0; i<userList.size();i++){
			JSONObject jo = new JSONObject();
			
			jo.put("id", userList.get(i).getId());
			jo.put("name", userList.get(i).getName());
			
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	@GetMapping(value = "/getReceipt",produces="text/plain;charset=UTF-8")
	public String getReceive(HttpServletRequest request, HttpServletResponse response) {
		JSONArray ja = new JSONArray();
		String name = request.getParameter("patientName");
		List<ReceivePatientVO> receiveList = receivePatientService.getReceipt(name);
		for( int i=0; i<receiveList.size();i++){

			JSONObject jo = new JSONObject();
			
			jo.put(0,receiveList.get(i).getPatientId());
			jo.put(1,receiveList.get(i).getGender());
			jo.put(2,receiveList.get(i).getRegNo());
			jo.put(3,receiveList.get(i).getAddress());
			jo.put(4,receiveList.get(i).getName());
			jo.put(5,receiveList.get(i).getAge());
			jo.put(6, receiveList.get(i).getTel());
			jo.put(7, receiveList.get(i).getFmyn());
			jo.put(8, receiveList.get(i).getReceiveId());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	@GetMapping(value = "/getReceiveInjectionPatient",produces="text/plain;charset=UTF-8")
	public String getReceiveInjectionPatient(HttpSession session) {
		JSONArray ja = new JSONArray();
		String userId = (String) session.getAttribute("userId");
		List<ReceivePatientVO> receiveList = receivePatientService.getReceiveInjectionPatient(userId);
		
		for( int i=0; i<receiveList.size();i++){
			JSONObject jo = new JSONObject();
			
			jo.put(0,receiveList.get(i).getName());
			jo.put(1,receiveList.get(i).getRegNo());
			jo.put(2,receiveList.get(i).getGender());
			jo.put(3,receiveList.get(i).getBlood());
			jo.put(4,receiveList.get(i).getAddress());
			jo.put(5,receiveList.get(i).getEtc());
			jo.put(6, receiveList.get(i).getFmyn());
			jo.put(7, receiveList.get(i).getPatientId());
			jo.put(8, receiveList.get(i).getReceiveId());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	@GetMapping(value = "/getReceivePatient",produces="text/plain;charset=UTF-8")
	public String getReceive(HttpSession session) {
		JSONArray ja = new JSONArray();
		String userId = (String) session.getAttribute("userId");
		List<ReceivePatientVO> receiveList = receivePatientService.getReceivePatient(userId);
		for( int i=0; i<receiveList.size();i++){
			JSONObject jo = new JSONObject();
			
			jo.put(0,receiveList.get(i).getName());
			jo.put(1,receiveList.get(i).getRegNo());
			jo.put(2,receiveList.get(i).getGender());
			jo.put(3,receiveList.get(i).getBlood());
			jo.put(4,receiveList.get(i).getAddress());
			jo.put(5,receiveList.get(i).getEtc());
			jo.put(6, receiveList.get(i).getFmyn());
			jo.put(7, receiveList.get(i).getPatientId());
			jo.put(8, receiveList.get(i).getReceiveId());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	@GetMapping(value = "/getSuga",produces="text/plain;charset=UTF-8")
	public String getSuga(HttpServletRequest request, HttpServletResponse response) {
		JSONArray ja = new JSONArray();
		JSONObject jor = new JSONObject();
		int receiveId = Integer.parseInt(request.getParameter("receiveId"));
		String fmyn = request.getParameter("fmyn");
		List<SugaVO> sugaInjectionList = sugaService.getInjecSuga(receiveId);
		List<SugaVO> sugaList = sugaService.getSuga(fmyn);
		for( int i=0; i<sugaInjectionList.size();i++){

			JSONObject jo = new JSONObject();
			jo.put(0,sugaInjectionList.get(i).getSugaId());
			jo.put(1,sugaInjectionList.get(i).getSugaNameKor());
			jo.put(2,sugaInjectionList.get(i).getPayNonpay());
			jo.put(3,sugaInjectionList.get(i).getUnitCost());
			ja.add(jo);
		}
		JSONObject jo = new JSONObject();
		jo.put(0,sugaList.get(0).getSugaId());
		jo.put(1,sugaList.get(0).getSugaNameKor());
		jo.put(2,sugaList.get(0).getPayNonpay());
		jo.put(3,sugaList.get(0).getUnitCost());
		
		
		jor.put("suga", jo);
		jor.put("sugaInjec", ja);
		return jor.toJSONString();
	}
	@GetMapping(value = "/getInjectionPatient",produces="text/plain;charset=UTF-8")
	public String getInjectionPatient() {
		JSONArray ja = new JSONArray();
		List<ReceivePatientVO> receiveList = receivePatientService.getReceiveInjection();
		for( int i=0; i<receiveList.size();i++){

			JSONObject jo = new JSONObject();
			
			jo.put(0,receiveList.get(i).getName());
			jo.put(1,receiveList.get(i).getGender());
			jo.put(2,receiveList.get(i).getRegNo());
			jo.put(3,receiveList.get(i).getAge());
			jo.put(4,receiveList.get(i).getBlood());
			jo.put(5, receiveList.get(i).getReceiveId());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	@GetMapping(value = "/getInjectionPrescription",produces="text/plain;charset=UTF-8")
	public String getInjectionPrescription(HttpServletRequest request, HttpServletResponse response) {
		JSONArray ja = new JSONArray();
		int receiveId = Integer.parseInt(request.getParameter("receiveId"));
		List<InjectionPrescriptionVO> injectionPrescriptionList = injectionPrescriptionService.getInjectionPrescription(receiveId);
		for( int i=0; i<injectionPrescriptionList.size();i++){

			JSONObject jo = new JSONObject();
			
			jo.put(0,injectionPrescriptionList.get(i).getInjecId());
			jo.put(1,injectionPrescriptionList.get(i).getInjecNameKor());
			jo.put(2,injectionPrescriptionList.get(i).getImg());

			ja.add(jo);
		}
		return ja.toJSONString();
	}
	@GetMapping(value="/getPastReceive",produces="text/plain;charset=UTF-8")
	public String getPastReceive(HttpServletRequest request) {
		JSONArray ja = new JSONArray();
		int id = Integer.parseInt(request.getParameter("id"));
		List<PastReceiveVO> pastReceiveList = pastReceiveService.getPastReceive(id);
		for( int i=0; i<pastReceiveList.size();i++){
			JSONObject jo = new JSONObject();
			
			jo.put(0,pastReceiveList.get(i).getDiseaseNameKor());
			jo.put(1,pastReceiveList.get(i).getDrugName());
			jo.put(2,pastReceiveList.get(i).getInjecNameKor());
			jo.put(3, pastReceiveList.get(i).getReceiveId());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	
	@GetMapping(value="/getDrugPrescription",produces="text/plain;charset=UTF-8")
	public String getDrugPrescription(HttpServletRequest request) {
		JSONArray ja = new JSONArray();
		int id = Integer.parseInt(request.getParameter("receiveId"));
		List<DrugVO> drugList = drugService.getDrug(id);
		for(int i=0;i<drugList.size();i++) {
			JSONObject jo = new JSONObject();
			jo.put("name", drugList.get(i).getDrugName());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	
	@GetMapping(value="/getDiseasePrescription",produces="text/plain;charset=UTF-8")
	public String getDiseasePrescription(HttpServletRequest request) {
		JSONArray ja = new JSONArray();
		int id = Integer.parseInt(request.getParameter("receiveId"));
		List<DiseaseVO> diseaseList = diseaseService.getDisease(id);
		for(int i=0;i<diseaseList.size();i++) {
			JSONObject jo = new JSONObject();
			jo.put("name", diseaseList.get(i).getDiseaseNameKor());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	
}
