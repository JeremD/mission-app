package dev.mission.exec;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("nextTJM")
public class ListerProchainesMissionsParTJM implements Runnable {

	private MissionRepository missionRepository;

	public ListerProchainesMissionsParTJM(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {

		// Lister les prochaines missions filtrées par taux journalier
		List<Mission> missionsTJM = missionRepository.findByDateDebutWithTJM(new BigDecimal("500"));
		
		for (Mission mission: missionsTJM) {
			System.out.println(mission.getLibelle());
		}
		
	}
	
}
