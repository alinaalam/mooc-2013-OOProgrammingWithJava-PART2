/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Collections;
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
        return (int) (getAvgFilmRating(ratings.get(o2)) - getAvgFilmRating(ratings.get(o1)));
    }
    
    private double getAvgFilmRating(List<Rating> ratings) {
        if(ratings.isEmpty()) {
            return 0;
        }
        
        double sum = 0;
        
        for(Rating rating : ratings) {
            sum += rating.getValue();
        }
        
        return sum/ratings.size();
    }
}
