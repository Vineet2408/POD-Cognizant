package com.cts.portal;

public class SpecialistDetail {
	
	private String name;
	private String areaOfExpertise;
	private int experienceInYears;
	private String contactNumber;
	
	public SpecialistDetail() {
		super();
	}
	public SpecialistDetail(String name, String areaOfExpertise, int experienceInYears, String contactNumber) {
		super();
		name = name;
		this.areaOfExpertise = areaOfExpertise;
		this.experienceInYears = experienceInYears;
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
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
	@Override
	public String toString() {
		return "SpecialistDetail [Name=" + name + ", areaOfExpertise=" + areaOfExpertise + ", experienceInYears="
				+ experienceInYears + ", contactNumber=" + contactNumber + "]";
	}
	
}