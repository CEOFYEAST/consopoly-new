import java.util.*;

/**
class containing methods to aid in a utility capacity
*/
public class Util {
  /**
  pauses thread for specified time in milliseconds
  */
  public static void tryWait(int waitTime){
    try 
      {
          Thread.sleep(waitTime);
      } 
      catch(InterruptedException e)
      { 
        
      }
  }

  /**
  returns true if every value in given array is null
  */
  public static boolean allNull(Object[] toCheck){
    boolean allNull = true;
    for(Object i: toCheck){
      if(i != null){
        return false;
      } 
    }
    return true;
  }
}