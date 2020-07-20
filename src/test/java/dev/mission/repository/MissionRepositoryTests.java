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
		mission.setLibelle("Mission 2");
		mission.setTauxJournalier(new BigDecimal("55.80"));
		mission.setDateDebut(LocalDate.of(2020, 8, 4));
		mission.setDateFin(LocalDate.of(2020, 8, 29));
		
		Mission mission2 = new Mission();
		mission2.setLibelle("Mission 3");
		mission2.setTauxJournalier(new BigDecimal("69"));
		mission2.setDateDebut(LocalDate.of(2020, 8, 1));
		mission2.setDateFin(LocalDate.of(2020, 8, 18));
		
		// Exécution de la requête
		entityManager.persist(mission);
		entityManager.persist(mission2);
		
		// Vérification du résultat
		// Récupération du libelle depuis la liste de mission 
		List<Mission> resultat = missionRepository.findByDateDebutGreaterThanEqual(LocalDate.of(2020, 8, 3));
		assertThat(resultat).extracting(Mission::getLibelle).contains("Mission 2");
		
	}

	@Test
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual() {
		// TODO insérer des données avec `entityManager`
		// TODO exécuter la requête
		// TODO vérifier le résultat
	}
}