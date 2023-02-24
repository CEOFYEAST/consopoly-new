import java.util.*;

class Main {
  public static void main(String[] args) {
    int[] positions = {0, 1, 2, 3, 4, 5, 6, 7};
    Util.printBoardTest(positions);
    
    /**
    long totalOfDiffs = 0; 
    long initTime = 0;
    for(int i = 0; i < 1000; i++){
      initTime = System.currentTimeMillis();
      Misc.printBoard();
      totalOfDiffs += System.currentTimeMillis() - initTime;
      Misc.clear();
    }
    System.out.println("Avg combined diff: " + (totalOfDiffs/1000));
    /*
    

    /**
    long totalOfDiffs = 0; 
    long initTime = 0;
    for(int i = 0; i < 1000; i++){
      initTime = System.currentTimeMillis();
      Misc.printOldBoard();
      totalOfDiffs += System.currentTimeMillis() - initTime;
      Misc.clear();
    }
    System.out.println("Avg seperate diff: " + (totalOfDiffs/1000));
    */
  }
}