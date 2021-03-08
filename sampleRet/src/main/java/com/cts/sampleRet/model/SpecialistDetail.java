package com.cts.sampleRet.model;

import org.springframework.stereotype.Component;

public class SpecialistDetail {
	
	private String Name;
	private String areaOfExpertise;
	private int experienceInYears;
	private String contactNumber;
	
	public SpecialistDetail(String name, String areaOfExpertise, int experienceInYears, String contactNumber) {
		super();
		Name = name;
		this.areaOfExpertise = areaOfExpertise;
		this.experienceInYears = experienceInYears;
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAreaOfExpertise() {
		return areaOfExpertise;
	}
	public void setAreaOfExpertise(String areaOfExpertise) {
		this.areaOfExpertise = areaOfExpertise;
	}
	public int getExperienceInYears() {
		return experienceInYears;
	}
	public void setExperienceInYears(int experienceInYears) {
		this.experienceInYears = experienceInYears;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}