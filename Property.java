/**
Superclass representing property
*/
public class Property{
  //member variables
  private Tile parentTile;
  private Player owner;


  //constructor
  public Property(Tile tile, Player owner){
    parentTile = tile;
    this.owner = owner;
  }

  
  //getters&setters
  public Tile getParentTile(){
    return parentTile;
  }
  public Player getOwner(){
    return owner;
  }
  
}