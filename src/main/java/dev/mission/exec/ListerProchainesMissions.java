package dev.mission.exec;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("next")
public class ListerProchainesMissions implements Runnable {

	private MissionRepository missionRepository;

	public ListerProchainesMissions(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {

		// Lister les prochaines missions
		List<Mission> prochainesMissions = missionRepository.findAll();
		
		for (Mission mission: prochainesMissions) {
			System.out.println(mission.getLibelle());
		}
		
	}

}
