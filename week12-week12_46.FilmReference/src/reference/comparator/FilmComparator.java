/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author alinaalam
 */
public class FilmComparator implements Comparator<Film>{
    
    private final Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        int avgRatingO1 = (int) getAvgFilmRating(ratings.get(o1));
        int avgRatingO2 = (int) getAvgFilmRating(ratings.get(o2));
        
        return avgRatingO2 - avgRatingO1;
    }
    
    private double getAvgFilmRating(List<Rating> ratings) {
        double sum = 0.0;
        
        for(Rating rating : ratings) {
            sum += rating.getValue();
        }
        
        return (ratings.size() > 0) ? sum/ratings.size() : 0.0;
    }
}
