package dev.mission.repository;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import dev.mission.entite.Mission;

@DataJpaTest
class MissionRepositoryTests {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	MissionRepository missionRepository;

	@Test
	void findByDateDebutGreaterThanEqual() {
		
		// Insertion des données avec `entityManager`
		Mission mission = new Mission();
		mission.setLibelle("Mission");
		mission.setTauxJournalier(new BigDecimal("55.80"));
		mission.setDateDebut(LocalDate.of(2020, 6, 30));
		mission.setDateFin(LocalDate.of(2020, 8, 29));
		
		Mission mission2 = new Mission();
		mission2.setLibelle("Mission 2");
		mission2.setTauxJournalier(new BigDecimal("69"));
		mission2.setDateDebut(LocalDate.of(2020, 8, 4));
		mission2.setDateFin(LocalDate.of(2020, 8, 18));
		
		// Exécution de la requête
		entityManager.persist(mission);
		entityManager.persist(mission2);
		
		// Vérification du résultat
		// Récupération du libelle depuis la liste de mission 
		List<Mission> resultat = missionRepository.findByDateDebutGreater(LocalDate.of(2020, 8, 1));
		assertThat(resultat).extracting(Mission::getLibelle).contains("Mission 2");
		
	}

	@Test
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual() {
		
		// Insertion des données avec `entityManager``
		Mission mission3 = new Mission();
		mission3.setLibelle("Mission 3");
		mission3.setTauxJournalier(new BigDecimal("82.36"));
		mission3.setDateDebut(LocalDate.of(2020, 8, 14));
		mission3.setDateFin(LocalDate.of(2020, 9, 10));
		
		Mission mission4 = new Mission();
		mission4.setLibelle("Mission 4");
		mission4.setTauxJournalier(new BigDecimal("75"));
		mission4.setDateDebut(LocalDate.of(2020, 6, 2));
		mission4.setDateFin(LocalDate.of(2020, 7, 2));
		
		// Exécution de la requête
		entityManager.persist(mission3);
		entityManager.persist(mission4);
		
		List<Mission> resultat = missionRepository.findByDateDebutGreaterAndTauxJournalierGreater(
				LocalDate.of(2020, 8, 1), new BigDecimal("50"));
		
		// Vérification du résultat
		assertThat(resultat).extracting(Mission::getLibelle).contains("Mission 3");
	}
}