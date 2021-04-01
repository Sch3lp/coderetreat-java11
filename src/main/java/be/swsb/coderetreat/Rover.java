package be.swsb.coderetreat;

import java.util.Objects;

import static be.swsb.coderetreat.Position.at;

public class Rover {

    private final Position position;
    private final Direction direction;

    public Rover(Position position, Direction direction){
        this.position = position;
        this.direction = direction;
    }

    public Rover receive(Command command) {
        return new Rover(this.position.increaseYByOne(), Direction.NORTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position) && direction == rover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}
