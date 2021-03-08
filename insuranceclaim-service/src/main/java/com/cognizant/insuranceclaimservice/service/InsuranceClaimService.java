package com.cognizant.insuranceclaimservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.insuranceclaimservice.InsuranceclaimServiceApplication;
import com.cognizant.insuranceclaimservice.dao.InsuranceClaimDao;
import com.cognizant.insuranceclaimservice.exception.NoClaimsInitiatedException;
import com.cognizant.insuranceclaimservice.exception.PackageNameNotFoundException;
import com.cognizant.insuranceclaimservice.model.InitiateClaim;
import com.cognizant.insuranceclaimservice.model.InsurerDetail;

@Service
public class InsuranceClaimService {
	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceclaimServiceApplication.class);
	@Autowired
	private InsuranceClaimDao insuranceClaimDao;
	public InsuranceClaimDao getInsuranceClaimDao() {
		return insuranceClaimDao;
	}
	public void setInsuranceClaimDao(InsuranceClaimDao insuranceClaimDao) {
		this.insuranceClaimDao = insuranceClaimDao;
	}
	
	public List<InsurerDetail> getAllInsurerDetail() {
		  LOGGER.info("Start");
		  LOGGER.info("End");
		  return insuranceClaimDao.getAllInsurerDetail();
		}
	
	public InsurerDetail getInsurerByPackageName(String packageName) throws PackageNameNotFoundException {
		LOGGER.info("Start");
		  LOGGER.info("End");
			return insuranceClaimDao.getInsurerByPackageName(packageName);

}
	
	public double initiateClaim(InitiateClaim initiateClaim) {
		LOGGER.info("Start");
		  LOGGER.info("End");
			return insuranceClaimDao.initiateClaim(initiateClaim);
	}
	public List<InitiateClaim> getAllInitiatedClaims() throws NoClaimsInitiatedException{
		LOGGER.info("Start");
		  LOGGER.info("End");
		  return insuranceClaimDao.getAllInitiatedClaims();
	}
}