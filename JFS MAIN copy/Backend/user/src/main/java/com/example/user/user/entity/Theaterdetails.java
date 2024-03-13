package com.example.user.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Theaters")
public class Theaterdetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long TheaterId;
	
	public String TheatreName;
	
	public String MetroLocation;
	
	public String District;
	
	public int NumberOfShows;
	
	public int SeatingCapacity;
	
	public int RegervationCapacityRegular;

	@Override
	public String toString() {
		return "Theaterdetails [TheaterId=" + TheaterId + ", TheatreName=" + TheatreName + ", MetroLocation="
				+ MetroLocation + ", District=" + District + ", NumberOfShows=" + NumberOfShows + ", SeatingCapacity="
				+ SeatingCapacity + ", RegervationCapacityRegular=" + RegervationCapacityRegular + "]";
	}

	public Theaterdetails() {
		super();
	}

	public Theaterdetails(Long theaterId, String theatreName, String metroLocation, String district, int numberOfShows,
			int seatingCapacity, int regervationCapacityRegular) {
		super();
		TheaterId = theaterId;
		TheatreName = theatreName;
		MetroLocation = metroLocation;
		District = district;
		NumberOfShows = numberOfShows;
		SeatingCapacity = seatingCapacity;
		RegervationCapacityRegular = regervationCapacityRegular;
	}

	public Long getTheaterId() {
		return TheaterId;
	}

	public void setTheaterId(Long theaterId) {
		TheaterId = theaterId;
	}

	public String getTheatreName() {
		return TheatreName;
	}

	public void setTheatreName(String theatreName) {
		TheatreName = theatreName;
	}

	public String getMetroLocation() {
		return MetroLocation;
	}

	public void setMetroLocation(String metroLocation) {
		MetroLocation = metroLocation;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public int getNumberOfShows() {
		return NumberOfShows;
	}

	public void setNumberOfShows(int numberOfShows) {
		NumberOfShows = numberOfShows;
	}

	public int getSeatingCapacity() {
		return SeatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		SeatingCapacity = seatingCapacity;
	}

	public int getRegervationCapacityRegular() {
		return RegervationCapacityRegular;
	}

	public void setRegervationCapacityRegular(int regervationCapacityRegular) {
		RegervationCapacityRegular = regervationCapacityRegular;
	}
}
