package dev.mission.exec;

import java.math.BigDecimal;

import java.time.LocalDate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("insert")
public class InsererMission implements Runnable {

	private MissionRepository missionRepository;

	public InsererMission(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {

		// Insertion de mission
		Mission mission = new Mission();
		mission.setLibelle("Mission 1");
		mission.setTauxJournalier(new BigDecimal("100.90"));
		mission.setDateDebut(LocalDate.of(2019, 1, 1));
		mission.setDateFin(LocalDate.of(2019, 3, 4));
		this.missionRepository.save(mission);

		Mission missionImpossible = new Mission();
		missionImpossible.setLibelle("Mission Impossible");
		missionImpossible.setTauxJournalier(new BigDecimal("500"));
		missionImpossible.setDateDebut(LocalDate.of(2020, 6, 1));
		missionImpossible.setDateFin(LocalDate.of(2020, 9, 1));
		this.missionRepository.save(missionImpossible);

	}
}