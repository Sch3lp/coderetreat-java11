package be.swsb.coderetreat.rover;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction opposite() {
        switch (this) {
            case NORTH: return SOUTH;
            case EAST: return WEST;
            case SOUTH: return NORTH;
            case WEST: return EAST;
            default: throw new IllegalArgumentException("Explosion!");
        }
    }

    public Direction rotateClockwise() {
        switch (this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: throw new IllegalArgumentException("Explosion!!!");
        }
    }

    public Direction rotateCounterClockwise() {
        return rotateClockwise().opposite();
    }
}
