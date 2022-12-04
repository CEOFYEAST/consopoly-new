import java.util.*;

class Main {
  public static void main(String[] args) {
    long initTime = System.currentTimeMillis();
    Misc.printBoard();
    System.out.println("Diff: " + (System.currentTimeMillis() - initTime));
  }
}