package eu.javaspecialists.courses.datastructures.ch2_lists;

/*
Template for measuring time:
long $TIME$ = System.nanoTime();
try {
    $SELECTION$
} finally {
    $TIME$ = System.nanoTime() - $TIME$;
    System.out.printf("$TIME$ = %dms%n", ($TIME$/1_000_000));
}
 */
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Arrays.asList()
 * Quick look at the List methods
 * Optional methods
 * asList() vs List.of()
 * RandomAccess
 */
public class _2_1_Lists {
  public static void main(String... args) {
    asListDemo();
    listOfDemo();

    for (int i = 0; i < 10; i++) {
      randomAccessDemo();
      System.out.println();
    }
  }

  private static void randomAccessDemo() {
    randomAccessTest(ArrayList::new); // O(1)
    randomAccessTest(Vector::new);// O(1)
    randomAccessTest(CopyOnWriteArrayList::new);// O(1)
    randomAccessTest(LinkedList::new);// O(n)
  }

  private static void randomAccessTest(Supplier<List<Integer>> listSupplier) {
    List<Integer> input = IntStream.range(0, 100_000)
        .boxed().toList();
    List<Integer> test = listSupplier.get();
    long addTime = System.nanoTime();
    try {
      test.addAll(input);
    } finally {
      addTime = System.nanoTime() - addTime;
      System.out.printf("addTime = %dms%n", (addTime / 1_000_000));
    }

    long time = System.nanoTime();
    try {
      long total = 0;
      for (int i = 0; i < 1000; i++) {
        total += test.get(test.size() / 2);
      }
    } finally {
      time = System.nanoTime() - time;
      System.out.printf("%s time = %dms%n", test.getClass().getSimpleName(),
          time / 1_000_000);
    }
  }

  private static void asListDemo() {
    System.out.println("_2_1_Lists.asListDemo");
    String[] input = {"TS", "RO", "RJ", "ES", "ED"};
    List<String> students = Arrays.asList(input);
    System.out.println(students.getClass().getName());
    System.out.println("students = " + students);
    input[0] = "VK";
    input[1] = "CJ";
    students.set(4, "PS");
    System.out.println("students = " + students);
  }
  private static void listOfDemo() {
    System.out.println("_2_1_Lists.listOfDemo");
    String[] input = {"TS", "RO", "RJ", "ES", "ED"};
    List<String> students = List.of(input);
    System.out.println(students.getClass().getName());
    System.out.println("students = " + students);
    input[0] = "VK";
    input[1] = "CJ";
//    students.set(4, "PS");
    System.out.println("students = " + students);
  }
}
