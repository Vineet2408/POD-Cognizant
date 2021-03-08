package com.cts.portal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SpecialistInterface {

	@GET("/specialist")
    public Call<SpecialistDetail> getUser();
	
	
}
