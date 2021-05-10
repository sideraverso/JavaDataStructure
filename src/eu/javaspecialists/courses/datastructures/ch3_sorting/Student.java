package eu.javaspecialists.courses.datastructures.ch3_sorting;

import java.util.Comparator;

public class Student implements Comparable<Student>{
  private final String name;
  private final int iq;

  public Student(String name, int iq) {
    this.name = name;
    this.iq = iq;
  }

  public static final Comparator<Student> NATURAL_COMPARATOR =
      Comparator.comparing(Student::name);

  @Override
  public int compareTo(Student that) {
    return NATURAL_COMPARATOR.compare(this, that);
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", iq=" + iq +
        '}';
  }

  public int iq() {
    return iq;
  }

  public String name() {
    return name;
  }
}
