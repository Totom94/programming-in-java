package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;
import agh.ii.prinjava.proj2.utils.Utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayWithMoviesImplementation implements PlayWithMovies {
    // Load the list of movies from a CSV file into an unmodifiable list
    private static final List<Movie> movies = ImdbTop250.movies().orElseThrow();

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     * @param director the name of the director to filter movies by
     * @return a set of movie titles
     */
     static Set<String> ex01(String director) {
        // Stream<Movie> is a sequence of elements supporting sequential and parallel aggregate operations
        // flatMap is used to convert each Movie to a Stream<Movie>, one for each director, for further processing
        // filter is used to select only the movies with the given director
        // map is used to transform the stream of Movie objects to a stream of their titles
        // collect is used to accumulate elements into a Set (A collection that contains no duplicate elements)
        return movies.stream()
                .flatMap(m -> Utils.oneToManyByDirector(m).stream())
                .filter(m -> m.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the movies (only titles) in which an actor played
     * @param actor the name of the actor to filter movies by
     * @return a set of movie titles
     */
    public static Set<String> ex02(String actor) {
        // Similar to ex01, but for actors instead of directors
        return movies.stream()
                .flatMap(m -> Utils.oneToManyByActor(m).stream())
                .filter(m -> m.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the number of movies per director (as a map)
     * @return a map where each key is a director's name and each value is the count of their movies
     */
    public static Map<String, Long> ex03() {
        // Collectors.groupingBy groups elements according to a classification function (here the director's name)
        // Collectors.counting provides a count of the number of occurrences of each director
        return movies.stream()
                .flatMap(m -> m.directors().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Returns the 10 directors with the most films on the list
     * @return a linked hash map of the top 10 directors mapped to their movie counts
     */
    public static Map<String, Long> ex04() {
        // The entries of the map are sorted by value (the counts of movies) in descending order
        // limit truncates the stream to contain no more than the given number of elements
        // The result is collected into a LinkedHashMap, which maintains the order of elements as they are inserted
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
     * @return a linked hash map where each key is a director's name from the top 10 list,
     *         and the value is a set of titles of their movies
     */
    public static Map<String, Set<String>> ex05() {
        // The top 10 directors are used as keys for a new map
        // The values are sets of movie titles, which are obtained by calling ex01 for each director
        return ex04().keySet().stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        PlayWithMoviesImplementation::ex01,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
    // ex06, ex07, ex08 are similar to ex03, ex04, ex05 but for actors instead of directors
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
     * @return a linked hash map of the top 5 actor duos mapped to the number of movies they appeared in together
     */
    public static Map<String, Long> ex09() {
        // Utils.orderedPairsFrom creates all possible unique pairs of actors
        // These pairs are then counted and the top 5 pairs are returned in a LinkedHashMap
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
     * @return a linked hash map where each key is a pair of actor names from the top 5 duos,
     *         and the value is a set of titles of movies in which they appeared together
     */
    public static Map<String, Set<String>> ex10() {
        // This map is built by filtering the original list of movies for each actor duo
        // and collecting the titles into a set
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