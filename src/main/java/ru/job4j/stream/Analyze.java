package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.summingDouble;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(t -> t.subjects()
                        .stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(t -> new Tuple(t.name(), t.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0D)
                ))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(t -> t.subjects()
                        .stream())
                .collect(Collectors
                        .groupingBy(Subject::name,
                                LinkedHashMap::new, averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(t -> new Tuple(t.name(), t.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .sum()
                ))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(t -> t.subjects()
                        .stream())
                .collect(Collectors
                        .groupingBy(Subject::name,
                                LinkedHashMap::new, summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }
}