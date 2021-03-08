package com.cts.sampleRet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.sampleRet.model.SpecialistDetail;

@RestController
public class Cnt {

	@GetMapping("/hello")
	public String hello()
	{
		return "hello";
	}
	@GetMapping("/specialist")
	public SpecialistDetail getSpeciaListDetail()
	{
		SpecialistDetail u=new SpecialistDetail( "utsav",  "ortho",  5,  "789456123");
		
		return u;
	}
	@GetMapping("/specialist/{name}")
	public SpecialistDetail getSpeciaListDetailByName(@PathVariable String name)
	{
		SpecialistDetail u=new SpecialistDetail( "utsav",  "ortho",  5,  "789456123");
		
		return u;
		}
}
