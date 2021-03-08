package com.cts.portal;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.ArrayList;
import java.util.List;


public class GetSpecialist
{
	String BASEURL = "http://localhost:8080/";
	String BASEURL2 = "http://localhost:8081/";
	String BASEURL3 = "http://localhost:8082/";

	 SpecialistDetail mainuser=null;
	public SpecialistDetail get()
	{
		System.out.println("inside--------------------------------------------------------");
		
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		
		Retrofit retrofit = new Retrofit.Builder()
		  .baseUrl(BASEURL)
		  .addConverterFactory(GsonConverterFactory.create())
		  .client(httpClient.build())
		  .build();
		
		System.out.println("inside   222--------------------------------------------------------");

		SpecialistInterface service = retrofit.create(SpecialistInterface.class);
		
		
		
		System.out.println("inside 3333--------------------------------------------------------");

		Call<SpecialistDetail> callSync = service.getUser();
		
		try {
		    Response<SpecialistDetail> response = callSync.execute();
		    SpecialistDetail user = response.body();
		    mainuser=user;
		} catch (Exception ex) { System.out.println("erorororororororororororororororor"); }
		
		
		return mainuser;
	}

}
