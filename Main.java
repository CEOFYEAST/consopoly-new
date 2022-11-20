import java.util.*;

class Main {
  public static void main(String[] args) {
    int[] positions = new int[] {0, 0, 1, 2, 4, 6, 8, 8};
    Util.printBoardTest(positions);
    ArrayList<Player> playerList = Board.getPlayerList();
    //int startLocation, int destination, int length, Player toMove
    //Board.printBoard(-3, 1, 7, playerList.get(0));
    Board.movePlayer(5, 5, playerList.get(0));
    Util.tryWait(2000);
    Board.movePlayer(80, 5, playerList.get(1));
    //player.printInventory();
  }
}