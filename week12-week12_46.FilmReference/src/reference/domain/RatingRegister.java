/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if(!personalizedRating.containsKey(person)) {
            return Rating.NOT_WATCHED;
        }
        Map<Film, Rating> rating = personalizedRating.get(person);
        return (rating.containsKey(film)) ? rating.get(film) : Rating.NOT_WATCHED;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        return personalizedRating.get(person);
    }
    
    public List<Person> reviewers() {
        return new ArrayList<Person>(personalizedRating.keySet());
    }
}
