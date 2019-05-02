/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author alinaalam
 */
public class PreferenceComparator implements Comparator<Film>{
    
    private Map<Film, Rating> filmRatings;

    public PreferenceComparator(Map<Film, Rating> filmRatings) {
        this.filmRatings = filmRatings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        return filmRatings.get(o2).getValue() - filmRatings.get(o1).getValue();
    }
}
