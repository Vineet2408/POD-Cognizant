package com.cognizant.insuranceclaimservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.insuranceclaimservice.InsuranceclaimServiceApplication;
import com.cognizant.insuranceclaimservice.exception.NoClaimsInitiatedException;
import com.cognizant.insuranceclaimservice.exception.PackageNameNotFoundException;

import com.cognizant.insuranceclaimservice.model.InitiateClaim;
import com.cognizant.insuranceclaimservice.model.InsurerDetail;
import com.cognizant.insuranceclaimservice.model.PatientDetail;
import com.cognizant.insuranceclaimservice.model.TreatmentPlan;
import com.cognizant.insuranceclaimservice.repository.InitiateClaimRepository;
import com.cognizant.insuranceclaimservice.repository.InsurerDetailRepository;
@Component
public class InsuranceClaimDaoImpl implements InsuranceClaimDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceclaimServiceApplication.class);
	private static ArrayList<InsurerDetail> insurerList;
	private static ArrayList<InitiateClaim> initiateClaimList;
	private static ArrayList<PatientDetail> patientList;
	private static ArrayList<TreatmentPlan> treatmentList;
	@Autowired
	InsurerDetailRepository insurerDetailRepository;
	
	@Autowired
	InitiateClaimRepository initiateClaimRepo;
	
	
	
	public InsuranceClaimDaoImpl() {
		
		LOGGER.info("Start");
		LOGGER.info("End");
	}

	@Override
	public List<InsurerDetail> getAllInsurerDetail() {
		List<InsurerDetail> insurerDetailList = null;
		LOGGER.info("Start");
		insurerDetailList = insurerDetailRepository.findAll();
		LOGGER.info("End");
		return insurerDetailList;
		
	}

	
	@Override
	public InsurerDetail getInsurerByPackageName(String packageName) throws PackageNameNotFoundException{
		LOGGER.info("Start");
		InsurerDetail insurerDetail;
		try {
	   
	    insurerDetail=insurerDetailRepository.findByInsurerPackageName(packageName);
		}
		catch(Exception e) {
			throw new PackageNameNotFoundException();
		}
		LOGGER.info("End");
	   return insurerDetail;
}


	@Override
	public double initiateClaim(InitiateClaim initiateClaim) {
		LOGGER.info("Start");
		initiateClaimRepo.save(initiateClaim);
		double balance;
		balance=initiateClaim.getTreatmentCost()-initiateClaim.getInsurerAmountLimit();
		balance=balance<0?0:balance;
		InitiateClaim updatedBalanceAndStatus = initiateClaimRepo.findById(initiateClaim.getId());
		    updatedBalanceAndStatus.setBalance(balance);
		    updatedBalanceAndStatus.setStatus("Completed");
		    initiateClaimRepo.save(updatedBalanceAndStatus);
		    LOGGER.info("End");
		 return balance;
		    
		
	
	    
}

	@Override
	public List<InitiateClaim> getAllInitiatedClaims() throws NoClaimsInitiatedException {
		try {
		List<InitiateClaim> initiateClaimList=initiateClaimRepo.findAll();
		}
		catch(Exception e) {
			throw new  NoClaimsInitiatedException();
		}
		return initiateClaimList;
	}

	
}
