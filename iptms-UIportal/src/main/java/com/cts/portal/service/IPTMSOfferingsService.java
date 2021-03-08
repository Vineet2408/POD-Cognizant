package com.cts.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.portal.model.IPTreatmentPackages;
import com.cts.portal.model.PackageDetail;
import com.cts.portal.model.SpecialistDetail;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Service
public class IPTMSOfferingsService
{
	private final String BASEURL="http://localhost:8081"; 
	IPTreatmentPackages packageDetail = null;
	List<IPTreatmentPackages> iPTreatmentPackagesList=null;
	
	OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	
	Retrofit retrofit = new Retrofit.Builder()
	  .baseUrl(BASEURL)
	  .addConverterFactory(GsonConverterFactory.create())
	  .client(httpClient.build())
	  .build();
	
	public IPTreatmentPackages getIPTreatmentPackageByName(String category,String packageName)
	{
		IPTMSOfferingInterface service = retrofit.create(IPTMSOfferingInterface.class);
		Call<IPTreatmentPackages> callsync=service.getIPTreatmentPackageByName(category,packageName);
		try {
		    Response<IPTreatmentPackages> response = callsync.execute();
		    IPTreatmentPackages packageBean = response.body();
		    packageDetail=packageBean;
		} catch (Exception ex) { System.out.println("error in IPTreatmentPackages list"); }
		
		return packageDetail;
	}
	public List<IPTreatmentPackages> getIPTreatmentPackagesList()

	{
		iPTreatmentPackagesList=new ArrayList<IPTreatmentPackages>();
		IPTMSOfferingInterface service = retrofit.create(IPTMSOfferingInterface.class);
		
		Call<List<IPTreatmentPackages>> callsync=service.getIPTPackagesList();
		try {
		    Response<List<IPTreatmentPackages>> response = callsync.execute();
		    List<IPTreatmentPackages> list = response.body();
		    iPTreatmentPackagesList=list;
		} catch (Exception ex) { System.out.println("error in IPTreatmentPackages"); }
		
		return iPTreatmentPackagesList;
	}

	public List<SpecialistDetail> getSpecialistList()
	{
		List<SpecialistDetail> list=new ArrayList<>();
		IPTMSOfferingInterface service = retrofit.create(IPTMSOfferingInterface.class);
		Call<List<SpecialistDetail>> callsync = service.getAllSpecialist();
		try {
			Response<List<SpecialistDetail>> response=callsync.execute();
			list=response.body();
			for(SpecialistDetail sd:list)
			{
				System.out.println(sd.toString());
			}
		}catch(Exception ex)
		{
			System.out.println("error in Specialist list");
		}
		
		return list;
	}
	public IPTreatmentPackages getIPTreatmentPackage(int id)
	{
		iPTreatmentPackagesList=new ArrayList<IPTreatmentPackages>();
		IPTMSOfferingInterface service = retrofit.create(IPTMSOfferingInterface.class);
		
		Call<List<IPTreatmentPackages>> callsync=service.getIPTPackagesList();
		try {
		    Response<List<IPTreatmentPackages>> response = callsync.execute();
		    List<IPTreatmentPackages> list = response.body();
		    iPTreatmentPackagesList=list;
		} catch (Exception ex) { System.out.println("error in IPTreatmentPackages"); }
		
		for(IPTreatmentPackages ips:iPTreatmentPackagesList)
		{
			if(ips.getId()==id)
			{
				packageDetail=ips;
			}
		}
		return packageDetail;
	}
}
