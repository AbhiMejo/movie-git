package com.example.user.user.entity;


import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ShowDetails")
public class ShowDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long ShowId;
	
	public Long TId;
	
	public Long MId;
	
	public String STime;
	
	public int SPrice;
	
	public int RegularSeatAvailable;

	public ShowDetails() {
		super();
	}

	public ShowDetails(Long showId, Long tId, Long mId, String sTime, int sPrice, int regularSeatAvailable) {
		super();
		ShowId = showId;
		TId = tId;
		MId = mId;
		STime = sTime;
		SPrice = sPrice;
		RegularSeatAvailable = regularSeatAvailable;
	}

	@Override
	public String toString() {
		return "ShowDetails [ShowId=" + ShowId + ", TId=" + TId + ", MId=" + MId + ", STime=" + STime + ", SPrice="
				+ SPrice + ", RegularSeatAvailable=" + RegularSeatAvailable + "]";
	}

	public Long getShowId() {
		return ShowId;
	}

	public void setShowId(Long showId) {
		ShowId = showId;
	}

	public Long getTId() {
		return TId;
	}

	public void setTId(Long tId) {
		TId = tId;
	}

	public Long getMId() {
		return MId;
	}

	public void setMId(Long mId) {
		MId = mId;
	}

	public String getSTime() {
		return STime;
	}

	public void setSTime(String sTime) {
		STime = sTime;
	}

	public int getSPrice() {
		return SPrice;
	}

	public void setSPrice(int sPrice) {
		SPrice = sPrice;
	}

	public int getRegularSeatAvailable() {
		return RegularSeatAvailable;
	}

	public void setRegularSeatAvailable(int regularSeatAvailable) {
		RegularSeatAvailable = regularSeatAvailable;
	}
}
