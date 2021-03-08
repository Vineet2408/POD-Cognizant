package com.cts.portal.service;

import com.cts.portal.model.PatientDetail;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatientServiceRetrofit
{
	String BASEURL ="http://localhost:8081";
	PatientDetail patientDetail=null;
public PatientDetail get()
{
	OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	
	Retrofit retrofit = new Retrofit.Builder()
	  .baseUrl(BASEURL)
	  .addConverterFactory(GsonConverterFactory.create())
	  .client(httpClient.build())
	  .build();
	
	PatientInterface service = retrofit.create(PatientInterface.class);
	Call<PatientDetail> callSync = service.getPatient();
	
	try {
	    Response<PatientDetail> response = callSync.execute();
	    PatientDetail patient = response.body();
	    patientDetail=patient;
	} catch (Exception ex) { System.out.println("erorororororororororororororororor"); }
	
	
	return patientDetail;
}
}
