package be.swsb.coderetreat;

import java.util.StringJoiner;

public class Rover {

    private final Position position;
    private final Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Rover receiveForwards() {
        return new Rover(position.increaseY(), this.direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (position != null ? !position.equals(rover.position) : rover.position != null) return false;
        return direction == rover.direction;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Rover.class.getSimpleName() + "[", "]")
                .add("position=" + position)
                .add("direction=" + direction)
                .toString();
    }
}
