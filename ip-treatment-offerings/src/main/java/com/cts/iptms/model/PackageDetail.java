package com.cts.iptms.model;

import javax.persistence.Embeddable;

@Embeddable
public class PackageDetail {

	private String treatmentPackageName;
	private String testDetails;
	private int cost;
	private int treatmentDuration;

	@Override
	public String toString() {
		return "PackageDetail [treatmentPackageName=" + treatmentPackageName + ", testDetails=" + testDetails
				+ ", cost=" + cost + ", treatmentDuration=" + treatmentDuration + "]";
	}

	public String getTreatmentPackageName() {
		return treatmentPackageName;
	}

	public void setTreatmentPackageName(String treatmentPackageName) {
		this.treatmentPackageName = treatmentPackageName;
	}

	public String getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(String testDetails) {
		this.testDetails = testDetails;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTreatmentDuration() {
		return treatmentDuration;
	}

	public void setTreatmentDuration(int treatmentDuration) {
		this.treatmentDuration = treatmentDuration;
	}

	public PackageDetail(String treatmentPackageName, String testDetails, int cost, int treatmentDuration) {
		super();
		this.treatmentPackageName = treatmentPackageName;
		this.testDetails = testDetails;
		this.cost = cost;
		this.treatmentDuration = treatmentDuration;
	}

	public PackageDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

}
