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
  private int tileArray[][] =
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
    /**
    formats inventory to be printed
    */
  public String[] formatInventory(){
    ArrayList<Integer> columnList = new ArrayList<Integer>();
    ArrayList<Integer> columnOneList = new ArrayList<Integer>();
    ArrayList<Integer> columnTwoList = new ArrayList<Integer>();
    ArrayList<Integer> columnThreeList = new ArrayList<Integer>();
     for(int row = 0; row < tileArray.length; row++){
      for(int column = 0; column < 3; column++){
        if(tileArray[row][column] == 0){
        } else{
          columnList.add(tileArray[row][column]);
        }
      }
    }
    for(int i = 0; i < tileArray.length; i++){
     if(rowZs[i] == 0){
       columnOneList.add(columnList.get(0));
       columnList.remove(0);
       columnTwoList.add(columnList.get(0));
       columnList.remove(0);
       columnThreeList.add(columnList.get(0));
       columnList.remove(0);
     } else if(rowZs[i] == 1){
       columnOneList.add(columnList.get(0));
       columnList.remove(0);
       columnTwoList.add(columnList.get(0));
       columnList.remove(0);
       columnThreeList.add(0);
     } else if(rowZs[i] == 2){
       columnOneList.add(columnList.get(0));
       columnList.remove(0);
       columnTwoList.add(0);
       columnThreeList.add(0);
     } 
    }
    if(columnOneList.size() == 5 || columnOneList.size() == 7){
      columnOneList.add(0);
      columnTwoList.add(0);
      columnThreeList.add(0);
    }
    String inventoryArray[] = new String[72];
    int round = 0;
    for(int column = 0; column < 3; column++){
      ArrayList<Integer> currentColumn = new ArrayList<Integer>();
      if(column == 0){
        currentColumn = columnOneList;
      } else if(column == 1){
        currentColumn = columnTwoList;
      } else{
        currentColumn = columnThreeList;
      }
      for(int line = 0; line < 8; line++){
        String lineOn = "";
        int rowIndex = 0;
        for(int i: currentColumn){
          if(i == 0){
            if(line == 0){
              lineOn += "__________________";
            } else{
              lineOn += "|                |";
            }
          } else {
            Tile currentTile = new Tile(i);
            String printTile[] = currentTile.getTile();
            lineOn += printTile[line]; 
          }
        }
        inventoryArray[round] = lineOn;
        round++;
      } 
    }
    return inventoryArray;
  }
    /**
    prints visual representation of a player's owned properties for trading and managing
    */
  public void printInventory(){
    String inventoryArray[] = formatInventory();
    if(Misc.noANSILength(inventoryArray[1]) > 72){
      for(int index = 0; index < 24; index++){
        if(index == 1 || index == 2 || index == 3 || index == 9 || index == 10 || index == 11 || index == 17 || index == 18 || index == 19){
          int i = index;

          ArrayList<Integer> allIndex = new ArrayList<Integer>();
          ArrayList<Integer> bigLineIndex = new ArrayList<Integer>();
          ArrayList<Integer> smallLineIndex = new ArrayList<Integer>();

          int bigLineCount = 0;
          int smallLineCount = 0;
          for(int r = 0; r < inventoryArray[i].length(); r++){
            char cC= inventoryArray[i].charAt(r);
            if(cC == '│'){
              bigLineCount++;
              if(bigLineCount % 2 == 0){
                bigLineIndex.add(r);
              }
            }else if(cC == '|'){
              smallLineCount++;
              if(smallLineCount % 2 == 0){
                smallLineIndex.add(r);
              }
            }
          }
          for(int r: bigLineIndex){
            allIndex.add(r);
          }
          for(int e: smallLineIndex){
            allIndex.add(e);
          }
          
          Collections.sort(allIndex);
      
          int midIndex = allIndex.get(allIndex.size()/2 - 1);

          inventoryArray[24 + i] = inventoryArray[i].substring(midIndex + 1, inventoryArray[i].length());
          inventoryArray[i] = inventoryArray[i].substring(0, midIndex + 1);
        } 
        else{
          int i = index;
            String cL = inventoryArray[i];
            inventoryArray[i] = cL.substring(0, cL.length()/2);
            String toAdd = cL.substring(cL.length()/2, cL.length());
            inventoryArray[24+i] = toAdd;
          }
        }
      }
      boolean allNull = true;
      System.out.println("Property:");
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
      System.out.println("-----------------");
      System.out.println("Railroads:");
      System.out.println("-----------------");
      System.out.println("Utilities:");
      System.out.println(); 
  }
  public void setTileArray(){
    for(int i = 0; i < tileProperty.size(); i++){
        Tile currentTile = tileProperty.get(i);
        int currentTilePosition = currentTile.getPosition();
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
      this.setPropertyZeros();
    }
}