package eu.javaspecialists.courses.datastructures.ch2_lists;

import eu.javaspecialists.courses.datastructures.util.Benchmark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

/**
 * Safe iteration
 */
public class _2_4_CopyOnWriteArrayList {
  private static final Benchmark bm = new Benchmark();
  public static void main(String... args) {
    for (int i = 0; i < 10; i++) {
      test();
    }
  }

  private static void test() {
    experiment(LinkedList::new);
    experiment(ArrayList::new);
    experiment(ConcurrentLinkedQueue::new);
    experiment(CopyOnWriteArrayList::new);
  }

  private static void experiment(Supplier<Collection<Integer>> supplier) {
    bm.start();
    Collection<Integer> temp = new ArrayList<>();
    for (int i = 0; i < 100_000; i++) {
      temp.add(i);
    }
    Collection<Integer> list = supplier.get();
    list.addAll(temp);
    bm.stop();
    System.out.println(list.getClass().getSimpleName() + " " + bm);
  }
}
