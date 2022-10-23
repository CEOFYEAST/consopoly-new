import java.util.*;

class Main {
  public static void main(String[] args) {
      //play
    Board.clear();
    //PrintBoard.printBoard();
    
    Board board = new Board(Game.setPlayerCount());

      //test
    // Board board = new Board(2);

    // ArrayList<Player> playerList = board.getPlayerList();
    // Player playerUp = playerList.get(1);
    
    // Tile currentTile = Board.move(2, playerUp);
    // Game.decisions(playerUp, currentTile, board);

    
    //int arr[] = {1, 3, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 27, 29, 31, 32, 34, 37, 39};

    //int arr[] = {8, 11, 18, 19, 24, 26, 27, 29, 32, 37, 39};

    //int arr[] = {6, 8, 11, 23};
    
    // for(int i: arr){
    //   Tile tile = new Tile(i);
    //   tile.purchase(playerUp);
    // }
    
    // board.clear();
    
    // playerUp.setProperty();
    // playerUp.formatProperty();
    // playerUp.printProperty();
  }
}