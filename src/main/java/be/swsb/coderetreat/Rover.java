package be.swsb.coderetreat;

import java.util.Objects;

import static be.swsb.coderetreat.Command.FORWARDS;
import static be.swsb.coderetreat.Command.LEFT;

public class Rover {

    private final Position position;
    private final Direction facingDirection;

    public Rover(Position position, Direction facingDirection) {
        this.position = position;
        this.facingDirection = facingDirection;
    }

    public Rover receive(Command command) {
        if (command.equals(LEFT)) {
            return new Rover(this.position, this.facingDirection.rotateCounterClockwise());
        } else if (command.equals(FORWARDS)) {
            return new Rover(this.position.move(facingDirection), this.facingDirection);
        } else {
            return new Rover(this.position.move(facingDirection.opposite()), this.facingDirection);
        }
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
