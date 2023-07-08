import java.util.*;

class Main {
  public static void main(String[] args) {
    Board.initializeBoard(1);
    int[] positions = new int[] {0, 4, 4, 4, 4, 4, 8, 8};
    Util.printBoardTest(positions);
    ArrayList<Player> playerList = Board.getPlayerList();
    //Util.printIcons(Board.getTile(0), playerList.get(0));
    //Util.printIcons(Board.getTile(4), playerList.get(0));
    //Util.printIcons(Board.getTile(6), playerList.get(0));
    //Util.printIcons(Board.getTile(8), playerList.get(0));
    //Util.giveAllProperties(playerList.get(0));
    //int startLocation, int destination, int length, Player toMove
    //Board.printBoard(-3, 1, 7, playerList.get(0));
    Board.movePlayer(5, 7, playerList.get(0));
    //Util.tryWait(2000);
    ///Board.movePlayer(80, 7, playerList.get(1));
    //playerList.get(0).printInventory();
    //commit this dick dumbass

    //Misc.passGoAnimation();
  }
}