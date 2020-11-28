package com.ocs.osj.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ocs.osj.model.DiseasePrescriptionService;
import com.ocs.osj.model.DiseasePrescriptionVO;
import com.ocs.osj.model.DrugPrescriptionService;
import com.ocs.osj.model.DrugPrescriptionVO;
import com.ocs.osj.model.DrugService;
import com.ocs.osj.model.InjectionPrescriptionService;
import com.ocs.osj.model.InjectionPrescriptionVO;
import com.ocs.osj.model.PatientService;
import com.ocs.osj.model.PatientVO;
import com.ocs.osj.model.PrescriptionService;
import com.ocs.osj.model.PrescriptionVO;
import com.ocs.osj.model.ReceiveService;
import com.ocs.osj.model.ReceiveVO;
import com.ocs.osj.model.UserService;
import com.ocs.osj.model.UserVO;

@Controller
public class PatientController {
	private static final String UPLOAD_PATH = "C:\\Users\\maison64\\Desktop\\school\\eclipse-workspace\\ocs\\src\\main\\webapp\\resources\\img\\";
	@Autowired
	PatientService patientService;
	@Autowired
	ReceiveService receiveSerive;
	@Autowired
	UserService userService;
	@Autowired
	PrescriptionService prescriptionService;
	@Autowired
	DiseasePrescriptionService diseasePrescriptionService;
	@Autowired
	DrugPrescriptionService drugPrescriptionService;
	@Autowired
	InjectionPrescriptionService injectionPrescriptionService;
	
	@GetMapping("/insert")
	public String goPatient() {
		return "insert";
	}
	@GetMapping("/receipt")
	public String goReceipt() {
		return "receipt";
	}
	
	@PostMapping("/insertPatient.do")
	public String insertPatient(PatientVO vo) {
		patientService.insertPatient(vo);
		return "redirect:/main.do";
	}
	@GetMapping("/drug")
	public String showDrug() {
		return "drug";
	}
	@GetMapping("/disease")
	public String showDisease() {
		return "disease";
	}
	@GetMapping("/injection")
	public String showInjection() {
		return "injection";
	}
	@GetMapping("/pastReceive")
	public String showPastReceive() {
		
		return "pastReceive";
	}
	@GetMapping("/result")
	public String showResult(HttpServletRequest request,Model model) {
		List<InjectionPrescriptionVO> list= injectionPrescriptionService.getInjectionPrescription(Integer.parseInt(request.getParameter("receive_id")));
		
		model.addAttribute("img","resources/img/"+list.get(0).getImg());
		return "result";
	}
	@GetMapping("/test")
	public String showTest() {
		return "test";
	}
	@PostMapping("/insertReceive.do")
	public String insertReceive(ReceiveVO vo) {
		vo.setTreatStatus("N");
		vo.setReceiptYn("N");
		receiveSerive.insertReceive(vo);
		return "redirect:/main.do";
	}
	@PostMapping("/insertPrescription.do")
	public String insertPrescription(@RequestParam(value="diseaseId") List<Integer> diseaseIdList,
									@RequestParam(value="disesYn") List<String> disesYnList, 
									@RequestParam(value="drugId") List<Integer> drugIdList,
									@RequestParam(value="days") List<Integer> daysList,
									@RequestParam(value="oneDosage") List<Integer> oneDosageList,
									@RequestParam(value="dayDosage") List<Integer> dayDosageList,
									DiseasePrescriptionVO vo1, DrugPrescriptionVO vo2) {
		for(int i=0;i<diseaseIdList.size();i++) {
			vo1.setDiseaseId(diseaseIdList.get(i));
			vo1.setDisesYn(disesYnList.get(i));
			diseasePrescriptionService.insertDiseasePrescription(vo1);	
		
		}
		for(int i=0;i<drugIdList.size();i++) {
			vo2.setDrugId(drugIdList.get(i));
			vo2.setDays(daysList.get(i));
			vo2.setOneDosage(oneDosageList.get(i));
			vo2.setDayDosage(dayDosageList.get(i));
			drugPrescriptionService.insertReceive(vo2);
		}
		
		ReceiveVO receiveVO = new ReceiveVO();
		receiveVO.setReceiveId(vo1.getReceiveId());
		receiveSerive.updateReceive(receiveVO);
		return "redirect:/main.do";
	}
	@PostMapping("/updateInjection.do")
	public String updateInjection(ReceiveVO vo,InjectionPrescriptionVO vo2) {
		receiveSerive.updateReceive(vo);
		receiveSerive.updateReceiveInjection(vo);
		injectionPrescriptionService.insertInjectionPrescription(vo2);
		
		return "redirect:/main.do";
	}
	@PostMapping("/updateReceive.do")
	public String updateReceive(ReceiveVO vo) {
		receiveSerive.updateReceiveReceipt(vo);
		return "receipt";
	}
	@PostMapping("/fileupload.do")
	public String updateInjectionPrescription(MultipartFile uploadFile, InjectionPrescriptionVO vo) {
		UUID uuid = UUID.randomUUID();
		String saveName = uuid+"_"+uploadFile.getOriginalFilename();
		
		File saveFile = new File(UPLOAD_PATH, saveName);
		try {
			uploadFile.transferTo(saveFile);
		}catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		vo.setImg(saveName);
		injectionPrescriptionService.updateInjectionPrescription(vo);
		
		ReceiveVO receiveVO = new ReceiveVO();
		receiveVO.setReceiveId(vo.getReceiveId());
		
		receiveSerive.updateReceiveInjectionPrescription(receiveVO);
		return "redirect:/main.do";
	}
}
