package eu.javaspecialists.courses.datastructures.ch3_sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Sorting list of Strings
 * Sorting custom classes like Student
 * Comparing ints and longs
 */
public class _3_1_SortingLists {
  public static void main(String... args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student("John", 165));
    students.add(new Student("Heinz", 135));
    students.add(new Student("Anton", 135));
    students.add(new Student("Dirk", 135));
    students.add(new Student("Bennie", 135));
    students.add(new Student("Sarah", 135));
    System.out.println("students = " + students);

    Comparator<Student> iqNameComparator =
        Comparator.comparingInt(Student::iq).reversed()
            .thenComparing(Student::name);
    students.sort(iqNameComparator);
    System.out.println(students);
  }
}
