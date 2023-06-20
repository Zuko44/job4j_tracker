package ru.job4j.hmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                result += subject.score();
                count++;
            }
        }
        return result / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> listOfPupils = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double result = 0;
            for (Subject subject : pupil.subjects()) {
                result += subject.score();
            }
            listOfPupils.add(new Label(pupil.name(), result / pupil.subjects().size()));
        }
        return listOfPupils;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> listOfSubjects = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                /**
                 * map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
                 */
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + subject.score());
            }
        }
        for (String key : map.keySet()) {
            listOfSubjects.add(new Label(key, map.get(key) / pupils.size()));
        }
        return listOfSubjects;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> listOfStudents = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(pupil.name(), map.getOrDefault(pupil.name(), 0) + subject.score());
            }
        }
        for (String key : map.keySet()) {
            listOfStudents.add(new Label(key, map.get(key)));
        }
        listOfStudents.sort(Comparator.naturalOrder());
        return listOfStudents.get(listOfStudents.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> listOfSubjects = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                /**map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
                 */
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + subject.score());
            }
        }
        for (String key : map.keySet()) {
            listOfSubjects.add(new Label(key, map.get(key)));
        }
        listOfSubjects.sort(Comparator.naturalOrder());
        return listOfSubjects.get(listOfSubjects.size() - 1);
    }
}
