package com.cts.portal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.portal.model.IPTreatmentPackages;
import com.cts.portal.model.SpecialistDetail;
import com.cts.portal.service.IPTMSOfferingsService;

@Controller
public class HomeController 
{
	@Autowired
	IPTMSOfferingsService service;
	@GetMapping("/home")
	public String home(ModelMap map)
	{
		List<IPTreatmentPackages> list=service.getIPTreatmentPackagesList();
		List<SpecialistDetail> sList=service.getSpecialistList();
		map.put("iPTreatmentPackageList", list);
		map.put("specialistList", sList);
		return "home";
	}
	@GetMapping
	public String defaultPage(ModelMap map)
	{
		List<IPTreatmentPackages> list=service.getIPTreatmentPackagesList();
		List<SpecialistDetail> sList=service.getSpecialistList();
		map.put("iPTreatmentPackageList", list);
		map.put("specialistList", sList);
		return "home";
	}
	
	@GetMapping("/registerPatient")
	public String register()
	{
		return "registration";
	}
	@GetMapping("/signup")
	public String signUp()
	{
		return "registration";
	}
	@GetMapping("/searchPackage")
	public String search(@RequestParam String packageName,@RequestParam String ailment,ModelMap map)
	{
		IPTreatmentPackages pack=service.getIPTreatmentPackageByName(ailment, packageName);
		List<IPTreatmentPackages> list=new ArrayList<IPTreatmentPackages>();
		list.add(pack);
		map.put("iptreatmentPackageList", list);
		return "IPTreatmentPackagesServices";
	}
	
}
