package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Adding four seasons
 * indexOf() and contains()
 * size() vs elementData.length in debugger
 * removeIf()
 */
public class _2_2_ArrayList {
  public static void main(String... args) {
    for (int i = 0; i < 10; i++) {
      test();
    }
  }

  private static void test() {
    List<Integer> numbers;
    long timeCreate = System.nanoTime();
    try {
      numbers = IntStream.range(0, 400_000)
          .boxed().collect(Collectors.toCollection(ArrayList::new));
    } finally {
      timeCreate = System.nanoTime() - timeCreate;
      System.out.printf("timeCreate = %dms%n", (timeCreate / 1_000_000));
    }
    long time = System.nanoTime();
    try {
//      for (Iterator<Integer> it = numbers.iterator(); it.hasNext(); ) {
//        Integer next = it.next();
//        if (next % 2 == 1) it.remove();
//      }
      numbers.removeIf(next -> next % 2 == 1);
    } finally {
      time = System.nanoTime() - time;
      System.out.printf("time = %dms%n", (time / 1_000_000));
    }
    System.out.println(numbers.size());
  }
}
