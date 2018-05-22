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
			new Platform("3DO Interactive Multiplayer"),
			new Platform("Action Max"),
			new Platform("Adventure Vision"),
			new Platform("Amiga CD32"),
			new Platform("Amstrad GX4000"),
			new Platform("APF-MP1000"),
			new Platform("APF Imagination Machine"),
			new Platform("Apple Bandai Pippin"),
			new Platform("Arcadia 2001/Leisure Vision"),
			new Platform("Atari 2600"),
			new Platform("Atari 5200"),
			new Platform("Atari 7800"),
			new Platform("Atari Jaguar"),
			new Platform("Atari Jaguar CD"),
			new Platform("Atari PONG"),
			new Platform("Atari XEGS"),
			new Platform("Bally Astrocade"),
			new Platform("Bandai Super Vision 8000"),
			new Platform("Bridge Companion"),
			new Platform("CAANOO"),
			new Platform("Casio Loopy"),
			new Platform("CD-i"),
			new Platform("Champion 2711"),
			new Platform("Channel F II"),
			new Platform("Children's Discovery System"),
			new Platform("ColecoVision"),
			new Platform("Coleco Telstar"),
			new Platform("Color TV-Game"),
			new Platform("Colorvision"),
			new Platform("Commodore 64 Games System"),
			new Platform("Commodore CDTV"),
			new Platform("CPS Changer"),
			new Platform("Cybiko"),
			new Platform("Design Master Senshi"),
			new Platform("Didj"),
			new Platform("Digi Casse"),
			new Platform("digiBlast"),
			new Platform("Dingoo A320"),
			new Platform("Dreamcast"),
			new Platform("Entex Adventure Vision"),
			new Platform("Epoch Cassette Vision"),
			new Platform("Etch A Sketch Animator 2000"),
			new Platform("Fairchild Channel F"),
			new Platform("Family Computer Disk System"),
			new Platform("FM Towns Marty"),
			new Platform("Gamate"),
			new Platform("Gamate 3D"),
			new Platform("Game Boy"),
			new Platform("Game Boy Advance"),
			new Platform("Game Gear"),
			new Platform("Game Master"),
			new Platform("Game Pocket Computer"),
			new Platform("Game Wave"),
			new Platform("Game Wizard"),
			new Platform("GameCube"),
			new Platform("GameKing"),
			new Platform("Game.com"),
			new Platform("Gizmondo"),
			new Platform("GCW Zero"),
			new Platform("GP2X"),
			new Platform("GP2X Wiz"),
			new Platform("GP32"),
			new Platform("HyperScan"),
			new Platform("IM-26"),
			new Platform("Intellivision"),
			new Platform("iQue Player"),
			new Platform("iQuest"),
			new Platform("iXL"),
			new Platform("K-Magic"),
			new Platform("Kasey the Kinderbot"),
			new Platform("Kids Pad"),
			new Platform("Leapster"),
			new Platform("Leapster Explorer"),
			new Platform("Light Games"),
			new Platform("Lynx"),
			new Platform("Magnavox Odyssey"),
			new Platform("Magnavox Odyssey²"),
			new Platform("Mega Duck"),
			new Platform("Memorex VIS"),
			new Platform("Microvision"),
			new Platform("My Vision"),
			new Platform("N-Gage"),
			new Platform("NES/Family Computer (Famicom)"),
			new Platform("Neo-Geo"),
			new Platform("Neo-Geo CD"),
			new Platform("Neo-Geo Pocket"),
			new Platform("Neo-Geo X"),
			new Platform("Nintendo 64"),
			new Platform("Nintendo 64DD"),
			new Platform("Nintendo 3DS"),
			new Platform("Nintendo DS"),
			new Platform("Nintendo Switch"),
			new Platform("Nomad"),
			new Platform("Nuon"),
			new Platform("PasoGo"),
			new Platform("Pandora"),
			new Platform("PC-50X Family"),
			new Platform("PC-FX"),
			new Platform("PC Engine/TurboGrafx-16"),
			new Platform("PC Engine2/SuperGrafx"),
			new Platform("Ping-O-Tronic"),
			new Platform("Pioneer LaserActive"),
			new Platform("Pixter"),
			new Platform("PlayCable"),
			new Platform("Playdia"),
			new Platform("PlayStation"),
			new Platform("PlayStation 2"),
			new Platform("PlaySation 3"),
			new Platform("PlayStation 4"),
			new Platform("PlayStation Portable"),
			new Platform("PlayStation Vita"),
			new Platform("Pokémon Mini"),
			new Platform("PreComputer 1000"),
			new Platform("ProScreen"),
			new Platform("PV-1000"),
			new Platform("R-Zone"),
			new Platform("RCA Studio II"),
			new Platform("Satellaview"),
			new Platform("Sega 32X"),
			new Platform("Sega CD/Mega CD"),
			new Platform("Sega Genesis/Mega Drive"),
			new Platform("Sega Master System"),
			new Platform("Sega Pico"),
			new Platform("Sega Saturn"),
			new Platform("Sega SG-1000"),
			new Platform("Select-A-Game"),
			new Platform("Shield Portable"),
			new Platform("Super A'Can"),
			new Platform("Super Cassette Vision"),
			new Platform("Super Micro"),
			new Platform("Super NES/Super Famicom"),
			new Platform("Supervision"),
			new Platform("Tele-Spiel"),
			new Platform("Turbo Duo/PC Engine Duo"),
			new Platform("Turbo Twist"),
			new Platform("TurboExpress"),
			new Platform("Variety"),
			new Platform("VC 4000"),
			new Platform("Vectrex"),
			new Platform("Video 2000"),
			new Platform("VideoNow XP"),
			new Platform("Videopac G7400"),
			new Platform("Virtual Boy"),
			new Platform("VTech CreatiVision"),
			new Platform("V.Smile Pocket"),
			new Platform("Wii"),
			new Platform("Wii U"),
			new Platform("WonderSwan"),
			new Platform("Xbox"),
			new Platform("Xbox 360"),
			new Platform("Xbox One"),
			new Platform("Zemmix"),
			new Platform("Zodiac")
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
