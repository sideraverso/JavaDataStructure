package eu.javaspecialists.courses.datastructures.ch3_sorting;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Sorting performance ArrayList vs LinkedList
 * Parallel sorting of ArrayList
 * // -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -verbose:gc
 * -Xmx20g -Xms20g -XX:+AlwaysPreTouch
 */
public class _3_4_ParallelSorting {
  public static void main(String... args) {
    Integer[] numbers = ThreadLocalRandom.current().ints(10_000_000).
        boxed().toArray(Integer[]::new);
    Arrays.parallelSort(numbers);
    for (int i = 0; i < 3; i++) {
      parallelSort(numbers);
      listSort(numbers);
      listParallelSort(numbers);
      sequentialSort(numbers);
    }
  }

  private static void parallelSort(Integer[] numbers) {
    Integer[] clone = numbers.clone();
    long time = System.nanoTime();
    try {
      Arrays.parallelSort(clone);
    } finally {
      time = System.nanoTime() - time;
      System.out.printf("parallel sort time = %dms%n", (time / 1_000_000));
    }
  }
  private static void listSort(Integer[] numbers) {
    List<Integer> list = new ArrayList<>();
    Collections.addAll(list, numbers);
    long time = System.nanoTime();
    try {
      list.sort(null);
    } finally {
      time = System.nanoTime() - time;
      System.out.printf("list sort time = %dms%n", (time / 1_000_000));
    }
  }
  private static void listParallelSort(Integer[] numbers) {
    List<Integer> list = new ArrayList<>();
    Collections.addAll(list, numbers);
    long time = System.nanoTime();
    try {
      parallelSort(list, null);
    } finally {
      time = System.nanoTime() - time;
      System.out.printf("list parallel sort time = %dms%n", (time / 1_000_000));
    }
  }

  public static <E> void parallelSort(List<E> list, Comparator<? super E> c) {
    Object[] a = list.toArray();
    Arrays.parallelSort(a, (Comparator) c);
    ListIterator<E> i = list.listIterator();
    for (Object e : a) {
      i.next();
      i.set((E) e);
    }
  }

  private static void sequentialSort(Integer[] numbers) {
    Integer[] clone = numbers.clone();
    long time = System.nanoTime();
    try {
      Arrays.sort(clone);
    } finally {
      time = System.nanoTime() - time;
      System.out.printf("sequential sort time = %dms%n", (time / 1_000_000));
    }
  }
}
