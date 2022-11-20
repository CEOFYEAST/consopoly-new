import java.util.ArrayList;

/**
class representing tiles and their respective cards on the monopoly board
*/
public class Tile{
  //member vars
  private int price;
    //sets tile type
      // 0 is property
        //01 is a railroad
        //02 is a utility
      // 1 is tax
      // 2 is draw card
      // 3 is jail
      // 4 is collect (go and others)
      // 5 is nothing (parking space, visiting jail)
  private int type = 0;
    //int representing tile's position on the board
  private int position;
    //bool representing tile's mortgage status
  private boolean isMortgaged = false;
    //bool representing if a tile is part of a monopoly (every tile in that set is owned by one player)
  private boolean isMonopoly = false;
    //tile owner
  private Player owner;
    //tile rent list used for determining rent with certain property #
  private int rentArr[];
    //tile property lists
  private ArrayList<House> houseList = new ArrayList<House>();
  private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    //misc
      //used for generating visual tile text
  private String colorLine =  "                ";
  private String topLine =    "              ";
  private String bottomLine = "              ";
      //used for visual tile color
  private String tileColor = Misc.WHITE;
  private String outlineColor = Misc.WHITE;

  
  //constructor 
  public Tile(int position){
    this.position = position;
    this.setTile();
  }

  
  //getters&setters
  public String getTopLine(){
    return topLine;
  }
  public String getBottomLine(){
    return bottomLine;
  }
  public String getTileColor(){
    return tileColor;
  }
  public Player getOwner(){
    return owner;
  }
  public void setOwner(Player owner){
    this.owner = owner;
  }
  public int getPrice(){
    return price;
  }
  public int getMortgage(){
    return price/2;
  }
  public int getPosition(){
    return position;
  }
  public int getType(){
    return type;
  }
  public void addHouse(House toAdd){
    houseList.add(toAdd);
  }
  public void addHotel(Hotel toAdd){
    hotelList.add(toAdd);
  }
  public boolean isMortgaged(){
    return isMortgaged;
  }
  public int[] getRents(){
    return rentArr;
  }
    /**
    returns tile rent based on tile type and tile property count
    */
  public int getRent(int... diceRoll){
      //checks to see if tile is a utility in order to apply special rent properties 
    if(diceRoll != null){
      for(int roll: diceRoll){
        int propertyCount = 0;
        ArrayList<Tile> tileProperty = owner.getTilePropertyList();
        for(int i = 0; i < tileProperty.size(); i++){
          if(tileProperty.get(i).getType() == 02){
            propertyCount += 1;
          }
      }
        if(propertyCount == 1){
          return(roll * 4);
        }
        else {
          return(roll * 10);
        }
      }
    }
      //checks to see if tile is a railroad in order to apply special rent properties
    if(type == 01){
      int propertyCount = 0;
      ArrayList<Tile> tileProperty = owner.getTilePropertyList();
      for(int i = 0; i < tileProperty.size(); i++){
        if(tileProperty.get(i).getType() == 01){
          propertyCount += 1;
        }
      }
      return 50 * propertyCount;
    } 
      //if tile isn't a railroad or utility, sets rent based on tile property count and rentArr
    else{
    if(hotelList.size() > 0){
      return rentArr[5];
    } else if(houseList.size() == 4){
      return rentArr[4];
    } else if(houseList.size() == 3){
      return rentArr[3];
    } else if(houseList.size() == 2){
      return rentArr[2];
    } else if(houseList.size() == 1){
      return rentArr[1];
    }
    return rentArr[0];
    }
  }
    /**
    sets all variables of a tile depending on its location on the board
    */
  public void setTile(){
    switch (position) {
      case 0: 
        //ref        "              "
        topLine =    " Go ----->    ";
        bottomLine = " Collect $200 ";
        type = 4;
        break;
      case 1: 
        //ref        "              "
        topLine =    "Mediterranean ";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_BROWN;
        price = 60;
        rentArr = new int[]{2, 10, 30, 90, 160, 250}; 
        break;
      case 2: 
        //ref        "              "
        topLine =    "   Community  ";
        bottomLine = "    Chest     ";
        type = 2;
        break;
      case 3: 
        //ref        "              "
        topLine =    "Baltic Avenue ";
        tileColor = Misc.BACKGROUND_BROWN;
        price = 60;
        rentArr = new int[]{4, 20 ,60, 180, 320, 450};
        break;
      case 4: 
        //ref        "              "
        topLine   =  "  Income Tax  ";
        type = 1;
        break;
      case 5: 
        //ref        "              "
        colorLine = "    Reading     ";
        topLine =    "   Railroad   ";
        price = 200;
        rentArr = new int[]{50, 100, 150, 200};
        type = 01;
        break;
      case 6: 
        //ref        "              "
        topLine =    "   Oriental   ";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_LIGHT_BLUE;
        price = 100;
        rentArr = new int[]{6, 30, 90, 270, 400, 550};
        break;
      case 7: 
        //ref        "              "
        colorLine = "     Chance     ";
        topLine =    "      ?       ";
        type = 2;
        break;
      case 8: 
        //ref        "              "
        topLine =    "Vermont Avenue";
        tileColor = Misc.BACKGROUND_LIGHT_BLUE;
        price = 100;
        rentArr = new int[]{6, 30, 90, 270, 400, 550};
        break;
      case 9: 
        //ref        "              "
        topLine =    "  Connecticut ";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_LIGHT_BLUE;
        price = 120;
        rentArr = new int[]{8, 40, 100, 300, 450, 600};
        break;
      case 10: 
        //ref        "              "
        topLine =    "    Jail /    ";
        bottomLine = " Just Visiting";
        type = 5;
        break;
      case 11: 
        //ref        "              "
        topLine =    "  St.Charles  ";
        bottomLine = "    Place     ";
        tileColor = Misc.BACKGROUND_LIGHT_PINK;
        price = 140;
        rentArr = new int[]{10, 50, 150, 450, 625, 750};
        break;
      case 12: 
        //ref        "              "
        colorLine = "    Electric    ";
        topLine =    "   Company    ";
        price = 150;
        type = 02;
        break;
      case 13: 
        //ref        "              "
        topLine =    "States Avenue ";
        tileColor = Misc.BACKGROUND_LIGHT_PINK;
        price = 140;
        rentArr = new int[]{10, 50, 150, 450, 625, 750};
        break;
      case 14: 
        //ref        "              "
        topLine =    "   Virginia   ";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_LIGHT_PINK;
        price = 160;
        rentArr = new int[]{12, 60, 180, 500, 700, 900};
        break;
      case 15: 
        //ref        "              "
        colorLine = "  Pennsylvania  ";
        topLine =    "   Railroad   ";
        price = 200;
        rentArr = new int[]{50, 100, 150, 200};
        type = 01;
        break;
      case 16: 
        //ref        "              "
        topLine =    "St.James Place";
        tileColor = Misc.BACKGROUND_ORANGE;
        price = 180;
        rentArr = new int[]{14, 70, 200, 550, 750, 950};
        break;
      case 17: 
        //ref        "              "
        topLine =    "  Community   ";
        bottomLine = "    Chest     ";
        type = 2;
        break;
      case 18: 
        //ref        "              "
        topLine =    "   Tennessee  ";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_ORANGE;
        price = 180;
        rentArr = new int[]{14, 70, 200, 550, 750, 950};
        break;
      case 19: 
        //ref        "              "
        topLine =    "   New York   ";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_ORANGE;
        price = 200;
        rentArr = new int[]{16, 80, 220, 600, 800, 1000};
        break;
      case 20: 
        //ref        "              "
        topLine =    " Free Parking ";
        type = 5;
        break;
      case 21: 
        //ref        "              "
        topLine =    "   Kentucky   ";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_RED;
        price = 220;
        rentArr = new int[]{18, 90, 250, 700, 875, 1050};
        break;
      case 22: 
        //ref        "              "
        colorLine = "     Chance     ";
        topLine =    "      ?       ";
        type = 2;
        break;
      case 23: 
        //ref        "              "
        topLine =    "Indiana Avenue";
        tileColor = Misc.BACKGROUND_RED;
        price = 220;
        rentArr = new int[]{18, 90, 250, 700, 875, 1050};
        break;
      case 24: 
        //ref        "              "
        topLine =    "   Illinois   ";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_RED;
        price = 240;
        rentArr = new int[]{20, 100, 300, 750, 925, 1100};
        break;
      case 25: 
        //ref        "              "
        topLine =    "B.&.O Railroad";
        price = 200;
        rentArr = new int[]{50, 100, 150, 200};
        type= 01;
        break;
      case 26: 
        //ref        "              "
        topLine =    "   Atlantic   ";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_YELLOW;
        price = 260;
        rentArr = new int[]{22, 110, 330, 800, 975, 1150};
        break;
      case 27: 
        //ref        "              "
        topLine =    "Ventnor Avenue";
        tileColor = Misc.BACKGROUND_YELLOW;
        price = 260;
        rentArr = new int[]{22, 110, 330, 800, 975, 1150};
        break;
      case 28: 
        //ref        "              "
        colorLine = "  Water Works   ";
        price = 150;
        type = 02;
        break;
      case 29: 
        //ref        "              "
        topLine =    "Marvin Gardens";
        tileColor = Misc.BACKGROUND_YELLOW;
        price = 280;
        rentArr = new int[]{24, 120, 360, 850, 1025, 1200};
        break;
      case 30: 
        //ref        "              "
        topLine =    "  Go To Jail  ";
        type = 3;
        break;
      case 31: 
        //ref        "              "
        topLine =    "Pacific Avenue";
        tileColor = Misc.BACKGROUND_FOREST_GREEN;
        price = 300;
        rentArr = new int[]{26, 130, 390, 900, 100, 1275};
        break;
      case 32: 
        //ref        "              "
        topLine =    "North Carolina";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_FOREST_GREEN;
        price = 300;
        rentArr = new int[]{26, 130, 390, 900, 100, 1275};
        break;
      case 33: 
        //ref        "              "
        topLine =    "  Community   ";
        bottomLine = "    Chest     ";
        type = 2;
        break;
      case 34: 
        //ref        "              "
        topLine =    " Pennsylvania ";
        bottomLine = "    Avenue    ";
        tileColor = Misc.BACKGROUND_FOREST_GREEN;
        price = 320;
        rentArr = new int[]{28, 150, 450, 1000, 1200, 1400};
        break;
      case 35: 
        //ref        "              "
        topLine =    "  Short Line  ";
        price = 200;
        rentArr = new int[]{50, 100, 150, 200};
        type = 01;
        break;
      case 36: 
        //ref        "              "
        colorLine = "     Chance     ";
        topLine =    "      ?       ";
        type = 2;
        break;
      case 37: 
        //ref        "              "
        topLine =    "  Park Place  ";
        tileColor = Misc.BACKGROUND_DARK_BLUE;
        price = 350;
        rentArr = new int[]{35, 175, 500, 1100, 1300, 1500};
        break;
      case 38: 
        //ref        "              "
        topLine =    "  Luxury Tax  ";
        type = 1;
        break;
      case 39: 
        //ref        "              "
        topLine =    "  Boardwalk   ";
        tileColor = Misc.BACKGROUND_DARK_BLUE;
        price = 400;
        rentArr = new int[]{50, 200, 600, 1400, 1700, 2000};
        break;
    }
  }
    /**
    returns card/board version of tile in a string array
    */
  public String[] getTile(){
    //lines representing hotels/houses
    String oneLine =   "       " + Misc.GREEN + "[]" + Misc.RESET + "       ";
    String twoLine =   "    " + Misc.GREEN + "[]    []" + Misc.RESET + "    ";
    String threeLine = "   " + Misc.GREEN + "[]  []  []" + Misc.RESET + "   ";
    String fourLine =  " " + Misc.GREEN + "[]  []  []  []" + Misc.RESET + " ";
    String hotelLine = "       " + Misc.RED + "[]" + Misc.RESET + "       ";

    //places hotels/houses in line to be inserted in tile
      //line to be inserted
    String propertyLine = "                ";
    if(hotelList.size() > 0){
      propertyLine = hotelLine;
    } else if(houseList.size() == 1){
      propertyLine = oneLine;
    } else if(houseList.size() == 2){
      propertyLine = twoLine;
    } else if(houseList.size() == 3){
      propertyLine = threeLine;
    } else if(houseList.size() == 4){
      propertyLine = fourLine;
    } 

    String[] toReturn = new String[]
    {
      outlineColor + "┌────────────────┐" + Misc.RESET, //0
      outlineColor + "│" + Misc.RESET + tileColor + colorLine + Misc.RESET + outlineColor + "│" + Misc.RESET, //1
      outlineColor + "│ " + Misc.RESET + Misc.WHITE + topLine + Misc.RESET + outlineColor + " │" + Misc.RESET, //2
      outlineColor + "│ " + Misc.RESET + Misc.WHITE + bottomLine + Misc.RESET + outlineColor + " │" + Misc.RESET, //3
      outlineColor + "│────────────────│" + Misc.RESET, //4
      outlineColor + "│" + Misc.RESET + propertyLine + outlineColor + "│" + Misc.RESET, //5
      outlineColor + "│                │" + Misc.RESET, //6
      outlineColor + "│                │" + Misc.RESET, //7
      outlineColor + "│                │" + Misc.RESET, //8
      outlineColor + "└────────────────┘" + Misc.RESET //9
    }; 
    return toReturn;
	}
  
