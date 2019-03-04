package monopolydemo;

/**
 *
 * @author TM
 */
class Player {

    private Piece p;
    private Board b;
    private Die[] dice;
    
    Player(Die[] dice, Piece p, Board b) {
        this.p = p;
        this.b = b;
        this.dice = dice;
    }

    void takeTurn() {
        int total = 0;
        for (Die die : dice) {
            die.roll();
            total += die.getFaceValue();
        }
        Square oldLocation = p.getLocation();
        Square newLocation = b.getSquare(oldLocation, total);
        p.setLocation(newLocation);
    }

}
