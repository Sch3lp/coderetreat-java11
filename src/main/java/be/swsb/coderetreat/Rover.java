package be.swsb.coderetreat;

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
        switch (command) {
            case LEFT:
                return aRover(this.position, this.facingDirection.rotateCounterClockwise());
            case RIGHT:
                return aRover(this.position, this.facingDirection.rotateClockwise());
            case FORWARDS:
                return aRover(this.position.move(facingDirection), this.facingDirection);
            case BACKWARDS:
                return aRover(this.position.move(facingDirection.opposite()), this.facingDirection);
            default:
                throw new IllegalArgumentException("Explosion!!!!!");
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
