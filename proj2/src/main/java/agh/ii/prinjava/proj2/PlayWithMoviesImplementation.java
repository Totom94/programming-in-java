package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;
import agh.ii.prinjava.proj2.utils.Utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayWithMoviesImplementation implements PlayWithMovies {
    private static final List<Movie> movies = ImdbTop250.movies().orElseThrow();

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    public static Set<String> ex01(String director) {
        return movies.stream()
                .flatMap(m -> Utils.oneToManyByDirector(m).stream())
                .filter(m -> m.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    public static Set<String> ex02(String actor) {
        return movies.stream()
                .flatMap(m -> Utils.oneToManyByActor(m).stream())
                .filter(m -> m.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    public static Map<String, Long> ex03() {
        return movies.stream()
                .flatMap(m -> m.directors().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    public static Map<String, Long> ex04() {
        return ex03().entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in ex04
     */
    public static Map<String, Set<String>> ex05() {
        return ex04().keySet().stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        PlayWithMoviesImplementation::ex01,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    public static Map<String, Long> ex06() {
        return movies.stream()
                .flatMap(m -> m.actors().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    public static Map<String, Long> ex07() {
        return ex06().entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(9)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from ex07
     */
    public static Map<String, Set<String>> ex08() {
        return ex07().keySet().stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        PlayWithMoviesImplementation::ex02,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    public static Map<String, Long> ex09() {
        return movies.stream()
                .flatMap(m -> Utils.orderedPairsFrom(m.actors()).stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    public static Map<String, Set<String>> ex10() {
        Map<String, Long> topActorDuos = ex09();
        return topActorDuos.keySet().stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        duo -> movies.stream()
                                .filter(m -> Utils.orderedPairsFrom(m.actors()).contains(duo))
                                .map(Movie::title)
                                .collect(Collectors.toSet()),
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
