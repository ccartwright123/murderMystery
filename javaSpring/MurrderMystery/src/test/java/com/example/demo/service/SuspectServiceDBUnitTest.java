package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.data.Suspect;
import com.example.demo.data.repo.SuspectRepo;

@SpringBootTest
@ActiveProfiles("test")
public class SuspectServiceDBUnitTest {

	@Autowired // injects the actual service from the context
	private SuspectServiceDB service;

	@MockBean // tells Spring to make a 'fake' KittenRepo that we can program
	private SuspectRepo repo;

	@Test
	void testCreate() {

		Suspect newSuspect = new Suspect("jordan","gun","bedroom","teacher",50);

		Suspect savedSuspect = new Suspect("jordan","gun","bedroom","teacher",50);

		Mockito.when(this.repo.save(newSuspect)).thenReturn(savedSuspect);

		assertThat(this.service.createSuspect(newSuspect)).isEqualTo(savedSuspect);

		Mockito.verify(this.repo, Mockito.times(1)).save(newSuspect);
	}

	@Test
	void testGetAll() {
		List<Suspect> testSuspects = List.of(new Suspect("jordan","gun","bedroom","teacher",50));

		Mockito.when(this.repo.findAll()).thenReturn(testSuspects);

		assertThat(this.service.getAllSuspects()).isEqualTo(testSuspects);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testFindByID() {
		int id = 1;
		Suspect testSuspect = new Suspect("dan","rope","car","gamer",60);

		Mockito.when(repo.findById(id)).thenReturn(Optional.of(testSuspect));

		Suspect actual = this.service.getSuspect(id);
		assertThat(actual).isEqualTo(testSuspect);

		Mockito.verify(repo, Mockito.times(1)).findById(id);
	}

	@Test
	void testGetByName() {

		List<Suspect> testSuspects = List.of(new Suspect("jordan","gun","bedroom","teacher",50));

		String search = "jordan";
		Mockito.when(this.repo.findByNameIgnoreCase(search)).thenReturn(testSuspects);

		assertThat(this.service.getByName(search)).isEqualTo(testSuspects);

		Mockito.verify(this.repo, Mockito.times(1)).findByNameIgnoreCase(search);
	}

	@Test
	void testUpdate() {
		// GIVEN
		int id = 1;

		Suspect testSuspect= new Suspect(id,"jordan","gun","bedroom","teacher",50); // returned by FindById
		Suspect testNewSuspect = new Suspect(id,"daisy","rope","garden","shop keeper",90); // new cat data

		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testSuspect)); // dw about this for now tbh
		Mockito.when(this.repo.save(new Suspect(id,"daisy","rope","garden","shop keeper",90))).thenReturn(testNewSuspect);

		Suspect actual = this.service.replaceSuspect(id, testNewSuspect);
		// THEN
		assertThat(actual).isEqualTo(testNewSuspect);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(new Suspect(id,"daisy","rope","garden","shop keeper",90));
	}

	@Test
	void testDeleteSucceeds() {
		int id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.deleteSuspect(id)).isEqualTo("Deleted: " + id);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

	@Test
	void testDeleteFails() {
		int id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(true);

		assertThat(this.service.deleteSuspect(id)).isEqualTo("Not deleted: " + id);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

}

