import java.util.*;

class Main {
  public static void main(String[] args) {
    /**
    Player player = new Player("Dog");

    Tile medditeranean = new Tile(1);
    Tile newYorkAve = new Tile(19);

    medditeranean.printTile();

    Tile railroad = new Tile(5);
    Tile railroad2 = new Tile(15);
    
    railroad.printTile();

    Tile util = new Tile(28);

    util.printTile();

    medditeranean.setOwner(player);
    newYorkAve.setOwner(player);

    House house = new House(medditeranean, player);
    House house2 = new House(medditeranean, player);
    House house3 = new House(medditeranean, player);
    House house4 = new House(medditeranean, player);
    medditeranean.addHouse(house);
    medditeranean.addHouse(house2);
    medditeranean.addHouse(house3);
    medditeranean.addHouse(house4);
    
    Hotel hotel = new Hotel(medditeranean, player);
    medditeranean.addHotel(hotel);
    
    medditeranean.printTile();
    
    player.printInventory();
    */

    

    /**
    Tile medditeranean = new Tile(1);
    Tile newYorkAve = new Tile(19);
    Tile tennessee = new Tile(18);

    medditeranean.setOwner(player);
    newYorkAve.setOwner(player);
    tennessee.setOwner(player);

    player.addProperty(medditeranean);
    player.addProperty(newYorkAve);
    player.addProperty(tennessee);
    */

    Player player = new Player("Dog");
    
    for(int i = 0; i < 26; i++){
      Tile newTile = new Tile(i);
      if(newTile.getType() == 0 && (i % 2 == 0 || i == 1)){
        newTile.setOwner(player);
        player.addProperty(newTile);
        for(int l = 0; l < 4; l++){
          House house = new House(newTile, player);
          newTile.addHouse(house);
        }
      }
    }
    
    player.updateTileArrays();
    player.printInventory();
    
    /**
    for(String line: property){
      System.out.println(line);
    }
    */
    
    /**
    for(int i = 0; i < 40; i++){
      Tile newTile = new Tile(i);
      if(newTile.getType() == 0){
        newTile.setOwner(player);
        player.addProperty(newTile);
      }
    }
    */
    
    
  }
}