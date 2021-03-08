package com.cts.portal.controllers;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.portal.model.IPTreatmentPackages;
import com.cts.portal.model.InitiateClaim;
import com.cts.portal.model.PackageDetail;
import com.cts.portal.model.PatientDetail;
import com.cts.portal.model.SamplePatient;
import com.cts.portal.model.TreatmentPlan;
import com.cts.portal.model.User;
import com.cts.portal.service.IPTMSInsuranceService;
import com.cts.portal.service.IPTMSOfferingsService;
import com.cts.portal.service.IPTMSPatientService;

@Controller
@RequestMapping("/patient")
public class IPTMSPatientController 
{
	@Autowired
	IPTMSPatientService patientService;
	@Autowired
	IPTMSOfferingsService offeringService;
	
	@Autowired
	IPTMSInsuranceService insuranceService;
	User u=null;
	@PostMapping("/processform")
	public String handleForm(@ModelAttribute User user ,ModelMap map)
	{
		u=user;
		List<IPTreatmentPackages> list=offeringService.getIPTreatmentPackagesList();
		
		for(IPTreatmentPackages ip:list)
			System.out.println(ip.toString());
		
		map.put("iptreatmentPackageList", list);
		
		return "IPTreatmentPackagesServices";
	}
	
	@RequestMapping("/getTreatment")
	public String getTreatment(@RequestParam("id") int id,ModelMap map)
	{
		String name = u.getName();
		int age = u.getAge();
		String ailment = u.getAilment();
		
		System.out.println("IPTreatmentPackages idididididididididididididididididididididid"+id);
		IPTreatmentPackages pack=offeringService.getIPTreatmentPackage(id);
		System.out.println(pack.toString());
		
		PackageDetail pd=pack.getPackageDetail();
		
		String tpn = pd.getTreatmentPackageName();
		String arr[]=tpn.split(" ");
		tpn=arr[0]+arr[1];
		tpn=tpn.toLowerCase();
		System.out.println("tpnrpnepnepnepnepenepenepenepenepentptntptntp   "+tpn);
		
		Date d=new Date();
		Calendar calendar = Calendar.getInstance();
		//calendar.setTime(d);
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String date = sm.format(d);
		Date fDate=null;
		try {
			fDate= sm.parse(date);
		} catch (Exception e) {
			
			System.out.println("Date Fromatting error");
		}
		System.out.println(fDate.toString());
		SamplePatient patient=new SamplePatient(name,age,ailment,tpn,date);
		System.out.println("innnnnnnnnn patient controller sending this patient = "+patient.toString());
		try {
	
		
		TreatmentPlan res=patientService.addSamplePatient(patient);
		System.out.println("in patient  controlllllllllllllllllllllller"+res.toString());
		
		List<InitiateClaim> list=insuranceService.getAllInitiatedClaims();
		double balanceAmt=res.getCost();
		for(InitiateClaim ic:list)
		{
			if(ic.getId()==res.getPatientDetail().getId())
				balanceAmt=ic.getBalance();
		}
		
		map.put("patientDetail", patient);
		map.put("treatmentPlan",res);
		map.put("treatmentCommencementDate", res.getTreatmentCommencementDate());
		map.put("treatmentEndDate",res.getTreatmentEndDate());
		map.put("balanceAmount", balanceAmt);
		
		}catch(Exception ex)
		{
			
		}
		return "profile";
	}
	
	@GetMapping("/profile")
	public String profile()
	{
		return "profile";
	}
}
