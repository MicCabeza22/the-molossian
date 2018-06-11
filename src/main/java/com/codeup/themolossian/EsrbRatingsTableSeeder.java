package com.codeup.themolossian;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.codeup.themolossian.models.EsrbRating;
import com.codeup.themolossian.repositories.EsrbRatingRepository;

@Component
public class EsrbRatingsTableSeeder implements CommandLineRunner {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final EsrbRatingRepository esrbRatingRepository;
	
	@Value("${app.env}")
	private String environment;
	
	public EsrbRatingsTableSeeder(EsrbRatingRepository esrbRatingRepository) {
		this.esrbRatingRepository = esrbRatingRepository;
	}
	
	private void seedEsrbRatings() {
		List<EsrbRating> esrbRatings = Arrays.asList(
			new EsrbRating("EC (Early Childhood)"),
			new EsrbRating("E (Everyone)"),
			new EsrbRating("E10+ (Everyone 10+)"),
			new EsrbRating("T (Teen)"),
			new EsrbRating("M (Mature)"),
			new EsrbRating("AO (Adults Only)")
		);
		
		esrbRatingRepository.save(esrbRatings);
	}

	@Override
	public void run(String... strings) throws Exception {
		if (! environment.equals("development")) {
			log.info("app.env is not development, doing nothing.");
			return;
		}
		
		log.info("Deleting ESRB ratings...");
		esrbRatingRepository.deleteAll();
		log.info("Seeding ESRB ratings...");
		seedEsrbRatings();
	}
}
