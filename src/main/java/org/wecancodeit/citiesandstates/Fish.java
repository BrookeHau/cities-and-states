package org.wecancodeit.citiesandstates;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fish {

	@Id
	@GeneratedValue
	private long fishId;
	private String fishName;
	private String fishBinom;
	private String fishImage;
	
	public Fish() {
		
	}

	public Fish(String fishName, String fishBinom, String fishImage, State...states) {
		this.fishName = fishName;
		this.fishBinom = fishBinom;
		this.fishImage = fishImage;
		this.states = new HashSet<>(asList(states));
	}

	//mapping
	@OneToMany (mappedBy="fish")
	private Collection<State> states;
	
	public Collection<State> getStates(){
		return states;
	}
	
	public String getStateName() {
		String stateName = "";
		for(State state: states) {
			stateName = state.getStateName();
		} return stateName;
	}
	
	
	//methods
	public long getFishId() {
		return fishId;
	}
	
	public String getFishName() {
		return fishName;
	}

	public String getFishBinom() {
		return fishBinom;
	}

	public String getFishImage() {
		return fishImage;
	}
	
	@Override
	public int hashCode() {
		return ((Long) fishId).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return fishId == ((Fish) obj).fishId;
	}

}
