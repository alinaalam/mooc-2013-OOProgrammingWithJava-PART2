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

    // if the person hasn't watched any movie, we can recommend him anything
    public Film recommendFilm(Person person) {
        if (ratingRegister.getPersonalRatings(person).isEmpty()) {
            return getTopRatedFilm();
        }
        return getPersonalizedRatedFilm(person);
    }

    private Film getTopRatedFilm() {
        FilmComparator filmComparator = new FilmComparator(ratingRegister.filmRatings());
        List<Film> films = new ArrayList(ratingRegister.filmRatings().keySet());
        Collections.sort(films, filmComparator);
        return films.get(0);
    }

    private Film getPersonalizedRatedFilm(Person person) {

        Map<Person, Integer> similarityMap = getSimilarityMap(person);
        Person recommendedPerson = getMostSimilarPerson(similarityMap);

        return (recommendedPerson != null) ? getRecommendedFilm(person, recommendedPerson) : null;
    }

    private Person getMostSimilarPerson(Map<Person, Integer> similarityMap) {

        PersonComparator personComparator = new PersonComparator(similarityMap);
        List<Person> mostSimilarPeople = new ArrayList<Person>(similarityMap.keySet());
        Collections.sort(mostSimilarPeople, personComparator);

        return (mostSimilarPeople.isEmpty()) ? null : mostSimilarPeople.get(0);
    }

    private Map<Film, Rating> filterFilms(Person person, Person recommendedPerson) {
        Map<Film, Rating> possibleFilmsToWatch = new HashMap<Film, Rating>();

        Map<Film, Rating> filmsWatchedByRecommendedPerson = ratingRegister.getPersonalRatings(recommendedPerson);

        for (Map.Entry<Film, Rating> entry : filmsWatchedByRecommendedPerson.entrySet()) {
            if (ratingRegister.getRating(person, entry.getKey()) == Rating.NOT_WATCHED) {
                possibleFilmsToWatch.put(entry.getKey(), entry.getValue());
            }
        }

        return possibleFilmsToWatch;
    }

    private List<Film> sortedListOfPossibleRecommendations(Map<Film, Rating> possibleRecommendations) {
        List<Film> sortedPossibleRecommendations = new ArrayList<Film>(possibleRecommendations.keySet());
        PreferenceComparator preferenceComparator = new PreferenceComparator(possibleRecommendations);

        Collections.sort(sortedPossibleRecommendations, preferenceComparator);
        return sortedPossibleRecommendations;
    }

    private Film getRecommendedFilm(Person person, Person recommendedPerson) {
        Map<Film, Rating> possibleRecommendations = filterFilms(person, recommendedPerson);
        List<Film> sortedPossibleRecommendations = sortedListOfPossibleRecommendations(possibleRecommendations);

        for (Film film : sortedPossibleRecommendations) {
            Rating rating = possibleRecommendations.get(film);
            if (rating == Rating.GOOD || rating == Rating.FINE) {
                return film;
            }
        }
        return null;
    }

    /**
     * need to calculate how similar this person is to other viewers
     *
     * @param person
     * @return similarityMap map
     */
    private Map<Person, Integer> getSimilarityMap(Person person) {

        Map<Person, Integer> similarityMap = new HashMap<Person, Integer>();

        for (Person reviewer : ratingRegister.reviewers()) {
            if (reviewer != person) {
                int similarity = calculateSimilarity(person, reviewer);
                if (similarity > 0) {
                    similarityMap.put(reviewer, similarity);
                }
            }
        }

        return similarityMap;
    }

    private int calculateSimilarity(Person person, Person reviewer) {
        Map<Film, Rating> filmsRatedByThisPerson = ratingRegister.getPersonalRatings(person);

        int similarity = 0;

        for (Map.Entry<Film, Rating> entry : filmsRatedByThisPerson.entrySet()) {
            Rating reviewerRating = ratingRegister.getRating(reviewer, entry.getKey());
            if (reviewerRating != Rating.NOT_WATCHED) {
                similarity += entry.getValue().getValue() * reviewerRating.getValue();
            }
        }

        return similarity;
    }
}
