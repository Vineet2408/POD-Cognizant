package com.cognizant.iptm.model;

public class SamplePatient 
{
	private long id;
	private String name;
	private int age;
	private String ailment;
	private String treatmentPackage;
	private String treatmentCommencementDate;
	
	
	public SamplePatient() {
		super();
	}
	
	public SamplePatient(String name, int age, String ailment, String treatmentPackage,
			String treatmentCommencementDate) {
		super();
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		this.treatmentPackage = treatmentPackage;
		this.treatmentCommencementDate = treatmentCommencementDate;
	}

	public SamplePatient(long id, String name, int age, String ailment, String treatmentPackage,
			String treatmentCommencementDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		this.treatmentPackage = treatmentPackage;
		this.treatmentCommencementDate = treatmentCommencementDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAilment() {
		return ailment;
	}
	public void setAilment(String ailment) {
		this.ailment = ailment;
	}
	public String getTreatmentPackage() {
		return treatmentPackage;
	}
	public void setTreatmentPackage(String treatmentPackage) {
		this.treatmentPackage = treatmentPackage;
	}
	public String getTreatmentCommencementDate() {
		return treatmentCommencementDate;
	}
	public void setTreatmentCommencementDate(String treatmentCommencementDate) {
		this.treatmentCommencementDate = treatmentCommencementDate;
	}
	
	


}
