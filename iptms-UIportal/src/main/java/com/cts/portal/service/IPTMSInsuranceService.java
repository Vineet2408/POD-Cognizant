package com.cts.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.portal.model.IPTreatmentPackages;
import com.cts.portal.model.InitiateClaim;
import com.cts.portal.model.InsurerDetail;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class IPTMSInsuranceService 
{
	private final String BASEURL="http://localhost:8083"; 
	InsurerDetail insurerDetail = null;
	List<InsurerDetail> insurerDetailList=null;
	
	OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	
	Retrofit retrofit = new Retrofit.Builder()
	  .baseUrl(BASEURL)
	  .addConverterFactory(GsonConverterFactory.create())
	  .client(httpClient.build())
	  .build();
	public List<InsurerDetail> getAllInsurerDetail()
	{
		IPTMSInsuranceInterface insuranceService = retrofit.create(IPTMSInsuranceInterface.class);
		Call<List<InsurerDetail>> callsync= insuranceService.getAllInsurerDetail();
		try {
		    Response<List<InsurerDetail>> response = callsync.execute();
		    List<InsurerDetail> insurerDetailBean = response.body();
		    insurerDetailList=insurerDetailBean;
		} catch (Exception ex) { System.out.println("error in IPTreatmentPackages list"); }
		for(InsurerDetail id:insurerDetailList)
			System.out.println(id.toString());
		return insurerDetailList;
	}
	public InsurerDetail getInsurerDetailByPackageName(String packageName)
	{
		IPTMSInsuranceInterface insuranceService = retrofit.create(IPTMSInsuranceInterface.class);
		Call<InsurerDetail> callsync = insuranceService.getInsurerDetailByPackageName(packageName);
		try {
		    Response<InsurerDetail>response = callsync.execute();
		    InsurerDetail insurerDetailBean = response.body();
		    insurerDetail=insurerDetailBean;
		} catch (Exception ex) { System.out.println("error in IPTreatmentPackages list"); }
		
		return insurerDetail;
	}
	public double initiateClaim(InitiateClaim claim)
	{
		double balanceAmount=0;
		IPTMSInsuranceInterface service = retrofit.create(IPTMSInsuranceInterface.class);
		Call<Double> callsync=service.initiateClaim(claim);
		try {
		    Response<Double> response = callsync.execute();
		    Double amt = response.body();
		    balanceAmount=(double)amt;
		} catch (Exception ex) { System.out.println("error in IPTreatmentPackages list"); }
		
		return balanceAmount;
	}
	
	public List<InitiateClaim> getAllInitiatedClaims()
	{
		List<InitiateClaim> list=null;
		IPTMSInsuranceInterface service = retrofit.create(IPTMSInsuranceInterface.class);
		Call<List<InitiateClaim>> callSync=service.getAllInitiatedClaims();
		try {
		    Response<List<InitiateClaim>> response = callSync.execute();
		    List<InitiateClaim> jsonList = response.body();
		    list=jsonList;
		} catch (Exception ex) { System.out.println("error in IPTreatmentPackages list"); }
		
		return list;
	}

}
