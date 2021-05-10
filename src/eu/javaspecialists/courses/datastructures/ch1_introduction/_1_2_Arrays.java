package eu.javaspecialists.courses.datastructures.ch1_introduction;

import java.util.LinkedList;

/**
 * Primitive vs object arrays
 * Multi-dimensional arrays
 */
public class _1_2_Arrays {
  public static void main(String... args) {
    int[] numbers = new int[1000]; // 4016
    Integer[] numbers2 = new Integer[1000]; // 4016 + 16000
    LinkedList<Integer> numbers3 = new LinkedList<>(); // 32 + 24000 + 16000
    for (int i = 0; i < 1000; i++) {
      numbers3.add(i + 1_000_000);
    }
  }
}
