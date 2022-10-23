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

    
    for(int i = 0; i < 40; i++){
      Tile newTile = new Tile(i);
      newTile.printTile();
    }

    
    
  }
}