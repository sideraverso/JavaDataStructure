package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Enumeration bugs
 * Fail fast collection
 * forEach()
 */
public class _2_3_Iteration {
  public static void main(String... args) {
    Collection<String> beachToys = new ConcurrentLinkedQueue<>(); // weakly-consistent
//    Collection<String> beachToys = new CopyOnWriteArrayList<>(); // snapshot
//    Collection<String> beachToys = new ArrayList<>(); // fail-fast
    Collections.addAll(beachToys, "floatie", "sunblock", "rage", "razor",
        "umbrella", "bucket", "raki");
    Iterator<String> it = beachToys.iterator();
    while(it.hasNext()) {
      String toy = it.next();
      if (toy.startsWith("ra")) beachToys.remove(toy);
    }
    System.out.println(beachToys);
  }
}
