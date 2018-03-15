package org.wecancodeit.citiesandstates;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CityStateClassTest {

	
	@Test
	public void createStateClass() {
		City city = new City("name", 123);
		Fish fish = new Fish("name", "binomial", "image");
		State state = new State("statename", "motto", "abbreviation", fish, city);
		String check = state.getStateName();
		String check2 = state.getStateMotto();
		String check3 = state.getStateAbbrev();
		assertThat(check, is("statename"));
		assertThat(check2, is("motto"));
		assertThat(check3, is("abbreviation"));
	}
	
	@Test 
	public void createCityClass() {
		City city = new City("name", 123);
		String check = city.getCityName();
		int check2 = city.getPopulation();
		assertThat(check, is("name"));
		assertThat(check2, is(123));
	}
	
	@Test 
	public void createFishClass() {
		Fish fish = new Fish("name", "binomial", "image");
		String check = fish.getFishName();
		String check2 = fish.getFishBinom();
		String check3 = fish.getFishImage();
		assertThat(check, is("name"));
		assertThat(check2, is("binomial"));
		assertThat(check3, is("image"));
	}
}
