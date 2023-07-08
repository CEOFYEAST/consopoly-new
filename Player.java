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
        //0 marks unowned tiles
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
      {0, 0, 100},
    };
  private int railroadTileArray[] = {5, 0, 0, 0};
  private int utilityTileArray[] = {12, 0};
  
  /**
  private int rowZs[] = new int[8];
  */

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
  public void addMoney(int toAdd){
    this.money += toAdd;
    if(this.money < 0){
      this.money = 0;
    }
    if(toAdd < 0){
      System.out.println(iconName + " has been deducted $" + toAdd);
    } else {
      System.out.println(iconName + " has been given $" + toAdd);
    }
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
  public static int getPropertyZeroes(int[] zeroesOf){
    int Zs = 0;
    for(int column: zeroesOf){
      if(column == 0){
        Zs++;
      }
    }
    return Zs;
  }
  public static int[] get2DPropertyZeros(int[][] zeroesOf){
    int rowZs[] = new int[zeroesOf.length];
    for(int row = 0; row < zeroesOf.length; row++){
      int zCount = 0;
      for(int column = 0; column < zeroesOf[0].length; column++){
        if(zeroesOf[row][column] == 0){
          zCount++;
        } 
      }
      rowZs[row] = zCount;
    }
    return rowZs;
  }
  /**
  method containing visual representations of player icons 
  */
  public String[] getIcon(){
    if(iconName == "Scottie Dog"){
      String toReturn[] = new String[]{
        "_┌┐",
        "___",
        "| |"
      };
      return toReturn;
    } else if(iconName == "Tophat"){
      String toReturn[] = new String[]{
        "|||",
        "|||",
        "---"
      };
      return toReturn;
    } else if(iconName == "Thimble"){
      String toReturn[] = new String[]{
        " _ ",
        "| |",
        "---"
      };
      return toReturn;
    } else if(iconName == "Battleship"){
      String toReturn[] = new String[]{
        " |>",
        "_|_",
        "|_/"
      };
      return toReturn;
    } else if(iconName == "Racing Car"){
      String toReturn[] = new String[]{
        "__ ",
        "__]",
        "0 0"
      };
      return toReturn;
    } else if(iconName == "Cat"){
      String toReturn[] = new String[]{
        "_00",
        "___",
        "| |"
      };
      return toReturn;
    } else if(iconName == "Wheelbarrow"){
      String toReturn[] = new String[]{
        "___",
        "__/",
        "0/ "
      };
      return toReturn;
    } else if(iconName == "Boot"){
      String toReturn[] = new String[]{
        "__ ",
        "|| ",
        "|_]"
      };
      return toReturn;
    }
    return null;
  }
  
  /**
  updates tile arrays to account for changes in property ownership, such as buying or selling of property
  */
  private void updateTileArrays(){
    for(int i = 0; i < tileProperty.size(); i++){
      Tile currentTile = tileProperty.get(i);
      int currentTilePosition = currentTile.getPosition();
      //makes sure tileArray contains every tile in tile property (useful when property is added to a player's inventory)
      switch(currentTilePosition){
        //property tiles
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
        //railroad tiles
        case 5:
          railroadTileArray[0] = currentTilePosition;
          break;
        case 15:
          railroadTileArray[1] = currentTilePosition;
          break;
        case 25:
          railroadTileArray[2] = currentTilePosition;
          break;
        case 35:
          railroadTileArray[3] = currentTilePosition;
          break;
        //utility tiles
        case 12:
          utilityTileArray[0] = currentTilePosition;
          break;
        case 28:
          utilityTileArray[1] = currentTilePosition;
          break;
      }
    }
    //removes any property from tileArray not present in tileProperty (useful when property is removed from a player's inventory)
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
  }

    /**
  purchases specified tile for the player, taking care to remove the tile from the inventory of it's previous owner (if it has one) and deduct the tile's price from the new owner's balance 
  */
  public void purchaseTile(Tile toPurchase){
    //removes tile from previous owner's inventory
    if(toPurchase.getOwner() != null){
      Player previousOwner = toPurchase.getOwner();
      previousOwner.removeTile(toPurchase);
    }
    addTile(toPurchase);
    addMoney(-(toPurchase.getPrice()));
  }
  
  /**
  adds specified tile to player inventory, updates tileArrays to reflect this change 
  */
  public void addTile(Tile toAdd){
    toAdd.setOwner(this);
    tileProperty.add(toAdd);
    updateTileArrays();
  }

  /**
  removes specified tile from tileProperty, updates tileArrays to reflect this change 
  */
  public void removeTile(Tile toRemove){
    int toRemoveIndex = 0;
    for(Tile tile: tileProperty){
      if(tile == toRemove){
        tileProperty.remove(toRemoveIndex);
        break;
      }
      toRemoveIndex++;
    }
    updateTileArrays();
  }
  
  /**
  aids print inventory: formats inventory to be printed
  */
  private String[] formatInventory(Tile[] tiles){
    //counts number of monopolies that have atleast one owned property
    ArrayList<Integer> monopoliesToPrintIndices = new ArrayList<Integer>();
    for(int row = 0; row < tileArray.length; row++){
      for(int column = 0; column < 3; column++){
        if(tileArray[row][column] != 0 && tileArray[row][column] != 100){
          monopoliesToPrintIndices.add(row);
          column = 3;
        } 
      }
    }

    //calls fillInventory twice if more than 4 monopolies need to be printed, and splices the two arrays into one complete inventory
    if(monopoliesToPrintIndices.size() > 4){
      //array containing first halve of toReturn
      String[] firstInventoryArray = fillInventory(tiles, 0, monopoliesToPrintIndices.get(3));
      //array containing second halve of toReturn
      String[] secondInventoryArray = fillInventory(tiles, monopoliesToPrintIndices.get(4), monopoliesToPrintIndices.size() - 1);
      //array containing firstInventoryArray and secondInventoryArray spliced together
      String[] toReturn = new String[firstInventoryArray.length + secondInventoryArray.length];

      //fills toReturn
      for(int i = 0; i < firstInventoryArray.length; i++){
        toReturn[i] = firstInventoryArray[i];
      }
      for(int i = 0; i < secondInventoryArray.length; i++){
        toReturn[i + (firstInventoryArray.length)] = secondInventoryArray[i];
      }
      return toReturn;
    } 
    //calls fillInventory once if 4 or less monopolies need to be printed
    else {
      //sends full tileArray
      return fillInventory(tiles, 0, 7);
    } 
  }

  /**
  aids print inventory: returns formatted inventory including only monopolies from start to end
  */
  private String[] fillInventory(Tile[] tiles, int start, int end){
    //new tile array that will only contain owned property values from start to end range 
    int modifiedTileArray[][] =
    {
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0}
    };
    
    //fills modifiedTileArray from start to end, everything out of that range remains 0
    for(int row = start; row <= end; row++){
      for(int column = 0; column < 3; column++){
        modifiedTileArray[row][column] = tileArray[row][column];
      }
    }

    /**
    for(int[] row: modifiedTileArray){
      System.out.println("\n");
      for(int column: row){
        System.out.println(column + " ");
      }
    }
    */
    
    //sets rowZs for column formatting 
    int[] rowZs = get2DPropertyZeros(modifiedTileArray);
    
    //iterates for visual tile length (can't be greater than 9 or less than 4)
      //9 includes whole tile, 6 includes property, 4 includes text
    int lengthOfVisualTile = 6;
    
    //stores values representing locations of tiles owned by player, taken from modifiedTileArray
      //stores all non-zero tile array values in order
    ArrayList<Integer> columnList = new ArrayList<Integer>();
      //stores tiles to be printed in visual inventory columns  
    ArrayList<Integer> columnOneList = new ArrayList<Integer>();
    ArrayList<Integer> columnTwoList = new ArrayList<Integer>();
    ArrayList<Integer> columnThreeList = new ArrayList<Integer>();

    //fills columnList 
    for(int row = 0; row < modifiedTileArray.length; row++){
      for(int column = 0; column < 3; column++){
        if(modifiedTileArray[row][column] != 0){
          columnList.add(modifiedTileArray[row][column]);
        } 
      }
    }
    //sets #'d column lists depending on owned property 
    for(int i = 0; i < modifiedTileArray.length; i++){
      //if all properties of current modifiedTileArray row are owned (a monopoly)
      if(rowZs[i] == 0){
        //adds to all #'d column lists
        columnOneList.add(columnList.get(0));
        columnList.remove(0);
        columnTwoList.add(columnList.get(0));
        columnList.remove(0);
        columnThreeList.add(columnList.get(0));
        columnList.remove(0);
      } 
      //if only two properties of current modifiedTileArray row are owned
        //if that second property isn't a 100 blank property
      else if(rowZs[i] == 1 && columnList.get(1) != 100){
        //adds to columnOne and Two list 
        columnOneList.add(columnList.get(0));
        columnList.remove(0);
        columnTwoList.add(columnList.get(0));
        columnList.remove(0);
        columnThreeList.add(0);
      } 
      //if only two properties of current modifiedTileArray row are owned
        //if that second property IS a 100 blank property
      else if(rowZs[i] == 1){
        //adds to columnOne and Two list
        columnOneList.add(columnList.get(0));
        columnList.remove(0);
        columnTwoList.add(0);
        columnThreeList.add(columnList.get(0));
        columnList.remove(0);
      }
      //if only one property of current modifiedTileArray row is owned 
        //if that one property isn't a 100 blank property
      else if(rowZs[i] == 2 && columnList.get(0) != 100){
        //only adds to columnOneList 
        columnOneList.add(columnList.get(0));
        columnList.remove(0);
        columnTwoList.add(0);
        columnThreeList.add(0);
      } 
      //if only one property of current modifiedTileArray row is owned 
        //if that one property IS a 100 blank property
          //removes said tile from columnList
      else if(rowZs[i] == 2){
        columnList.remove(0);
      }
    }
    //array representing visual formatted string representation of a player's inventory, made up of three columns whose contents lie in the #'d column lists
    ArrayList<String> inventoryList = new ArrayList<String>();
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
              lineOn += "|" + Misc.BACKGROUND_GREY + "                " + Misc.RESET + "|";
            }
          } 
          //generates visual tile if tile is owned 
          else if(tilePos != 100){
            Tile currentTile = tiles[tilePos];
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
    return inventoryArray;
  }

  /**
  returns formatted inventory of railroads
  */
  private String[] fillExtraneousInventory(int[] extraneousTileProperty){
    //iterates for visual tile length (can't be greater than 9)
      //9 includes whole tile, 4 includes text
    int lengthOfVisualTile = 4;
    //array containing formatted inventory to be returned
    String[] inventoryArray = new String[lengthOfVisualTile];

      //checks to make sure all extraneousTileProperty values aren't zero
    if(getPropertyZeroes(extraneousTileProperty) != extraneousTileProperty.length){
      //fills inventory array
      for(int line = 0; line < lengthOfVisualTile; line++){
        String lineOn = "";
        //iterates through every tile in tileProperty
        for(int tilePos: extraneousTileProperty){
          //generates placeholder tile if tile is unowned
          if(tilePos == 0){
            if(line == 0){
              lineOn += " ________________ ";
            } else{
              lineOn += "|" + Misc.BACKGROUND_GREY + "                " + Misc.RESET + "|";
            }
          } 
          //generates visual tile if tile is owned 
          else{
            Tile currentTile = new Tile(tilePos);
            String printTile[] = currentTile.getTile();
            lineOn += printTile[line]; 
          }
        }
        inventoryArray[line] = lineOn;
      } 
    } 
    return inventoryArray;
  }
  
  /**
  prints visual representation of a player's owned properties for trading and managing
  */
  public void printInventory(){
    Misc.clear();

    System.out.println("Exit: y/n");

    //grabs tiles to be used in printing 
    Tile[] tiles = Board.getTiles();
    
    String[] inventoryArray = formatInventory(tiles);
    String[] railroadInventoryArray = fillExtraneousInventory(railroadTileArray);
    String[] utilityInventoryArray = fillExtraneousInventory(utilityTileArray);

    //length of inventory seperator lines
      //currently set to length of railroad inventory array
    int seperatorLength = 87;
    
      //for aesthetics
    printInventorySeperatorLines(seperatorLength, "PROPERTY", Misc.GOLD, Misc.WHITE);
    //prints main player inventory
    printInventoryLines(inventoryArray, "Property");

      //for aesthetics
    System.out.print("\n");
    printInventorySeperatorLines(seperatorLength, "RAILROADS", Misc.GOLD, Misc.WHITE);
    //prints railroad inventory
    printInventoryLines(railroadInventoryArray, "Railroads");
    
      //for aesthetics
    System.out.print("\n");
    printInventorySeperatorLines(seperatorLength, "UTILITIES", Misc.GOLD, Misc.WHITE);
    //prints utility inventory
    printInventoryLines(utilityInventoryArray, "Utilities");
  }
  /**
  aids print inventory: prints inventory lines while avoiding null lines
  */
  private static void printInventoryLines(String[] inventoryArray, String content){
    //prints inventory array, removing null lines
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
      System.out.println("No " + content + " Owned");
    }
  }
  /**
  aids print inventory: prints lines seperating sections of player inventory
  */
  private static void printInventorySeperatorLines(int length, String content, String contentColor, String lineColor){
    content = " " + content + " ";
    int i = content.length()/2;
    while(true){
      System.out.print("-");
      if(i == length/2){
        System.out.print(contentColor + content + Misc.RESET);
        i += content.length()/2;
      } else if (i == length - 1){
        System.out.print("\n");
        break;
      }
      i++;
    }
  }
}