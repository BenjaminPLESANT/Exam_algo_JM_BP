package com.jad.chessknight;

/**
 * The type Pawn.
 */
public abstract class Pawn {
    private int x;
    private int y;
    private final Board board;
    private int moves;

    /**
     * Instantiates a new Pawn.
     *
     * @param board the board
     * @param x     the x
     * @param y     the y
     */
    protected Pawn( final Board board, final int x, final int y) {
        this.board = board;
        this.moves = 0;
        this.moveTo(x, y);
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public final int getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    private void setX(final int x) {
        this.x = (x < 0) ? 0 : (x >= this.board.getWidth()) ? (this.board.getWidth() - 1) : x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public final int getY() {
        return y;
    }


    private void setY(final int y) {
        this.y = (y < 0) ? 0 : (y >= this.board.getHeight()) ? (this.board.getHeight() - 1) : y;
    }

    /**
     * Move to (x, y) boolean.
     * Return true if the move is possible and done
     *
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    public boolean moveTo(int x, int y) {
        if( (this.board.getAt(x,y) != null) && (this.board.getAt(x,y).getValue() == 0) ){
            this.setX(x);
            this.setY(y);
            this.board.saveStepAt(x,y,this.doAMove());
            return true;
        }
        return false;
    }

    private int doAMove() {
        return ++this.moves;
    }
}