  /**
  returns visual representation of players currently visiting tile
  */
  public String[] getTileIcons(Player currentPlayer) {
    // list of all players
    ArrayList<Player> playerList = Board.getPlayerListCopy();
    // list of strings to be returned
    String[] toReturn = new String[9];

    //fills toReturn with empty strings to avoid null calls 
    for(int i = 0; i < toReturn.length; i++){
      toReturn[i] = "";
    }

    // removes currentPlayer and players whose positions aren't on the tile from playerList
    for (int i = 0; i < playerList.size(); i++) {
      Player player = playerList.get(i);
      // checks for currentPlayer
      if (player == currentPlayer) {
        playerList.remove(i);
        i--;
      }
      // checks for players not actually on tile
      else if(player.getPosition() != this.position) {
        playerList.remove(i);
        i--;
      }
    }

    // starting index in playerList for lineIndex loop
    int addIndex = 0;
    for (int playerIndex = 0; playerIndex < playerList.size(); playerIndex++) {
      Player player = playerList.get(playerIndex);
      String[] icon = player.getIcon();

      // adds every line of icon to toReturn
      for(int lineIndex = addIndex; lineIndex < addIndex + 3; lineIndex++) {
        // before/after spaces content
        String spacesToAdd = "   ";

        // adds before space to icon if icon is first in it's row
        if (playerIndex == 0 || playerIndex == 3 || playerIndex == 6) {
          toReturn[lineIndex] += spacesToAdd;
          
          // adds extra space if icon is in the last row
          if (playerIndex == 6) {
            toReturn[lineIndex] += spacesToAdd;
            toReturn[lineIndex] += " ";
          }
        }

        // adds tile content to toReturn at lineIndex (get, set, add)
        toReturn[lineIndex] += icon[lineIndex - addIndex] + " ";

        // adds after space to icon if icon is last in its row
        // adds to addIndex if icon is last in its row, and lineIndex is on the last line
        if (playerIndex == 2 || playerIndex == 5 || playerIndex == 6) {
          toReturn[lineIndex] += spacesToAdd;
          // adds extra space if icon is in the last row
          if (playerIndex == 6) {
            toReturn[lineIndex] += spacesToAdd;
          }
          // adds to addIndex if icon is last in it's row, and lineIndex is on the last line
          if (lineIndex == 2 || lineIndex == 5) {
            addIndex += 3;
            break;
          }
        }
        // checks for icons that are last in their row but their row isn't full
        else if(playerList.size() == playerIndex + 1) {
          // addds two spaces by default (one icon is missing from row)
          toReturn[lineIndex] += spacesToAdd;
          toReturn[lineIndex] += spacesToAdd;
          // adds extra space if two icons are missing from row
          if (playerIndex == 0 || playerIndex == 3) {
            toReturn[lineIndex] += spacesToAdd;
          }
        }
      }
    }
    //checks for empty lines and fills them with spaces
    for(int line = 0; line < toReturn.length; line++){
      if(toReturn[line].isEmpty()){
        toReturn[line] = "                  ";
      }
    }
    return toReturn;
  }
  
