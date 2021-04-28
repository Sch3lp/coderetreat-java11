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
        if (command instanceof MoveCommand) {
            return move((MoveCommand) command);
        }
        if (command instanceof RotateCommand) {
            return rotate((RotateCommand) command);
        }
        throw new IllegalArgumentException("Explosion!!!!!");
    }

    private Rover move(MoveCommand command) {
        if (command.isForwards()) {
            return aRover(this.position.move(facingDirection), this.facingDirection);
        }
        if (command.isBackwards()) {
            return aRover(this.position.move(facingDirection.opposite()), this.facingDirection);
        }
        throw new IllegalArgumentException("Not a move command");
    }

    private Rover rotate(RotateCommand command) {
        if (command.isLeft()) {
            return aRover(this.position, this.facingDirection.rotateCounterClockwise());
        }
        if (command.isRight()) {
            return aRover(this.position, this.facingDirection.rotateClockwise());
        }
        throw new IllegalArgumentException("Not a rotate command");
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
