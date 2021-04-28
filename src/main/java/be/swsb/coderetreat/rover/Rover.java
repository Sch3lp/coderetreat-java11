package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.rover.commands.Command;
import be.swsb.coderetreat.rover.commands.Command.MoveCommand;
import be.swsb.coderetreat.rover.commands.Command.RotateCommand;

import java.util.Objects;

public class Rover {

    private final Position position;
    private final Direction facingDirection;

    private Rover(Position position, Direction facingDirection) {
        this.position = position;
        this.facingDirection = facingDirection;
    }

    public static Rover aRover(Position position, Direction facingDirection) {
        return new Rover(position, facingDirection);
    }

    public Rover receive(Command command) {
        return command.execute(this);
    }

    public Rover moveBackwards() {
        return aRover(this.position.move(facingDirection.opposite()), this.facingDirection);
    }

    public Rover moveForwards() {
        return aRover(this.position.move(facingDirection), this.facingDirection);
    }
    public Rover rotateRight() {
        return aRover(this.position, this.facingDirection.rotateClockwise());
    }

    public Rover rotateLeft() {
        return aRover(this.position, this.facingDirection.rotateCounterClockwise());
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