  /**
  prints visual tile
  */
  public void printTile(){
    String [] tile = this.getTile();
    for(String toPrint: tile){
      System.out.println(toPrint);
    }
  }
  
  /**
  prints tile details
  */
  public void printTileDetails(){
    int rentList[] = this.getRents();
    System.out.println(" - Tile Price " + price);
    if(type == 02){
      System.out.println(" - With One Utility Owned, Rent is 4 Times Dice Roll");
      System.out.println(" - With Two Utilities Owned, Rent is 10 Times Dice Roll");
    } else if(type == 01){
      System.out.println(" - Rent with One Railroad: " + rentList[0]);
      System.out.println(" - Rent with Two Railroads: " + rentList[1]);
      System.out.println(" - Rent with Three Railroads: " + rentList[2]);
      System.out.println(" - Rent with Four Railroads: " + rentList[3]);
    } else {
      for(int i = 0; i < 6; i++){
        String toPrint = "";
        switch(i){
          case 0:
            toPrint = " - Base Rent with No Properties: ";
            break;
          case 1:
            toPrint = " - Rent with One House: ";
            break;
          case 2:
            toPrint = " - Rent with Two Homes: ";
            break;
          case 3:
            toPrint = " - Rent with Three Homes: ";
            break;
          case 4:
            toPrint = " - Rent with Four Homes ";
            break;
          case 5:
            toPrint = " - Rent with Hotel: ";
            break;
        }
        System.out.println(toPrint + rentArr[i]);
      }
    }
  }
}