package com.codeup.themolossian;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.codeup.themolossian.models.Platform;
import com.codeup.themolossian.repositories.PlatformRepository;

@Component
public class PlatformsTableSeeder implements CommandLineRunner {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final PlatformRepository platformRepository;
	
	@Value("${app.env}")
	private String environment;
	
	public PlatformsTableSeeder(PlatformRepository platformRepository) {
		this.platformRepository = platformRepository;
	}
	
	private void seedPlatforms() {
		List<Platform> platforms = Arrays.asList(
			new Platform("Magnavox Odyssey"),
			new Platform("Ping-O-Tronic"),
			new Platform("Atari PONG"),
			new Platform("PC-50X Family"),
			new Platform("Tele-Spiel"),
			new Platform("Video 2000"),
			new Platform("Coleco Telstar"),
			new Platform("Color TV-Game"),
			new Platform("Champion 2711"),
			new Platform("Fairchild Channel F"),
			new Platform("RCA Studio II"),
			new Platform("Atari 2600"),
			new Platform("Bally Astrocade"),
			new Platform("APF-MP1000"),
			new Platform("VC 4000"),
			new Platform("Magnavox Odyssey²"),
			new Platform("Channel F II"),
			new Platform("APF Imagination Machine"),
			new Platform("Bandai Super Vision 8000"),
			new Platform("Intellivision"),
			new Platform("PlayCable"),
			new Platform("VTech CreatiVision"),
			new Platform("Epoch Cassette Vision"),
			new Platform("Arcadia 2001/Leisure Vision"),
			new Platform("Atari 5200"),
			new Platform("ColecoVision"),
			new Platform("Entex Adventure Vision"),
			new Platform("Vectrex"),
			new Platform("PV-1000"),
			new Platform("Videopac G7400"),
			new Platform("Sega SG-1000"),
			new Platform("NES/Family Computer (Famicom)"),
			new Platform("My Vision"),
			new Platform("Super Cassette Vision"),
			new Platform("Sega Master System"),
			new Platform("Zemmix"),
			new Platform("Bridge Companion"),
			new Platform("Atari 7800"),
			new Platform("Family Computer Disk System"),
			new Platform("Atari XEGS"),
			new Platform("Action Max"),
			new Platform("Commodore 64 Games System"),
			new Platform("Amstrad GX4000"),
			new Platform("PC Engine/TurboGrafx-16"),
			new Platform("Sega Genesis/Mega Drive"),
			new Platform("PC Engine2/SuperGrafx"),
			new Platform("Neo-Geo"),
			new Platform("Super NES/Super Famicom"),
			new Platform("Commodore CDTV"),
			new Platform("Turbo Duo/Pc Engine Duo"),
			new Platform("CD-i"),
			new Platform("Sega CD/Mega CD"),
			new Platform("Memorex VIS"),
			new Platform("Sega Pico"),
			new Platform("Sega 32X"),
			new Platform("Satellaview"),
			new Platform("Super A'Can"),
			new Platform("FM Towns Marty"),
			new Platform("Pioneer LaserActive"),
			new Platform("Amiga CD32"),
			new Platform("3DO Interactive Multiplayer"),
			new Platform("Atari Jaguar"),
			new Platform("CPS Changer"),
			new Platform("Neo-Geo CD"),
			new Platform("Playdia"),
			new Platform("Sega Saturn"),
			new Platform("PlayStation"),
			new Platform("PC-FX"),
			new Platform("Apple Bandai Pippin"),
			new Platform("Atari Jaguar CD"),
			new Platform("Casio Loopy"),
			new Platform("Nintendo 64"),
			new Platform("Nintendo 64DD"),
			new Platform("Dreamcast"),
			new Platform("Nuon"),
			new Platform("PlayStation 2"),
			new Platform("GameCube"),
			new Platform("Xbox"),
			new Platform("iQue Player"),
			new Platform("Game Wave"),
			new Platform("Xbox 360"),
			new Platform("HyperScan"),
			new Platform("Wii"),
			new Platform("PlaySation 3"),
			new Platform("Wii U"),
			new Platform("PlayStation 4"),
			new Platform("Xbox One")
		);
		
		platformRepository.save(platforms);
	}

	@Override
	public void run(String... strings) throws Exception {
		if (! environment.equals("development")) {
			log.info("app.env is not development, doing nothing.");
			return;
		}
		
		log.info("Deleting platforms...");
		platformRepository.deleteAll();
		log.info("Seeding platforms...");
		seedPlatforms();
		log.info("Finished running seeders!");
	}
}
