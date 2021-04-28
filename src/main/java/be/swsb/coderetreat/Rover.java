package be.swsb.coderetreat;

import java.util.Objects;

import static be.swsb.coderetreat.Command.*;

public class Rover {

    private final Position position;
    private final Direction facingDirection;

    public Rover(Position position, Direction facingDirection) {
        this.position = position;
        this.facingDirection = facingDirection;
    }

    public Rover receive(Command command) {
        return switch (command) {
            case LEFT -> new Rover(this.position, this.facingDirection.rotateCounterClockwise());
            case RIGHT -> new Rover(this.position, this.facingDirection.rotateClockwise());
            case FORWARDS -> new Rover(this.position.move(facingDirection), this.facingDirection);
            case BACKWARDS -> new Rover(this.position.move(facingDirection.opposite()), this.facingDirection);
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position) && facingDirection == rover.facingDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, facingDirection);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", direction=" + facingDirection +
                '}';
    }
}
