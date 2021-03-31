package be.swsb.coderetreat;

import java.util.StringJoiner;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

   public Position increaseY() {
        return new Position(x, y + 1);
   }

    public Position decreaseY() {
        return new Position(x, y - 1);
    }

    public Position increaseX() {
        return new Position(x+1, y);
    }

    public Position decreaseX() {
        return new Position(x-1, y);
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
        return String.format("(%s,%s)", x, y);
    }
}
