import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.util.concurrent.TimeUnit;

/**
class representing the monopoly board, including it's tiles and every player's positions on them, as well as methods to move players around the board 
*/
public class Board{
  //member variables 
    //total player count
  private static int playerCount;
    //player turn and their index
  private static Player playerUp;
  private static int playerUpIndex;
   //array containing every tile as it's created 
  private static Tile tiles[] = new Tile[40];
    //list of players
 private static ArrayList<Player> playerList = new ArrayList<Player>();
    //list of player icons
  private static ArrayList<String> availableIcons = new ArrayList<String>(Arrays.asList("Scottie Dog", "Tophat", "Thimble", "Battelship", "Racing Car", "Cat", "Wheelbarrow", "Boot"));
  
    
  //mutators
  public static ArrayList<Player> getPlayerList(){
    return playerList;
  }
  public static ArrayList<Player> getPlayerListCopy(){
    ArrayList<Player> toReturn = new ArrayList<Player>(playerList);
    return toReturn;
  }
  public static void setTurn(int newIndex){
    if(newIndex > playerList.size() - 1 || newIndex <= 0){
    } else{
      playerUp = playerList.get(newIndex);
      playerUpIndex = newIndex;
    }
  }
  public static Player getPlayerUp(){
    return playerUp;
  }
  public static int getPlayerUpIndex(){
    return playerUpIndex;
  }
  public static void setPlayerUpIndex(int newIndex){
    playerUpIndex = newIndex;
  }
  public static Tile[] getTiles(){
    return tiles;
  }
  public static Tile getTile(int index){
    return tiles[index];
  }

  private static void printBoard(int startLocation, String spaces, int length, Player toMove){
      //index of tiles to be filled 
    int tilesIndex = 0;
      //2d array containing visual tiles of tiles 
    String[][] visualArray = new String[length][];
      //2d array containing icons of tiles
    String[][] iconsArray = new String[length][];

    //fills visual and icons arrays, making sure to account for wrapping around the board 
    for(int i = startLocation; i < startLocation + length; i++){
        //position to be assigned to tile
      int assignIndex = i; 
      
      //handles indices greater than 39
      if(assignIndex > 39){
        assignIndex = assignIndex - 40;
      }
      //handles indices less than 0
      else if(assignIndex < 0){
        assignIndex = 40 + assignIndex;
      }
      //initializes visual and icons arrays at tileIndex
      Tile tile = Board.getTile(assignIndex);
      visualArray[tilesIndex] = tile.getTile();
      iconsArray[tilesIndex] = tile.getTileIcons(toMove);
      
      tilesIndex++;
    }

    //prints visual tiles
    Util.print2DStringArray(visualArray);

    //prints player icon
    String[] icon = toMove.getIcon();
    for(int i = 0; i < icon.length; i++){
      System.out.println(spaces + icon[i]);
    }
    
    //prints tile icons
    Util.print2DStringArray(iconsArray);
  }
  
  /**
  moves given player across the board by moveAmount
  */
  public static void movePlayer(int moveAmount, int length, Player player){
      //initializes player icon
    String printIcon[] = player.getIcon();
      //declares current tile 
    Tile currentTile;
      //string of spaces that's the length of a tile
    String spaces = "                  ";
    int playerPosition = player.getPosition();
    int destination = playerPosition + moveAmount;

    //moves player, calls printBoard and sets player icon before space 
    for(int i = -1; i < moveAmount; i++){
        //sets before space of player icon depending on playerPosition's distance from destination
      String finalSpaces = "       ";
      
      //prints first frame/no-move frame
      if(i == -1){
        playerPosition = player.getPosition();
        
        //if player isn't moving
        if(moveAmount == 0){
          for(int l = 0; l < length/2; l++){
            finalSpaces += spaces;
          }
          printBoard(destination - (length/2), finalSpaces, length, player);
          return;
        }
        //if player is moving
        printBoard(playerPosition, finalSpaces, length, player);
        if(moveAmount > 12){
          Util.tryWait(100);
        } else if(moveAmount > 6){
          Util.tryWait(500);
        } else if(moveAmount > 3){
          Util.tryWait(1000);
        } else {
          Util.tryWait(1500);
        }
        Misc.clear();
        continue;
      }
      
      player.addToPosition(1);
      playerPosition = player.getPosition();

      //if player passes go
      if(playerPosition == 0){
        Misc.clear();
        Misc.passGoAnimation();
        Misc.clear();
      }
      
      //if playerPosition is within range of destination
      if(!(playerPosition <= destination - (length/2))){
        //if playerPosition = destination
        if(playerPosition == destination){
          for(int l = 0; l < length/2; l++){
            finalSpaces += spaces;
          }
          printBoard(destination - (length/2), finalSpaces, length, player);
          return;
        }
        //if playerPosition is within range of destination but does not equal destination
        else{
          for(int l = playerPosition; l > destination - (length/2); l--){
            finalSpaces += spaces;
          }
        }
        printBoard(destination - (length/2), finalSpaces, length, player);
      }
      //if playerPosition is out of range of destination
      else{
        //if playerPosition is only one space out of range
        if(!(playerPosition < destination - (length/2))){
          printBoard(destination - (length/2), finalSpaces, length, player);
        }
        //if playerPosition is fully out of range of destination
        else{
          printBoard(playerPosition, finalSpaces, length, player);
        }
      }
      if(moveAmount > 12){
        Util.tryWait(100);
      } else if(moveAmount > 6){
        Util.tryWait(500);
      } else if(moveAmount > 3){
        Util.tryWait(1000);
      } else {
        Util.tryWait(1500);
      }
      Misc.clear();
    }
  }

  /**
  simulates a dice roll for the given player 
  */
  public static int roll(Player player){
    Scanner s = new Scanner(System.in);
   
    Util.interact("Roll the Dice");
   
    int doublesCount = 0;
    int num1 = (int) ((Math.random() * 6) + 1);
    int num2 = (int) ((Math.random() * 6) + 1);
    int totalNum = num1 + num2;
    String userName = player.getIconName();
       
    System.out.println(userName + " rolled " + num1 + " and " + num2 + " for a total of " + totalNum);
    
    if(num1 == num2){
      if(doublesCount > 0){
        System.out.println(userName + " rolled doubles again!");
      } else{
        System.out.println(userName + " rolled doubles!");
      }
      doublesCount++;
    }

    if(doublesCount == 3){
      System.out.println("Go to jail");
    }
  return totalNum;
  }
  
  /**
  gets board ready for play
  */
  public static void initializeBoard(int playerCount){
    //sets player count
    Board.playerCount = playerCount;

    //builds every tile
    for(int i = 0; i < 40; i++){
      Tile tile = new Tile(i);
      tiles[i] = tile;
    }
    
    //Scanner s = new Scanner(System.in);

    /**
    //assigns player icons
    int selection;
    for(int i = 0; i < playerCount; i++){
      System.out.println("player " + (i + 1) + ", choose your icon");
      for(int l = 0; l < availableIcons.size(); l++){
        System.out.println("Press " + (l + 1) + " for " + availableIcons.get(l));
      }
      //selection = s.nextInt() - 1;
      selection = 0;

      System.out.println("You chose " + availableIcons.get(selection));
      //Game.tryWait(1500);
      
      //initializes playerList
      Player player = new Player(availableIcons.get(selection));
      playerList.add(player);

      //updates available icons
      availableIcons.remove(selection);

      Board.clear();
    }
    */

    /**
    //updates player turn 
    playerUp = playerList.get(0);
    playerUpIndex = 0;

    //starts the game 
    Game.turn(playerUp, this);
    */
  }
}
