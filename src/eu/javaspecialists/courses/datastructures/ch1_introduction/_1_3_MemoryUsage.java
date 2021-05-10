package eu.javaspecialists.courses.datastructures.ch1_introduction;

/**
 * Memory usage and layout
 */
public class _1_3_MemoryUsage {
  public static void main(String... args) {
    // Object: 12 bytes
    // pointer - 4 bytes
    // int, float - 4
    // long, double - 8
    // char, short - 2
    // byte - 1

    /*
    LinkedList
    # Running 64-bit HotSpot VM.
# Using compressed oop with 3-bit shift.
# Using compressed klass with 3-bit shift.
# WARNING | Compressed references base/shifts are guessed by the experiment!
# WARNING | Therefore, computed addresses are just guesses, and ARE NOT RELIABLE.
# WARNING | Make sure to attach Serviceability Agent to get the reliable addresses.
# Objects are 8 bytes aligned.
# Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
# Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]

Instantiated the sample instance via default constructor.

java.util.LinkedList object internals:
 OFFSET  SIZE  TYPE DESCRIPTION                    VALUE
      0     4       (object header)                05 00 00 00 (00000101 00000000 00000000 00000000) (5)
      4     4       (object header)                00 00 00 00 (00000000 00000000 00000000 00000000) (0)
      8     4       (object header)                70 d1 15 00 (01110000 11010001 00010101 00000000) (1429872)
     12     4   int AbstractList.modCount          0
     16     4   int LinkedList.size                0
     20     4  Node LinkedList.first               null
     24     4  Node LinkedList.last                null
     28     4       (loss due to the next object alignment)
Instance size: 32 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


java.util.LinkedList$Node object internals:
 OFFSET  SIZE   TYPE DESCRIPTION                    VALUE
      0     4        (object header)                05 00 00 00 (00000101 00000000 00000000 00000000) (5)
      4     4        (object header)                00 00 00 00 (00000000 00000000 00000000 00000000) (0)
      8     4        (object header)                c8 db 15 00 (11001000 11011011 00010101 00000000) (1432520)
     12     4 Object Node.item                      null
     16     4   Node Node.next                      null
     20     4   Node Node.prev                      null
Instance size: 24 bytes
Space losses: 0 bytes internal + 0 bytes external = 0 bytes total

     */
  }
}
