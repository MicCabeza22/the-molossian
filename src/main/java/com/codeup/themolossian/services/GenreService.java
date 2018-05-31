package com.codeup.themolossian.services;

import com.codeup.themolossian.models.Genre;
import com.codeup.themolossian.repositories.GenreRepository;

public class GenreService {
	private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    
    public Iterable<Genre> findAll() {
    	return genreRepository.findAll();
    }
    
    public Genre findOne(long id) {
        return genreRepository.findOne(id);
    }
}
