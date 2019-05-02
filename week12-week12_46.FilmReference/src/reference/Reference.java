/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.comparator.PreferenceComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author alinaalam
 */
public class Reference {
    
    private final RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }
    
    public Film recommendFilm(Person person) {
        // if the person hasn't watched any movie, we can recommend him anything
        if(ratingRegister.getPersonalRatings(person).size() > 0) {
            return getPersonalizedRatedFilm(person);
        }
        return getTopRatedFilm();
    }
    
    private Film getTopRatedFilm() {
        FilmComparator filmComparator = new FilmComparator(ratingRegister.filmRatings());
        List<Film> films = new ArrayList(ratingRegister.filmRatings().keySet());
        for(Film film : films) {
            System.out.println(film);
        }
        Collections.sort(films, filmComparator);
        for(Film film : films) {
            System.out.println(film);
        }
        return films.get(0);
    }
    
    private Film getPersonalizedRatedFilm(Person person) {
        Map<Person, Integer> similarityMap = getSimilarityMap(person);
        // need to sort this map 
        PersonComparator personComparator = new PersonComparator(similarityMap);
        List<Person> mostSimilarPeople = new ArrayList<Person>(similarityMap.keySet()); 
        Collections.sort(mostSimilarPeople, personComparator);
        
        Person recommendedPerson = mostSimilarPeople.get(0);
        // need to sort this person's film list
        Map<Film, Rating> possibleRecommendations = filterFilms(person, recommendedPerson);
        
        List<Film> recommendedFilms = new ArrayList<Film>(possibleRecommendations.keySet());
        PreferenceComparator preferenceComparator = new PreferenceComparator(possibleRecommendations);
        
        Collections.sort(recommendedFilms, preferenceComparator);
        
        if(recommendedFilms.isEmpty()) {
            return null;
        }
        
        for(Film film : recommendedFilms) {
            Rating rating = possibleRecommendations.get(film);
            if(rating == Rating.GOOD || rating == Rating.FINE) {
                return film;
            }
        }
        
        return null;
    }
    
    private Map<Film, Rating> filterFilms(Person person, Person recommendedPerson) {
        Map<Film, Rating> possibleFilmsToWatch = new HashMap<Film, Rating>();
        
        Map<Film, Rating> p1Films = ratingRegister.getPersonalRatings(person);
        Map<Film, Rating> rFilms = ratingRegister.getPersonalRatings(recommendedPerson);
        
        for(Film film : rFilms.keySet()) {
            if(!p1Films.containsKey(film)) {
                possibleFilmsToWatch.put(film, rFilms.get(film));
            }
        }
        
        return possibleFilmsToWatch;
    }
    
    private int calculateSimilarity(Map<Film, Rating> person1, Map<Film, Rating> person2) {
        int preference = 0;
        
        for(Film film : person1.keySet()) {
            if(person2.containsKey(film)) {
                preference += person1.get(film).getValue() * person2.get(film).getValue();
            }
        }
        
        return preference;
    }
    
    private Map<Person, Integer> getSimilarityMap(Person person) {
        List<Person> reviewers = ratingRegister.reviewers();
        Map<Film, Rating> ratingsForThisPerson = ratingRegister.getPersonalRatings(person);
        // need to get preferences for each person
        Map<Person, Integer> similarity = new HashMap<Person, Integer>();
        
        for(Person reviewer : reviewers) {
            if(reviewer != person) {
                similarity.put(reviewer, calculateSimilarity(ratingsForThisPerson, 
                        ratingRegister.getPersonalRatings(reviewer)));
            }
        }
        
        return similarity;
    }
}
