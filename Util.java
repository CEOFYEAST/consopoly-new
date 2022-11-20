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

  /**
  forces user to continue inputting until they input one, used for user engagement/interactivity 
  */
  public static void interact(String text){
    Scanner s = new Scanner(System.in);
    
    System.out.println("Press 1 to " + text);
    int enter = 0;
    while(enter != 1){
      enter = s.nextInt();
    }
  }

  /**
  prints 2d String array
  */
  public static void print2DStringArray(String[][] toPrint){
    for(int col = 0; col < toPrint[0].length; col++){
      for(int row = 0; row < toPrint.length; row++){
        System.out.print(toPrint[row][col]);
        if(row + 1 == toPrint.length){
          System.out.print("\n");
        }
      }
    }
  }

  /**
  gives a player every property, adding homes and hotels to monopolies (for testing)
  */
  public static void giveAllProperties(Player player){
    Board.initializeBoard(1);
    
    for(int i = 0; i < 40; i++){
      Tile currentTile = Board.getTile(i);
      if((currentTile.getType() == 0 || currentTile.getType() == 01 || currentTile.getType() == 02)){
        player.purchaseTile(currentTile);
        Misc.clear();
        if(currentTile.getType() == 0){
          if(i % 2 == 0){
            for(int l = 0; l < 4; l++){
              House house = new House(currentTile, player);
              currentTile.addHouse(house);
            }
          } else {
            Hotel hotel = new Hotel(currentTile, player);
            currentTile.addHotel(hotel);
          }
        }
      }
    }
  }

  /**
  initializes 8 players and sets their positions arbitrarily around the board (for testing)
  */
  public static void printBoardTest(int[] positions){
      //array containing icon names
    String[] iconNames = new String[] {"Scottie Dog", "Tophat", "Wheelbarrow", "Cat", "Boot", "Racing Car", "Battleship", "Thimble"};
      //playerList 
    ArrayList<Player> playerList = Board.getPlayerList();
    
    //initializes players, adds them to playerList and adds to their positions
    for(int i = 0; i < iconNames.length; i++){
      Player player = new Player(iconNames[i]);
      playerList.add(player);
      player.addToPosition(positions[i]);
    }
  }

  /**
  prints out player icons of a tile (for testing)
  */
  public static void printIcons(Tile tile, Player player){
    String[] playersOnTile = tile.getTileIcons(player);
    
    String[] tileString = tile.getTile();
    
    for(int i = 0; i < tileString.length; i++){
      System.out.println(tileString[i]);
    }

    for(int i = 0; i < playersOnTile.length; i++){
      System.out.println(playersOnTile[i]);
    }
  }
}