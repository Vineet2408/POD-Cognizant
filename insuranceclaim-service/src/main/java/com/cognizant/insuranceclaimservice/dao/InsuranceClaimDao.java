package com.cognizant.insuranceclaimservice.dao;

import java.util.List;

import com.cognizant.insuranceclaimservice.exception.NoClaimsInitiatedException;
import com.cognizant.insuranceclaimservice.exception.PackageNameNotFoundException;

import com.cognizant.insuranceclaimservice.model.InitiateClaim;
import com.cognizant.insuranceclaimservice.model.InsurerDetail;

public interface InsuranceClaimDao {
	List<InsurerDetail> getAllInsurerDetail();
	
	InsurerDetail getInsurerByPackageName(String packageName) throws PackageNameNotFoundException;
	
	double initiateClaim(InitiateClaim initiateClaim);
	
	List<InitiateClaim> getAllInitiatedClaims() throws NoClaimsInitiatedException;

	

}
