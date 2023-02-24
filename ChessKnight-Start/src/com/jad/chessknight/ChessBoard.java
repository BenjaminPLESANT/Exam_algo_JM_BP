package com.jad.chessknight;

/**
 * The type Chess board 8x8 Squares.
 */
public class ChessBoard extends Board<Square> {
    /**
     * Instantiates a new Chess board.
     *
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public ChessBoard() throws CloneNotSupportedException {
        super(8, 8);
        this.fillWith(new Square(0));
    }
}
