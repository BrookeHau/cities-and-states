package org.wecancodeit.citiesandstates;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CityStateMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private StateRepository stateRepo;

	@Resource
	private CityRepository cityRepo;

	@Resource
	private FishRepository fishRepo;

	@Test
	public void saveandLoadCity() {
		City city = new City("name", 123);
		city = cityRepo.save(city);
		long cityId = city.getCityId();

		entityManager.flush();
		entityManager.clear();

		city = cityRepo.findOne(cityId);
		assertThat(city.getCityName(), is("name"));

	}

	@Test
	public void saveAndLoadFish() {
		Fish fish = new Fish("name2", "binomial", "image");
		fish = fishRepo.save(fish);
		long fishId = fish.getFishId();

		entityManager.flush();
		entityManager.clear();

		fish = fishRepo.findOne(fishId);
		assertThat(fish.getFishName(), is("name2"));

	}

	@Test
	public void saveandLoadState() {
		City city = new City("name", 123);
		city = cityRepo.save(city);
		Fish fish = new Fish("name2", "binomial", "image");
		fish = fishRepo.save(fish);
		State state = new State("statename", "motto", "abbreviation", fish, city);
		state = stateRepo.save(state);
		long stateId = state.getStateId();

		entityManager.flush();
		entityManager.clear();

		state = stateRepo.findOne(stateId);
		assertThat(state.getStateName(), is("statename"));
	}

}
