package com.cts.portal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.portal.model.IPTreatmentPackages;
import com.cts.portal.model.PatientDetail;
import com.cts.portal.service.IPTMSOfferingsService;
@Controller
public class IPTMSOfferingsController
{
	@Autowired
	IPTMSOfferingsService service;
	
	@RequestMapping("/tpack")
	
	public String  getIPTreatmentPackages(ModelMap map) {

List<IPTreatmentPackages> list=service.getIPTreatmentPackagesList();
		
		for(IPTreatmentPackages ip:list)
			System.out.println(ip.toString());
		
		map.put("iptreatmentPackageList", list);
		
		return "IPTreatmentPackagesServices";
	}

}
