package org.wecancodeit.citiesandstates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {

	@Id
	@GeneratedValue
	private long cityId;
	private String cityName;
	private int cityPopulation;

	public City() {

	}

	public City(String cityName, int cityPopulation) {
		this.cityName = cityName;
		this.cityPopulation = cityPopulation;
	}

	// mapping
	@ManyToOne
	public State state;

	public State getState() {
		return state;
	}

	// method
	public String getCityName() {
		return cityName;
	}
	
	public Long getCityId() {
		return cityId;
	}

	public int getPopulation() {
		return cityPopulation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cityId ^ (cityId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (cityId != other.cityId)
			return false;
		return true;
	}

}
