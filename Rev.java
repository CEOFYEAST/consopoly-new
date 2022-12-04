/**
static class designed to boost the efficiency of the game display by combining all strings into one before printing. This significantly reduces the number of print statements in the program, and as a result reduces the amount of overhead code being run 
*/
public class Rev{
  //member variables 
    //index of toPrint for addToPrint to add to 
  private static int toPrintIndex = 0;
    //array of strings representing every line of the console 
  private static String[] toPrint = new String[]
  {
    "", "", "", "", "", "", "", "", "", "",
    "", "", "", "", "", "", "", "", "", "",
    "", "", "", "", "", "", "", "", "", "",
    "", "", "", "", "", "", "", "", "", "",
    "", "", "", "", "", "", "", ""
  };
    //array of Strings representing empty toPrint, used for quick emptying of toPrint
  private static String[] toPrintEmpty = new String[]
  {
    "", "", "", "", "", "", "", "", "", "",
    "", "", "", "", "", "", "", "", "", "",
    "", "", "", "", "", "", "", "", "", "",
    "", "", "", "", "", "", "", "", "", "",
    "", "", "", "", "", "", "", ""
  };


  /**
  method designed to add strings to toPrint, making sure to take care of newLine strings
  */
  public static void addToPrint(String toAdd, boolean isNewLine){
    if(isNewLine){
      toAdd += "\n";
      toPrint[toPrintIndex] += toAdd;
      toPrintIndex++;
    } else {
      toPrint[toPrintIndex] += toAdd;
    }
  }
  
  /**
  method designed to print toPrint 
   - condenses all strings in toPrint into one string to reduce overhead associated with printing
   - clears the console before printing and toPrint after printing
   - resets toPrintIndex
  */
  public static void print(){
    String toPrintString = "";
    for(int i = 0; i < toPrintIndex; i++){
      toPrintString += toPrint[i];
    }
    System.out.print(toPrintString);
    toPrintIndex = 0;
    toPrint = toPrintEmpty.clone();
  }
}