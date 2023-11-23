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


    // Stream<Movie> : Sequence of elements supporting sequential and parallel aggregate operations
    // FlatMap : Used to convert each Movie to a Stream<Movie>
    // Filter : Used to select only the movies with the given director (or other specification)
    // Map : Used to transform the stream of Movie objects to a stream of their titles (first ex)
    // Collect : Used to accumulate elements into a Set (A collection that contains no duplicate elements)


    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     * @param director the name of the director to filter movies by
     * @return a set of movie titles
     */
    static Set<String> ex01(String director) {
        return movies.stream()                                              // Start by creating a stream from the list of movies.
                .flatMap(m -> Utils.oneToManyByDirector(m).stream())        // Use flatMap to flatten movies into a single sequence of movies.
                .filter(m -> m.directors().contains(director))              // Filter movies where the director matches the specified director.
                .map(Movie::title)                                          // Use map to extract movie titles.
                .collect(Collectors.toSet());                               // Collect the titles into a set (to eliminate duplicates) and return the result.
    }

    /**
     * Returns the movies (only titles) in which an actor played
     * @param actor the name of the actor to filter movies by
     * @return a set of movie titles
     */
    public static Set<String> ex02(String actor) {
        // Similar to ex01, but for actors instead of directors
        return movies.stream()                                              // Start by creating a stream from the list of movies.
                .flatMap(m -> Utils.oneToManyByActor(m).stream())           // Use flatMap to flatten movies into a single sequence of movies.
                .filter(m -> m.actors().contains(actor))                    // Filter movies where the actor is in the list of actors.
                .map(Movie::title)                                          // Use map to extract movie titles.
                .collect(Collectors.toSet());                               // Collect the titles into a set (to eliminate duplicates) and return the result.
    }

    /**
     * Returns the number of movies per director (as a map)
     * @return a map where each key is a director's name and each value is the count of their movies
     */
    public static Map<String, Long> ex03() {
        // Collectors.groupingBy groups elements according to a classification function (here the director's name)
        // Collectors.counting provides a count of the number of occurrences of each director
        return movies.stream()                                                                      // Start by creating a stream from the list of movies.
                .flatMap(m -> m.directors().stream())                                               // Flatten the list of directors from each movie into a single stream of directors.
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));        // Collect and group directors by their identity (name) and count their occurrences.
    }

    /**
     * Returns the 10 directors with the most films on the list
     * @return a linked hash map of the top 10 directors mapped to their movie counts
     */
    public static Map<String, Long> ex04() {
        // The entries of the map are sorted by value (the counts of movies) in descending order
        // limit truncates the stream to contain no more than the given number of elements
        // The result is collected into a LinkedHashMap, which maintains the order of elements as they are inserted
        return ex03().entrySet().stream()                                                           // Start by creating a stream from the set of directors.
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())                       // Sort the directors by their counts in descending order.
                .limit(10)                                                                        // Limit the stream to the top 10 directors.
                .collect(Collectors.toMap(                                                          // Collect the results into a map.
                        Map.Entry::getKey,                                                          // The key is the director's name.
                        Map.Entry::getValue,                                                        // The value is the count of their movies.
                        (e1, e2) -> e1,                                                             // If the same key is encountered twice, keep the first value.
                        LinkedHashMap::new));                                                       // Use a LinkedHashMap to maintain the order of elements as they are inserted.
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in ex04
     * @return a linked hash map where each key is a director's name from the top 10 list,
     *         and the value is a set of titles of their movies
     */
    public static Map<String, Set<String>> ex05() {
        // The top 10 directors are used as keys for a new map
        // The values are sets of movie titles, which are obtained by calling ex01 for each director
        return ex04().keySet().stream()                                                             // Start by creating a stream from the set of directors.
                .collect(Collectors.toMap(                                                          // Collect the results into a map.
                        Function.identity(),                                                        // The key is the director's name.
                        PlayWithMoviesImplementation::ex01,                                         // The value is a set of movie titles obtained by calling ex01.
                        (e1, e2) -> e1,                                                             // If the same key is encountered twice, keep the first value.
                        LinkedHashMap::new));                                                       // Use a LinkedHashMap to maintain the order of elements as they are inserted.
    }
    // ex06, ex07, ex08 are similar to ex03, ex04, ex05 but for actors instead of directors
    /**
     * Returns the number of movies per actor (as a map)
     */
    public static Map<String, Long> ex06() {
        return movies.stream()                                                                      // Start by creating a stream from the list of movies.
                .flatMap(m -> m.actors().stream())                                                  // Flatten the list of actors from each movie into a single stream of actors.
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));        // Collect and group actors by their identity (name) and count their occurrences.
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    public static Map<String, Long> ex07() {
        return ex06().entrySet().stream()                                                           // Start by creating a stream from the set of actors.
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())                      // Sort the actors by their counts in descending order.
                .limit(9)                                                                         // Limit the stream to the top 9 actors.
                .collect(Collectors.toMap(                                                          // Collect the results into a map.
                        Map.Entry::getKey,                                                          // The key is the actor's name.
                        Map.Entry::getValue,                                                        // The value is the count of their movies.
                        (e1, e2) -> e1,                                                             // If the same key is encountered twice, keep the first value.
                        LinkedHashMap::new));                                                       // Use a LinkedHashMap to maintain the order of elements as they are inserted.
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from ex07
     */
    public static Map<String, Set<String>> ex08() {
        return ex07().keySet().stream()                                                        // Start by creating a stream from the set of actors.
                .collect(Collectors.toMap(                                                     // Collect the results into a map.
                        Function.identity(),                                                   // The key is the actor's name.
                        PlayWithMoviesImplementation::ex02,                                    // The value is a set of movie titles obtained by calling ex02.
                        (e1, e2) -> e1,                                                        // If the same key is encountered twice, keep the first value.
                        LinkedHashMap::new));                                                  // Use a LinkedHashMap to maintain the order of elements as they are inserted.
    }
    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     * @return a linked hash map of the top 5 actor duos mapped to the number of movies they appeared in together
     */
    public static Map<String, Long> ex09() {
        // Utils.orderedPairsFrom creates all possible unique pairs of actors
        // These pairs are then counted and the top 5 pairs are returned in a LinkedHashMap
        return movies.stream()                                                                              // Start by creating a stream from the list of movies.
                .flatMap(m -> Utils.orderedPairsFrom(m.actors()).stream())                                  // Flatten the list of actor pairs from each movie into a single stream of pairs.
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))                 // Collect and group actor pairs by their identity (name) and count their occurrences.
                .entrySet().stream()                                                                        // Start by creating a stream from the set of actor pairs.
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())                              // Sort the pairs by their counts in descending order.
                .limit(5)                                                                                 // Limit the stream to the top 5 pairs.
                .collect(Collectors.toMap(                                                                  // Collect the results into a map.
                        Map.Entry::getKey,                                                                  // The key is the actor duo.
                        Map.Entry::getValue,                                                                // The value is the count of movies they appeared in together.
                        (e1, e2) -> e1,                                                                     // If the same key is encountered twice, keep the first value.
                        LinkedHashMap::new));                                                               // Use a LinkedHashMap to maintain the order of elements as they are inserted.
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     * @return a linked hash map where each key is a pair of actor names from the top 5 duos,
     *         and the value is a set of titles of movies in which they appeared together
     */
    public static Map<String, Set<String>> ex10() {
        // This map is built by filtering the original list of movies for each actor duo
        // and collecting the titles into a set
        Map<String, Long> topActorDuos = ex09();                                                            // Start by getting the top 5 actor duos.
        return topActorDuos.keySet().stream()                                                               // Start by creating a stream from the set of top actor duos.
                .collect(Collectors.toMap(                                                                  // Collect the results into a map.
                        Function.identity(),                                                                // The key is the actor duo.
                        duo -> movies.stream()                                                              // Start by creating a stream from the list of movies.
                                .filter(m -> Utils.orderedPairsFrom(m.actors()).contains(duo))              // Filter movies where the duo is in the list of actor pairs.
                                .map(Movie::title)                                                          // Extract movie titles.
                                .collect(Collectors.toSet()),                                               // Collect titles into a set.
                        (e1, e2) -> e1,                                                                     // If the same key is encountered twice, keep the first value.
                        LinkedHashMap::new));                                                               // Use a LinkedHashMap to maintain the order of elements as they are inserted.
    }
}