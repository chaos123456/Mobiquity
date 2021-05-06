package com.example.codeChallenge.challenge.model;

import java.util.List;

public class ATMDetails {

	//public List<Address> address;
	private Address address;
	private int distance;
	private List<OpeningHours> openingHours;
	private String functionality;
	private String type;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public List<OpeningHours> getOpeningHours() {
		return openingHours;
	}
	public String getFunctionality() {
		return functionality;
	}
	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	

	/*
	 * public List<Address> getAddress() { return address; }
	 */
}
