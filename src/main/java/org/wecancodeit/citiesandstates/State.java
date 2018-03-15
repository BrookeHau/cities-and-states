package org.wecancodeit.citiesandstates;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class State {

	@Id
	@GeneratedValue
	private long stateId;
	private String stateName;
	private String stateMotto;
	private String stateAbbreviation;

	public State() {

	}

	public State(String stateName, String stateMotto, String stateAbbreviation, Fish fish, City... cities) {
		this.stateName = stateName;
		this.stateMotto = stateMotto;
		this.stateAbbreviation = stateAbbreviation;
		this.fish = fish;
		this.cities = new HashSet<>(asList(cities));
	}

	// mapping
	@ManyToOne
	public Fish fish;

	public Fish getFish() {
		return fish;
	}

	@OneToMany(mappedBy = "state")
	Collection<City> cities;

	public Collection<City> getCities() {
		return cities;
	}

	// methods
	public long getStateId() {
		return stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public String getStateMotto() {
		return stateMotto;
	}

	public String getStateAbbrev() {
		return stateAbbreviation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (stateId ^ (stateId >>> 32));
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
		State other = (State) obj;
		if (stateId != other.stateId)
			return false;
		return true;
	}

}
