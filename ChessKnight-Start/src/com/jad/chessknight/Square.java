package com.jad.chessknight;

/**
 * The type Square.
 */
public class Square implements Cloneable{
    private int value;

    /**
     * Instantiates a new Square.
     */
    public Square() {
        this(0);
    }

    /**
     * Instantiates a new Square.
     *
     * @param value the value
     */
    public Square(int value) {
        this.value = value;
    }

    /**
     * Instantiates a new Square.
     *
     * @param other the other
     */
    public Square(Square other) {
        this(other.getValue());
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public final int getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public final void setValue(final int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public Square clone() throws CloneNotSupportedException
    {
        Square clone = (Square) super.clone();
        clone.setValue(this.getValue());
        return clone;
    }
}
