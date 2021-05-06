package com.example.codeChallenge.challenge.model;

import java.util.List;

public class OpeningHours {
	
	private int dayOfWeek;
	private List<Hours> hours;

	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	public List<Hours> getHours() {
		return hours;
	}

	

}
