package be.swsb.coderetreat;

import java.util.Objects;

public class Rover {

    private final Direction direction;
    private final Position position;

    public Rover() {
        this(Direction.NORTH, new Position(0, 0));
    }

    public Rover(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public Rover receiveForward() {
        return new Rover(this.direction, new Position(0, 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return direction == rover.direction && Objects.equals(position, rover.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, position);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "direction=" + direction +
                ", position=" + position +
                '}';
    }
}
