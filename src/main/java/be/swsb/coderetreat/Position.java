package be.swsb.coderetreat;

import java.util.StringJoiner;

import static be.swsb.coderetreat.Direction.*;

public class Position {
    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position at(int x, int y) {
        return new Position(x, y);
    }


    private Position increaseXByOne() {
        return new Position(x + 1, y);
    }

    private Position increaseYByOne() {
        return new Position(x, y + 1);
    }

    private Position decreaseYByOne() {
        return new Position(x, y - 1);
    }

    private Position decreaseXByOne() {
        return new Position(x - 1, y);
    }

    public Position move(Direction direction) {
        if (direction.equals(NORTH)) {
            return increaseYByOne();
        } else if (direction.equals(EAST)) {
            return increaseXByOne();
        } else if (direction.equals(SOUTH)) {
            return decreaseYByOne();
        } else if (direction.equals(WEST)) {
            return decreaseXByOne();
        } else {
            throw new IllegalArgumentException("Tis kapot");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Position.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .toString();
    }
}
