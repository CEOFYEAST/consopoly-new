import java.util.*;
import java.lang.Math;

/** 
class representing an invididual player
*/
public class Player{
  //member variables
    //default 1500;
  private int money = 1500;
    //players position on the board
  private int position = 0;
    //player icon name
  private String iconName;
  private boolean inJail = false;
    //property lists
      //list containing every house owned by the player
  private ArrayList<House> houseList = new ArrayList<House>();
      //list containing every hotel owned by the player
  private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
      //list containing every tile owned by the player
  private ArrayList<Tile> tileProperty = new ArrayList<Tile>();
    //used for formatting player inventory 
      //2d array with ints representing owned tiles
      //100 marks non-existant tiles 
  private int tileArray[][] =
    {
      {0, 0, 100},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 100}
    };
  private int rowZs[] = new int[8];


  //constructor 
  public Player(String iconName){
    this.iconName = iconName;
  }

  
  //getters&setters
  public int getMoney(){
    return money;
  }
  public void setMoney(int money){
    this.money = money;
  }
  public void minusMoney(int money){
    this.money -= money;
    System.out.println(iconName + " has been deducted " + money + " dollars");
  }
  public void addMoney(int money){
    this.money += money;
    System.out.println(iconName + " has been given " + money + " dollars");
  }
  public String getIconName(){
    return iconName;
  }
  public void setIconName(String newIconName){
    iconName = newIconName;
  }
  public int getPosition(){
    return position;
  }
  public void addToPosition(int toAdd){
    int newPosition = position += toAdd;
    if(newPosition > 39){
      position = (newPosition % 39) - 1;
    } else if(newPosition < 0){
      position = Math.abs(toAdd);
    } else {
      position = newPosition; 
    }
  }
  public void setPosition(int position){
    this.position = position;
    if(this.position > 39){
      this.position = 0;
    }
  }
  public ArrayList<House> getHouseList(){
    return houseList;
  }
  public ArrayList<Hotel> getHotelList(){
    return hotelList;
  }
  public ArrayList<Tile> getTilePropertyList(){
    return tileProperty;
  }
  public void addProperty(Tile tile){
    tileProperty.add(tile);
  }
  public void inJail(boolean inJail){
    this.inJail = inJail;
  }
  public int[][] getTileArray(){
    return tileArray;
  }
  public void setPropertyZeros(){
    int typeCount = 0;
    int rowZs[] = new int[8];
    for(int row = 0; row < tileArray.length; row++){
      int zCount = 0;
      for(int column = 0; column < 3; column++){
        if(tileArray[row][column] == 0){
          zCount++;
        } else{
        }
      }
      rowZs[row] = zCount;
      if(zCount > 0){
        typeCount++;
      }
    }
    this.rowZs = rowZs;
  }
  public void setTileArray(){
    for(int i = 0; i < tileProperty.size(); i++){
      Tile currentTile = tileProperty.get(i);
      int currentTilePosition = currentTile.getPosition();
      //makes sure tileArray contains every tile in tile property (useful when property is added to a player's inventory)
      switch(currentTilePosition){
        case 1:
          tileArray[0][0] = currentTilePosition;
          break;     
        case 3:
          tileArray[0][1] = currentTilePosition;
          break;            
        case 6:
          tileArray[1][0] = currentTilePosition;
          break;            
        case 8:
          tileArray[1][1] = currentTilePosition;
          break;
        case 9:
          tileArray[1][2] = currentTilePosition;
          break;
        case 11:
          tileArray[2][0] = currentTilePosition;
          break;
        case 13:
          tileArray[2][1] = currentTilePosition;
          break;
        case 14:
          tileArray[2][2] = currentTilePosition;
          break;
        case 16:
          tileArray[3][0] = currentTilePosition;
          break;
        case 18:
          tileArray[3][1] = currentTilePosition;
          break;
        case 19:
          tileArray[3][2] = currentTilePosition;
          break;
        case 21:
          tileArray[4][0] = currentTilePosition;
          break;
        case 23:
          tileArray[4][1] = currentTilePosition;
          break;
        case 24:
          tileArray[4][2] = currentTilePosition;
          break;
        case 26:
          tileArray[5][0] = currentTilePosition;
          break;
        case 27:
          tileArray[5][1] = currentTilePosition;
          break;
        case 29:
          tileArray[5][2] = currentTilePosition;
          break;
        case 31:
          tileArray[6][0] = currentTilePosition;
          break;
        case 32:
          tileArray[6][1] = currentTilePosition;
          break;
        case 34:
          tileArray[6][2] = currentTilePosition;
          break;
        case 37:
          tileArray[7][0] = currentTilePosition;
          break;
        case 39:
          tileArray[7][1] = currentTilePosition;
          break;
      }
    }
    //removes any property from tileArray not present in tileProperty (useful when property is removed from a player's inventory)
    /**
    for(int row = 0; row < tileArray.length; row++){
      for(int column = 0; column < tileArray[0].length; column++){
        if(tileArray[row][column] != 0 && tileArray[row][column] != 100){
          boolean isPresent = false;
          for(Tile tile: tileProperty){
            if(tile.getPosition() == tileArray[row][column]){
              isPresent = true;
            }
          }
          if(isPresent) { } else {
            tileArray[row][column] = 0;
          }
        } else {
          continue;
        }
      }
    }
    */
  }
  
  /**
  formats inventory to be printed
  */
  public String[] formatInventory(){
    //iterates for visual tile length (can't be greater than 9 or less than 4)
      //9 includes whole tile, 6 includes property, 4 includes text
    int lengthOfVisualTile = 6;
    
    //stores values representing locations of tiles owned by player, taken from tileArray
      //stores all non-zero tile array values in order
    ArrayList<Integer> columnList = new ArrayList<Integer>();
      //stores tiles to be printed in visual inventory columns  
    ArrayList<Integer> columnOneList = new ArrayList<Integer>();
    ArrayList<Integer> columnTwoList = new ArrayList<Integer>();
    ArrayList<Integer> columnThreeList = new ArrayList<Integer>();

    //fills columnList 
    for(int row = 0; row < tileArray.length; row++){
      for(int column = 0; column < 3; column++){
        if(tileArray[row][column] != 0){
          columnList.add(tileArray[row][column]);
        } 
      }
    }
    //sets #'d column lists depending on owned property 
    for(int i = 0; i < tileArray.length; i++){
      //if all properties of current tileArray row are owned (a monopoly)
      if(rowZs[i] == 0){
        //adds to all #'d column lists
        columnOneList.add(columnList.get(0));
        columnList.remove(0);
        columnTwoList.add(columnList.get(0));
        columnList.remove(0);
        columnThreeList.add(columnList.get(0));
        columnList.remove(0);
      //if only two properties of current tileArray row are owned
      } else if(rowZs[i] == 1){
        //adds to columnOne and Two list 
        columnOneList.add(columnList.get(0));
        columnList.remove(0);
        columnTwoList.add(columnList.get(0));
        columnList.remove(0);
        columnThreeList.add(0);
      //if only one property of current tileArray row is owned 
      } else if(rowZs[i] == 2 && columnList.get(0) != 100){
        //only adds to columnOneList 
        columnOneList.add(columnList.get(0));
        columnList.remove(0);
        columnTwoList.add(0);
        columnThreeList.add(0);
      } 
    }
    //fills out #'d column lists to avoid an odd number
    if(columnOneList.size() == 5 || columnOneList.size() == 7){
      columnOneList.add(0);
      columnTwoList.add(0);
      columnThreeList.add(0);
    }  
    //array representing visual formatted string representation of a player's inventory, made up of three columns whose contents lie in the #'d column lists
    ArrayList<String> inventoryList = new ArrayList<String>();
    for(int toPrint: columnOneList){
      System.out.println(toPrint);
    }
    for(int column = 0; column < 3; column++){
      ArrayList<Integer> currentColumn = new ArrayList<Integer>();
      //sets currentColumn
      if(column == 0){
        currentColumn = columnOneList;
      } else if(column == 1){
        currentColumn = columnTwoList;
      } else{
        currentColumn = columnThreeList;
      }
      for(int line = 0; line < lengthOfVisualTile; line++){
        String lineOn = "";
        //iterates through every tile in current #'d column 
        for(int tilePos: currentColumn){
          //generates blank tile for non-existant tile
          if(tilePos == 100){
            lineOn += "                  ";
          } 
          //generates placeholder tile if tile is unowned
          else if(tilePos == 0){
            if(line == 0){
              lineOn += " ________________ ";
            } else{
              lineOn += "|                |";
            }
          } 
          //generates visual tile if tile is owned 
          else if(tilePos != 100){
            Tile currentTile = new Tile(tilePos);
            String printTile[] = currentTile.getTile();
            lineOn += printTile[line]; 
          }
        }
        inventoryList.add(lineOn);
      } 
    }
    //fills and initializes inventory array
    String[] inventoryArray = new String[inventoryList.size()];
    for(int i = 0; i < inventoryArray.length; i++){
      inventoryArray[i] = inventoryList.get(i);
    }
    //lengthens inventory array to handle split inventory 
    String[] tempArray = new String[72];
    for(int string = 0; string < inventoryArray.length; string++){
      tempArray[string] = inventoryArray[string];
    }
    inventoryArray = tempArray;
    //splits inventory in half if it's too long to fit in the console 
    if(Misc.noANSILength(inventoryArray[1]) > 72){
      //iterates through every line in the inventory 
      for(int line = 0; line < lengthOfVisualTile * 3; line++){
        //if line is a text line
        if(line == 1 || line == 2 || line == 3 || line == (lengthOfVisualTile + 1) || line == (lengthOfVisualTile + 2) || line == (lengthOfVisualTile + 3) || line == ((lengthOfVisualTile * 2) + 1) || line == ((lengthOfVisualTile * 2) + 2) || line == ((lengthOfVisualTile * 2) + 3)){
          int i = line;
          //contains indices for certain characters
            //contains indices of even index big and small lines
          ArrayList<Integer> allIndex = new ArrayList<Integer>();
            //contains even index indices of '│', makes up left walls of owned property
          ArrayList<Integer> bigLineIndex = new ArrayList<Integer>();
            //contains even index indices of '|', makes up left walls of unowned property
          ArrayList<Integer> smallLineIndex = new ArrayList<Integer>();
          int bigLineCharCount = 0;
          int smallLineCharCount = 0;
          //iterates for every char in current line, stores indices of big and small lines in their respective lists
          for(int charIndex = 0; charIndex < inventoryArray[i].length(); charIndex++){
            char currentChar = inventoryArray[i].charAt(charIndex);
            if(currentChar == '│'){
              bigLineCharCount++;
              //only adds every even index (left wall) big line to the list
              if(bigLineCharCount % 2 == 0){
                bigLineIndex.add(charIndex);
              }
            } else if(currentChar == '|'){
              smallLineCharCount++;
              //only adds every even index (left wall) small line to the list
              if(smallLineCharCount % 2 == 0){
                smallLineIndex.add(charIndex);
              }
            } 
          }
          //adds every big line index to all index
          for(int index: bigLineIndex){
            allIndex.add(index);
          }
          System.out.print("\n");
          //adds every small line index to all index
          for(int index: smallLineIndex){
            allIndex.add(index);
          }
          //sorts allIndex, essentially mixing the indices of blank and owned property left walls together 
          Collections.sort(allIndex);
          //gets the index of the middle left wall (can be any type of wall)
          int midIndex = allIndex.get(allIndex.size()/2 - 1);
          //splits inventory down the middle using midIndex 
          inventoryArray[24 + i] = inventoryArray[i].substring(midIndex + 1, inventoryArray[i].length());
          inventoryArray[i] = inventoryArray[i].substring(0, midIndex + 1);
        } 
        //splits lines besides text lines 
        else{
          int i = line;
            String currentLine = inventoryArray[i];
            inventoryArray[i] = currentLine.substring(0, currentLine.length()/2);
            String toAdd = currentLine.substring(currentLine.length()/2, currentLine.length());
            inventoryArray[24+i] = toAdd;
          }
        }
      }
    return inventoryArray;
  }
  
  /**
  prints visual representation of a player's owned properties for trading and managing
  */
  public void printInventory(){
    String[] inventoryArray = formatInventory();

    
    //prints inventory array, removing null lines
      //for aesthetics
    printInventoryLines(inventoryArray, "PROPERTY");
    boolean allNull = true;
    for(String i: inventoryArray){
      if(i != null){
        if(i.length() > 0){
          allNull = false;
          System.out.println(i);
        }
      } 
    }
    if(allNull){
      System.out.println("No Property Owned");
    }
    System.out.print("\n");
    printInventoryLines(inventoryArray, "RAIlROADS");
    System.out.print("\n");
    printInventoryLines(inventoryArray, "UTILITIES");
  }
  /**
  simple method to aid printInventory
  */
  public static void printInventoryLines(String[] inventoryArray, String content){
    content = " " + content + " ";
    int i = content.length()/2;
    while(true){
      System.out.print("-");
      if(i == inventoryArray[0].length()/2){
        System.out.print(Misc.GOLD + content + Misc.RESET);
        i += content.length()/2;
      } else if (i == inventoryArray[0].length() - 1){
        System.out.print("\n");
        break;
      }
      i++;
    }
  }
}