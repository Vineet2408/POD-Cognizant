package com.cts.iptms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.iptms.model.IPTreatmentPackages;
import com.cts.iptms.model.SpecialistDetail;
import com.cts.iptms.service.IPTMSPackageDetailService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IPTreatmentPackagesController {
	
	@Autowired
	IPTMSPackageDetailService packageDetailService;
	
	@GetMapping("/IPTreatmentPackages")
	public List<IPTreatmentPackages> getIPTreatmentPackages(){
		return packageDetailService.getIPTreatmentPackages();
	}
	
	@GetMapping(path = "/IPTreatmentPackageByName/{category}/{packageName}")
	public IPTreatmentPackages getIPTreatmentPackageByAilmentCategoryAndName(@PathVariable String category,@PathVariable String packageName) {

		return packageDetailService.getIPTreatmentPackageByAilmentCategoryAndName(packageName,category);
	}
	
	@GetMapping("/SpecialistDetail")
	public List<SpecialistDetail> getSpecialistDetail(){
		return packageDetailService.getSpecialistDetail();
	}
}