
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alinaalam
 */
public class RingingCentre {

    private Map<Bird, List<String>> observations;

    public RingingCentre() {
        observations = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
//        List<String> places = observations.getOrDefault(bird, new ArrayList<String>());
//        places.add(place);
//        observations.put(bird, places);
        observations.putIfAbsent(bird, new ArrayList<String>());
        List<String> places = observations.get(bird);
        places.add(place);
    }

    public void observations(Bird bird) {
        List<String> places = observations.getOrDefault(bird, new ArrayList());
        System.out.println(bird + " observations: " + places.size());
        for (String place : places) {
            System.out.println(place);
        }
    }
}
