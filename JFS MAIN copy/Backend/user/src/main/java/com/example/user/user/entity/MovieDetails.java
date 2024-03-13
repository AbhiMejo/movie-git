package com.example.user.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Movies")
public class MovieDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long MovieId;
	
	public String MovieName;
	
	public String Language;
	
	public int Duration;

	public MovieDetails() {
		super();
	}

	@Override
	public String toString() {
		return "MovieDetails [MovieId=" + MovieId + ", MovieName=" + MovieName + ", Language=" + Language
				+ ", Duration=" + Duration + "]";
	}

	public MovieDetails(Long movieId, String movieName, String language, int duration) {
		super();
		MovieId = movieId;
		MovieName = movieName;
		Language = language;
		Duration = duration;
	}

	public Long getMovieId() {
		return MovieId;
	}

	public void setMovieId(Long movieId) {
		MovieId = movieId;
	}

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}
}
