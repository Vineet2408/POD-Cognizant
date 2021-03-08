package com.cognizant.insuranceclaimservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.insuranceclaimservice.InsuranceclaimServiceApplication;
import com.cognizant.insuranceclaimservice.exception.NoClaimsInitiatedException;
import com.cognizant.insuranceclaimservice.exception.PackageNameNotFoundException;
import com.cognizant.insuranceclaimservice.model.InitiateClaim;
import com.cognizant.insuranceclaimservice.model.InsurerDetail;

import com.cognizant.insuranceclaimservice.service.InsuranceClaimService;

@RestController
@RequestMapping("/insurance-claim")
public class InsuranceClaimController {
	@Autowired
	private InsuranceClaimService insuranceClaimService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceclaimServiceApplication.class);
	@GetMapping
	public List<InsurerDetail> getAllInsurerDetail() {
		LOGGER.info("START");
		LOGGER.info("END");
		return insuranceClaimService.getAllInsurerDetail();
	}
	@GetMapping("/{packageName}")
	public InsurerDetail getInsurerDetailByPackageName(@PathVariable String packageName) throws PackageNameNotFoundException {
		LOGGER.info("START");
		LOGGER.info("END");
		return insuranceClaimService.getInsurerByPackageName(packageName);
	}
	@GetMapping("/initiate-claim")
	public  List<InitiateClaim> getAllInitiatedClaims() throws NoClaimsInitiatedException {
		LOGGER.info("START");
		LOGGER.debug("all list");
		LOGGER.info("END");
		try {
		return insuranceClaimService.getAllInitiatedClaims();
		}
		catch(Exception e) {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "No claims initiated", e);
		}
	}
	@PostMapping
	public double initiateClaim(@RequestBody @Valid InitiateClaim initiateClaim)
	{
		LOGGER.info("START");
		LOGGER.info("END");
		return insuranceClaimService.initiateClaim(initiateClaim);
	}
	

}
