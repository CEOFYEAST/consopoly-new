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
}