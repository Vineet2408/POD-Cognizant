package com.cts.iptms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iptms.exception.PackageDetailNotFoundException;
import com.cts.iptms.model.IPTreatmentPackages;
import com.cts.iptms.model.SpecialistDetail;
import com.cts.iptms.repository.IPTMSPackageDetail;
import com.cts.iptms.repository.IPTMSSpecialistDetail;

@Service
public class IPTMSPackageDetailService {
	
	@Autowired
	IPTMSPackageDetail iptmsPackageDetail;
	
	@Autowired
	IPTMSSpecialistDetail iptmsSpecialistDetail;
	
	public List<IPTreatmentPackages> getIPTreatmentPackages(){
		List<IPTreatmentPackages> treatmentPackages = iptmsPackageDetail.findAll();
		System.out.println(treatmentPackages);
		return treatmentPackages;
	}
	
	public IPTreatmentPackages getIPTreatmentPackageByAilmentCategoryAndName(String packageName, String category) {
		IPTreatmentPackages packagedetail = null;
		if (packageName.equalsIgnoreCase("package1"))
			packagedetail = iptmsPackageDetail.findByName("Package 1", category);
		else if (packageName.equalsIgnoreCase("package2"))
			packagedetail = iptmsPackageDetail.findByName("Package 2", category);

		if(packagedetail==null)
			throw new PackageDetailNotFoundException(packageName);
		return packagedetail;
	}
	
	public List<SpecialistDetail> getSpecialistDetail(){
		List<SpecialistDetail> specialistDetail = iptmsSpecialistDetail.findAll();
		return specialistDetail;
	}
}
