package com.cts.portal.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class PatientDetail {

	private long id;
	private String name;
	private int age;
	private String ailment;
	private String treatmentPackage;
	//@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date treatmentCommencementDate;
	public PatientDetail(String name, int age, String ailment, String treatmentPackage,
			Date treatmentCommencementDate) {
		super();
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

	public Date getTreatmentCommencementDate() {
		return treatmentCommencementDate;
	}
	public void setTreatmentCommencementDate(Date treatmentCommencementDate) {
		this.treatmentCommencementDate = treatmentCommencementDate;
	}
	@Override
	public String toString() {
		return "PatientDetail [id=" + id + ", name=" + name + ", age=" + age + ", ailment=" + ailment
				+ ", treatmentPackage=" + treatmentPackage + ", treatmentCommencementDate="
				+ treatmentCommencementDate + "]";
	}
	public PatientDetail(long id, String name, int age, String ailment, String treatmentPackage,
			Date treatmentCommencementDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		this.treatmentPackage = treatmentPackage;
		this.treatmentCommencementDate = treatmentCommencementDate;
	}
	public PatientDetail() {
		super();
	}
	
}
