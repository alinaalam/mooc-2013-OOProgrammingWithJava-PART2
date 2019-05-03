/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author alinaalam
 */
public class RatingRegister {
    
    private final Map<Film, List<Rating>> ratingRegister;
    private final Map<Person, Map<Film, Rating>> personalizedRating;
    
    public RatingRegister() {
        ratingRegister = new HashMap<Film, List<Rating>>();
        personalizedRating = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        ratingRegister.putIfAbsent(film, new ArrayList<Rating>());
        List<Rating> ratings = ratingRegister.get(film);
        ratings.add(rating);
    }
    
    public List<Rating> getRatings(Film film) {
        return ratingRegister.getOrDefault(film, new ArrayList<Rating>());
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return ratingRegister;
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        personalizedRating.putIfAbsent(person, new HashMap<Film, Rating>());
        Map<Film, Rating> personalRatings = personalizedRating.get(person);
        if(!personalRatings.containsKey(film)) {
            personalRatings.put(film, rating);
            addRating(film, rating);
        }
    }
    public Rating getRating(Person person, Film film) {
        if(personalizedRating.containsKey(person)) {
            Map<Film, Rating> rating = personalizedRating.get(person);
            if(rating.containsKey(film)) {
                return rating.get(film);
            }
        }
        return Rating.NOT_WATCHED;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        return personalizedRating.getOrDefault(person, new HashMap<Film, Rating>());
    }
    
    public List<Person> reviewers() {
        return new ArrayList<Person>(personalizedRating.keySet());
    }
}
