package com.jad.chessknight;

/**
 * The type Board.
 *
 * @param <Data> the type parameter extends Square
 */
public abstract class Board<Data extends Square> {
    private final Data[][] squares;
    private final int height;
    private final int width;

    /**
     * Instantiates a new Board.
     *
     * @param height the height of the board
     * @param width  the width of the board
     */
    protected Board(final int height, final int width) {
        this.height = (height <= 0) ? 1 : height;
        this.width = (width <= 0) ? 1 : width;
        this.squares = (Data[][]) new Square[this.height][this.width];
    }

    /**
     * Gets height of the board.
     *
     * @return the height
     */
    public final int getHeight() {
        return height;
    }

    /**
     * Gets width of the board.
     *
     * @return the width
     */
    public final int getWidth() {
        return width;
    }

    /**
     * Gets data at (x, y).
     *
     * @param x the x
     * @param y the y
     * @return the at
     */
    public final Data getAt(int x, int y) {
        if ( (x >= 0) && (y >= 0) && (x < this.getWidth()) && (y < this.getHeight()) ) {
            return this.squares[y][x];
        }
        return null;
    }

    /**
     * Put data at (x, y).
     *
     * @param x    the x
     * @param y    the y
     * @param data the data
     */
    public final void putAt(int x, int y, Data data) {
        if ( (x >= 0) && (y >= 0) && (x < this.getWidth()) && (y < this.getHeight()) ) {
            this.squares[y][x] = data;
        }
    }

    /**
     * Save step at (x, y).
     *
     * @param x    the x
     * @param y    the y
     * @param step the step
     */
    public final void saveStepAt(int x, int y, int step) {
        if ( (x >= 0) && (y >= 0) && (x < this.getWidth()) && (y < this.getHeight()) ) {
            this.squares[y][x].setValue(step);
        }
    }

    /**
     * Clear step at (x, y).
     *
     * @param x the x
     * @param y the y
     */
    public final void clearStepAt(int x, int y) {
        if ( (x >= 0) && (y >= 0) && (x < this.getWidth()) && (y < this.getHeight()) ) {
            this.squares[y][x].setValue(0);
        }
    }

    /**
     * Fill with data.
     *
     * @param data the data
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public final void fillWith(Data data) throws CloneNotSupportedException {
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                this.putAt(x, y, (Data) data.clone());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                result.append(this.getAt(x, y)).append("\t");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
