package com.cts.portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.portal.model.IPTreatmentPackages;
import com.cts.portal.model.PatientDetail;
import com.cts.portal.model.SamplePatient;
import com.cts.portal.model.TreatmentPlan;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Service
public class IPTMSPatientService {

	private final String BASEURL="http://localhost:8082"; 
	IPTreatmentPackages packageDetail = null;
	List<IPTreatmentPackages> iPTreatmentPackagesList=null;
	
	OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	
	Retrofit retrofit = new Retrofit.Builder()
	  .baseUrl(BASEURL)
	  .addConverterFactory(GsonConverterFactory.create())
	  .client(httpClient.build())
	  .build();
		
	public PatientDetail getPatientDetail(long ptId)
	{
		PatientDetail patientDetail=null;
		IPTMSPatientInterface service = retrofit.create(IPTMSPatientInterface.class);
		Call<PatientDetail> callsync=service.getPatient(ptId);
		try {
		    Response<PatientDetail> response = callsync.execute();
		    PatientDetail patientDetailBean = response.body();
		    patientDetail=patientDetailBean;
		} catch (Exception ex) { System.out.println("error in IPTreatmentPackages list"); }
		
		return patientDetail;
	}
	public TreatmentPlan getTreatmentPlan(long ptId)
	{
		TreatmentPlan treatmentPlan=null;
		IPTMSPatientInterface service = retrofit.create(IPTMSPatientInterface.class);
		Call<TreatmentPlan> callsync=service.getTreatmentPlan(ptId);
		try {
		    Response<TreatmentPlan> response = callsync.execute();
		    TreatmentPlan treatmentPlanBean = response.body();
		    treatmentPlan=treatmentPlanBean;
		} catch (Exception ex) { System.out.println("error in IPTreatmentPackages list"); }
		
		return treatmentPlan;
	}

	public TreatmentPlan addPatient(PatientDetail pd)
	{
		TreatmentPlan res=null;
		IPTMSPatientInterface service = retrofit.create(IPTMSPatientInterface.class);
		Call<TreatmentPlan> callsync=service.addPatient(pd);
		try {
			Response<TreatmentPlan> response=callsync.execute();
			TreatmentPlan plan=response.body();
			res=plan;
			System.out.println(plan.toString());
		}
		catch(Exception ex)
		{
			System.out.println("error in service in fromgetTreatmentPlan add patient = error msg = ="+ex.getMessage());
		}
		return res;
	}
	
	public List<TreatmentPlan> getAllTreatmentPlan() {
		List<TreatmentPlan> treatmentPlanList=null;
		IPTMSPatientInterface service = retrofit.create(IPTMSPatientInterface.class);
		Call<List<TreatmentPlan>> callsync = service.getAllTreatmentPlans();
		try {
			Response<List<TreatmentPlan>> response=callsync.execute();
			treatmentPlanList=response.body();
			
		}
		catch(Exception ex)
		{
			System.out.println("error in get All Treatments plans"+ex.getMessage());
		}
		return treatmentPlanList;
	}
	public TreatmentPlan addSamplePatient(SamplePatient sp)
	{
		TreatmentPlan plan=null;
		IPTMSPatientInterface service = retrofit.create(IPTMSPatientInterface.class);
		Call<TreatmentPlan> callsync = service.addSamplePatient(sp);
		try {
		    Response<TreatmentPlan> response = callsync.execute();
		    TreatmentPlan treatmentPlanBean = response.body();
		    plan=treatmentPlanBean;
		} catch (Exception ex) { System.out.println("error in IPTreatmentPackages list"); }
		
		return plan;
		
	}
}
