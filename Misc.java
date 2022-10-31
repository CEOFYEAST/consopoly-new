/**
class designed to aid in the animation and sylization of the game
*/
public class Misc {
  //member variables
  public static final String RESET = "\033[0m";  
    //foreground colors
  public static final String BLACK = "\033[0;30m";   
  public static final String RED = "\033[31m";   
  public static final String GREEN = "\033[0;32m";   
  public static final String YELLOW = "\033[0;33m";  
  public static final String BLUE = "\033[0;34m";   
  public static final String PURPLE = "\033[0;35m";  
  public static final String CYAN = "\033[0;36m";   
  public static final String WHITE = "\033[0;37m";   
  public static final String LIGHT_PURPLE = "\033[38;2;200;0;200m";
  public static final String TEAL = "\033[38;2;0;225;221m";
  public static final String ORANGE = "\033[38;2;225;153;0m"; 
  public static final String GOLD = "\033[38;5;178m";
  public static final String LIGHT_GREEN = "\033[38;2;136;255;0m"; 
  public static final String LIGHT_BLUE = "\033[38;2;120;172;255m"; 
  public static final String DARK_BLUE = "\033[38;2;72;0;255m"; 
  public static final String ROSY_PINK = "\033[38;2;255;0;162m"; 
  public static final String BROWN = "\033[38;2;135;82;62m";
  public static final String FOREST_GREEN = "\033[38;2;62;135;81m";
  public static final String BANANA_YELLOW = "\033[38;2;240;238;113m"; 
  public static final String DARK_RED = "\033[38;2;145;40;16m";
  public static final String LIGHT_PINK = "\033[38;2;255;153;240m";
    //background colors
  public static final String BACKGROUND_BLACK = "\033[0;40m";   
  public static final String BACKGROUND_RED = "\033[41m";   
  public static final String BACKGROUND_GREEN = "\033[0;42m";   
  public static final String BACKGROUND_YELLOW = "\033[0;43m";  
  public static final String BACKGROUND_BLUE = "\033[0;44m";   
  public static final String BACKGROUND_PURPLE = "\033[0;45m";  
  public static final String BACKGROUND_CYAN = "\033[0;46m";   
  public static final String BACKGROUND_WHITE = "\033[0;47m";   
  public static final String BACKGROUND_LIGHT_PURPLE = "\033[48;2;200;0;200m";
  public static final String BACKGROUND_TEAL = "\033[48;2;0;225;221m";
  public static final String BACKGROUND_ORANGE = "\033[48;2;225;153;0m"; 
  public static final String BACKGROUND_GOLD = "\033[48;5;178m";
  public static final String BACKGROUND_GREY = "\033[48;5;238m";
  public static final String BACKGROUND_LIGHT_GREEN = "\033[48;2;136;255;0m"; 
  public static final String BACKGROUND_LIGHT_BLUE = "\033[48;2;120;172;255m"; 
  public static final String BACKGROUND_DARK_BLUE = "\033[48;2;72;0;255m"; 
  public static final String BACKGROUND_ROSY_PINK = "\033[48;2;255;0;162m"; 
  public static final String BACKGROUND_BROWN = "\033[48;2;135;82;62m";
  public static final String BACKGROUND_FOREST_GREEN = "\033[48;2;62;135;81m";
  public static final String BACKGROUND_BANANA_YELLOW = "\033[48;2;240;238;113m"; 
  public static final String BACKGROUND_DARK_RED = "\033[48;2;145;40;16m";
  public static final String BACKGROUND_LIGHT_PINK = "\033[48;2;255;153;240m";

  
  /**
  methods for removing ANSI characters from strings
  */
  public static int noANSILength(String str) {
    return str.replaceAll("(\\x9B|\\x1B\\[)[0-?]*[ -\\/]*[@-~]", "").length();
  }
  public static String noANSI(String str) {
    return str.replaceAll("(\\x9B|\\x1B\\[)[0-?]*[ -\\/]*[@-~]", "");
  }

  /**
  clears the console 
  */
  public static void clear(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
  purely aesthetic method for printing a simplified version of the game board
  */
  public static void printBoard(){
    String boardArr[] = new String[]
    {
      " _________________________",
      "│|" + RED + "<>" + RESET + "|" + BROWN + "-" + RESET + "|" + LIGHT_BLUE + "|" + RESET + "|" + BROWN + "-" + RESET + "|" + BANANA_YELLOW + "*" + RESET + "|" + WHITE + "|" + RESET + "|" + LIGHT_BLUE + "-" + RESET + "|" + ROSY_PINK + "|" + RESET + "|" + LIGHT_BLUE + "-" + RESET + "|" + LIGHT_BLUE + "-" + RESET + "|" + ORANGE + "<>" + RESET + "|│",
      
      "│|" + PURPLE + "-" + RESET + "|                   |" + LIGHT_PURPLE + "-" + RESET + "|│",
      
      "│|" + BANANA_YELLOW + "|" + RESET + "|                   |"+ BANANA_YELLOW + "|" + RESET + "|│",
      
      "│|" + PURPLE + "-" + RESET + "|                   |" + LIGHT_PURPLE + "-" + RESET + "|│",
      
      "│|" + ORANGE + "|" + RESET + "|                   |" + LIGHT_PURPLE + "-" + RESET + "|│",
      
      "│|" + BLACK + "|" + RESET + "|                   |" + BLACK + "|" + RESET + "|│",
      
      "│|" + FOREST_GREEN + "-" + RESET + "|                   |" + ORANGE + "-" + RESET + "|│",
      
      "│|" + LIGHT_BLUE + "|" + RESET + "|                   |" + LIGHT_BLUE + "|" + RESET + "|│",
      
      "│|" + FOREST_GREEN + "-" + RESET + "|                   |" + ORANGE + "-" + RESET + "|│",

      "│|" + FOREST_GREEN + "-" + RESET + "|                   |" + ORANGE + "-" + RESET + "|│",
      
      "│|" + DARK_BLUE + "<>" + RESET + "|" + BANANA_YELLOW + "-" + RESET + "|" + ORANGE + "*" + RESET + "|" + BANANA_YELLOW + "-" + RESET + "|" + BANANA_YELLOW + "-" + RESET + "|" + BLACK + "|" + RESET + "|" + RED + "-" + RESET + "|" + RED + "-" + RESET + "|" + LIGHT_BLUE + "|" + RESET + "|" + RED + "-" + RESET + "|" + DARK_RED + "<>" + RESET + "|│",
      " ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾"
    };

    for(String s: boardArr){
      System.out.println(s);
      Util.tryWait(150);
    }

    clear();

    for(int i = 0; i < boardArr.length; i++){
      if(i == 6){
        System.out.println("│|" + FOREST_GREEN + "-" + RESET + "|     CONSOPOLY     |" + ORANGE + "-" + RESET + "|│");
        continue;
      } 
      System.out.println(boardArr[i]);
    }
  }
}