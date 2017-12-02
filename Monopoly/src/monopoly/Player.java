/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 */
package monopoly;

public class Player {
    private String name;
    private Piece piece;
    private Board board;
    private Die[] dice;
    private int playerTurn;
    
    public Player(String name, Die[] dice, Board board){
        this.name = name;
        this.dice = dice;
        this.board = board;
        this.piece = new Piece(board.getStartSquare());
    }
    
    public void setplayerTurn(int turn)
    {
        this.playerTurn = turn;
    }
    
    public int getPlayerTurn()
    {
        return this.playerTurn;
    }
    
    public void takeTurn(){
        //roll dice
        int rollTotal = 0;
        for(int i = 0; i < dice.length; i++){
            dice[i].roll();
            rollTotal += dice[i].getFaceValue();
        }
        Square newLoc = board.getSquare(piece.getLocation(), rollTotal);
        piece.setLocation(newLoc);
    }
    
    public Square getLocation(){
        return piece.getLocation();
    }
    
    public String getName(){
        return name;
    }
    
    public void setTurn(int turn){
        playerTurn = turn;
    }
    
    public int getTurn(){
        return playerTurn;
    }
    
}
