package be.swsb.coderetreat;

import java.util.List;
import java.util.StringJoiner;

public class Rover {

    private final Position position;
    private final Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Rover receiveForwards() {
        switch (this.direction) {
            case NORTH:
                return new Rover(position.increaseY(), this.direction);
            case EAST:
                return new Rover(position.increaseX(), this.direction);
            case SOUTH:
                return new Rover(position.decreaseY(), this.direction);
            case WEST:
                return new Rover(position.decreaseX(), this.direction);
            default:
                throw new RuntimeException() ;
        }
    }

    public Rover receiveBackwards() {
        switch (this.direction) {
            case NORTH:
                return new Rover(position.decreaseY(), this.direction);
            case EAST:
                return new Rover(position.decreaseX(), this.direction);
            case SOUTH:
                return new Rover(position.increaseY(), this.direction);
            case WEST:
                return new Rover(position.increaseX(), this.direction);
            default:
                throw new RuntimeException() ;
        }
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

    public Rover receive(Command... commands) {
        return List.of(commands).stream().reduce(this, Rover::receiveCmd, (r1, r2) -> r1);
    }

    private Rover receiveCmd(Command cmd) {
        switch (cmd) {
            case FORWARDS:
                return this.receiveForwards();
            case BACKWARDS:
                return this.receiveBackwards();
            default:
                throw new RuntimeException("'tis kapot");
        }
    }
}
