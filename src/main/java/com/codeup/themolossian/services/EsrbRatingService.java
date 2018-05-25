package com.codeup.themolossian.services;

import com.codeup.themolossian.models.EsrbRating;
import com.codeup.themolossian.repositories.EsrbRatingRepository;

public class EsrbRatingService {
	private EsrbRatingRepository esrbRatingRepository;

    public EsrbRatingService(EsrbRatingRepository esrbRatingRepository) {
        this.esrbRatingRepository = esrbRatingRepository;
    }
    
    public Iterable<EsrbRating> findAll() {
    	return esrbRatingRepository.findAll();
    }
    
    public EsrbRating findOne(long id) {
        return esrbRatingRepository.findOne(id);
    }
}
