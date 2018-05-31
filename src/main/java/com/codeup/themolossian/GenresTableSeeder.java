package com.codeup.themolossian;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.codeup.themolossian.models.Genre;
import com.codeup.themolossian.repositories.GenreRepository;

@Component
public class GenresTableSeeder implements CommandLineRunner {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final GenreRepository genreRepository;

	@Value("${app.env}")
	private String environment;
	
	public GenresTableSeeder(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}
	
	private void seedGenres() {
		List<Genre> genres = Arrays.asList(
			new Genre("Action"),
			new Genre("Action-adventure"),
			new Genre("Adventure"),
			new Genre("Role-playing"),
			new Genre("Simulation"),
			new Genre("Sports"),
			new Genre("Strategy")
		);
		
		genreRepository.save(genres);
	}
	
	@Override
	public void run(String...strings) throws Exception {
		if (! environment.equals("development")) {
			log.info("app.env is not development, doing nothing.");
			return;
		}
		
		log.info("Deleting genres...");
		genreRepository.deleteAll();
		log.info("Seeding genres...");
		seedGenres();
	}
}
