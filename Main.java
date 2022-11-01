import java.util.*;

class Main {
  public static void main(String[] args) {
    Player player = new Player("Dog");

    //array storing copy of every tile
    Tile[] tiles = new Tile[40];

    //gives player every property, adding homes and hotels to monopolies for testing
    for(int i = 0; i < 20; i++){
      Tile newTile = new Tile(i);
      tiles[i] = newTile;
      if((newTile.getType() == 0 || newTile.getType() == 01 || newTile.getType() == 02)){
        player.purchaseTile(newTile);
        if(newTile.getType() == 0){
          if(i % 2 == 0){
            for(int l = 0; l < 4; l++){
              House house = new House(newTile, player);
              newTile.addHouse(house);
            }
          } else {
            Hotel hotel = new Hotel(newTile, player);
            newTile.addHotel(hotel);
          }
        }
      }
    }
    
    player.printInventory(tiles);
  }
}