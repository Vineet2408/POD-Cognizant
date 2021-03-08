package com.cts.portal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.portal.model.InitiateClaim;
import com.cts.portal.model.InsurerDetail;
import com.cts.portal.model.PatientDetail;
import com.cts.portal.model.TreatmentPlan;
import com.cts.portal.service.IPTMSInsuranceService;
import com.cts.portal.service.IPTMSPatientService;

import retrofit2.http.Path;

@Controller
@RequestMapping("/insurance")
public class IPTMSInsuranceController
{
	@Autowired
	IPTMSInsuranceService service;
	@Autowired
	IPTMSPatientService patientService;
	
	TreatmentPlan tp;
	@GetMapping
	public String getAllInsurerDetail() {
	
		 
		 return "Insurance";
	}
	@GetMapping("/{packageName}")
	public InsurerDetail getInsurerDetailByPackageName(@PathVariable String packageName)  {
	
		return service.getInsurerDetailByPackageName(packageName);
	}
	
	@PostMapping
	public double initiateClaim(@RequestBody InitiateClaim initiateClaim)
	{

		return service.initiateClaim(initiateClaim);
	}
	@GetMapping("/viewApplications")
	public String viewApplication(ModelMap map)
	{
		List<TreatmentPlan> treatmentPlanList=patientService.getAllTreatmentPlan();
		for(TreatmentPlan tp:treatmentPlanList)
		{
			System.out.println(tp.toString());
		}
		map.put("treatmentPlanList", treatmentPlanList);
		return "PatientForInsuranceClaim";
	}
	@GetMapping("/viewAllPackages")
	public String viewAllPackages(ModelMap map)
	{
		List<InsurerDetail> list=service.getAllInsurerDetail();
		for(InsurerDetail id:list)
			System.out.println(id.toString());
		map.put("insurancePackagesList", list);
		return "InsurancePackages";
	}
	//from PatientForInsuranceClaim
	@GetMapping("/selectInsurance")
	public String selectInsurance(@RequestParam long tpid,ModelMap map)
	{
		TreatmentPlan tplan=patientService.getTreatmentPlan(tpid);
		tp=tplan;
		//patientService.getPatientDetail(tp.getPatientDetail());
		List<InsurerDetail> list=service.getAllInsurerDetail();
		map.put("insurerDetailList",list);
		return "SelectInsurance";
	}
	@GetMapping("/initiateClaim")
	public String initiateClaimForPatient(@RequestParam String packageName,ModelMap map)
	{

		
		InsurerDetail insurerDetail=service.getInsurerDetailByPackageName(packageName);
		PatientDetail pd = tp.getPatientDetail();
		String patientName=pd.getName();
		String ailment=pd.getAilment();
		String treatmentPackageName=pd.getTreatmentPackage();
		String insurerName=insurerDetail.getInsurerName();
		double cost = tp.getCost();
		double insurerAmountLimit = insurerDetail.getInsuranceAmountLimit();
		String status="Under Progress";
		InitiateClaim ic=new InitiateClaim(patientName,ailment,treatmentPackageName,insurerName,cost,insurerAmountLimit,status);
		double balanceAmount=service.initiateClaim(ic);
		map.put("balanceAmount", balanceAmount);
		return "balanceAmount";
	}
	

}
