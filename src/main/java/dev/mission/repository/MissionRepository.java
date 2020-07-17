package dev.mission.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.mission.entite.Mission;


public interface MissionRepository extends JpaRepository<Mission, Integer> {
	
	// Lister les prochaines missions filtrées par taux journalier
	@Query("select m from Mission m where m.dateDebut >= CURDATE() and m.tauxJournalier >= ?1")
	List<Mission> findByDateDebutWithTJM(BigDecimal jtm);
	
}