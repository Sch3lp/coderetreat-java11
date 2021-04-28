package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.rover.commands.Command;

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

    // Command implementations
    public static final class Forwards implements Command.MoveCommand {
        public static final Forwards instance = new Forwards();

        private Forwards() {
        }

        @Override
        public Rover execute(Rover rover) {
            return aRover(rover.position.move(rover.facingDirection), rover.facingDirection);
        }
    }

    public static final class Backwards implements Command.MoveCommand {
        public static final Backwards instance = new Backwards();

        private Backwards() {
        }

        @Override
        public Rover execute(Rover rover) {
            return aRover(rover.position.move(rover.facingDirection.opposite()), rover.facingDirection);
        }
    }

    public static final class Right implements Command.RotateCommand {
        public static final Right instance = new Right();

        private Right() {
        }

        @Override
        public Rover execute(Rover rover) {
            return aRover(rover.position, rover.facingDirection.rotateClockwise());
        }
    }

    public static final class Left implements Command.RotateCommand {
        public static final Left instance = new Left();

        private Left() {
        }

        @Override
        public Rover execute(Rover rover) {
            return aRover(rover.position, rover.facingDirection.rotateCounterClockwise());
        }

    }

}
